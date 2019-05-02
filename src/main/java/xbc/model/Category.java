package xbc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity
@Table(name="t_category")
public class Category implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable=false, length=11)
	private Integer id;
	
	@Column(name="code", nullable=false, length=50)
	private String code;
	
	@Column(name="name", nullable=false, length=50)
	private String name;

	@Column(name="description", nullable=false, length=255)
	private String description;

	
	// ........ created on, modified on, deleted on

	
	@Column(name="created_on", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Jakarta")
	private Date createdOn;
	
	@Column(name="modified_on", nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Jakarta")
	private Date modifiedOn;
	
	@Column(name="deleted_on", nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Jakarta")
	private Date deletedOn;

	
	// ........ created by, modified by, deleted by
	
	
	@Column(name="created_by", nullable=false, length=11)
	private Integer createdBy;
	
	@Column(name="modified_by", nullable=true, length=11)
	private Integer modifiedBy;
	
	@Column(name="deleted_by", nullable=true, length=11)
	private Integer deletedBy;
	
	
	// ........ is_delete
	
	
	@Column(name="is_delete", nullable=false)
	private boolean isDelete;

	
	// ........ getters, setters
	

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}


	public Date getModifiedOn() {
		return modifiedOn;
	}


	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}


	public Date getDeletedOn() {
		return deletedOn;
	}


	public void setDeletedOn(Date deletedOn) {
		this.deletedOn = deletedOn;
	}


	public Integer getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}


	public Integer getModifiedBy() {
		return modifiedBy;
	}


	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}


	public Integer getDeletedBy() {
		return deletedBy;
	}


	public void setDeletedBy(Integer deletedBy) {
		this.deletedBy = deletedBy;
	}


	public boolean getIsDelete() {
		return isDelete;
	}


	public void setIsDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

}