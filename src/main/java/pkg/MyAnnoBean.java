package pkg;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("myAnnoBean")
@Primary
public class MyAnnoBean {
    private int id;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
