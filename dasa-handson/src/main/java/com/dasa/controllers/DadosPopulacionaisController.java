package com.dasa.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dasa.domain.DadoPopulacional;
import com.dasa.domain.EstatisticaAnoResponse;
import com.dasa.service.DadosPopulacionaisService;

@RestController
@RequestMapping("/dadosPopulacionais")
public class DadosPopulacionaisController {

	@Autowired
	private DadosPopulacionaisService service;

	@RequestMapping(value = "/2010", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public EstatisticaAnoResponse get2010data() {

		DadoPopulacional pop = service.obterPopulacaoPorAno(Optional.of("2010"));
		EstatisticaAnoResponse stat = new EstatisticaAnoResponse(pop);

		return stat;
	}

	@RequestMapping(value = "/2017", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public EstatisticaAnoResponse get2017data() {
		DadoPopulacional pop = service.obterPopulacaoPorAno(Optional.of("2017"));
		EstatisticaAnoResponse stat = new EstatisticaAnoResponse(pop);

		return stat;
	}

}
