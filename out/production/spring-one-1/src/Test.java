import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserDao;

public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Xop.xml");
        UserDao dao = (UserDao) context.getBean("userimpl");
        dao.getName("hcq");
    }
}
