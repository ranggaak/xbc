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
@Table(name="t_idle_news")
public class IdleNews implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable=false, length=11)
	private Integer id;
	
	@Column(name="category_id", nullable=false, length=11)
	private Integer categoryId;
	
	@ManyToOne
	@JoinColumn(name = "category_id", updatable = false, insertable = false)
	private Category category;
	
	@Column(name="title", nullable=false, length=255)
	private String title;
	
	@Column(name="content", nullable=true, length=5000)
	private String content;
	
	@Column(name="is_publish", nullable=false)
	private boolean isPublish;
	
	// ... %By
	@Column(name="createdBy", nullable=false, length=11)
	private Integer createdBy;
	
	@Column(name="modifiedBy", nullable=true, length=11)
	private Integer modifiedBy;
	
	@Column(name="deletedBy", nullable=true, length=11)
	private Integer deletedBy;
	
	// ... %On
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
	
	@Column(name="is_delete", nullable=false)
	private boolean isDelete;
	
	// ... setter & getter

	public Integer getId() {
		return id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean getIsPublish() {
		return isPublish;
	}

	public void setIsPublish(boolean isPublish) {
		this.isPublish = isPublish;
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
	
}