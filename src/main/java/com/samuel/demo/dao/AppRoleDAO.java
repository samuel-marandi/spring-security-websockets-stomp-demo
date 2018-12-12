package com.samuel.demo.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Repository
@Transactional
public class AppRoleDAO extends JdbcDaoSupport {

    @Autowired
    public AppRoleDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public List<String> getRoleNames(Long userId) {
        log.info("The user id is :" + userId);

        String sql = "Select r.Role_Name from User_Role ur, App_Role r where ur.Role_Id = r.Role_Id and ur.User_Id = ?";

        Object[] params = new Object[] { userId };

        List<String> roles = this.getJdbcTemplate().queryForList(sql, params, String.class);

        log.info("The roles are :" +roles.toString());

        return roles;
    }
}
