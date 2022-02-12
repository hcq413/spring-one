import com.hcq.xxx.Aop.service.UserDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Aop/bop.xml");
        UserDao bean = (UserDao) context.getBean("userimpl");
        bean.getName("1");
    }
}
