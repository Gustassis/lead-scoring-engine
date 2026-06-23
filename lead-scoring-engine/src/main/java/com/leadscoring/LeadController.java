package com.leadscoring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/leads")
public class LeadController {

    @Autowired
    private LeadScoringService leadScoringService;

    @PostMapping("/score")
    public ScoreResult calcularScore(@RequestBody Lead lead) {
        return leadScoringService.calcularScore(lead);
    }
}