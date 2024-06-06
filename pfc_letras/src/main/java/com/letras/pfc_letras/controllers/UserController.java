package com.letras.pfc_letras.controllers;

import com.letras.pfc_letras.dtos.user.CreateUserDto;
import com.letras.pfc_letras.facades.Facade;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
    public String processRegister(Model model,
                                  @ModelAttribute("createUserDto") @Valid CreateUserDto createUserDto,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "register";
        }

        redirectAttributes.addFlashAttribute(facade.newUser(createUserDto));
        return "redirect:/login";
    }
}

//                          List<String> errors = bindingResult.getFieldErrors()
//                                               .stream()
//                                               .map(error -> error.getField() + "," + error.getDefaultMessage())
//                                               .collect(Collectors.toList());
//
//            model.addAttribute("errors", errors);
//            model.addAttribute("result", bindingResult);
//            model.addAttribute("createUserDto", createUserDto);
