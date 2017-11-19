package com.example.javaRPS;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("rounds")
public class RoundsController {
    private RoundRepo roundRepo;

    public RoundsController(RoundRepo roundRepo) {
        this.roundRepo = roundRepo;
    }

    @GetMapping
    public List<Round> index() {
        return roundRepo.all();
    }
}
