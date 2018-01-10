package cn.com.lk.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.lk.pojo.Species;
import cn.com.lk.service.SpeciesService;

@Transactional
@Service("speciesServiceImpl")
public class SpeciesServiceImpl extends BaseServiceImpl<Species> implements SpeciesService {

}
