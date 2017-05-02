package com.dasa.domain;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class EstatisticaAnoResponse {
	private final String ano;
	private final BigDecimal populacaoGeral;
	private final BigDecimal proporcaoHomens;
	private final BigDecimal proporcaoMulheres;
	
	public String getAno() {
		return ano;
	}

	public BigDecimal getPopulacaoGeral() {
		return populacaoGeral;
	}

	public BigDecimal getProporcaoHomens() {
		return proporcaoHomens;
	}

	public BigDecimal getProporcaoMulheres() {
		return proporcaoMulheres;
	}

	public EstatisticaAnoResponse(DadoPopulacional pop) {
		this.ano = pop.getAno();
		this.populacaoGeral = pop.getPopulacaoTotal();
		this.proporcaoHomens = pop.obtemProporcaoHomens();
		this.proporcaoMulheres = pop.obtemProporcaoMulheres();
	}
}
