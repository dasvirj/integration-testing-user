Feature: Teste de integração com cucumber e rest assured

  Scenario: Listar usuarios apos cadastro
    Given as informacoes de um usuario
    When realizo o seu cadastro
    Then o status code da API deve retornar 201
    And todos os usuarios cadastrados sao listados