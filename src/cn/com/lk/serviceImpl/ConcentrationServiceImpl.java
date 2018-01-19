package cn.com.lk.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.lk.pojo.AIS;
import cn.com.lk.service.ConcentrationServcie;

@Transactional
@Service("concentrationService")
public class ConcentrationServiceImpl extends BaseServiceImpl<AIS> implements ConcentrationServcie {

}
