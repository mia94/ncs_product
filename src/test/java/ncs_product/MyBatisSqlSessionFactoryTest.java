package ncs_product;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import ncs_product.jdbc.MyBatisSqlSessionFactory;

public class MyBatisSqlSessionFactoryTest extends AbstractTest{
	
	private static final Log log = LogFactory.getLog(MyBatisSqlSessionFactoryTest.class);


	@Test
	public void testOpenSession() {
		log.debug("testOpenSession()");
		
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		log.debug("session "+session);
		Assert.assertNotNull(session);
	}

}
