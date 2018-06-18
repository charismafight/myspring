package springinaction.ch15;

import springinaction.ch04.Spittle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SpitterServiceImpl implements SpitterService {
    @Override
    public List<Spittle> getRecentSpittles() {
        Spittle spittle = new Spittle("fuck", new Date());
        List<Spittle> result = new ArrayList<>();
        result.add(spittle);
        return result;
    }
}
