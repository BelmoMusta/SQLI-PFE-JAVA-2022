package org.sqli.authentification.dto.response;

import lombok.*;

@Getter
@Setter
@ToString
public class ResponseMessage {

    String message;

    public ResponseMessage(String message)
    {
        this.message = message;
    }
}
