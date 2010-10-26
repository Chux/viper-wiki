<?php
class WikiSyntaxConverter {

  public static function convertToHTML( $pString ) {

     $pString = self::runAllConversions( $pString );
     return $pString;

  }

  private static function runAllConversions( $pString ) {

    $tConverted = $pString;
    $tConverted = strip_Tags( $tConverted ); 
    $tConverted = preg_replace('/\'\'\'\'\'([^\n\']+)\'\'\'\'\'/','<strong><i>${1}</i></strong>',$tConverted);
    $tConverted = preg_replace('/\'\'\'([^\n\']+)\'\'\'/','<strong>${1}</strong>',$tConverted);
    $tConverted = preg_replace('/\'\'([^\n\']+)\'\'/','<i>${1}</i>',$tConverted);
    $tConverted = preg_replace('/\=\=\=\=\=\=\W([^\n\']+)\W\=\=\=\=\=\=/','<h6>${1}</h6>',$tConverted);
    $tConverted = preg_replace('/\=\=\=\=\=\W([^\n\']+)\W\=\=\=\=\=/','<h5>${1}</h5>',$tConverted);
    $tConverted = preg_replace('/\=\=\=\=\W([^\n\']+)\W\=\=\=\=/','<h4>${1}</h4>',$tConverted);
    $tConverted = preg_replace('/\=\=\=\W([^\n\']+)\W\=\=\=/','<h3>${1}</h3>',$tConverted);
    $tConverted = preg_replace('/\=\=\W([^\n\']+)\W\=\=/','<h2>${1}</h2>',$tConverted);
    $tConverted = preg_replace('/\[\[([^\n\']+)\|([^\n\']+)\]\]/','<a href=${1}>${2}</a>',$tConverted); // Internal links with diffrent link text
    $tConverted = preg_replace('/\[\[([^\n\']+)\]\]/','<a href=${1}>${1}</a>',$tConverted); // Internal links
    $tConverted = preg_replace('/((?:http|https)(?::\\/{2}[\\w]+)(?:[\\/|\\.]?)(?:[^\\s"]*))/', '<a href=${1}>${1}</a>', $tConverted );

    return $tConverted;

  }

} 
