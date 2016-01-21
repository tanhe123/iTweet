package net.xiayule.itweet.controller;

import net.xiayule.itweet.db.entity.GreetingEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by tan on 16-1-7.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/", method = GET)
    public String home(Model model) {

        GreetingEntity greetingEntity = new GreetingEntity();

        greetingEntity.setName("test");

        model.addAttribute("greeting", greetingEntity);

        return "/home";
    }

}
