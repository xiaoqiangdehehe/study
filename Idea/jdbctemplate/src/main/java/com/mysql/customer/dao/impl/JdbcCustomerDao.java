package com.mysql.customer.dao.impl;

import com.mysql.customer.dao.CustomerDAO;
import com.mysql.customer.model.Customer;
import com.mysql.customer.rowmapper.CustomerRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class JdbcCustomerDao implements CustomerDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource datasource) {
        this.dataSource = datasource;
    }

    public void insert(Customer customer) {
        String sql = "INSERT INTO CUSTOMER " +
                "(CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql, new Object[] {
                customer.getCustID(),
                customer.getName(),
                customer.getAge()
        });
    }

    public Customer findByCustomerId(int custId) {
        String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID =  ?";
        jdbcTemplate = new JdbcTemplate(dataSource);
        Customer customer = (Customer) jdbcTemplate.queryforo
        return customer;
    }
}
