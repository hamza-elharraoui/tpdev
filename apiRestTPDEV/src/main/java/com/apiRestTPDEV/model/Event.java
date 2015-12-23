package com.apiRestTPDEV.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.apiRestTPDEV.dao.JsonDateDeserializer;
import com.apiRestTPDEV.dao.JsonDateSerializer;
import com.apiRestTPDEV.dao.JsonUserDeserializer;

@XmlRootElement
@Entity
@Table(name = "event")
public class Event {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String name;
	@JsonSerialize(using = JsonDateSerializer.class)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	@Column(name = "date")
	private Date date;
	// @JsonSerialize(using = JsonUserSerializer.class)
	@JsonDeserialize(using = JsonUserDeserializer.class)
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	@ManyToOne
	@JoinColumn(name = "museum_id")
	private Museum museum;

	public Event() {
	}

	public Event(String name, Date date, User user, Museum museum) {
		this.name = name;
		this.date = date;
		this.user = user;
		this.museum = museum;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Museum getMuseum() {
		return museum;
	}

	public void setMuseum(Museum museum) {
		this.museum = museum;
	}

}
