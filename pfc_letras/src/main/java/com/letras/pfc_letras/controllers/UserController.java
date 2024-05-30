package com.letras.pfc_letras.controllers;

import com.letras.pfc_letras.dtos.user.CreateUserDto;
import com.letras.pfc_letras.errors.exceptions.NewUserWithDifferentPassword;
import com.letras.pfc_letras.facades.Facade;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.security.core.AuthenticationException;

@Controller
public class UserController {

    @Resource
    private Facade facade;

    @GetMapping("/login")
    public String showLoginPage(HttpServletRequest request, Model model) {
        AuthenticationException exception = (AuthenticationException) request.getSession()
                                                                             .getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        if (exception != null)
            model.addAttribute("errorMessage", exception.getMessage());
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
            redirectAttributes.addFlashAttribute("createUserDto", facade.newUser(createUserDto).get());
            return "redirect:/";

        } catch (NewUserWithDifferentPassword | ResponseStatusException e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }
}
