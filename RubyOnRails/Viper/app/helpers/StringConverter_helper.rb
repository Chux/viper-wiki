#!/usr/bin/ruby
class StringConverter
  def initialize
    @rules = [   
               {:regex => /\s[*]{1,1}\s(.*?)\r+\n+/, :replace => '<li>\1</li>'},
               {:regex => /(<li>.*\r+\n+)/, :replace => '<ul>\1</ul>\n'},            # Wrap li tags with ul tags correctly.
               {:regex => /[=]{6,6}([^=]+?)[=]{6,6}/,:replace => '<h6>\1</h6>\n'},
               {:regex => /[=]{5,5}([^=]+?)[=]{5,5}/,:replace => '<h5>\1</h5>\n'},  # After h6...
               {:regex => /[=]{4,4}([^=]+?)[=]{4,4}/,:replace => '<h4>\1</h4>\n'},  # After h5 and so on...
               {:regex => /[=]{3,3}([^=]+?)[=]{3,3}/,:replace => '<h3>\1</h3>\n'},
               {:regex => /[=]{2,2}([^=]+?)[=]{2,2}/,:replace => '<h2>\1</h2>\n'},
               {:regex => /[=]{1,1}([^=]+?)[=]{1,1}/,:replace => '<h1>\1</h1>\n'},
#               {:regex => /\[\[(.+?)\]\]/, :replace => "<a href='/Wiki/article/index/\1/' class='internalLink'>\1</a>"}, # After _..._.
               {:regex => /\[([^\s]+?)\]/, :replace => "<a href='\1' rel='external' >\1</a>"},     # After [[...]]
               {:regex => /\[([^\s]+)\s(.+?)\]/, :replace => "<a href='\1' title='\2' rel='external'>\2</a>"} , 
               {:regex => /\'\'\'\'\'([^\']+?)\'\'\'\'\'/,:replace => '<strong><i>\1</i></strong>'},
               {:regex => /\'\'\'([^\']+?)\'\'\'/, :replace => '<strong>\1</strong>' },
               {:regex => /\'\'([^\']+?)\'\'/, :replace =>'<i>\1</i>' }
            ]
  
  end

  def wikiToHtml (inputString)
    @rules.each do |rule|
        inputString = inputString.gsub(rule[:regex],rule[:replace])
    end       
    return inputString
  end

  def urlizeTitle (s)
    s = s.gsub(' ','-')       
    return s
  end
 
  def deUrlizeTitle(s)
     s = s.gsub('-',' ')       
     return s
   end
end