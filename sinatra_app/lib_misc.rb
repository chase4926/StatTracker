

# Miscellaneous methods needed for the sinatra application


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

def nicen_number(number)
  number = number.to_s().reverse()
  result_number = ''
  number.length().times() do |i|
    result_number << number[i]
    result_number << ',' if i != number.length() - 1 and (i + 1) % 3 == 0
  end
  return result_number.reverse()
end

