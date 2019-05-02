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
@Table(name="t_biodata")
public class Biodata implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", length=11, nullable=false, columnDefinition = "serial")
	private Integer id;
	
	@Column(name="name", length=255, nullable=false)
	private String name;
	
	@Column(name="gender", length=5)
	private String gender;
	
	@Column(name="last_education", length=100, nullable=false)
	private String lastEducation;
	
	@Column(name="gradution_yeaar", length=5, nullable=false)
	private String graduationYear;
	
	@Column(name="educational_level", length=5, nullable=false)
	private String educationalLevel;
	
	@Column(name="majors", length=100, nullable=false)
	private String majors;
	
	@Column(name="gpa", length=5, nullable=false)
	private String gpa;
	
	@ManyToOne
	@JoinColumn(name="bootcamp_test_type", updatable=false, insertable=false)
	private BootcampTestType bootCampTestType;
	
	@Column(name="bootcamp_test_type", length=11)
	private Integer bootcampTestType;
	
	@Column(name="iq", length=4)
	private Integer iq;
	
	@Column(name="du", length=10)
	private String du;
	
	@Column(name="arithmetic", length=5)
	private Integer arithmetic;
	
	@Column(name="nested_logic", length=5)
	private Integer nestedLogic;
	
	@Column(name="join_table", length=5)
	private Integer joinTable;
	
	@Column(name="tro", length=50)
	private String tro;
	
	@Column(name="notes", length=100)
	private String notes;
	
	@Column(name="interviewer", length=100)
	private String interviewer;
	
	@Column(name="create_by", length=11, nullable=false)
	private Integer createBy;
	
	@Column(name="created_on", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Jakarta")
	private Date createdOn;
	
	@Column(name="modified_by", length=11)
	private Integer modifiedBy;
	
	@Column(name="modified_on")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Jakarta")
	private Date modifiedOn;
	
	@Column(name="delete_by", length=11)
	private Integer deleteBy;
	
	@Column(name="delete_on")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Jakarta")
	private Date deleteOn;
	
	@Column(name="is_delete", nullable=false)
	private boolean isDelete;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public String getLastEducation() {
		return lastEducation;
	}

	public String getGraduationYear() {
		return graduationYear;
	}

	public String getEducationalLevel() {
		return educationalLevel;
	}

	public String getMajors() {
		return majors;
	}

	public String getGpa() {
		return gpa;
	}

	public BootcampTestType getBootCampTestType() {
		return bootCampTestType;
	}

	public Integer getBootcampTestType() {
		return bootcampTestType;
	}

	public Integer getIq() {
		return iq;
	}

	public String getDu() {
		return du;
	}

	public Integer getArithmetic() {
		return arithmetic;
	}

	public Integer getNestedLogic() {
		return nestedLogic;
	}

	public Integer getJoinTable() {
		return joinTable;
	}

	public String getTro() {
		return tro;
	}

	public String getNotes() {
		return notes;
	}

	public String getInterviewer() {
		return interviewer;
	}

	public Integer getCreateBy() {
		return createBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public Integer getDeleteBy() {
		return deleteBy;
	}

	public Date getDeleteOn() {
		return deleteOn;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setLastEducation(String lastEducation) {
		this.lastEducation = lastEducation;
	}

	public void setGraduationYear(String graduationYear) {
		this.graduationYear = graduationYear;
	}

	public void setEducationalLevel(String educationalLevel) {
		this.educationalLevel = educationalLevel;
	}

	public void setMajors(String majors) {
		this.majors = majors;
	}

	public void setGpa(String gpa) {
		this.gpa = gpa;
	}

	public void setBootCampTestType(BootcampTestType bootCampTestType) {
		this.bootCampTestType = bootCampTestType;
	}

	public void setBootcampTestType(Integer bootcampTestType) {
		this.bootcampTestType = bootcampTestType;
	}

	public void setIq(Integer iq) {
		this.iq = iq;
	}

	public void setDu(String du) {
		this.du = du;
	}

	public void setArithmetic(Integer arithmetic) {
		this.arithmetic = arithmetic;
	}

	public void setNestedLogic(Integer nestedLogic) {
		this.nestedLogic = nestedLogic;
	}

	public void setJoinTable(Integer joinTable) {
		this.joinTable = joinTable;
	}

	public void setTro(String tro) {
		this.tro = tro;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public void setInterviewer(String interviewer) {
		this.interviewer = interviewer;
	}

	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public void setDeleteBy(Integer deleteBy) {
		this.deleteBy = deleteBy;
	}

	public void setDeleteOn(Date deleteOn) {
		this.deleteOn = deleteOn;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

}
