package cn.com.lk.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.lk.pojo.Industry;
import cn.com.lk.service.IndustryService;

@Transactional
@Service("industryService")
public class IndustryServiceImpl extends BaseServiceImpl<Industry> implements IndustryService {

}
