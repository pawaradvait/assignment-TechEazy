package com.TechEazy.model;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Response {

        private String statusCode;
        private String message;


        public Response(String statusCode, String message) {
                this.statusCode = statusCode;
                this.message = message;
        }

}
