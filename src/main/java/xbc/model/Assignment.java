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
@Table(name = "t_assignment")
public class Assignment implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11, nullable = false)
	private Integer id;

	@Column(name = "biodata_id", length = 11, nullable = false)
	private Integer biodataId;
	
	@ManyToOne
	@JoinColumn(name = "biodata_id", updatable = false, insertable = false)
	private Biodata biodata;

	@Column(name = "title", length = 255, nullable = false)
	private String title;

	@Column(name = "start_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Jakarta")
	private Date startDate;

	@Column(name = "end_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Jakarta")
	private Date endDate;

	@Column(name = "description", length = 255, nullable = true)
	private String description;

	@Column(name = "realization_date", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Jakarta")
	private Date realizationDate;
	
	@Column(name = "notes", length = 255, nullable = true)
	private String notes;
	
	@Column(name = "is_hold", nullable = true)
	private boolean isHold;

	@Column(name = "is_done", nullable = true)
	private boolean isDone;

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

	@Column(name = "is_delete", nullable = false)
	private boolean isDelete;

	//getter setter
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBiodataId() {
		return biodataId;
	}

	public void setBiodataId(Integer biodataId) {
		this.biodataId = biodataId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getRealizationDate() {
		return realizationDate;
	}

	public void setRealizationDate(Date realizationDate) {
		this.realizationDate = realizationDate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public boolean getIsHold() {
		return isHold;
	}

	public void setIsHold(boolean isHold) {
		this.isHold = isHold;
	}

	public boolean getIsDone() {
		return isDone;
	}

	public void setIsDone(boolean isDone) {
		this.isDone = isDone;
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

	public boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Biodata getBiodata() {
		return biodata;
	}

	public void setBiodata(Biodata biodata) {
		this.biodata = biodata;
	}
	
	
	
}
