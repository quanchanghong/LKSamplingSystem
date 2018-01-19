package cn.com.lk.pojo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ²úÒµ±ð
 * @author 1500000367-3
 *
 */
@Entity
@Table(name="industry")
public class Industry implements Serializable{
	
	private static final long serialVersionUID = 852435009864124387L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer industryId;
	private String industryName;
	public Integer getIndustryId() {
		return industryId;
	}
	public void setIndustryId(Integer industryId) {
		this.industryId = industryId;
	}
	public String getIndustryName() {
		return industryName;
	}
	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}
	@Override
	public String toString() {
		return "Industry [industryId=" + industryId + ", industryName="
				+ industryName + "]";
	}
	
}
