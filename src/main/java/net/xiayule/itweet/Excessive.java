package net.xiayule.itweet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zhiyou on 16-1-25.
 */
@Controller
public class Excessive {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String excessive(){
        return "index";
    }
}
