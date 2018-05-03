package spring_in_practise.ch03.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import spring_in_practise.ch03.model.Member;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/roster")
public class RosterController {
    private List<Member> members = new ArrayList<>();

    public RosterController() {
        members.add(new Member("John", "Lennon"));
        members.add(new Member("Paul", "McCartney"));
        members.add(new Member("George", "Harrison"));
        members.add(new Member("Ringo", "Starr"));
    }

    @RequestMapping
    public void list(Model model) {
        model.addAttribute(members);
    }

    @RequestMapping
    public void member(@RequestParam("id") int id, Model model) {
        System.out.println("request member");
        model.addAttribute(members.get(id));
    }
}
