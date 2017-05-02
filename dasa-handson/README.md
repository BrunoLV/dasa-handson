Objetivos Gerais (Entregável):
1. Fornecer uma API com a população geral e a proporção percentual entre homens e mulheres para um determinado ano.    
    1.1 Retorne o resultado para o ano de 2010.
    Url: /dadosPopulacionais/2010

    1.2 Retorne o resultado para o ano de 2017 considerando a formula de projeção Geométrica de crescimento. populacional
    Url:/dadosPopulacionais/2017

2. Fornecer uma API onde um usuário possa notificar que participou de uma das campanhas. Importante que na resposta da participação contenha o Sexo, a Campanha e o ​Ano.​
    Url: /participacaoCampanha/registrar
    Json Exemplo: 
    {
	"ano":2016,
	"campanha":"PREVENCAO_CANCER_PROSTATA",
	"sexo":"F"
    }

    2.1 Fornecer uma API com dos dados de participação por Campanha, realizando o filtro por Ano.
    Url: /participacaoCampanha/obterPorAno/{ano}
    
    2.2 Fornecer uma API com a proporção de participação entre Homens X Mulheres X Campanha filtrando pelo ano.
    Url: /participacaoCampanha/obterEstasticaPorAno/{ano}
