require 'articles_helper'

conv = ArticlesHelper.new
puts conv.wikiToHtml("==olle== ===KIM=== '''kompis''' ''skolalla'' =Tim= http://www.google.com")
puts conv.urlizeTitle("olle är fint")
puts conv.deUrlizeTitle("olle-är-fint")

#puts conv.test("=olle=")