package cn.com.lk.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="concentration")
public class Concentration {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer concentrationId;
	
	private Integer msgType;
	
	private Integer isPay;
	
	@OneToOne
	@JoinColumn(name="areaId")
	private Area area;
	
	@OneToOne
	@JoinColumn(name="speciesId")
	private Species species;
	
	@OneToOne
	@JoinColumn(name="industryId")
	private Industry industry;

}
