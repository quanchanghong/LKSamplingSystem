package cn.com.lk.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.lk.dao.AdminDao;
import cn.com.lk.pojo.Admin;
import cn.com.lk.service.AdminService;

@Transactional
@Service("adminService")
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDao adminDao;

	@Override
	public Admin login(Integer adminId) {
		return adminDao.login(adminId);
	}

}
