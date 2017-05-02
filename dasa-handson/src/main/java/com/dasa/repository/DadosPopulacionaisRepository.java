package com.dasa.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dasa.domain.DadoPopulacional;

@Transactional
public interface DadosPopulacionaisRepository extends CrudRepository<DadoPopulacional, Long> {

    DadoPopulacional findByAno(final String ano);
    
    @Query(value = "select min(d.ano) from DadoPopulacional d")
    String findPrimeiroAno();
    
    @Query(value = "select max(d.ano) from DadoPopulacional d")
    String findUltimoAno();

}
