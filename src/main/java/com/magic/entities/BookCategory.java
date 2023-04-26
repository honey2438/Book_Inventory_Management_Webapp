package com.magic.entities;

import javax.persistence.*;

@Entity
public class BookCategory {
	@Id
	@GeneratedValue(generator = "cat_seq")
	@SequenceGenerator(name = "cat_seq", initialValue = 112, allocationSize = 1)
	private int catid;
	@Column(unique = true)
	private String category;
	private String description;

	public int getCatid() {
		return catid;
	}

	public void setCatid(int catid) {
		this.catid = catid;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
