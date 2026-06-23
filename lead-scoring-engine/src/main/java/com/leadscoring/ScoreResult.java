package com.leadscoring;

import java.util.ArrayList;
import java.util.List;

public class ScoreResult {

    private String nomeLead;
    private int score;
    private String classificacao;
    private List<String> criteriosAplicados = new ArrayList<>();

    public ScoreResult() {}

    public String getNomeLead() { return nomeLead; }
    public void setNomeLead(String nomeLead) { this.nomeLead = nomeLead; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    public String getClassificacao() { return classificacao; }
    public void setClassificacao(String classificacao) { this.classificacao = classificacao; }

    public List<String> getCriteriosAplicados() { return criteriosAplicados; }
    public void setCriteriosAplicados(List<String> criteriosAplicados) { this.criteriosAplicados = criteriosAplicados; }

    public void adicionarCriterio(String criterio) {
        this.criteriosAplicados.add(criterio);
    }

    public void adicionarPontos(int pontos) {
        this.score += pontos;
    }
}