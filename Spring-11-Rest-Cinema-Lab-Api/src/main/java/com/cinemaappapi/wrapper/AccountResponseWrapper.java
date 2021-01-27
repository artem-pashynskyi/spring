package com.cinemaappapi.wrapper;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@Getter
@Setter
public class AccountResponseWrapper {
    private String message;
    private boolean success;
    private int code;
    private Object accounts;

    public AccountResponseWrapper(String message, Object accounts) {
        this.message = message;
        this.accounts = accounts;
        this.success = true;
        this.code = HttpStatus.OK.value();
    }

    public AccountResponseWrapper(String message) {
        this.message = message;
        this.success = true;
        this.code = HttpStatus.OK.value();
    }
}
