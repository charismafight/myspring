package springinaction.ch12;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@EnableNeo4jRepositories("springinaction.ch12")
@EnableTransactionManagement
public class Neo4jConfig {
    @Bean
    public SessionFactory sessionFactory() {
        return new SessionFactory(configuration(), "springinaction.ch12");
    }

    @Bean
    public org.neo4j.ogm.config.Configuration configuration() {
        return new org.neo4j.ogm.config.Configuration.Builder()
                .uri("bolt://localhost:7687")
                .credentials("neo4j", "7u82enp")
                .build();
    }

    @Bean
    public Neo4jTransactionManager transactionManager() {
        return new Neo4jTransactionManager(sessionFactory());
    }
}
