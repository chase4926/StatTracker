#!/usr/bin/env ruby

require 'sinatra'

set(:port, 4567)
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

class String
  def upcase?()
    if self == self.upcase() then
      return true
    else
      return false
    end
  end
  
  def downcase?()
    return !upcase?()
  end
end


def de_camelcase(string)
  string = String.new(string)
  index_array = Array.new()
  string.length().times() do |i|
    if i > 0 and string[i].upcase?() and string[i - 1].downcase?() then
      index_array << i
    end
  end
  i_add = 0
  index_array.each() do |i|
    string.insert(i + i_add, ' ')
    i_add += 1
  end
  return string
end

def format_table_row(key, value, last=false)
  return <<-heredoc
  <tr>
    <td><p align="left">#{de_camelcase(key) << ':'}</p>#{last ? '' : '<hr>'}</td>
    <td><p align="right">#{value}</p>#{last ? '' : '<hr>'}</td>
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

def get_formatted_block(filedata_instance, filename='stats.txt')
  filedata_instance.load_file(filename)
  return format_table_rows(filedata_instance.get_hash())
end


filedata = FileData.new()

get('/') do
  @output = get_formatted_block(filedata)
  erb(:template)
end
