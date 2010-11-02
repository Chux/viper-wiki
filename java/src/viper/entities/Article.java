package viper.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import viper.interfaces.ResourceElement;

@Entity(name="articles")
public class Article implements Serializable, ResourceElement {

	private static final long serialVersionUID = 4601312214768336909L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String title;
	
	@Column(name="article_body")
	private String articleBody;
	
	@Column
	private Date datetime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return articleBody;
	}
	public void setContent(String content) {
		this.articleBody = content;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public String toJsonString() {
		
		
		
		String json = "{}";
		return json;
	}
	
}
