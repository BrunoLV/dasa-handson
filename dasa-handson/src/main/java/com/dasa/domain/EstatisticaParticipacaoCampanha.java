package com.dasa.domain;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class EstatisticaParticipacaoCampanha {

	private Integer ano;
	private EnumCampanha campanha;
	private Long totalParticipantes;
	private BigDecimal proporcaoHomens;
	private BigDecimal proporcaoHomensEmRelacaoPopulacaoTotalHomens;
	private BigDecimal proporcaoMulheres;
	private BigDecimal proporcaoMulheresEmRelacaoPopulacaoTotalMulheres;

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public EnumCampanha getCampanha() {
		return campanha;
	}

	public void setCampanha(EnumCampanha campanha) {
		this.campanha = campanha;
	}

	public Long getTotalParticipantes() {
		return totalParticipantes;
	}

	public void setTotalParticipantes(Long totalParticipantes) {
		this.totalParticipantes = totalParticipantes;
	}

	public BigDecimal getProporcaoHomens() {
		return proporcaoHomens;
	}

	public void setProporcaoHomens(BigDecimal proporcaoHomens) {
		this.proporcaoHomens = proporcaoHomens;
	}

	public BigDecimal getProporcaoHomensEmRelacaoPopulacaoTotalHomens() {
		return proporcaoHomensEmRelacaoPopulacaoTotalHomens;
	}

	public void setProporcaoHomensEmRelacaoPopulacaoTotalHomens(
			BigDecimal proporcaoHomensEmRelacaoPopulacaoTotalHomens) {
		this.proporcaoHomensEmRelacaoPopulacaoTotalHomens = proporcaoHomensEmRelacaoPopulacaoTotalHomens;
	}

	public BigDecimal getProporcaoMulheres() {
		return proporcaoMulheres;
	}

	public void setProporcaoMulheres(BigDecimal proporcaoMulheres) {
		this.proporcaoMulheres = proporcaoMulheres;
	}

	public BigDecimal getProporcaoMulheresEmRelacaoPopulacaoTotalMulheres() {
		return proporcaoMulheresEmRelacaoPopulacaoTotalMulheres;
	}

	public void setProporcaoMulheresEmRelacaoPopulacaoTotalMulheres(
			BigDecimal proporcaoMulheresEmRelacaoPopulacaoTotalMulheres) {
		this.proporcaoMulheresEmRelacaoPopulacaoTotalMulheres = proporcaoMulheresEmRelacaoPopulacaoTotalMulheres;
	}

}
