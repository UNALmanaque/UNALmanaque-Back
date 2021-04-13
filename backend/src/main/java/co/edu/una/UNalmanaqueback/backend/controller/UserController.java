package co.edu.una.UNalmanaqueback.backend.controller;

import co.edu.una.UNalmanaqueback.backend.model.User;
import co.edu.una.UNalmanaqueback.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/register/api")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @PostMapping(path = "/user")
    @ResponseBody
    public String addNewUser (@RequestBody User user) {
        userRepository.save(user);
        return "Saved";
    }
    @GetMapping(path = "/user")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
