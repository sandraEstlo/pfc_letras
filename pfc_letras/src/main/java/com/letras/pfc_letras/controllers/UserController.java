package com.letras.pfc_letras.controllers;

import com.letras.pfc_letras.dtos.user.CreateUserDto;
import com.letras.pfc_letras.errors.exceptions.NewUserWithDifferentPassword;
import com.letras.pfc_letras.facades.Facade;
import com.letras.pfc_letras.models.UsersModels.UserModel;
import com.letras.pfc_letras.models.UsersModels.UserRoles;
import com.letras.pfc_letras.repositories.UserRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;
import java.util.Set;

@Controller
public class UserController {

    @Resource
    private Facade facade;

    @Resource
    UserRepository userRepository;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("createUserDto", CreateUserDto.builder().build());
        return "register";
    }

    @PostMapping("/register")
    public String processRegister(Model model, CreateUserDto createUserDto, RedirectAttributes redirectAttributes) {
        try {
            redirectAttributes.addFlashAttribute("createUserDto", facade.newUser(createUserDto) );
            return "redirect:/";

        } catch (NewUserWithDifferentPassword | ResponseStatusException e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }
}
