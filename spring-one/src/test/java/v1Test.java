import com.hcq.xxx.one.v1.Father;
import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Log4j
public class v1Test {
    @Test
    public void a1() {
        Father father = (Father) new ClassPathXmlApplicationContext("Aop/applicationContext.xml").getBean("father");
        father.play();
    }
}
