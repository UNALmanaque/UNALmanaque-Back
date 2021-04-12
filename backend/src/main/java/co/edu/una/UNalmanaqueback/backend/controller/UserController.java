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

@Controller
@RequestMapping("/register/api")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @PostMapping(path = "/user")
    public @ResponseBody String addNewUser (@RequestParam String userName, @RequestParam String userEmail, @RequestParam String userPassword) {
        User newUser = new User();
        newUser.setUserName(userName);
        newUser.setUserEmail(userEmail);
        newUser.setUserPassword(userPassword);
        userRepository.save(newUser);
        return "Saved";
    }
    @GetMapping(path = "/user")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
