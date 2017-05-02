package com.dasa.service;

public abstract class CalculoService {

	public static Double calculaTaxaCrescimentoGeometrico(Double valorInicial, Double valorFinal, Double intervalo) {
		return Math.pow(valorFinal / valorInicial, 1 / intervalo) - 1;
	}
	
	public static Double calculaProjecaoGeometrica(Double valorAtual, Double taxaCrescimento, Double tempo) {
		return valorAtual * Math.pow(Math.E, taxaCrescimento * tempo);
	}

}
