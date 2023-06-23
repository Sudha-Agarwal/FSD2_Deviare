package com.java.persistence;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Teacher {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int teacherId;
	
	private String teacherName;
	
	@ManyToMany
	@JoinTable(name="TEACHER_SUBJECT",
			joinColumns= {@JoinColumn(name="teacherId")},
			inverseJoinColumns = {@JoinColumn(name="subjectId")})		
	private Set<Subject> subjects = new HashSet<>();
	
	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	public Set<CollegeClass> getClasses() {
		return Classes;
	}

	public void setClasses(Set<CollegeClass> classes) {
		Classes = classes;
	}

	@ManyToMany(mappedBy="teachers")
	private Set<CollegeClass> Classes = new HashSet<CollegeClass>();

	

	
	
	

}
