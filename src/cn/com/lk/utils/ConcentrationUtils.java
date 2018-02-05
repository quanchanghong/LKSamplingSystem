package cn.com.lk.utils;

import java.util.List;

import cn.com.lk.constant.ConcentrationConstant;

public class ConcentrationUtils {
	
	/**
	 * 根据浓度排名值计算对应的风险值
	 * @param listPercent
	 * @return
	 */
	public static double calculateRiskValue(List<Double> listPercent){
		int n = listPercent.size();
		
		if (n <= 2){
			return ConcentrationConstant.CALCULATE_RISK_VALUE_ERROR;
		}
		
		double φ = 360 / n;
		double riskArea = 0.0;
		double RadarArea =(double) 1 / 2 * n * ConcentrationConstant.RADAR_RADIUS * ConcentrationConstant.RADAR_RADIUS * Math.sin(φ);
		
		for(int i = 0; i < listPercent.size(); i++){

			double nowLine = listPercent.get(i);
			double nextLine = 0.0;
			if ((i + 1) >= listPercent.size()){
				nextLine = listPercent.get(0);
			}else{
				nextLine = listPercent.get(i+1);
			}
			
			double oneArea = (double)1 / 2 * nextLine * nowLine * Math.sin(φ);
			riskArea = riskArea + oneArea;
			
		}
		
		double riskValue = riskArea / RadarArea;
		return riskValue;
	}

}
