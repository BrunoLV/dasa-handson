package com.dasa.domain;

import lombok.Data;

@Data
public class NotificacaoParticipacaoCampanha {

	private Integer ano;
	private EnumCampanha campanha;
	private String sexo;

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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}
