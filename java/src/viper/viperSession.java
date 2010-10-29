package viper;

import java.io.Serializable;
import java.util.List;

import viper.entities.Article;

public class viperSession implements Serializable {

	private static final long serialVersionUID = 3498836437809200645L;

	public List<Article> allArticles;

	
	
	public List<Article> getAllArticles() {
		return allArticles;
	}

	public void setAllArticles(List<Article> allArticles) {
		this.allArticles = allArticles;
	}
}
