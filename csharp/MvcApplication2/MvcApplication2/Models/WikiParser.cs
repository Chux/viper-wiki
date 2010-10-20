using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;

namespace MvcApplication2.Models
{
    // Welcome to the worst wiki-syntax parser... EVER!!!!!!!!!!!! 
    class WikiParser
    {
        public static string WikiToHTML(String tString)
        {
            tString = tString + " ";
            string parsedString = "";
            char currentChar = '0';
            char lastChar = '0';
            char nextChar = '0';
            int fnuttCounter = 0;
            int likamedCounter = 0;
            bool parsing_link = false;
            string link_text = "";
            string link_href = "";
            List<string> currentContext = new List<string>();
            currentContext.Add("");
  
            for (int i = 0; i < tString.Length; i++)
            {
                if ((i + 1) < tString.Length)
                {
                    nextChar = tString[i + 1];
                }

                currentChar = (char) tString[i];


                if ( currentChar == '\n') // Radbyte! Dags att slänga ut några taggar kanske?
                {
                    if (lastChar == '\n')
                    {
                        parsedString += "<br />";
                    }
                    else if (currentContext.Last<string>() == "li")
                    {
                        currentContext.RemoveAt(currentContext.Count - 1);
                        parsedString += "</li>\n";
                    }
                }
                else if (currentChar == ':' && nextChar == '/') // used for detecting external links( the :/ in http://)
                { 
                    parsedString = parsedString.Substring(0,parsedString.Length - 4);
                    parsing_link = true;
                    link_href = "http:";
                    currentContext.Add("external");
                }
                else if (currentChar == ' ' && currentContext.Last<string>() == "external") // used for internal and external links
                {
                        parsing_link = false;
                        parsedString += "<a href=\"";
                        parsedString += link_href;
                        parsedString += "\">";
                        parsedString += link_href;
                        parsedString += "</a>";
                        currentContext.RemoveAt(currentContext.Count - 1);
                        link_href = "";
                        link_text = "";
                }
                else if (currentChar == '[')
                {
                    if (nextChar == '[')
                    {
                        parsing_link = true;
                        currentContext.Add("internal");
                        link_text = "";
                    }
                }
                else if (currentChar == ']')
                {
                    if (nextChar == ']' && parsing_link)
                    {
                        link_href = "/articles/" + link_text;
                        parsedString += "<a href=\"";
                        parsedString += link_href;
                        parsedString += "\">";
                        parsedString += link_text;
                        parsedString += "</a>";
                        parsing_link = false;
                        link_text = "";
                        link_href = "";
                        currentContext.RemoveAt(currentContext.Count - 1);
                    }
                }
                else if (currentChar == '\'')
                {
                    fnuttCounter++;

                    if (fnuttCounter == 2 && nextChar != '\'')
                    {
                        if (currentContext.Last<string>() == "i")
                        {
                            fnuttCounter = 0;
                            currentContext.RemoveAt(currentContext.Count - 1);
                            parsedString += "</i>";
                        }
                        else
                        {
                            currentContext.Add("i");
                            parsedString += "<i>";
                            fnuttCounter = 0;
                        }
                    }
                    else if (fnuttCounter == 3 && nextChar != '\'')
                    {
                        if (currentContext.Last<string>() == "b")
                        {
                            fnuttCounter = 0;
                            currentContext.RemoveAt(currentContext.Count - 1);
                            parsedString += "</b>";
                        }
                        else
                        {
                            currentContext.Add("b");
                            parsedString += "<b>";
                            fnuttCounter = 0;
                        }
                    }
                    else if (fnuttCounter == 5)
                    {
                        if (currentContext.Last<string>() == "bi")
                        {
                            fnuttCounter = 0;
                            currentContext.RemoveAt(currentContext.Count - 1);
                            parsedString += "</i></b>";
                        }
                        else
                        {
                            currentContext.Add("bi");
                            parsedString += "<b><i>";
                            fnuttCounter = 0;
                        }
                    }

                }
                else if (currentChar == '=')
                {
                    likamedCounter++;

                    if (likamedCounter > 0 && nextChar != '=')
                    {
                        if (currentContext.Last<string>() == "h")
                        {
                            currentContext.RemoveAt(currentContext.Count - 1);
                            parsedString += "</h" + currentContext.Last<string>() + ">\n";
                            currentContext.RemoveAt(currentContext.Count - 1);
                        }
                        else
                        {
                            currentContext.Add(likamedCounter.ToString());
                            currentContext.Add("h");
                            parsedString += "<h" + likamedCounter + ">";
                        }

                        likamedCounter = 0;
                    }
                }
                else if (currentChar == '\'')
                {
                    fnuttCounter++;

                    if (fnuttCounter == 2 && nextChar != '\'')
                    {
                        if (currentContext.Last<string>() == "i")
                        {
                            fnuttCounter = 0;
                            currentContext.RemoveAt(currentContext.Count - 1);
                            parsedString += "</i>";
                        }
                        else
                        {
                            currentContext.Add("i");
                            parsedString += "<i>";
                            fnuttCounter = 0;
                        }
                    }
                    else if (fnuttCounter == 3 && nextChar != '\'')
                    {
                        if (currentContext.Last<string>() == "b")
                        {
                            fnuttCounter = 0;
                            currentContext.RemoveAt(currentContext.Count - 1);
                            parsedString += "</b>";
                        }
                        else
                        {
                            currentContext.Add("b");
                            parsedString += "<b>";
                            fnuttCounter = 0;
                        }
                    }
                    else if (fnuttCounter == 5)
                    {
                        if (currentContext.Last<string>() == "bi")
                        {
                            fnuttCounter = 0;
                            currentContext.RemoveAt(currentContext.Count - 1);
                            parsedString += "</b></i>";
                        }
                        else
                        {
                            currentContext.Add("bi");
                            parsedString += "<b><i>";
                            fnuttCounter = 0;
                        }
                    }

                }
                else if (currentChar == '#' && lastChar == '\n')
                {
                    if (currentContext.Last<string>() != "ol")
                    {
                        currentContext.Add("ol");
                        parsedString += "\n<ol>";
                    }
                    currentContext.Add("li");
                    parsedString += "\n  <li>";
                }
                else if (currentChar == '*' && lastChar == '\n')
                {
                    currentContext.Add("ul");
                    parsedString += "\n<ul>";
                }
                else // Om läst char inte är något av specialtecknen
                {
                    if (lastChar == '\n')
                    {
                        if (currentContext.Last<string>() == "ol")
                        {
                            currentContext.RemoveAt(currentContext.Count - 1);
                            parsedString += "</ol>\n";
                        }
                        else if (currentContext.Last<string>() == "ul")
                        {
                            currentContext.RemoveAt(currentContext.Count - 1);
                            parsedString += "</ul>\n";
                        }
                    }
                    if (parsing_link == false)
                    {
                        parsedString += currentChar;
                    }
                    else
                    {
                        link_href += currentChar;
                        link_text += currentChar;
                    }
                }
                lastChar = currentChar;

            }

            // Om vi har öppna context kvar så kolla igenom om det är några vi behöver stänga
            foreach(string s in currentContext) {
                if (s == "ol")
                {
                    parsedString += "</ol>\n";
                }
                else if (s == "ul")
                {
                    parsedString += "</ul>\n";
                }
            }
            return parsedString;
        }

    }
}
