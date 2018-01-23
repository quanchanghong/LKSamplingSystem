package cn.com.lk.pojo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="concentration")
public class Concentration implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer concentrationId;
	
	private Integer msgType;
	
	private Integer isPay;
	
	private Double percent;
	
	private Double concentrationValue;
	
	private Integer areaId;
	private Integer speciesId;
	private Integer industryId;
	private Integer userId;
	
	@OneToOne
	@JoinColumn(name="areaId", insertable=false, updatable=false)
	private Area area;
	
	@OneToOne
	@JoinColumn(name="speciesId", insertable=false, updatable=false)
	private Species species;
	
	@OneToOne
	@JoinColumn(name="industryId", insertable=false, updatable=false)
	private Industry industry;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getSpeciesId() {
		return speciesId;
	}

	public void setSpeciesId(Integer speciesId) {
		this.speciesId = speciesId;
	}

	public Integer getIndustryId() {
		return industryId;
	}

	public void setIndustryId(Integer industryId) {
		this.industryId = industryId;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Integer getConcentrationId() {
		return concentrationId;
	}

	public void setConcentrationId(Integer concentrationId) {
		this.concentrationId = concentrationId;
	}

	public Integer getMsgType() {
		return msgType;
	}

	public void setMsgType(Integer msgType) {
		this.msgType = msgType;
	}

	public Integer getIsPay() {
		return isPay;
	}

	public void setIsPay(Integer isPay) {
		this.isPay = isPay;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Species getSpecies() {
		return species;
	}

	public void setSpecies(Species species) {
		this.species = species;
	}

	public Industry getIndustry() {
		return industry;
	}

	public void setIndustry(Industry industry) {
		this.industry = industry;
	}

	public Double getPercent() {
		return percent;
	}

	public void setPercent(Double percent) {
		this.percent = percent;
	}

	public Double getConcentrationValue() {
		return concentrationValue;
	}

	public void setConcentrationValue(Double concentrationValue) {
		this.concentrationValue = concentrationValue;
	}

	@Override
	public String toString() {
		return "Concentration [concentrationId=" + concentrationId
				+ ", msgType=" + msgType + ", isPay=" + isPay + ", percent="
				+ percent + ", concentrationValue=" + concentrationValue
				+ ", areaId=" + areaId + ", speciesId=" + speciesId
				+ ", industryId=" + industryId + ", userId=" + userId
				+ ", area=" + area + ", species=" + species + ", industry="
				+ industry + "]";
	}

}
