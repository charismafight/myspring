package springinaction.ch04.web;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springinaction.ch04.Spitter;
import springinaction.ch04.data.SpitterRepository;
import springinaction.ch12.OrderRepository;

import javax.validation.Valid;
import java.util.Collections;

@Controller
@RequestMapping(value = "/spitter")
public class SpitterController {
    private SpitterRepository spitterRepository;

//    @Autowired
//    MongoOperations mongo;
//    @Autowired
//    OrderRepository orderRepository;
    @Autowired
    SessionFactory sessionFactory;

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
}
