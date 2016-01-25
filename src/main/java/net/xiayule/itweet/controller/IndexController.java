package net.xiayule.itweet.controller;

import net.xiayule.itweet.db.dao.PublishDao;
import net.xiayule.itweet.db.entity.Publish;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by tan on 16-1-7.
 */
@Controller
@RequestMapping(value = "/begin")
public class IndexController {

    @RequestMapping(value = "/content", method = POST)
    public ModelAndView home(Model model,HttpServletRequest request,HttpServletResponse response) {
        ModelAndView view = new ModelAndView();
        String content = request.getParameter("content");
        System.out.println("hello===="+content);
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-config.xml");
         PublishDao publishDao = (PublishDao) context.getBean("publishDao");
        Publish publish = new Publish(content);
        publishDao.add(publish);
        model.addAttribute("list",publishDao.findall());
        view.setViewName("index");
        return view;
    }

}
