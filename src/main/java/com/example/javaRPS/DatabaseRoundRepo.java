package com.example.javaRPS;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DatabaseRoundRepo implements RoundRepo {
    private JdbcTemplate jdbcTemplate;

    DatabaseRoundRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Round> all() {
        return jdbcTemplate.query(
                "SELECT * FROM rounds",
                (rs, i) -> new Round(
                        Throw.valueOf(rs.getString("p1_throw")),
                        Throw.valueOf(rs.getString("p2_throw")),
                        Result.valueOf(rs.getString("result"))
                )
        );
    }
}
