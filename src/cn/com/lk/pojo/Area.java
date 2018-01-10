package cn.com.lk.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ÖÆ³ÌÇøÓò
 * @author 1500000367-3
 *
 */
@Entity
@Table(name="area")
public class Area {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer areaId;
	private String areaName;
	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	@Override
	public String toString() {
		return "Area [areaId=" + areaId + ", areaName=" + areaName + "]";
	}
	
}
