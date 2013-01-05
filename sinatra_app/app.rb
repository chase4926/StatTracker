#!/usr/bin/env ruby

require 'sinatra'
require 'yaml'
require_relative 'lib_misc.rb'

$config = YAML.load_file('config.yml')

set(:port, $config['port'])
set(:views, Proc.new { File.join(root, 'sinatra_files') })
set(:public_folder, Proc.new { File.join(root, 'sinatra_files') })


class FileData
  attr_reader :file_contents, :length
  def initialize()
    @file_contents = ''
    @length = 0
    @stat_hash = Hash.new()
  end
  
  def get_hash()
    return @stat_hash
  end
  
  def get_by_index(index)
    return @stat_hash.keys()[index], @stat_hash.values()[index]
  end
  
  def load_file(filename)
    if File.exists?(filename) then
      new_file_contents = nil
      File.open(filename, 'r') do |file|
        new_file_contents = file.read()
      end
      if new_file_contents != @file_contents then
        @file_contents = new_file_contents
        @stat_hash.clear()
        @file_contents.each_line() do |line|
          line_data = line.split(':')
          @stat_hash[line_data[0]] = line_data[1].to_i()
        end
        @length = @stat_hash.length()
      end
    end
    return nil
  end
end

def format_table_row(key, value, last=false)
  return <<-heredoc
  <tr>
    <td><p align="left">#{de_camelcase(key) << ':'}</p>#{last ? '' : '<hr>'}</td>
    <td><p align="right">#{nicen_number(value)}</p>#{last ? '' : '<hr>'}</td>
  </tr>
  heredoc
end

def format_table_rows(hash)
  result_html = ""
  hash.keys().sort().each_with_index() do |key, i|
    last = false
    if i == (hash.length() - 1) then
      last = true
    end
    result_html << format_table_row(key, hash[key], last)
  end
  return result_html
end

def get_formatted_block(filename='stats.txt')
  $filedata.load_file(filename)
  return format_table_rows($filedata.get_hash())
end

def footer()
  if $config['footnote'] != nil then
    return "<section id='bottom'>#{$config['footnote']}</section>"
  end
end

def auto_refresh()
  if $config['auto_refresh'] then
    return "<meta http-equiv='refresh' content='#{$config["auto_refresh_rate"]}' >"
  end
end

def title()
  if $config['title'] != nil then
    return " for #{$config['title']}"
  end
end

def update_variables()
  $config = YAML.load_file('config.yml')
  @output = get_formatted_block()
  @footer = footer()
  @title = title()
  @stylesheet = $config["stylesheet"]
  @auto_refresh = auto_refresh()
end

$filedata = FileData.new()

get('/') do
  update_variables()
  erb(:template)
end
