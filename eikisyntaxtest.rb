require 'StringConverter'

conv = StringConverter.new
puts conv.wikiToHtml("==olle== ===KIM=== '''kompis''' ''skolalla'' ")
puts conv.urlizeTitle("olle är fint")
puts conv.deUrlizeTitle("olle-är-fint")

#puts conv.test("=olle=")