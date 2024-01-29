package com.khit.library.entity;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "book")
public class Book{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // 도서번호
	
	@Column(nullable = false)
	private String name; //도서이름
	
	@Column(unique = true)
	private String number; //도서고유번호
	
	@Column(nullable = false)
	private String author; //도서저자
}
