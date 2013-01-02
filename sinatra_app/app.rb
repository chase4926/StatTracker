#!/usr/bin/env ruby

require 'sinatra'

set :port, 4567


class FileData
  attr_reader :file_contents, :length
  def initialize()
    @file_contents = ''
    @length = 0
    @stat_hash = Hash.new()
    load_file()
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

def get_formatted_block(filedata_instance, filename='stats.txt')
  filedata_instance.load_file(filename)
  result = ''
  filedata_instance.length.times() do |i|
    data = filedata_instance.get_by_index(i)
    result << "#{data[0]} : #{data[1]}<br />\n"
  end
  return result
end

filedata = FileData.new()

get '/' do
  get_formatted_block(filedata)
end
