package cn.com.lk.pojo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * ����
 * @author 1500000367-3
 *
 */
@Entity
@Table(name="species")
public class Species implements Serializable{
	
	private static final long serialVersionUID = 545760217226687939L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer speciesId;
	private String	speciesName;
	public Integer getSpeciesId() {
		return speciesId;
	}
	public void setSpeciesId(Integer speciesId) {
		this.speciesId = speciesId;
	}
	public String getSpeciesName() {
		return speciesName;
	}
	public void setSpeciesName(String speciesName) {
		this.speciesName = speciesName;
	}
	@Override
	public String toString() {
		return "Species [speciesId=" + speciesId + ", speciesName="
				+ speciesName + "]";
	}
	
}
