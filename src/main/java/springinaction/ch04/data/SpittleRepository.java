package springinaction.ch04.data;

import springinaction.ch04.Spittle;

import java.util.List;

public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);

    List<Spittle> findRecentSpittles();

    Spittle findOne(long id);

    void save(Spittle spittle);
}
