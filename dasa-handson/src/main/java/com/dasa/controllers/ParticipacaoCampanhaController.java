package com.dasa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dasa.domain.EstatisticaParticipacaoCampanha;
import com.dasa.domain.NotificacaoParticipacaoCampanha;
import com.dasa.domain.ParticipacaoCampanha;
import com.dasa.service.ParticipacaoCampanhaService;

@RestController
@RequestMapping("/participacaoCampanha")
public class ParticipacaoCampanhaController {

	@Autowired
	private ParticipacaoCampanhaService service;

	@RequestMapping(value = "/registrar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public void registrarParticipacao(@RequestBody NotificacaoParticipacaoCampanha notificacao) {
		this.service.registrarParticipacao(notificacao);
	}
	
	@RequestMapping(value = "/obterPorAno/{ano}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public List<ParticipacaoCampanha> obterParticipacoesDoAno(@PathVariable("ano") Integer ano) {
		List<ParticipacaoCampanha> lista = this.service.findByAno(ano);
		return lista;
	}
	
	@RequestMapping(value = "/obterEstasticaPorAno/{ano}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public List<EstatisticaParticipacaoCampanha> obterEstatiscaParticipacaoPorAno(@PathVariable("ano") Integer ano) {
		List<EstatisticaParticipacaoCampanha> lista = this.service.findEstatiscaByAno(ano);
		return lista;
	}

}
