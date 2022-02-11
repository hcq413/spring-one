import com.hcq.xxx.one.v2.UserEmp;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class v2Test {

    @Test
    public void List() {
        UserEmp bean = (UserEmp) new ClassPathXmlApplicationContext("Collecttions.xml").getBean("useremp");
        bean.getList().forEach(System.out::println);
        bean.getSet().forEach(System.out::println);
        bean.getMap().forEach((K, V) -> System.out.println(V));
         bean.getProperties().forEach((K,V)-> System.out.println(V));
    }
}
