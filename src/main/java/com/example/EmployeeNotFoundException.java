package com.example;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
		value = HttpStatus.NOT_FOUND,
		reason = "no employee with that ID found"
)
public class EmployeeNotFoundException extends RuntimeException {

}
