package com.jsp.blogapp.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="comment_table")
public class CommentEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="comment_id")
	private int commentId;
	@Column(name="comment_data")
	private String commentData;
	@Column(name="creation_time")
	private LocalDateTime creationTime;
	@ManyToOne
	@JsonIgnore
	private PostEntity postEntity;
	@ManyToOne
	@JsonIgnore
	private UserEntity userEntity;
}
