package cn.com.lk.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.lk.pojo.Admin;

public class XmlConfigTest {
	
	@Test
	public void testBean(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContextTest.xml");
		Aservice<Admin> s =  (AAserviceImpl) ctx.getBean("AAservice");
		s.sayHello();
	}
	
}
