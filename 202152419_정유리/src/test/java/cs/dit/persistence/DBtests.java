package cs.dit.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)		//���� �׽�Ʈ �ڵ尡 ������ ���� ������ �� ���̶�� �˸�
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")	//�������� �о��
@Log4j	//lombok�� �̿��� �α׸� ����ϴ� Logger�� ������ ����
public class DBtests {

	@Test
	public void testConnection() {
		try {
			Class class1 = Class.forName("org.mariadb.jdbc.Driver");
			
			log.info(class1);
			
			Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3333/yuridb", "yuri", "1111");
			
			log.info(con);
			
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Autowired
	private DataSource ds;
	
	@Test
	public void testHikariCP() {
		try(Connection con = ds.getConnection();)
		{
			log.info("con : ----------------------");
			log.info(con);
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	
	@Autowired
	private SqlSessionFactory sessionFactory;
	
	@Test
	public void testMybatis() {
		try(	SqlSession session = sessionFactory.openSession();
				Connection con = session.getConnection()) 
		{
			log.info("SqlSession : -------------------");
			log.info(session);
			log.info(con);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	

}
