package com.yurets_y.spring_tutor_001.ch8_jpa.auditable.entities;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

/**
 * Created by iuliana.cosmina on 5/7/17.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditableEntity<U> implements Serializable {
	@CreatedDate
	@Column(name = "CREATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date createdDate;

	@CreatedBy
	@ManyToOne
	@JoinColumn(name="CREATOR_ID")
	protected Creator createdBy;

	@LastModifiedBy
	@ManyToOne
	@JoinColumn(name = "LAST_MODIFIED_BY")
	protected Creator lastModifiedBy;

	@LastModifiedDate
	@Column(name = "LAST_MODIFIED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date lastModifiedDate;

	public Optional<Creator> getCreatedBy() {
		return Optional.of(createdBy);
	}

	public void setCreatedBy(Creator createdBy) {
		this.createdBy = createdBy;
	}

	public Optional<Date> getCreatedDate() {
		return Optional.of(createdDate);
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Optional<Creator> getLastModifiedBy() {
		return Optional.of(lastModifiedBy);
	}

	public void setLastModifiedBy(Creator lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Optional<Date> getLastModifiedDate() {
		return Optional.of(lastModifiedDate);
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

}
