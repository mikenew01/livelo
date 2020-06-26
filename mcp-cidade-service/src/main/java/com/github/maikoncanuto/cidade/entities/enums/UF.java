package com.github.maikoncanuto.cidade.entities.enums;

public enum UF {

    RO(11, "Rondônia", "RO"),
    AC(12, "Acre", "AC"),
    AM(13, "Amazonas", "AM"),
    RR(14, "Roraima", "RR"),
    PA(15, "Pará", "PA"),
    AP(16, "Amapá", "AP"),
    TO(17, "Tocantins", "TO"),
    MA(21, "Maranhão", "MA"),
    PI(22, "Piauí", "PI"),
    CE(23, "Ceará", "CE"),
    RN(24, "Rio Grande do Norte", "RN"),
    PB(25, "Paraíba", "PB"),
    PE(26, "Pernambuco", "PE"),
    AL(27, "Alagoas", "AL"),
    SE(28, "Sergipe", "SE"),
    BA(29, "Bahia", "BA"),
    MG(31, "Minas Gerais", "MG"),
    ES(32, "Espírito Santo", "ES"),
    RJ(33, "Rio de Janeiro", "RJ"),
    SP(35, "São Paulo", "SP"),
    PR(41, "Paraná", "PR"),
    SC(42, "Santa Catarina", "SC"),
    RS(43, "Rio Grande do Sul", "RS"),
    MS(50, "Mato Grosso do Sul", "MS"),
    MT(51, "Mato Grosoo", "MT"),
    GO(52, "Goiás", "GO"),
    DF(53, "Distrito Federal", "DF");

    private Integer codigo;
    private String descricao;
    private String sigla;

    UF(Integer codigo, String descricao, String uf) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.sigla = uf;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public String getSigla() {
        return this.sigla;
    }

    public Integer getCodigo() {
        return this.codigo;
    }
}
