package com.learn.app.concepts.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

    @EqualsAndHashCode(callSuper = true)
    @Data
    class CustomInvalidAgeException extends RuntimeException {
        private String errorCode;
        public CustomInvalidAgeException(String msg) {
            super(msg);
        }
    }

public class CustomException {
}
