package org.rudtyz.absence.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@ControllerAdvice
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @GetMapping
    String onError() {
        return "error";
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    String errorAny(HttpServletRequest req, Exception ex) {
        return "INTERNAL ERROR 0xAC";
    }
}
