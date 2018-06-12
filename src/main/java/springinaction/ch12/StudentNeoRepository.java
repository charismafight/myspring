package springinaction.ch12;


import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface StudentNeoRepository extends Neo4jRepository<StudentNeo, Integer> {
}
