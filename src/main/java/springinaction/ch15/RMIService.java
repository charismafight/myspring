package springinaction.ch15;

import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.remoting.rmi.RmiServiceExporter;

public class RMIService {
    @Bean
    public RmiServiceExporter rmiServiceExporter(SpitterService service) {
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setService(service);
        exporter.setServiceName("SpitterService");
        exporter.setServiceInterface(SpitterService.class);
        //exporter.setRegistryHost("rmi.spitter.com");
        //exporter.setRegistryPort(1199);
        return exporter;
    }

    @Bean
    public RmiProxyFactoryBean spitterService() {
        RmiProxyFactoryBean bean = new RmiProxyFactoryBean();
        //直接rmi接服务器+service的name
        bean.setServiceUrl("rmi://localhost/SpitterService");
        bean.setServiceInterface(SpitterService.class);
        return bean;
    }
}
