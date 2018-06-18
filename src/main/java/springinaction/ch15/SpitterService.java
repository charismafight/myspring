package springinaction.ch15;

import springinaction.ch04.Spittle;

import java.util.List;

public interface SpitterService {
    List<Spittle> getRecentSpittles();
}
