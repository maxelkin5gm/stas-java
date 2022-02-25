package stas.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import stas.entities.UserEntity;
import stas.repositories.UserRepository;

@Controller
@AllArgsConstructor
public class MainController {

    UserRepository userRepository;

    @GetMapping("/")
    @ResponseBody
    public String test() {

        var user = new UserEntity();
        user.setEmail("1");

        userRepository.save(user);


        return "test";
    }
}
