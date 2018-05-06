package springinaction.ch02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan
@PropertySource("classpath:/myspring.properties")
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
