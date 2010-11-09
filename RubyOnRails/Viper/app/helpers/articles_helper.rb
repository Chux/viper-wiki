#require 'wikisyntaxtest'
module ArticlesHelper

def wikiToHtml ( inputString )
	rules =  [   
             {:regex => /(\n[ ]*[^#* ][^\n]*)\n(([ ]*[#]([^\n]*)\n)+)/x, :replace => '\1<ol>' + "\n" + '\2' + '</ol>' + "\n"},
             {:regex => /(\n[ ]*[^#* ][^\n]*)\n(([ ]*[*]([^\n]*)\n)+)/x, :replace => '\1<ul>' + "\n" + '\2' + '</ul>' + "\n"},
             {:regex => /\n[ ]*[\*#]+([^\n]*)/x, :replace => '<li>\1</li>'},
             {:regex => /[=]{6,6}([^=]+?)[=]{6,6}/,:replace => '<h6>\1</h6>'},
						 {:regex => /[=]{5,5}([^=]+?)[=]{5,5}/,:replace => '<h5>\1</h5>'},  # After h6...
						 {:regex => /[=]{4,4}([^=]+?)[=]{4,4}/,:replace => '<h4>\1</h4>'},  # After h5 and so on...
						 {:regex => /[=]{3,3}([^=]+?)[=]{3,3}/,:replace => '<h3>\1</h3>'},
						 {:regex => /[=]{2,2}([^=]+?)[=]{2,2}/,:replace => '<h2>\1</h2>'},
             {:regex => /\[\[(.+?)\]\]/, :replace => '<a href="' + '\1' + '" rel="internal">' + '\1' + '</a>'}, # After _..._.
						 {:regex => /(http:\/\/+[\w.]*)/, :replace => '<a href="\1" rel="external">\1</a>'},     # After [[...]]
						 {:regex => /[\']{5}(.+?)[\']{5}/,:replace => '<strong><i>\1</i></strong>'},
						 {:regex => /[\']{3}(.+?)[\']{3}/, :replace => '<strong>\1</strong>' },
						 {:regex => /[\']{2}(.+?)[\']{2}/, :replace =>'<i>\1</i>' }
					]

	rules.each do |rule|
			inputString = inputString.gsub(rule[:regex],rule[:replace])
	end       
	return inputString
end

def urlizeTitle ( s )
	s = s.gsub(' ','-')       
	return s
end

def deUrlizeTitle ( s )
	 s = s.gsub('-',' ')       
	 return s
 end

end
