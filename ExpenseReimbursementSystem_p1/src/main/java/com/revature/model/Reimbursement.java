package com.revature.model;
import java.io.InputStream;
import java.sql.Timestamp;

import com.revature.model.ReimbursementStatus;
import com.revature.model.ReimbursementType;
import com.revature.model.User;

public class Reimbursement {
	
	 	private int id;
	    private double reimbAmount;
	    private Timestamp reimbSubmitted;
	    private Timestamp reimbResolved;
	    private String reimbDescription;
	    private InputStream reimbReceipt;
	    private User reimbAuthor;
	    private User reimbResolver;
	    private ReimbursementStatus reStatus;
	    private ReimbursementType reType;
	    
		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public double getReimbAmount() {
			return reimbAmount;
		}


		public void setReimbAmount(double reimbAmount) {
			this.reimbAmount = reimbAmount;
		}


		public Timestamp getReimbSubmitted() {
			return reimbSubmitted;
		}


		public void setReimbSubmitted(Timestamp reimbSubmitted) {
			this.reimbSubmitted = reimbSubmitted;
		}


		public Timestamp getReimbResolved() {
			return reimbResolved;
		}


		public void setReimbResolved(Timestamp reimbResolved) {
			this.reimbResolved = reimbResolved;
		}


		public String getReimbDescription() {
			return reimbDescription;
		}


		public void setReimbDescription(String reimbDescription) {
			this.reimbDescription = reimbDescription;
		}


		public InputStream getReimbReceipt() {
			return reimbReceipt;
		}


		public void setReimbReceipt(InputStream reimbReceipt) {
			this.reimbReceipt = reimbReceipt;
		}


		public User getReimbAuthor() {
			return reimbAuthor;
		}


		public void setReimbAuthor(User reimbAuthor) {
			this.reimbAuthor = reimbAuthor;
		}


		public User getReimbResolver() {
			return reimbResolver;
		}


		public void setReimbResolver(User reimbResolver) {
			this.reimbResolver = reimbResolver;
		}


		public ReimbursementStatus getReStatus() {
			return reStatus;
		}


		public void setReStatus(ReimbursementStatus reStatus) {
			this.reStatus = reStatus;
		}


		public ReimbursementType getReType() {
			return reType;
		}


		public void setReType(ReimbursementType reType) {
			this.reType = reType;
		}


		public Reimbursement(int id, double reimbAmount, Timestamp reimbSubmitted, Timestamp reimbResolved,
				String reimbDescription, InputStream reimbReceipt, User reimbAuthor, User reimbResolver,
				ReimbursementStatus reStatus, ReimbursementType reType) {
			super();
			this.id = id;
			this.reimbAmount = reimbAmount;
			this.reimbSubmitted = reimbSubmitted;
			this.reimbResolved = reimbResolved;
			this.reimbDescription = reimbDescription;
			this.reimbReceipt = reimbReceipt;
			this.reimbAuthor = reimbAuthor;
			this.reimbResolver = reimbResolver;
			this.reStatus = reStatus;
			this.reType = reType;
		}
	    
}
