class SearchController < ApplicationController
  def index
    article = Article.search( params[:search_text] )

		respond_to do |format|
			unless article  
				@msg = "create this article? <a href='/article/new/#{ params[:search_text] }'"  
			else
				@article = article
				@searchstring = params[:search_text]
			end
	 		format.html # index.html.erb
			format.xml { render :xml => @article }
		end

  end

end
