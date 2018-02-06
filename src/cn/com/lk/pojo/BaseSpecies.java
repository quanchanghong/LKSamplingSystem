package cn.com.lk.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@OneToMany(targetEntity=AISCP.class, cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="baseSpeciesId", referencedColumnName="id")
	private Set<AISCP> AISCPSet = new HashSet<AISCP>();
	
	//private Integer pdId;
	
	@ManyToOne(targetEntity=ProductQuestion.class, fetch=FetchType.EAGER)
	@JoinColumn(name="pdId", referencedColumnName="pdId")
	private ProductQuestion productQuestion;
	
	private String customName;
	private double riskValue;
	private String date;
	private String source;
	
//	public Integer getPdId() {
//		return pdId;
//	}
//	public void setPdId(Integer pdId) {
//		this.pdId = pdId;
//	}
	public void setRiskValue(Double riskValue) {
		this.riskValue = riskValue;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ProductQuestion getProductQuestion() {
		return productQuestion;
	}
	public void setProductQuestion(ProductQuestion productQuestion) {
		this.productQuestion = productQuestion;
	}
	public String getCustomName() {
		return customName;
	}
	public void setCustomName(String customName) {
		this.customName = customName;
	}
	public double getRiskValue() {
		return riskValue;
	}
	public void setRiskValue(double riskValue) {
		this.riskValue = riskValue;
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
	
	public Set<AISCP> getAISCPSet() {
		return AISCPSet;
	}
	public void setAISCPSet(Set<AISCP> aISCPSet) {
		AISCPSet = aISCPSet;
	}
	@Override
	public String toString() {
		return "BaseSpecies [id=" + id + ", AISCPSet=" + AISCPSet
				+ ", productQuestion=" + productQuestion.getPdId() + ", customName="
				+ customName + ", riskValue=" + riskValue + ", date=" + date
				+ ", source=" + source + "]";
	}
	
}
