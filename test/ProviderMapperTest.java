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
			//1.获得mybatis核心配置文件的一个输入流对象
			InputStream is=Resources.getResourceAsStream("mybatis-config.xml");
			//2.通过输入流来创建sqlSessionFactory对象
			SqlSessionFactory fact=new SqlSessionFactoryBuilder().build(is);
			//3.通过sqlSessionFactory对象来创建sqlSessionFactory对象
			SqlSession sqlSession=fact.openSession();
			//4.调用sqlSession对象的方法来执行操作
			int count=sqlSession.selectOne("dao.ProviderMapper.getCount");
			System.out.println("获得的数据总数为："+count);
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
