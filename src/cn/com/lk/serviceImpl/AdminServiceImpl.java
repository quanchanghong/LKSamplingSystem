package cn.com.lk.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.lk.pojo.Admin;
import cn.com.lk.service.AdminService;

@Transactional
@Service("adminService")
public class AdminServiceImpl extends BaseServiceImpl<Admin> implements AdminService {
	

}
