package cn.appsys.dao.back.appinfo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestQuery {
	public static void main(String[] args) {
		
	}
	
	@Test
	public void testQ() {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
		BackAppInfoMapper backAppInfoMapper = (BackAppInfoMapper)context.getBean("backAppInfoMapper");
		int row = backAppInfoMapper.queryTotalCount(null, null, null, null, null);
		System.out.println("row的值为:" + row);
	}
}
