package pkg;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import spring_in_practise.ch01.AccountDAOImpl;
import spring_in_practise.ch01.AccountService;
import spring_in_practise.ch01.ProtoTypeModel;
import spring_in_practise.ch02.dao.ContactDao;
import spring_in_practise.ch02.dao.hbn.HbnConactDao;
import spring_in_practise.ch02.model.Contact;
import spring_in_practise.ch02.service.ContactService;
import springinaction.ch02.CDPlayer;
import springinaction.ch02.CompactDisc;
import springinaction.ch02.Config;
import springinaction.ch02.SgtPepper;
import springinaction.ch03.Performance;
import springinaction.ch03.Singer;

import javax.inject.Inject;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;

public class SpringTest {
    public static void main(String[] args) throws NamingException {
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


        ApplicationContext context1 = new AnnotationConfigApplicationContext(Config.class);
        CDPlayer cdPlayer = (CDPlayer) context1.getBean("cdplayer");
        cdPlayer.play();
        cdPlayer = (CDPlayer) context1.getBean("cdplayer");
        System.out.println("-----------------cd player property bean id is:" + cdPlayer.getId());

        System.out.println("spring in practise ch01 start....");
        AccountDAOImpl accountDAO = (AccountDAOImpl) context.getBean("accountDAO");
        System.out.println(accountDAO.getCsvResource().getFilename());
        System.out.println("prototype test start....");
        AccountDAOImpl service = (AccountDAOImpl) ((AccountService) context.getBean("accountService")).getAccountDAO();
        System.out.println("service's MyAnnoBeanmark now is " + service.getMark());
        service.setMark(1);
        System.out.println("set mark to 1");
        AccountDAOImpl service1 = (AccountDAOImpl) ((AccountService) context.getBean("accountService")).getAccountDAO();
        System.out.println("service1's mark is: " + service1.getMark());
        ProtoTypeModel protoTypeModel = (ProtoTypeModel) context.getBean("protoTypeModel");
        System.out.println("protoTypeModel: " + protoTypeModel.getMark());
        protoTypeModel.setMark(1);
        ProtoTypeModel protoTypeModel1 = (ProtoTypeModel) context.getBean("protoTypeModel");
        System.out.println("protoTypeModel1: " + protoTypeModel1.getMark());
        System.out.println("prototype test end");
        System.out.println("spring in practise ch01 end");

//        System.out.println("spring in practise ch02 start");
//        ContactService contactService = (ContactService) context.getBean("contactServiceImpl");
//        ContactDao hbnConactDao = (ContactDao) context.getBean("hbnConactDao");
//        var contact_email = hbnConactDao.findByEmail("lli");
//        System.out.println("find by email result:" + contact_email);
//        Contact contact = contactService.getContact(1L);
//        System.out.println("contact is :" + contact.getId());
//        System.out.println("spring in practise ch02 end");


        //this is spring in action start
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("spring in action start");
//        Performance singer = (Performance) context.getBean("singer");
//        singer.perform();
//        System.out.println("spring in action end");
//        ((ClassPathXmlApplicationContext) context).close();


        System.out.println("lambda tests started");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        numbers.stream().filter(SpringTest::isEven).forEach(System.out::println);
        System.out.println("lambda tests ended");
    }

    public static boolean isEven(Integer i) {
        if (i % 2 == 0) {
            return true;
        }

        return false;
    }
}
