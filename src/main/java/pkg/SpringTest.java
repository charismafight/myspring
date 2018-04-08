package pkg;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.StaticListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

public class SpringTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanconfig/TestBean.xml");
        var myBean = (MyBean) context.getBean("myBean");
        myBean.setName("test");
        System.out.println("this is appcontext's" + myBean.getName());
        // this is a deprecated class demo
        var factory = new XmlBeanFactory(new ClassPathResource("beanconfig/TestBean.xml"));
        System.out.println(factory.getClass());

        System.out.println("all beans:" + context.getBeansWithAnnotation(Component.class));
    }
}
