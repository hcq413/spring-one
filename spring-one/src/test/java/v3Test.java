import com.hcq.xxx.one.v3.PrinterUse;
import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Log4j
public class v3Test {

    @Test
    public void A1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Aop/v3.xml");
        PrinterUse use = (PrinterUse) context.getBean("printerUse");
        use.printshow();
    }
}
