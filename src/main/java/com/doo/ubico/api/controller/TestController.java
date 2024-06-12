package com.doo.ubico.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("permitAll()")

public class TestController {
	@Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/test-db")
    public String testDatabase() {
        try {
            jdbcTemplate.execute("SELECT 1");
            return "Conexión exitosa a la base de datos!";
        } catch (Exception e) {
            return "Error en la conexión: " + e.getMessage();
        }
    }
}


