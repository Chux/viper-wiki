package viper;

public class WikiSyntaxConverter {

	public static String convertToHTML( String string ) { 
		
		String content;
		String converted;
			
		return string;
		
	}
	/*
	 * @author Tim Romberg
	 * RegEx method for converting wiki syntax
	 * into HTML
	 */
	public static void main( String[] args ) {
		String htmlText = "strong";
		converted = converted.replaceAll("'{5}([^\n\']+)\'\'\'\'\'/','<strong><i>${1}</i></strong>"); // Bold and Italic text   
		converted = converted.replaceAll("'{5}([^\n']+)'{5}", "<strong><i>$1</i></strong>");		
		converted = converted.replaceAll("'{2}([^\n\']+)\'\'/','<i>${1}</i>"); // Italic text 
		
		/*
		 * following below is all headings
		 */
		
		converted = converted.replaceAll('/\=\=\=\=\=\=\W([^\n\']+)\W\=\=\=\=\=\=/','<h6>${1}</h6>',converted);
		converted = converted.replaceAll('/\=\=\=\=\=\W([^\n\']+)\W\=\=\=\=\=/','<h5>${1}</h5>',converted);
		converted = converted.replaceAll('/\=\=\=\=\W([^\n\']+)\W\=\=\=\=/','<h4>${1}</h4>',converted); 
		converted = converted.replaceAll('/\=\=\=\W([^\n\']+)\W\=\=\=/','<h3>${1}</h3>',converted);
		converted = converted.replaceAll('/\=\=\W([^\n\']+)\W\=\=/','<h2>${1}</h2>',converted);
		
		/*
		 * following below is all lists
		 */
		
		converted = converted.replaceAll('/(\n[ ]*[^#* ][^\n]*)\n(([ ]*[#]([^\n]*)\n)+)/','${1}<ol>'."\n".'${2}'.'</ol>'."\n", converted);
		converted = converted.replaceAll('/(\n[ ]*[^#* ][^\n]*)\n(([ ]*[*]([^\n]*)\n)+)/','${1}<ul>'."\n".'${2}'.'</ul>'."\n", converted);
		converted = converted.replaceAll('/\n[ ]*[\*#]+([^\n]*)/','<li>${1}</li>', converted);
		
		converted = converted.replaceAll('/\[\[([^\n\']+)\|([^\n\']+)\]\]/','<a rel="internal" href=${1}>${2}</a>',converted); // Internal links with different link text 
		converted = converted.replaceAll('/\[\[([^\n\']+)\]\]/','<a href=${1}>${1}</a>',converted); // Internal links
		converted = converted.replaceAll('/((?:http|https)(?::\\/{2}[\\w]+)(?:[\\/|\\.]?)(?:[^\\s"]*))/', '<a rel="external" href=${1}>${1}</a>', converted ); //External links
		
		return converted;
	}
	
	
}
