package com.dasa.service;

import java.util.List;

import com.dasa.domain.EstatisticaParticipacaoCampanha;
import com.dasa.domain.NotificacaoParticipacaoCampanha;
import com.dasa.domain.ParticipacaoCampanha;

public interface ParticipacaoCampanhaService {
	
	void registrarParticipacao(NotificacaoParticipacaoCampanha notificacao);
	List<ParticipacaoCampanha> findByAno(Integer ano);
	List<EstatisticaParticipacaoCampanha> findEstatiscaByAno(Integer ano);

}
