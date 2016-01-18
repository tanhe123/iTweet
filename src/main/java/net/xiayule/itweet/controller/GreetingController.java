package net.xiayule.itweet.controller;

import net.xiayule.itweet.db.entity.GreetingEntity;
import net.xiayule.itweet.db.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by tan on 16-1-18.
 */
@RestController
@RequestMapping("/greetings")
public class GreetingController {

    @Autowired
    private GreetingRepository greetingRepo;

    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestParam String name) {
        GreetingEntity greetingEntity = new GreetingEntity();
        greetingEntity.setName(name);

        greetingRepo.save(greetingEntity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public GreetingEntity findByName(@PathVariable Long id) {
        return greetingRepo.findOne(id);
    }
}
