package com.example.javaRPS;

import org.junit.Before;
import org.junit.Test;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class DatabaseRoundRepoTest {
    private JdbcTemplate jdbcTemplate;
    private DatabaseRoundRepo databaseRoundRepo;

    @Before
    public void setUp() throws Exception {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost/java_rps_test");
        dataSource.setUser("umehara");

        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update("TRUNCATE TABLE rounds");

        databaseRoundRepo = new DatabaseRoundRepo(jdbcTemplate);
    }

    @Test
    public void all_returnsRounds() throws Exception {
        jdbcTemplate.update(
                "INSERT INTO rounds (p1_throw, p2_throw, result)" +
                        " VALUES ('PAPER', 'ROCK', 'P1WINS')"
        );


        List<Round> rounds = databaseRoundRepo.all();


        assertThat(rounds.size(), equalTo(1));
        assertThat(rounds.get(0), equalTo(new Round(Throw.PAPER, Throw.ROCK, Result.P1WINS)));
    }
}
