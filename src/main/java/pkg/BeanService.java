package pkg;

import org.springframework.beans.factory.BeanNameAware;

public class BeanService implements BeanNameAware {
    @Override
    public void setBeanName(String name) {
        System.out.println("bean name =" + name);
    }

    private MyAnnoBean myAnnoBean;

    public MyAnnoBean getMyAnnoBean() {
        return myAnnoBean;
    }

    public void setMyAnnoBean(MyAnnoBean myAnnoBean) {
        this.myAnnoBean = myAnnoBean;
    }
}
