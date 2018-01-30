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
 * area species industry三者关系实体
 * @author 1500000367-3
 *
 */
@Entity
@Table(name="ais")
public class AIS implements Serializable{
	
	private static final long serialVersionUID = 7732783269295222516L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	@OneToOne
	@JoinColumn(name="areaId")
	private Area area;
	
	@OneToOne
	@JoinColumn(name="speciesId")
	private Species species;
	
	@OneToOne
	@JoinColumn(name="industryId")
	private Industry industry;
	
	/**
	 * 平均值
	 */
	private Double avg;
	/**
	 * 标准差
	 */
	private Double std;
	/**
	 * 终值
	 */
	private Double finalValue;
	
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
	public Double getAvg() {
		return avg;
	}
	public void setAvg(Double avg) {
		this.avg = avg;
	}
	public Double getStd() {
		return std;
	}
	public void setStd(Double std) {
		this.std = std;
	}
	public Double getFinalValue() {
		return finalValue;
	}
	public void setFinalValue(Double finalValue) {
		this.finalValue = finalValue;
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
	@Override
	public String toString() {
		return "AIS [id=" + id + ", name=" + name + ", area=" + area
				+ ", species=" + species + ", industry=" + industry + ", avg="
				+ avg + ", std=" + std + ", finalValue=" + finalValue + "]";
	}
}
