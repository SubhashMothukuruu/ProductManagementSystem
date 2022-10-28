package com.example.demo.Entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Roles {

	@Id
	@Column(name = "role_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "role_name")
	private String name;

	@ManyToMany
	private Set<Users> user;

	public Set<Users> getUser() {
		return user;
	}

	public void setUser(Set<Users> user) {
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Roles(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Roles() {
		super();
	}

	@Override
	public String toString() {
		return "Roles [id=" + id + ", name=" + name + "]";
	}

}
