package springinaction.ch12;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "springinaction.ch12")
public class MongoConfig {

    @Autowired
    private MongoClient mongo;

    @Bean
    MongoClient mongo() {
        return new MongoClient("localhost");
    }

    @Bean
    MongoOperations mongoTemplate() {
        return new MongoTemplate(mongo, "OrderDB");
    }
}
