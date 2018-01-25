package cn.com.lk.pojo;

import java.io.Serializable;

public class SpeciesPercent implements Serializable{

	private static final long serialVersionUID = -6046084735292621234L;
	
	private String species;
	private Double percent;
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public Double getPercent() {
		return percent;
	}
	public void setPercent(Double percent) {
		this.percent = percent;
	}
	@Override
	public String toString() {
		return "SpeciesPercent [species=" + species + ", percent=" + percent
				+ "]";
	}

}
