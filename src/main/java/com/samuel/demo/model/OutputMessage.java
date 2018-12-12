package com.samuel.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OutputMessage {
    private String from;
    private String text;
    private String time=new Date().toString();
}
