package springinaction.ch04.web;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import springinaction.ch04.Spitter;
import springinaction.ch04.Spittle;
import springinaction.ch04.data.SpitterRepository;
import springinaction.ch04.data.SpittleRepository;
import springinaction.ch12.StudentNeo;
import springinaction.ch12.StudentNeoRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping(value = "/spitter")
public class SpitterController {
    private SpitterRepository spitterRepository;
    private static final String MAX_LONG_AS_STRING = "9223372036854775807";

    @Autowired
    StudentNeoRepository repository;

    //    @Autowired
//    MongoOperations mongo;
//    @Autowired
//    OrderRepository orderRepository;
    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    public SpitterController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute("spitter", new Spitter());
        //System.out.println(mongo.getCollection("Order").count());
        Session session = sessionFactory.openSession();
        String query = "MATCH (n:Dept) RETURN n LIMIT 25";
        System.out.println(session.query(query, Collections.emptyMap()));
        repository.save(new StudentNeo());
        System.out.println("neo4j repository sample:" + repository.findAll());
        redisTemplate.opsForValue().set("fuck", "dog");
        System.out.println("this is redis find test:" + redisTemplate.opsForValue().get("fuck"));
        Cache cache = cacheManager.getCache("userCache");
        cache.put("fuck", "dog");
        System.out.println("this is ehcachecachemanager test:" + cache.get("fuck", String.class));
        return "registration";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Valid Spitter spitter, Errors errors) {
        if (errors.hasErrors()) {
            return "registration";
        }
        //spitterRepository.save(spitter);
//        mongo.save(spitter);
//        System.out.println(orderRepository.findChucksOrders());
        return "redirect:/";
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<Spitter> spittles(@RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
                           @RequestParam(value = "count", defaultValue = "20") int count) {
        return new ArrayList<>();
    }
}
