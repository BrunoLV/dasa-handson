package com.dasa.domain;

import javax.persistence.*;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
@Entity
@Table(name = "dados_populacionais")
public class DadoPopulacional implements Serializable {

    private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String ano;

    private BigDecimal populacaoTotal;

    private Long totalHomens;

    private Long totalMulheres;

    public DadoPopulacional() {
    }

    public DadoPopulacional(final String ano, final String totalPopulacao, final String totalHomens, final String totalMulheres) {
        this.ano = ano;
        this.populacaoTotal = BigDecimal.valueOf(Long.valueOf(totalPopulacao));
        this.totalHomens = Long.valueOf(totalHomens);
        this.totalMulheres = Long.valueOf(totalMulheres);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public BigDecimal getPopulacaoTotal() {
        return populacaoTotal;
    }

    public void setPopulacaoTotal(BigDecimal populacaoTotal) {
        this.populacaoTotal = populacaoTotal;
    }

    public Long getTotalHomens() {
        return totalHomens;
    }

    public void setTotalHomens(Long totalHomens) {
        this.totalHomens = totalHomens;
    }

    public Long getTotalMulheres() {
        return totalMulheres;
    }

    public void setTotalMulheres(Long totalMulheres) {
        this.totalMulheres = totalMulheres;
    }

	public BigDecimal obtemProporcaoMulheres() {
		BigDecimal tMulheres = new BigDecimal(this.totalMulheres);
		return tMulheres.multiply(new BigDecimal("100")).divide(populacaoTotal, RoundingMode.HALF_EVEN).setScale(2);
	}
	
	public BigDecimal obtemProporcaoHomens() {
		BigDecimal tHomens = new BigDecimal(this.totalHomens);
		return tHomens.multiply(new BigDecimal("100")).divide(populacaoTotal, RoundingMode.HALF_EVEN).setScale(2);
	}

}
