package com.example.skiply.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "receipt")
public class Receipt {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Long fee;

	private String dateTime;

	private String cardNumber;

	private String cardType;

	private Long studentId;

}
