package com.magic.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class BookPublisher 
{
	@Id
	@GeneratedValue(generator = "pub_seq")
	@SequenceGenerator(name = "pub_seq",initialValue = 1112,allocationSize = 1)
	private int pubid;
	@Column(unique=true)
	private String publisher;
	private String phone;
	private String email;
	public int getPubid() {
		return pubid;
	}
	public void setPubid(int pubid) {
		this.pubid = pubid;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
