package cn.com.lk.pojo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="aiscp")
public class AISCP implements Serializable{

	private static final long serialVersionUID = 7538787198057398443L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private double concentrationValue;
	private String percent;
	
	//@ManyToOne(targetEntity=BaseSpecies.class, cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	//@JoinColumn(name="baseSpeciesId", referencedColumnName="id")
	//private BaseSpecies baseSpecies;
	
	private Integer industryId;
	private Integer areaId;
	private Integer speciesId;
	
	@OneToOne
	@JoinColumn(name="industryId", insertable=false, updatable=false)
	private Industry industry;
	@OneToOne
	@JoinColumn(name="areaId", insertable=false, updatable=false)
	private Area area;
	@OneToOne
	@JoinColumn(name="speciesId", insertable=false, updatable=false)
	private Species species;
	
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
	public Integer getSpeciesId() {
		return speciesId;
	}
	public void setSpeciesId(Integer speciesId) {
		this.speciesId = speciesId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getConcentrationValue() {
		return concentrationValue;
	}
	public void setConcentrationValue(double concentrationValue) {
		this.concentrationValue = concentrationValue;
	}
	public String getPercent() {
		return percent;
	}
	public void setPercent(String percent) {
		this.percent = percent;
	}
//	public BaseSpecies getBaseSpecies() {
//		return baseSpecies;
//	}
//	public void setBaseSpecies(BaseSpecies baseSpecies) {
//		this.baseSpecies = baseSpecies;
//	}
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
	@Override
	public String toString() {
		return "AISCP [id=" + id + ", concentrationValue=" + concentrationValue
				+ ", percent=" + percent + ", industryId=" + industryId
				+ ", areaId=" + areaId + ", speciesId=" + speciesId
				+ ", industry=" + industry + ", area=" + area + ", species="
				+ species + "]";
	}
	
}
