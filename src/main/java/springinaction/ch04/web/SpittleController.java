package springinaction.ch04.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springinaction.ch04.Spittle;
import springinaction.ch04.data.SpittleRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
    private static final String MAX_LONG_VALUE_STRING = "9223372036854775807";

    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(@RequestParam(value = "max", defaultValue = MAX_LONG_VALUE_STRING) long max, @RequestParam(value = "count", defaultValue = "20") int count) {
        return spittleRepository.findSpittles(max, count);
    }

    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public String spittle(@PathVariable long spittleId, Model model) {
        List<Spittle> list = new ArrayList<>();
        list.add(spittleRepository.findOne(spittleId));
        model.addAttribute("spittleList", list);
        return "spittles";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveSpittle(SpittleForm form, Model model) {
        spittleRepository.save(new Spittle(form.getMessage(), new Date(), form.getLongitude(), form.getLatitude()));
        return "redirect:/spittles";
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showSpittle(@RequestParam("spittle_id") long spitlleId, Model model) {
        model.addAttribute(spittleRepository.findOne(spitlleId));
        return "spittles";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Spittle spittleById(@PathVariable long id) {
        // 这里的做法是通过url的id找到对应的spittle并返回，然后消息转换器会负责把返回的结果给到客户端
        // 当id不存在的时候，这个请求是不会有任何异常抛出来的。
        return spittleRepository.findOne(id);
    }

    @ExceptionHandler(ClassNotFoundException.class)
    public ResponseEntity<Error> spittleNotFound(ClassNotFoundException e) {
        //假设这里是自定义的Exception，它会记录id，类似的我们自定义的异常也可以记录对应的异常信息用于错误发生时返回给客户端
        String id = e.getMessage();
        Error error = new Error("Spittle id not found");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
