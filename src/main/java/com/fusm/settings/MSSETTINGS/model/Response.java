package com.fusm.settings.MSSETTINGS.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {
    private Integer status;
    private String message;
    private T data;

    public Response(HttpStatus httpStatus, T data) {
        super();
        this.status = httpStatus.value();
        this.message = httpStatus.getReasonPhrase();
        this.data = data;
    }
}
