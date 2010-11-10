class SearchController < ApplicationController
  def index
    article = Article.search(params[:search_text])
    unless article  
      @msg = "create this article? <a href='/article/new/#{params[:search_text]}'"  
    else
      @article = article
    end
  end

end
