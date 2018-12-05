package com.samuel.authdemo.mapper;

import com.samuel.authdemo.model.AppUser;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AppUserMapper implements RowMapper<AppUser> {
    public static final String BASE_SQL //
//            = "Select u.User_Id, u.User_Name, u.Encryted_Password From App_User";
            = "Select User_Id, User_Name, Encryted_Password From App_User";

    @Override
    public AppUser mapRow(ResultSet rs, int rowNum) throws SQLException {

        Long userId = rs.getLong("User_Id");
        String userName = rs.getString("User_Name");
        String encrytedPassword = rs.getString("Encryted_Password");

        return new AppUser(userId, userName, encrytedPassword);
    }
}

