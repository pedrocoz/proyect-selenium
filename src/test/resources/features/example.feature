Feature: Búsqueda en Google

  @example
  Scenario: Navegar a la página de Google y realizar una búsqueda
    Given ingreso a la página de Google
    When ingreso "Selenium" en el campo de búsqueda
    And hago clic en el botón de búsqueda
    Then veo resultados de búsqueda relacionados con "Seleniuma"