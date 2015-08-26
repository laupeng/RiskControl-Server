package com.riskcontrol.controller;

import com.riskcontrol.model.entity.User;
import com.riskcontrol.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Killua on 8/22/15.
 */

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final EntityLinks entityLinks;

    @Autowired
    public UserController(UserService userService, EntityLinks entityLinks) {
        this.userService = userService;
        this.entityLinks = entityLinks;
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public HttpEntity signIn(@RequestBody User anUser) {
        User user = userService.signIn(anUser);
        Resource<User> resource = new Resource<User>(user);
        if (!user.isNotFound() && !user.isWrongPassword()) {
            resource.add(entityLinks.linkToSingleResource(user));
        }
        return new ResponseEntity(resource, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/signOut/{userId}", method = RequestMethod.GET)
    public void signOut(@PathVariable int userId) {
        userService.signOut(userId);
    }
}
