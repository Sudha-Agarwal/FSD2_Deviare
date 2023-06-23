package persistence;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="address")
	private String address;
	
	@ManyToOne
	@JoinColumn(name="dept_id")
	private Department department;
	
	
	public Set<Meeting> getMeetings() {
		return meetings;
	}


	public void setMeetings(Set<Meeting> meetings) {
		this.meetings = meetings;
	}


	@ManyToMany
	@JoinTable(name="employee_meeting",
		joinColumns = {@JoinColumn(name="employee_id")},
		inverseJoinColumns = {@JoinColumn(name="meeting_id")}
			)
	private Set<Meeting> meetings = new HashSet<>();
	
	/*
	@OneToOne
	@JoinColumn(name="address_id")
	private Address address1;
	*/
	public int getId() {
		return id;
	}


	/*public Address getAddress1() {
		return address1;
	}


	public void setAddress1(Address address1) {
		this.address1 = address1;
	}
*/

	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}



	
	
	
	
	

}
