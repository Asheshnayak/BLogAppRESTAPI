package com.jsp.blogapp.entity;

import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;
	@Column(name="name",nullable=false)
	private String name;
	@Column(name="email",nullable=false,unique=true)
	private String email;
	@Column(name="phone_no",nullable=false,unique=true)
	private Long phoneNo;
	@Column(name="password",nullable=false)
	private String password;
	@Column(name="gender")
	private String gender;
	@Column(name="date_of_birth")
	private String dob;
	@OneToMany(mappedBy="userEntity")
	@Cascade(CascadeType.REMOVE)
	private List <PostEntity> post;
	@OneToMany(mappedBy="userEntity")
	@Cascade(CascadeType.REMOVE)
	private List<CommentEntity> comment;
}
