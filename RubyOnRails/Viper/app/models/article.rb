include ArticlesHelper
class Article < ActiveRecord::Base
  def to_param
    "#{urlizeTitle(title)}"
  end
end
