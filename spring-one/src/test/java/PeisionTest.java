import com.hcq.xxx.one.Persion;
import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Log4j
public class PeisionTest {

    @Test
    public void show() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Persion persion = (Persion) context.getBean("persion");
        log.info(persion);
    }
}
