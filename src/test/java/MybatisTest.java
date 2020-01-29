
import com.yage.dao.UserDAO;
import com.yage.domain.User;
import com.yage.mybatis.io.Resources;
import com.yage.mybatis.sqlsession.SqlSession;
import com.yage.mybatis.sqlsession.SqlSessionFactory;
import com.yage.mybatis.sqlsession.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author LOL_toulan
 * @Time 2020/1/27 18:50
 * @Message
 */
public class MybatisTest {


    /**
     * 入门案例
     * @param args
     */
    public static void main(String[] args) throws Exception {

        //1.读取配置文件
        //2.创建SqlSessionFactory工厂
        //3.使用工厂生产SqlSession对象
        //4.使用SqlSession创建Dao接口的代理对象
        //5.使用代理对象执行方法
        //6.释放资源

        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("datasource.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 通过SqlSessionFactoryBuilder对象，调用builder();方法，返回一个SqlSessionFactory
        // 对象，
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        // 重点
        UserDAO userDao = session.getMapper(UserDAO.class);
        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for(User user : users){
            System.out.println(user);
        }
        //6.释放资源
        session.close();
        in.close();
    }

}
