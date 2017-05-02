package com.dasa.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "participacao_campanha")
public class ParticipacaoCampanha {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Long id;
	
	private Integer ano;
	
	@Enumerated(EnumType.STRING)
	private EnumCampanha campanha;
	private Long totalGeralParticipantes;
	private Long totalHomens;
	private Long totalMulheres;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

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

	public Long getTotalGeralParticipantes() {
		return totalGeralParticipantes;
	}

	public void setTotalGeralParticipantes(Long totalGeralParticipantes) {
		this.totalGeralParticipantes = totalGeralParticipantes;
	}

	public Long getTotalHomens() {
		if (this.totalHomens == null) {
			return 0l;
		}
		return totalHomens;
	}

	public void setTotalHomens(Long totalHomens) {
		this.totalHomens = totalHomens;
	}

	public Long getTotalMulheres() {
		if (this.totalMulheres == null) {
			return 0l;
		}
		return totalMulheres;
	}

	public void setTotalMulheres(Long totalMulheres) {
		this.totalMulheres = totalMulheres;
	}

	public BigDecimal obtemProporcaoMulheres() {
		BigDecimal tMulheres = new BigDecimal(this.totalMulheres);
		return tMulheres.multiply(new BigDecimal("100"))
				.divide(new BigDecimal(this.totalGeralParticipantes), RoundingMode.HALF_EVEN).setScale(2);
	}

	public BigDecimal obtemProporcaoHomens() {
		BigDecimal tHomens = new BigDecimal(this.totalHomens);
		return tHomens.multiply(new BigDecimal("100"))
				.divide(new BigDecimal(this.totalGeralParticipantes), RoundingMode.HALF_EVEN).setScale(2);
	}

	public void somarUmAQuantidadeTotalGeral() {
		if (this.totalGeralParticipantes == null) {
			this.totalGeralParticipantes = 1l;
		} else {
			this.totalGeralParticipantes += 1;
		}
	}
	
	public void somarUmAQuantidadDeHomens() {
		if (this.totalHomens == null) {
			this.totalHomens = 1l;
		} else {
			this.totalHomens += 1;
		}
	}
	
	public void somarUmAQuantidadeDeMulheres() {
		if (this.totalMulheres == null) {
			this.totalMulheres = 1l;
		} else {
			this.totalMulheres += 1;
		}
	}

}
