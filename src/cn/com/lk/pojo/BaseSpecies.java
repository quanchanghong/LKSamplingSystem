package cn.com.lk.pojo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 和风险值相关的物种，需求随时在改，暂时只有这样
 * 
 * @author 1500000367-3
 *
 */
@Entity
@Table(name="basespecies")
public class BaseSpecies implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String customName;
	
	private String date;
	private String source;
	
	private String percent;
	private double concentrationValue;
	
	private Integer speciesId;
	private Integer areaId;
	private Integer industryId;
	
	@OneToOne
	@JoinColumn(name="industryId", insertable=false, updatable=false)
	private Industry industry;
	
	@OneToOne
	@JoinColumn(name="areaId", insertable=false, updatable=false)
	private Area area;
	
	@OneToOne
	@JoinColumn(name="speciesId", insertable=false, updatable=false)
	private Species species;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCustomName() {
		return customName;
	}
	public void setCustomName(String customName) {
		this.customName = customName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getPercent() {
		return percent;
	}
	public void setPercent(String percent) {
		this.percent = percent;
	}
	public double getConcentrationValue() {
		return concentrationValue;
	}
	public void setConcentrationValue(double concentrationValue) {
		this.concentrationValue = concentrationValue;
	}
	public Integer getSpeciesId() {
		return speciesId;
	}
	public void setSpeciesId(Integer speciesId) {
		this.speciesId = speciesId;
	}
	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public Integer getIndustryId() {
		return industryId;
	}
	public void setIndustryId(Integer industryId) {
		this.industryId = industryId;
	}
	public Industry getIndustry() {
		return industry;
	}
	public void setIndustry(Industry industry) {
		this.industry = industry;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "BaseSpecies [id=" + id + ", customName=" + customName
				+ ", date=" + date + ", source=" + source + ", percent="
				+ percent + ", concentrationValue=" + concentrationValue
				+ ", speciesId=" + speciesId + ", areaId=" + areaId
				+ ", industryId=" + industryId + ", industry=" + industry
				+ ", area=" + area + ", species=" + species + "]";
	}
	
}
