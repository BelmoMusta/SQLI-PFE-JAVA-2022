package org.sqli.authentification.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResponseErrorMessage {

    private String error;

    public ResponseErrorMessage(String error)
    {
        this.error = error;
    }
}
