package com.example.javaRPS;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class RoundsControllerTest {

    @Test
    public void index_returnsRounds() throws Exception {
        SuccessfulRoundRepoStub successfulRoundRepoStub = new SuccessfulRoundRepoStub();
        RoundsController roundsController = new RoundsController(successfulRoundRepoStub);

        MockMvc mockController = standaloneSetup(roundsController).build();

        mockController.perform(get("/rounds"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].p1Throw", equalTo("ROCK")))
                .andExpect(jsonPath("$[0].p2Throw", equalTo("PAPER")))
                .andExpect(jsonPath("$[0].result", equalTo("P1WINS")));
    }
}
