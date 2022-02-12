import com.hcq.xxx.one.Persion;
import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@Log4j
public class PeisionTest {

    @Test
    public void show() {
        long millis = System.currentTimeMillis();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Aop/applicationContext.xml");
        Persion persion = (Persion) context.getBean("persion");
        log.info(persion);
        long millis1 = System.currentTimeMillis();
        System.out.println("反射创建时间:" + (millis1 - millis) + "ms");
    }

    @Test
    public void show1() {
        long millis = System.currentTimeMillis();
        Persion persion = new Persion();
        persion.setId(1);
        persion.setUsername("hcq413");
        persion.setPassword("12345678");
        log.info(persion);
        long millis1 = System.currentTimeMillis();
        System.out.println("反射创建时间:" + (millis1 - millis) + "ms");
    }

}
