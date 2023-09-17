package com.example.skiply.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String studentName;
	private String studentGrade;
	private String schoolName;
	private String mobile;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "receipt_id")
	private Receipt receipt;

}
