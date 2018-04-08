package pkg;

import org.springframework.stereotype.Component;

@Component("myAnnoBean")
public class MyAnnoBean {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
