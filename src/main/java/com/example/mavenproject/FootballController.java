package com.example.mavenproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FootballController {

    private final FootballService footballService;

    @Autowired
    public FootballController(FootballService footballService) {
        this.footballService = footballService;
    }

    @GetMapping("/live-scores")
    public String getLiveScores(Model model) {
        String liveScores = footballService.getLiveScores().block(); // Llama al servicio para obtener los resultados en vivo
        model.addAttribute("liveScores", liveScores);
        return "liveScores"; // Llama a la plantilla `liveScores.html`
    }
}
