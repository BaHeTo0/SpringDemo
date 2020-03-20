package me.BaHeTo0.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {
	
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
    public void handleNotFoundException(
            NotFoundException ex, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_NOT_FOUND, ex.getLocalizedMessage());
    }

	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public void handleRuntimeException(
            RuntimeException ex, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getLocalizedMessage());
    }

}
