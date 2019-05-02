package xbc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "t_test_type")
public class TestType implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11, nullable = false)
	private Integer id;

	@Column(name = "name", length = 50, nullable = false)
	private String name;

	@Column(name = "notes", length = 255, nullable = true)
	private String notes;

	@Column(name = "type_of_answer", length = 11, nullable = false)
	private Integer typeOfAnswer;

	@ManyToOne
	@JoinColumn(name = "createdBy", updatable = false, insertable = false)
	private User user;
	// ... %By
	@Column(name = "createdBy", nullable = false, length = 11)
	private Integer createdBy;

	@Column(name = "modifiedBy", nullable = true, length = 11)
	private Integer modifiedBy;

	@Column(name = "deletedBy", nullable = true, length = 11)
	private Integer deletedBy;

	// ... %On
	@Column(name = "created_on", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Jakarta")
	private Date createdOn;

	@Column(name = "modified_on", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Jakarta")
	private Date modifiedOn;

	@Column(name = "deleted_on", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Jakarta")
	private Date deletedOn;

	@Column(name="is_delete", nullable=false)
	private boolean isDelete;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Integer getTypeOfAnswer() {
		return typeOfAnswer;
	}

	public void setTypeOfAnswer(Integer typeOfAnswer) {
		this.typeOfAnswer = typeOfAnswer;
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

	public boolean getIssDelete() {
		return isDelete;
	}

	public void setIsDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

}
