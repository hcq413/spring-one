import com.hcq.xxx.one.v3.PrinterUse;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class v3Test {

    @Test
    public void A1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("v3.xml");
        PrinterUse use = (PrinterUse) context.getBean("printerUse");
    }
}
