package com.openpayd.common.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorContainer {

    private String value;
    private String field;
    @NotNull
    private ErrorType type;
    private String message;

    public ErrorContainer(ErrorType type, String message) {
        this(null, null, type, message);
    }

}