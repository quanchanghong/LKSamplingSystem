package cn.com.lk.daoImpl;

import org.springframework.stereotype.Repository;

import cn.com.lk.dao.UserDao;
import cn.com.lk.pojo.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {


}
