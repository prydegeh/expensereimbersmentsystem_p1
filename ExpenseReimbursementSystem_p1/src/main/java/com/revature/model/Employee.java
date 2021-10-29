package com.revature.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String email;
	private String password;
	private int m_id;

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", m_id="
				+ m_id + "]";
	}

	public Employee() {
		super();
	}

	public Employee(String name, String email, String password, int m_id) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.m_id = m_id;
	}

	public Employee(int id, String name, String email, String password, int m_id) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.m_id = m_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int m_id() {
		return m_id;
	}

	public void setM_id(int m_id) {
		this.m_id = m_id;
	}

	public int getM_id() {
		return m_id;
	}

}
