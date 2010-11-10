include ArticlesHelper
class Article < ActiveRecord::Base
  def to_param
    "#{urlizeTitle(title)}"
  end 
  
  
  def self.search(search)
    search_condition = "%" + search + "%"
    inTitle = find(:all,:conditions => ['title LIKE ?', search_condition])
    inContent = find(:all,:conditions => ['content LIKE ?', search_condition])
    all = inTitle + inContent
    all.uniq
  end
  
end
