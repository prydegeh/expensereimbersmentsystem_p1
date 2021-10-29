package com.revature.model;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reimbursement")
public class Reimbursement {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int amount;
	private String employee_note;
	private String manager_note;
	private Timestamp time;

	@Override
	public String toString() {
		return "Reimbursement [rid=" + id + ", amount=" + amount + ", employee_note=" + employee_note
				+ ", manager_note=" + manager_note + ", time=" + time + "]";
	}

	public Reimbursement() {
		super();
	}

	public Reimbursement(int amount, String employee_note, String manager_note, Timestamp time) {
		super();
		this.amount = amount;
		this.employee_note = employee_note;
		this.manager_note = manager_note;
		this.time = time;
	}

	public Reimbursement(int id, int amount, String employee_note, String manager_note, Timestamp time) {
		super();
		this.id = id;
		this.amount = amount;
		this.employee_note = employee_note;
		this.manager_note = manager_note;
		this.time = time;
	}

	public int getRid() {
		return id;
	}

	public void setRid(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getEmployee_note() {
		return employee_note;
	}

	public void setEmployee_note(String employee_note) {
		this.employee_note = employee_note;
	}

	public String getManager_note() {
		return manager_note;
	}

	public void setManager_note(String manager_note) {
		this.manager_note = manager_note;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}
}
