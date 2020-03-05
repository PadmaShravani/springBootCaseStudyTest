package com.prgs.ticket;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class ModelUsers {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="userId")
	private int userId;
	@Basic
	@Column(name="userName",length=50,nullable=false)
	private String userName;
	@Basic
	@Column(name="password",length=50,nullable=false)
	private String password;
	@Basic
	@Column(name="fullName",length=50,nullable=false)
	private String fullName;
	@Basic
	@Column(name="email",length=100,nullable=false)
	private String email;
	@Basic
	@Column(name="dateOfBirth",length=50,nullable=false)
	private String dateOfBirth;

	@OneToMany(cascade=CascadeType.ALL)
	 @JoinColumn(name="userId",referencedColumnName="userId")
	private List<ModelTicketDetails> ticketDetails;
	
	
	
	
	//Constructors and methods
	
	
	public List<ModelTicketDetails> getTicketDetails() {
		return ticketDetails;
	}
	public void setTicketDetails(List<ModelTicketDetails> ticketDetails) {
		this.ticketDetails = ticketDetails;
	}
	public ModelUsers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ModelUsers(int userId, String userName, String password, String fullName, String email, String dateOfBirth) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
			}
//	public ModelUsers(int userId, String userName, String password, String fullName, String email, String dateOfBirth,
//			int roleId, List<ModelTicketDetails> mTickets) {
//		super();
//		this.userId = userId;
//		this.userName = userName;
//		this.password = password;
//		this.fullName = fullName;
//		this.email = email;
//		this.dateOfBirth = dateOfBirth;
//		this.roleId = roleId;
//		this.mTickets = mTickets;
//	}
	//Getters and Setters
	public int getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public String getFullName() {
		return fullName;
	}
	public String getEmail() {
		return email;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
//	public int getRoleId() {
//		return roleId;
//	}
//	public void setRoleId(int roleId) {
//		this.roleId = roleId;
//	}
//	public List<ModelTicketDetails> getmTickets() {
//		return mTickets;
//	}
//	public void setmTickets(List<ModelTicketDetails> mTickets) {
//		this.mTickets = mTickets;
//	}


	
	
	
}
