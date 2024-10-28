package com.letras.pfc_letras.errors;

import com.letras.pfc_letras.errors.exceptions.User.NewUserWithDifferentPassword;
import com.letras.pfc_letras.errors.exceptions.loans.BookNotAvailableException;
import com.letras.pfc_letras.errors.exceptions.loans.ErrorToUpdateLoan;
import com.letras.pfc_letras.errors.exceptions.loans.UserNotAvailableException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.time.LocalDateTime;

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

    @ExceptionHandler({UserNotAvailableException.class, BookNotAvailableException.class, ErrorToUpdateLoan.class})
    public ResponseEntity<ApiError> handleUserNotAvailableException(Exception ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ApiError.builder()
                                                          .status(HttpStatus.FORBIDDEN)
                                                          .dateTime(LocalDateTime.now())
                                                          .message(ex.getMessage())
                                                          .build());
    }
}
