package com.dasa.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dasa.domain.DadoPopulacional;
import com.dasa.domain.EstatisticaParticipacaoCampanha;
import com.dasa.domain.NotificacaoParticipacaoCampanha;
import com.dasa.domain.ParticipacaoCampanha;
import com.dasa.repository.ParticipacaoCampanhaRepository;

@Service
public class ParticipacaoCampanhaServiceImpl implements ParticipacaoCampanhaService {

	@Autowired
	private ParticipacaoCampanhaRepository repository;

	@Autowired
	private DadosPopulacionaisService dadosPopulacionaisService;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void registrarParticipacao(NotificacaoParticipacaoCampanha notificacao) {
		Long contagem = this.repository.countParticipacaoCampanhaByAno(notificacao.getAno(), notificacao.getCampanha());

		ParticipacaoCampanha participacaoCampanha = null;
		if (contagem > 0) {
			participacaoCampanha = this.repository.findByAnoAndCampanha(notificacao.getAno(),
					notificacao.getCampanha());
		} else {
			participacaoCampanha = new ParticipacaoCampanha();
			participacaoCampanha.setAno(notificacao.getAno());
			participacaoCampanha.setCampanha(notificacao.getCampanha());
		}
		participacaoCampanha.somarUmAQuantidadeTotalGeral();
		switch (notificacao.getSexo()) {
		case "M":
			participacaoCampanha.somarUmAQuantidadDeHomens();
			break;
		case "F":
			participacaoCampanha.somarUmAQuantidadeDeMulheres();
			break;
		default:
			break;
		}
		this.repository.save(participacaoCampanha);
	}

	@Override
	public List<ParticipacaoCampanha> findByAno(Integer ano) {
		return this.repository.findByAno(ano);
	}

	@Override
	public List<EstatisticaParticipacaoCampanha> findEstatiscaByAno(Integer ano) {
		List<EstatisticaParticipacaoCampanha> estatisticas = new ArrayList<>();
		List<ParticipacaoCampanha> lista = this.repository.findByAno(ano);
		for (ParticipacaoCampanha participacaoCampanha : lista) {
			DadoPopulacional dadoPopulacional = this.dadosPopulacionaisService.obterPopulacaoPorAno(ano.toString());
			Double proporcaoEmRelacaoPopulacaoTotalHomens = (Double.valueOf(participacaoCampanha.getTotalHomens())
					* 100.00) / Double.valueOf(dadoPopulacional.getTotalHomens());
			Double proporcaoEmRelacaoPopulacaoTotalMulheres = (Double.valueOf(participacaoCampanha.getTotalMulheres())
					* 100.00) / Double.valueOf(dadoPopulacional.getTotalMulheres());
			EstatisticaParticipacaoCampanha estatistica = new EstatisticaParticipacaoCampanha();
			estatistica.setAno(participacaoCampanha.getAno());
			estatistica.setCampanha(participacaoCampanha.getCampanha());
			estatistica.setTotalParticipantes(participacaoCampanha.getTotalGeralParticipantes());
			estatistica.setProporcaoHomens(participacaoCampanha.obtemProporcaoHomens());
			estatistica.setProporcaoHomensEmRelacaoPopulacaoTotalHomens(
					new BigDecimal(proporcaoEmRelacaoPopulacaoTotalHomens).setScale(2, RoundingMode.HALF_EVEN));
			estatistica.setProporcaoMulheres(participacaoCampanha.obtemProporcaoMulheres());
			estatistica.setProporcaoMulheresEmRelacaoPopulacaoTotalMulheres(
					new BigDecimal(proporcaoEmRelacaoPopulacaoTotalMulheres).setScale(2, RoundingMode.HALF_EVEN));
			estatisticas.add(estatistica);
		}
		return estatisticas;
	}

}
