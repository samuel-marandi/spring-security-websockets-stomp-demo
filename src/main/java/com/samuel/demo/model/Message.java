package com.samuel.demo.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private String from;
    private String text;
}
