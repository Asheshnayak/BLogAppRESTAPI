package com.jsp.blogapp.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="post_table")
public class PostEntity {
	@Id
	@Column(name="post_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;
	@Column(name="title")
	private String title;
	@Column(name="post_date")
	private String postDate;
	@Column(name="creation_time")
	private LocalDateTime creationTime;
	@OneToMany(mappedBy="postEntity")
	@Cascade(CascadeType.REMOVE)
	private List <CommentEntity> comment;
	@ManyToOne
	private UserEntity userEntity;
}
