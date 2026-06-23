package com.leadscoring;

public class Lead {

    private String nome;
    private String cargo;
    private String setor;
    private String origemCampanha;
    private boolean visitouPagina;
    private boolean baixouMaterial;

    public Lead() {}

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public String getSetor() { return setor; }
    public void setSetor(String setor) { this.setor = setor; }

    public String getOrigemCampanha() { return origemCampanha; }
    public void setOrigemCampanha(String origemCampanha) { this.origemCampanha = origemCampanha; }

    public boolean isVisitouPagina() { return visitouPagina; }
    public void setVisitouPagina(boolean visitouPagina) { this.visitouPagina = visitouPagina; }

    public boolean isBaixouMaterial() { return baixouMaterial; }
    public void setBaixouMaterial(boolean baixouMaterial) { this.baixouMaterial = baixouMaterial; }
}