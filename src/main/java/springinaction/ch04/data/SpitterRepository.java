package springinaction.ch04.data;

import springinaction.ch04.Spitter;

public interface SpitterRepository {
    Spitter save(Spitter spitter);
}
