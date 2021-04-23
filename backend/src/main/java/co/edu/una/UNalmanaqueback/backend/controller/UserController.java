package co.edu.una.UNalmanaqueback.backend.controller;

import co.edu.una.UNalmanaqueback.backend.model.User;
import co.edu.una.UNalmanaqueback.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
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

    @GetMapping(path = "user/find/{userEmail}")
    public User getUserByEmail(@PathVariable(value = "userEmail") String userEmail) {
        return userRepository.findUserByEmail(userEmail);
    }
}
