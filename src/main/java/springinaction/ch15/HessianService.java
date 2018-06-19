package springinaction.ch15;

import org.springframework.context.annotation.Bean;
import org.springframework.remoting.caucho.HessianServiceExporter;

public class HessianService {
    @Bean
    public HessianServiceExporter hessianServiceExporter(SpitterService service) {
        HessianServiceExporter exporter = new HessianServiceExporter();
        exporter.setService(service);
        exporter.setServiceInterface(SpitterService.class);
        return exporter;
    }
}
