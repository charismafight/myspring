package springinaction.ch19;

import org.springframework.context.annotation.Bean;
import org.springframework.jmx.export.MBeanExporter;
import springinaction.ch04.web.SpittleController;

import java.util.HashMap;
import java.util.Map;

public class SpittleMbean {
    @Bean
    public MBeanExporter spittleMbean(SpittleController spittleController) {
        MBeanExporter result = new MBeanExporter();
        Map<String, Object> beans = new HashMap<>();
        beans.put("spittle:name=SpittleController", spittleController);
        result.setBeans(beans);
        return result;
    }
}
