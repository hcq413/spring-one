import com.hcq.xxx.Aop.v3.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class AopTest {

    @Test
    public void show2() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Aop/Bop.xml");
        UserServiceImpl demo = (UserServiceImpl) context.getBean("demo");
        demo.finduserId("1");
    }
}
