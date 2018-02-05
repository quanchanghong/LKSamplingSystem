package cn.com.lk.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;

/**
 * 产品不良关联类，暂时不做关联
 * @author 1500000367-3
 *
 */
@Entity
@Table(name="productquestion")
public class ProductQuestion implements Serializable{
	
	private static final long serialVersionUID = -2584484418458814138L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer pdId;
	private String type;
	private String description;
	private String reason;
	private String imgurl;
	
	private double avg;
	private double std;
	private double max;
	private double min;
	
	@OneToMany(targetEntity=BaseSpecies.class, cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="productQuestion")
	//@JoinColumn(name="pdId", referencedColumnName="pdId")
	private Set<BaseSpecies> baseSpeciesSet = new HashSet<BaseSpecies>();

	public Integer getPdId() {
		return pdId;
	}

	public void setPdId(Integer pdId) {
		this.pdId = pdId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
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

	public Double getMax() {
		return max;
	}

	public void setMax(Double max) {
		this.max = max;
	}

	public Double getMin() {
		return min;
	}

	public void setMin(Double min) {
		this.min = min;
	}

	public Set<BaseSpecies> getBaseSpeciesSet() {
		return baseSpeciesSet;
	}

	public void setBaseSpeciesSet(Set<BaseSpecies> baseSpeciesSet) {
		this.baseSpeciesSet = baseSpeciesSet;
	}

	@Override
	public String toString() {
		return "ProductQuestion [pdId=" + pdId + ", type=" + type
				+ ", description=" + description + ", reason=" + reason
				+ ", imgurl=" + imgurl + ", avg=" + avg + ", std=" + std
				+ ", max=" + max + ", min=" + min + ", baseSpeciesSet="
				+ baseSpeciesSet + "]";
	}

}
