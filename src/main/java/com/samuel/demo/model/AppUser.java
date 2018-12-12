package com.samuel.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {
    private Long userId;
    private String userName;
    private String encrytedPassword;

    @Override
    public String toString() {
        return this.userName + "/" + this.encrytedPassword;
    }
}
