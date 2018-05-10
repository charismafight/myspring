package springinaction.ch04.data;

import springinaction.ch04.Spittle;

import java.util.List;

public interface SpitlleRepository {
    List<Spittle> findSpittles(long max, int count);
}
