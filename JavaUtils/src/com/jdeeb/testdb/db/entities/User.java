package com.jdeeb.testdb.db.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQueries({
	@NamedQuery(name="User.findAll", query="SELECT u FROM User u"),
	@NamedQuery(name="User.login", query="SELECT u FROM User u WHERE u.username = :userName AND u.password = :password"),
})

public class User implements Serializable, IEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String email;

	@Column(name="last_visit")
	private int lastVisit;

	private String password;

	@Column(name="register_date")
	private int registerDate;

	private int status;

	private String username;

	public User() {
	}

	// Setters AND Getters 
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getLastVisit() {
		return this.lastVisit;
	}

	public void setLastVisit(int lastVisit) {
		this.lastVisit = lastVisit;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRegisterDate() {
		return this.registerDate;
	}

	public void setRegisterDate(int registerDate) {
		this.registerDate = registerDate;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}