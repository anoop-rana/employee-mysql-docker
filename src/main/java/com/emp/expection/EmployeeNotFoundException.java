package com.emp.expection;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class EmployeeNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 3895235812451571187L;

    public EmployeeNotFoundException(String exception) {
        super(exception);
    }

}
