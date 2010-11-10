include ArticlesHelper
class Article < ActiveRecord::Base
  def to_param
    "#{urlizeTitle(title)}"
  end
  
  def self.search(search)
    search_condition = "%" + search + "%"
    find(:all, :conditions => ['title LIKE ? OR content LIKE ?', search_condition, search_condition])
  end
  
end
