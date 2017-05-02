package com.dasa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dasa.domain.DadoPopulacional;
import com.dasa.repository.DadosPopulacionaisRepository;

@Service
public class DadosPopulacionaisServiceimpl implements DadosPopulacionaisService {

	@Autowired
	private DadosPopulacionaisRepository dadosPopulacionaisRepository;

	@Override
	public DadoPopulacional obterPopulacaoPorAno(final Optional<String> ano) {
		final String anoCenso = ano.get();
		if (!ano.isPresent()) {
			throw new IllegalArgumentException("Parametro Ano é Obrigatório");
		}
		DadoPopulacional dadoPopulacional = obterPopulacaoPorAno(anoCenso);
		return dadoPopulacional;
	}

	@Override
	public DadoPopulacional obterPopulacaoPorAno(final String anoCenso) {
		DadoPopulacional dadoPopulacional = dadosPopulacionaisRepository.findByAno(anoCenso);
		if (dadoPopulacional == null) {
			// Se não existe dado populacional estima-se calculando a taxa de
			// crescismento.
			String primeiroAnoRegistrado = dadosPopulacionaisRepository.findPrimeiroAno();
			String ultimoAnoRegistrado = dadosPopulacionaisRepository.findUltimoAno();
			if (primeiroAnoRegistrado != null && ultimoAnoRegistrado != null) {
				dadoPopulacional = this.executarProjecao(anoCenso, primeiroAnoRegistrado, ultimoAnoRegistrado);
			}
		}
		return dadoPopulacional;
	}

	private DadoPopulacional executarProjecao(String ano, String primeiroAnoRegistrado, String ultimoAnoRegistrado) {

		DadoPopulacional dadoPopulacionalPrimeiroAno = dadosPopulacionaisRepository.findByAno(primeiroAnoRegistrado);
		DadoPopulacional dadoPopulacionalUltimoAno = dadosPopulacionaisRepository.findByAno(ultimoAnoRegistrado);

		Double intervalo = Double.parseDouble(dadoPopulacionalUltimoAno.getAno())
				- Double.parseDouble(dadoPopulacionalPrimeiroAno.getAno());
		Double intervaloProjecao = Double.parseDouble(ano) - Double.parseDouble(dadoPopulacionalUltimoAno.getAno());

		Double taxaCrescimentoPopulacional = CalculoService.calculaTaxaCrescimentoGeometrico(
				dadoPopulacionalPrimeiroAno.getPopulacaoTotal().doubleValue(),
				dadoPopulacionalUltimoAno.getPopulacaoTotal().doubleValue(), intervalo);
		Long projecaoPopulacaoGeral = CalculoService
				.calculaProjecaoGeometrica(dadoPopulacionalUltimoAno.getPopulacaoTotal().doubleValue(),
						taxaCrescimentoPopulacional, intervaloProjecao)
				.longValue();

		Double taxaCrescimentoHomens = CalculoService.calculaTaxaCrescimentoGeometrico(
				dadoPopulacionalPrimeiroAno.getTotalHomens().doubleValue(),
				dadoPopulacionalUltimoAno.getTotalHomens().doubleValue(), intervalo);
		Long projecaoCrescimentoHomens = CalculoService
				.calculaProjecaoGeometrica(dadoPopulacionalUltimoAno.getTotalHomens().doubleValue(),
						taxaCrescimentoHomens, intervaloProjecao)
				.longValue();

		Double taxaCrescimentoMulheres = CalculoService.calculaTaxaCrescimentoGeometrico(
				dadoPopulacionalPrimeiroAno.getTotalMulheres().doubleValue(),
				dadoPopulacionalUltimoAno.getTotalMulheres().doubleValue(), intervalo);
		Long projecaoCrescimentoMulheres = CalculoService
				.calculaProjecaoGeometrica(dadoPopulacionalUltimoAno.getTotalMulheres().doubleValue(),
						taxaCrescimentoMulheres, intervaloProjecao)
				.longValue();

		DadoPopulacional dadoPopulacional = new DadoPopulacional(ano, projecaoPopulacaoGeral.toString(),
				projecaoCrescimentoHomens.toString(), projecaoCrescimentoMulheres.toString());
		return dadoPopulacional;
	}
}
