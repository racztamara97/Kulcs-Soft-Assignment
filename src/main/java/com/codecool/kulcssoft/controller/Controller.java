package com.codecool.kulcssoft.controller;


import com.codecool.kulcssoft.model.User;
import com.codecool.kulcssoft.repository.UserRepository;
import com.codecool.kulcssoft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("newUser", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String registrationForm(@ModelAttribute("newUser") User user) {
        userRepository.save(user);
        return "redirect:/";
    }

    @PostMapping("/delete_user")
    public String deleteUser(@RequestParam("userButton") Integer id){
        userService.deleteUserById(id);
        return "redirect:/";
    }

    @PostMapping("/search")
    public String search(@RequestParam(value = "search") String search, Model model) {
        model.addAttribute("users", userRepository.findAllByUserNameContaining(search));
        return "index";
    }

}
