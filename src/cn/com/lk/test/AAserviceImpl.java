package cn.com.lk.test;

public class AAserviceImpl<T> implements Aservice<T> {
	
	private Adao dao;


	public void setDao(Adao dao) {
		this.dao = dao;
	}

	@Override
	public void sayHello() {
		System.out.println("service log");
		dao.sayHello();
	}

}
