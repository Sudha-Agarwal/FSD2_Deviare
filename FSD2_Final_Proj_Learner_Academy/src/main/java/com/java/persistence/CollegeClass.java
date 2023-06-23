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
public class CollegeClass {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int classId;
	
	private String className;
	
	@ManyToMany
	@JoinTable(name="CLASS_SUBJECT",
			joinColumns= {@JoinColumn(name="classId")},
			inverseJoinColumns = {@JoinColumn(name="subjectId")})	
	private Set<Subject> subjects = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name="CLASS_TEACHER",
			joinColumns= {@JoinColumn(name="classId")},
			inverseJoinColumns = {@JoinColumn(name="teacherId")})	
	private Set<Teacher> teachers = new HashSet<>();

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

}
