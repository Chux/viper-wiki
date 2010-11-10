class SearchController < ApplicationController
  def index
    articles = Article.search(params[:search_text])
    displayChars = 200
    articles.each do |article|
      pro = ''
      post = ''
      matchIndex =  article.content.index(params[:search_text])
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
    @article = articles
  end
end
