package com.java.persistence;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Subject {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int subjectId;
	
	private String subjectName;
	
	@ManyToMany(mappedBy = "subjects")
	private Set<Teacher> Teachers = new HashSet<>();

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Set<Teacher> getTeachers() {
		return Teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		Teachers = teachers;
	}

}
