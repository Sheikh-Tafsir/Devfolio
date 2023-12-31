package com.example.demo.common.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@SuperBuilder
public abstract class BaseEntity implements Serializable {
	
	@CreationTimestamp
	@Temporal (TemporalType.TIMESTAMP)
	@Column (nullable = false)
	private Date createdAt;
	
	@UpdateTimestamp
	@Temporal (TemporalType.TIMESTAMP)
	@Column()
	private Date updatedAt;
	
}
