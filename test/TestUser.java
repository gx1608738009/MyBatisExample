import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
/**
 * 测试用户操作的一个测试类
 * @author Thinkpad
 *
 */
class TestUser {

	@Test
	void test() {
		try {
			//1.获得mybatis核心配置文件的一个输入流对象
			InputStream is=Resources.getResourceAsStream("mybatis-config.xml");
			//2.通过输入流来创建sqlSessionFactory对象
			SqlSessionFactory fac=new SqlSessionFactoryBuilder().build(is);
			//3.通过sqlSessionFactory对象来创建sqlSessionFactory对象
			SqlSession sqlSession=fac.openSession();
			//4.调用sqlSession对象的方法来执行操作
			//执行sql语句只返回一个数据方法selectOne
			int count=sqlSession.selectOne("dao.UserMapper.getCount");
			System.out.println("获得的数据总数："+count);
			//关闭sqlSession对象
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
