package cn.com.lk.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Radar implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private List<SpeciesPercent> spList = new ArrayList<SpeciesPercent>();
	private double riskValue;

	public double getRiskValue() {
		return riskValue;
	}

	public void setRiskValue(double riskValue) {
		this.riskValue = riskValue;
	}

	public List<SpeciesPercent> getSpList() {
		return spList;
	}

	public void setSpList(List<SpeciesPercent> spList) {
		this.spList = spList;
	}

	@Override
	public String toString() {
		return "Radar [spList=" + spList + ", riskValue=" + riskValue + "]";
	}


}
