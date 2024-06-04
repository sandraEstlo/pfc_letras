package com.letras.pfc_letras.errors;

import com.letras.pfc_letras.dtos.user.CreateUserDto;
import com.letras.pfc_letras.errors.exceptions.User.NewUserWithDifferentPassword;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DuplicateKeyException.class)
    public String handleDuplicateKeyException(DuplicateKeyException ex,
                                              RedirectAttributes redirectAttrs) {
        redirectAttrs.addFlashAttribute("error", "Ya existe un usuario con ese nombre y/o correo electrónico.");
        return "redirect:/register?error";
    }

    @ExceptionHandler(NewUserWithDifferentPassword.class)
    public String handleNewUserWithDifferentPassword(NewUserWithDifferentPassword ex,
                                                     RedirectAttributes redirectAttrs) {
        redirectAttrs.addFlashAttribute("createUserDto", ex.getCreateUserDto());
        redirectAttrs.addFlashAttribute("error", ex.getMessage());
        return "redirect:/register?error";
    }
}
