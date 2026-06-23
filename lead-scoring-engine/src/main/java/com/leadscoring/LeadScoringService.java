package com.leadscoring;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;

@Service
public class LeadScoringService {

    record Regra(String descricao, int pontos, Predicate<Lead> condicao) {}

    private final List<Regra> regras = List.of(
        new Regra("Cargo de alto nível: +30 pontos", 30,
            lead -> lead.getCargo() != null &&
                   (lead.getCargo().equalsIgnoreCase("diretor") ||
                    lead.getCargo().equalsIgnoreCase("ceo"))),
        new Regra("Cargo gerencial: +20 pontos", 20,
            lead -> lead.getCargo() != null &&
                    lead.getCargo().equalsIgnoreCase("gerente")),
        new Regra("Setor tech: +20 pontos", 20,
            lead -> lead.getSetor() != null &&
                    lead.getSetor().equalsIgnoreCase("tecnologia")),
        new Regra("Origem LinkedIn: +15 pontos", 15,
            lead -> lead.getOrigemCampanha() != null &&
                    lead.getOrigemCampanha().equalsIgnoreCase("linkedin")),
        new Regra("Visitou página: +10 pontos", 10,
            lead -> lead.isVisitouPagina()),
        new Regra("Baixou material: +25 pontos", 25,
            lead -> lead.isBaixouMaterial())
    );

    public ScoreResult calcularScore(Lead lead) {
        ScoreResult result = new ScoreResult();
        result.setNomeLead(lead.getNome());

        List<String> criterios = new ArrayList<>();
        int score = 0;

        for (Regra regra : regras) {
            if (regra.condicao().test(lead)) {
                score += regra.pontos();
                criterios.add(regra.descricao());
            }
        }

        result.setScore(score);
        result.setCriteriosAplicados(criterios);

        if (score >= 70) {
            result.setClassificacao("HOT");
        } else if (score >= 40) {
            result.setClassificacao("WARM");
        } else {
            result.setClassificacao("COLD");
        }

        return result;
    }
}