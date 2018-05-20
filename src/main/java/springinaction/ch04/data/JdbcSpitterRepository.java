package springinaction.ch04.data;

import org.springframework.stereotype.Repository;
import springinaction.ch04.Spitter;

@Repository
public class JdbcSpitterRepository implements SpitterRepository {
    @Override
    public Spitter save(Spitter spitter) {
        return new Spitter();
    }
}
