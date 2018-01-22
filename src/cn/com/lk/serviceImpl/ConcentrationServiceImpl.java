package cn.com.lk.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;

import cn.com.lk.constant.ConcentrationConstant;
import cn.com.lk.dao.ConcentrationDao;
import cn.com.lk.pojo.AIS;
import cn.com.lk.service.ConcentrationServcie;

@Transactional
@Service("concentrationService")
public class ConcentrationServiceImpl extends BaseServiceImpl<AIS> implements ConcentrationServcie {
	
	@Autowired
	private ConcentrationDao concentrationDao;
	
	@Override
	public Double calculate(Integer areaId, Integer speciesId, Integer industryId, Double concentration) throws Exception {
		AIS ais = concentrationDao.getAISBy3Ids(areaId, speciesId, industryId);
		Double percent = calculatePercentByAis(ais, concentration);
		if (percent < 0){
			
		}
		return null;
	}
	
	public Double calculatePercentByAis(AIS ais, Double concentration){
		
		double percent = -1.00;
		if (ais != null){
			
			Double std = ais.getStd();
			Double avg = ais.getAvg();
			Double finalValue = ais.getFinalValue();
			
			Double Variance = std * std;
			Double temp1 = Math.log((Variance / avg + 1));
            
            Double �� = Math.sqrt(temp1);
            Double �� = Math.log(avg) - 0.5 * �� * ��;
            
            int n = (int) (finalValue / ConcentrationConstant.��);
            
            double totalArea = 0.0;  //��¼�����
            double thisArea = 0.0;  //���㵱ǰ���
            
            List<Double> list = new ArrayList<Double>();
            
            for (int i = 0; i < n; i++)
            {
                
                double x = i * ConcentrationConstant.�� + ConcentrationConstant.�� / 2;
                double A = 1 / (�� * Math.sqrt(2 * Math.PI));
                double B = Math.exp(-1 * (Math.log(x) - ��) * (Math.log(x) - ��) / (2 * �� * ��));


                double y = A * B;

                double z = ConcentrationConstant.�� * y; //���ε����
                thisArea += z;
                totalArea += z;   //�������Ҫѭ���ۼ�
                
                list.add(thisArea);

            }
            
            int m = (int) (concentration / ConcentrationConstant.��);
            if (m < n){
            	percent = (list.get(m) / totalArea) * 100;//����ٷֱ�
            }else{
            	percent = -1.00;
            }
		}
		return percent;
	}
}
