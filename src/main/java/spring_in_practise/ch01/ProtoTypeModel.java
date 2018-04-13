package spring_in_practise.ch01;

import org.springframework.context.annotation.Scope;
import org.springframework.context.support.BeanDefinitionDsl;

import java.beans.JavaBean;

public class ProtoTypeModel {
    private int mark;

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
