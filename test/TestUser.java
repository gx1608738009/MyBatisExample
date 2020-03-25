import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
/**
 * �����û�������һ��������
 * @author Thinkpad
 *
 */
class TestUser {

	@Test
	void test() {
		try {
			//1.���mybatis���������ļ���һ������������
			InputStream is=Resources.getResourceAsStream("mybatis-config.xml");
			//2.ͨ��������������sqlSessionFactory����
			SqlSessionFactory fac=new SqlSessionFactoryBuilder().build(is);
			//3.ͨ��sqlSessionFactory����������sqlSessionFactory����
			SqlSession sqlSession=fac.openSession();
			//4.����sqlSession����ķ�����ִ�в���
			//ִ��sql���ֻ����һ�����ݷ���selectOne
			int count=sqlSession.selectOne("dao.UserMapper.getCount");
			System.out.println("��õ�����������"+count);
			//�ر�sqlSession����
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
