package com.example.javaRPS;

import java.util.List;

import static java.util.Collections.singletonList;

public class SuccessfulRoundRepoStub implements RoundRepo {

    @Override
    public List<Round> all() {
        return singletonList(new Round(Throw.ROCK, Throw.PAPER, Result.P1WINS));
    }
}
