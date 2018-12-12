package com.samuel.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocketState {
    String sessionId;
    String username;
    Boolean keepAlive;
}
