package springinaction.ch02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan
@PropertySource("classpath:/myspring.properties")
@EnableAspectJAutoProxy
public class Config {
    @Autowired
    Environment environment;

    @Bean(name = "cdplayer")
    public CDPlayer cdPlayer() {
        var cd = new CDPlayer(new SgtPepper());
        cd.setId(Integer.parseInt(environment.getProperty("myproperty")));
        return cd;
    }
}
