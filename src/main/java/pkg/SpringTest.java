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
import spring_in_practise.ch01.AccountDAOImpl;
import spring_in_practise.ch01.AccountService;

import java.lang.invoke.VarHandle;

public class SpringTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanconfig/TestBean.xml");
        MyBean myBean = (MyBean) context.getBean("myBean");
//        myBean.setName("test");
        System.out.println("this is appcontext's " + myBean.getName());
        // this is a deprecated class demo
        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("beanconfig/TestBean.xml"));
        System.out.println(factory.getClass());

        System.out.println("all beans:" + context.getBeansWithAnnotation(Component.class));

        System.out.println("di injection below");
        BeanService s = new BeanService();
        s.setMyAnnoBean(new MyAnnoBean());
        s.getMyAnnoBean().setId(1);
        System.out.println("beanService's myAnnoBean's id:" + s.getMyAnnoBean().getId());

        System.out.println("spring in practise ch01 start:");
        AccountDAOImpl accountDAO = (AccountDAOImpl) context.getBean("accountDAO");
        System.out.println(accountDAO.getCsvResource().getFilename());
        System.out.println("spring in practise ch01 end:");
    }
}
