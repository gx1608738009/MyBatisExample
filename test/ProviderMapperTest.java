import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

class ProviderMapperTest {

	@Test
	void test() {
		try {
			//1.���mybatis���������ļ���һ������������
			InputStream is=Resources.getResourceAsStream("mybatis-config.xml");
			//2.ͨ��������������sqlSessionFactory����
			SqlSessionFactory fact=new SqlSessionFactoryBuilder().build(is);
			//3.ͨ��sqlSessionFactory����������sqlSessionFactory����
			SqlSession sqlSession=fact.openSession();
			//4.����sqlSession����ķ�����ִ�в���
			int count=sqlSession.selectOne("dao.ProviderMapper.getCount");
			System.out.println("��õ���������Ϊ��"+count);
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
