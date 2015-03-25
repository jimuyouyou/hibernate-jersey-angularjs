package com.king.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Blog {
	@QueryParam("id")
	private Long id;
	@QueryParam("title")
	private String title;
	@QueryParam("content")
	private String content;

	public Blog() {
	}

	public Blog(Long id, String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
