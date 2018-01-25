package cn.com.lk.serviceImpl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;

import cn.com.lk.constant.ConcentrationConstant;
import cn.com.lk.dao.ConcentrationDao;
import cn.com.lk.pojo.AIS;
import cn.com.lk.pojo.Concentration;
import cn.com.lk.pojo.Radar;
import cn.com.lk.pojo.SpeciesPercent;
import cn.com.lk.service.ConcentrationServcie;

@Transactional
@Service("concentrationService")
public class ConcentrationServiceImpl extends BaseServiceImpl<Concentration> implements ConcentrationServcie {
	
	@Autowired
	private ConcentrationDao concentrationDao;
	
	@Override
	public String calculate(Integer areaId, Integer speciesId, Integer industryId, Double concentration) throws Exception {
		
		Concentration conce = new Concentration();;
		
		AIS ais = concentrationDao.getAISBy3Ids(areaId, speciesId, industryId);
		Double percent = calculatePercentByAis(ais, concentration);
		if (percent > 0){
			
			conce.setMsgType(ConcentrationConstant.MSG_TYPE_SUCCESS);
			conce.setIsPay(ConcentrationConstant.NOT_PAYED);
			conce.setPercent(getDoublePoint(percent, 6));
			conce.setConcentrationValue(concentration);
			
			conce.setAreaId(areaId);
			conce.setIndustryId(industryId);
			conce.setSpeciesId(speciesId);
			
			concentrationDao.save(conce);
			
		}else{
			conce.setMsgType(ConcentrationConstant.MSG_TYPE_ERROR);
		}
		return JSON.toJSONString(conce);
	}
	
	public double getDoublePoint(Double value, Integer pointCount){
		Double temp = null;
		if (value != null){
			temp = Double.valueOf(new BigDecimal(value).setScale(pointCount, RoundingMode.HALF_UP).toString());
		}
		return temp;
	}
	
	public double getTotalArea(double std, double avg, double finalValue){
		double totalArea = 0.0;
		double Variance = std * std;
		double temp1 = Math.log((Variance / avg + 1));
        
		double ω = Math.sqrt(temp1);
		double θ = Math.log(avg) - 0.5 * ω * ω;
		
		int n = (int) (finalValue / ConcentrationConstant.μ);
		
		for (int i = 0; i < n; i++)
        {
            double x = i * ConcentrationConstant.μ + ConcentrationConstant.μ / 2;
            double A = 1 / (ω * Math.sqrt(2 * Math.PI));
            double B = Math.exp(-1 * (Math.log(x) - θ) * (Math.log(x) - θ) / (2 * ω * ω));
            double y = A * B;
            double z = ConcentrationConstant.μ * y; //当次的面积
            
            totalArea += z;   //算总面积要循环累加
            
        }
		
		return totalArea;
	}
	
	public double calculatePercentByAis(AIS ais, Double concentration){
		
		double percent = -1.00;
		if (ais != null){
			
			Double std = ais.getStd();
			Double avg = ais.getAvg();
			Double finalValue = ais.getFinalValue();
			
			Double Variance = std * std;
			Double temp1 = Math.log((Variance / avg + 1));
            
            Double ω = Math.sqrt(temp1);
            Double θ = Math.log(avg) - 0.5 * ω * ω;
            
            int n = (int) (finalValue / ConcentrationConstant.μ);
            
            double totalArea = 0.0;  //记录总面积
            double thisArea = 0.0;  //计算当前面积
            
            List<Double> list = new ArrayList<Double>();
            
            for (int i = 0; i < n; i++)
            {
                
                double x = i * ConcentrationConstant.μ + ConcentrationConstant.μ / 2;
                double A = 1 / (ω * Math.sqrt(2 * Math.PI));
                double B = Math.exp(-1 * (Math.log(x) - θ) * (Math.log(x) - θ) / (2 * ω * ω));


                double y = A * B;

                double z = ConcentrationConstant.μ * y; //当次的面积
                thisArea += z;
                totalArea += z;   //算总面积要循环累加
                
                list.add(thisArea);

            }
            
            int m = (int) (concentration / ConcentrationConstant.μ);
            if (m < n){
            	percent = (list.get(m) / totalArea) * 100;//计算百分比
            }else{
            	percent = -1.00;
            }
		}
		return percent;
	}

	@Override
	public String calculateRadarRisk(Radar radar) throws Exception {
		
		List<SpeciesPercent> spList = radar.getSpList();
		
		int n = spList.size();
		double φ = 360 / n;
		double riskArea = 0.0;
		double RadarArea =(double) 1 / 2 * n * ConcentrationConstant.RADAR_RADIUS * ConcentrationConstant.RADAR_RADIUS * Math.sin(φ);
		
		
		for(int i = 0; i < spList.size(); i++){

			double nowLine = spList.get(i).getPercent() * ConcentrationConstant.RADAR_RADIUS;
			double nextLine = 0.0;
			if ((i + 1) >= spList.size()){
				nextLine = spList.get(0).getPercent() * ConcentrationConstant.RADAR_RADIUS;
			}else{
				nextLine = spList.get(i+1).getPercent() * ConcentrationConstant.RADAR_RADIUS;
			}
			
			System.out.println(Math.sin(φ));
			
			double oneArea = (double)1 / 2 * nextLine * nowLine * Math.sin(φ);
			System.out.println(oneArea);
			riskArea = riskArea + oneArea;
			System.out.println(riskArea);
		}
		
		double riskValue = riskArea / RadarArea;
		System.out.println(riskValue);
		return null;
	}
}
