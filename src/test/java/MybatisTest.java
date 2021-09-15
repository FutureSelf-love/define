import cn.main.dao.UserDao;
import cn.main.domain.User;
import cn.main.mybatis.SqlSession.SqlSession;
import cn.main.mybatis.SqlSession.SqlSessionFactory;
import cn.main.mybatis.SqlSession.SqlSessionFactoryBuilder;
import cn.main.mybatis.io.Resources;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
public class MybatisTest {
    public static void main(String[] args) throws IOException {
    //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapperConfig.xml");
    //2.创建 SqlSessionFactory 的构建者对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    //3.使用构建者创建工厂对象 SqlSessionFactory
        SqlSessionFactory factory = builder.bulid(in);
    //4.使用 SqlSessionFactory 生产 SqlSession 对象
        SqlSession session = factory.openSession();
    //5.使用 SqlSession 创建 dao 接口的代理对象
        UserDao userDao = session.getMapper(UserDao.class);
    //6.使用代理对象执行查询所有方法
        List<User> users = userDao.findAll();
        for(User user : users) {
            System.out.println(user);
        }
    //7.释放资源
        session.close();
        in.close();

    }
}
