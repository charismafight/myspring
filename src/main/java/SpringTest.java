import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("TestBean.xml");
        var myBean = (MyBean) context.getBean("MyBean");

        System.out.println(context);
    }
}
