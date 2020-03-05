package com.perscholas.prgs.Registration;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="Users")
public class ModelUsers {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="userId")
	private int userId;
	@Basic
	@Column(name="firstName",length=50,nullable=false)
	private String firstName;

	@Basic
	@Column(name="lastName",length=50,nullable=false)
	private String lastName;
	@Basic
	
    @Size(min = 2, max = 30,message="wrong username")
	@Column(name="userName",length=50,nullable=false)
	private String userName;
	@Basic
	@Column(name="password",length=50,nullable=false)
	private String password;
	@Basic
	@Column(name="email",length=100,nullable=false)
	private String email;
	@Basic
	@Column(name="dateOfBirth",length=50,nullable=false)
	private String dateOfBirth;

//	@OneToOne
//	   private ModelRole role;
	
	//Constructors and methods
	//for login
	public void login() {
		
	}
	//for Sign up
	public void createNewUser() {
		
	}
	//to save user details 
	public void saveuser() {
		
	}
	
	public ModelUsers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ModelUsers(int userId, String firstName, String lastName, String password, String email,
			String dateOfBirth) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserId() {
		return userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPassword() {
		return password;
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
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	

	
	
	
}
