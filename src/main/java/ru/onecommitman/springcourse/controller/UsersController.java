package ru.onecommitman.springcourse.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.onecommitman.springcourse.model.User;
import ru.onecommitman.springcourse.service.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {

    private UserService userService;

    public UsersController() {
    }

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }


    @GetMapping("/new")
    public String newUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "new";
        }
        userService.saveUser(user);
        return "redirect:/users";

    }



    /*------------UPDATE METHODS-----------------------*/

    @GetMapping("/edit")
    public String showByID(@RequestParam("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserByID(id));
        return "edit";
    }


    @PatchMapping("/edit")
    public String update(@RequestParam("id") Long id, @ModelAttribute("user") @Valid User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "edit";
        }
        userService.updateUser(id, user);
        return "redirect:/users";
    }

    /*------------------------------------------*/

    @DeleteMapping
    public String delete(@RequestParam("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }

}