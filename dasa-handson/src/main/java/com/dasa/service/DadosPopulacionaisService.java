package com.dasa.service;

import java.util.Optional;

import com.dasa.domain.DadoPopulacional;


public interface DadosPopulacionaisService {

    DadoPopulacional obterPopulacaoPorAno(final Optional<String>  ano);
    
    DadoPopulacional obterPopulacaoPorAno(String  ano);

}
