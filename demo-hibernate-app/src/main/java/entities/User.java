package entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="usertest")
@DynamicUpdate
public class User {

	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="name" , nullable=false,length=50)
	private String firstName;
	
	@Column(name="email" , nullable=false,length=50)
	private String email;
	
	@CreationTimestamp
	private LocalDate creationDate;
	private String password;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(Long id, String firstName, String email, LocalDate creationDate, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.email = email;
		this.creationDate = creationDate;
		this.password = password;
	}
	public User() {
		super();
	}
	
	
}
