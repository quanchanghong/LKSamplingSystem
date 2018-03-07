package cn.com.lk.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.lk.dao.IndustryDao;
import cn.com.lk.pojo.Industry;
import cn.com.lk.pojo.Page;
import cn.com.lk.service.IndustryService;

@Transactional
@Service("industryService")
public class IndustryServiceImpl extends BaseServiceImpl<Industry> implements IndustryService {

	@Autowired
	@Qualifier("industryDao")
	private IndustryDao industryDao;
	
	@Override
	public Page<Industry> searchByName(String industryName) throws Exception {
		return industryDao.searchByName(industryName);
	}

}
