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
@Table(name="t_monitoring")
public class IdleMonitoring implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable=false, length=11)
	private Integer id;
	
	@Column(name = "biodata_id", length = 11, nullable = false)
	private Integer biodataId;
	
	@ManyToOne
	@JoinColumn(name = "biodata_id", updatable = false, insertable = false)
	private Biodata biodata;

	@Column(name = "idle_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Jakarta")
	private Date idleDate;

	@Column(name = "placement_date", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Jakarta")
	private Date placementDate;

	@Column(name = "is_delete", nullable = false)
	private boolean isDelete;

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

	public Biodata getBiodata() {
		return biodata;
	}

	public void setBiodata(Biodata biodata) {
		this.biodata = biodata;
	}

	public Date getIdleDate() {
		return idleDate;
	}

	public void setIdleDate(Date idleDate) {
		this.idleDate = idleDate;
	}

	public Date getPlacementDate() {
		return placementDate;
	}

	public void setPlacementDate(Date placementDate) {
		this.placementDate = placementDate;
	}

	public boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

}