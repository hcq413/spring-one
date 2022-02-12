import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;

public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config/Xop.xml");
        UserService bean = (UserService) context.getBean("userService");
        String b = bean.finduserId("hcq");
        System.out.println(b);
    }
}
