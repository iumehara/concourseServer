package com.example.javaRPS;

@SuppressWarnings("unused")
public class Round {
    private Throw p1Throw;
    private Throw p2Throw;
    private Result result;

    Round(Throw p1Throw, Throw p2Throw, Result result) {
        this.p1Throw = p1Throw;
        this.p2Throw = p2Throw;
        this.result = result;
    }

    public Throw getP1Throw() {
        return p1Throw;
    }

    public Throw getP2Throw() {
        return p2Throw;
    }

    public Result getResult() {
        return result;
    }

    @SuppressWarnings("SimplifiableIfStatement")
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Round round = (Round) o;

        if (p1Throw != round.p1Throw) return false;
        if (p2Throw != round.p2Throw) return false;
        return result == round.result;
    }

    @Override
    public int hashCode() {
        int result1 = p1Throw != null ? p1Throw.hashCode() : 0;
        result1 = 31 * result1 + (p2Throw != null ? p2Throw.hashCode() : 0);
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        return result1;
    }

    @Override
    public String toString() {
        return "Round{" +
                "p1Throw=" + p1Throw +
                ", p2Throw=" + p2Throw +
                ", result=" + result +
                '}';
    }
}
