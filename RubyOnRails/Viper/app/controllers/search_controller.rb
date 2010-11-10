class SearchController < ApplicationController
  def index
    articles = Article.search(params[:search_text])
    displayChars = 200
    articles.each do |article|
      pro = ''
      post = ''
      matchIndex =  article.content.index(params[:search_text])
      if matchIndex == nil 
        matchIndex = 0
      end
      if (matchIndex-displayChars/2 > 0)   
        from = matchIndex - displayChars/2 
        pro = '... '
        if (matchIndex+(displayChars/2)) < article.content.length
          post = ' ...'
        end
      else 
        from = 0
        if displayChars < article.content.length
          post =' ...'
        end
      end
      displayChars = 200
      article.content = pro + article.content.slice(from,displayChars) + post
    end
	  
	  respond_to do |format|
		  unless articles  
			  @msg = "create this article? <a href='/article/new/#{ params[:search_text] }'"  
		  else
			  @article = articles
			  @searchstring = params[:search_text]
		  end
 		  format.html # index.html.erb
		  format.xml { render :xml => @article }
	  end
	end
end
