package com.dasa.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.dasa.domain.EnumCampanha;
import com.dasa.domain.ParticipacaoCampanha;

@Transactional
public interface ParticipacaoCampanhaRepository extends CrudRepository<ParticipacaoCampanha, Long> {

	List<ParticipacaoCampanha> findByAno(final Integer ano);

	ParticipacaoCampanha findByAnoAndCampanha(Integer ano, EnumCampanha campanha);
	
	@Query("select count(p) from ParticipacaoCampanha p where p.ano = :ano and p.campanha = :campanha")
	Long countParticipacaoCampanhaByAno(@Param("ano") final Integer ano,
			@Param("campanha") final EnumCampanha campanha);

}
