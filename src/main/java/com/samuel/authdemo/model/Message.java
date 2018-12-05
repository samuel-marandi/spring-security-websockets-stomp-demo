package com.samuel.authdemo.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private String from;
    private String text;
}
