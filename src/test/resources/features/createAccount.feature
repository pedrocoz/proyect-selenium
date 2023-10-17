@register
Feature: Crear cuenta

  @caso-1
  Scenario: Crear una cuenta exitosa
    Given Ingreso a la pagina Advantage
    And navego a la pagina crear cuenta
    When Ingreso el usuario "Prueba"
    And  Ingreso el correo "prueba@gmail.com"
    And Ingreso la contraseña "Testing123"
    And Ingreso la confirmacion de contraseña "Testing123"

  @caso-2
  Scenario: Crear una cuenta exitosa - 2
    Given Ingreso a la pagina Advantage
    And navego a la pagina crear cuenta
    When Ingreso el detalle de la cuenta v1
      | usuario | correo           | contraseña | confirm-contraseña |
      | Prueba  | prueba@gmail.com | Testing123 | Testing123         |

  @caso-3 @usuario-existente @nok
  Scenario: Crear una cuenta exitosa - 3
    Given Ingreso a la pagina Advantage
    And navego a la pagina crear cuenta
    When Ingreso el detalle de la cuenta v2
      | usuario            | Prueba1           |
      | correo             | prueba1@gmail.com |
      | contraseña         | Testing123        |
      | confirm-contraseña | Testing123        |
    And Ingreso mis datos personales
      | nombre   | Carlos    |
      | apellido | Zambrano  |
      | celular  | 111111111 |
    And Ingreso mi direccion
      | pais          | Peru   |
      | ciudad        | Lima   |
      | direccion     | Lima   |
      | provincia     | Lima   |
      | codigo-postal | 123456 |
    And Accepto los terminos y condiciones
    And registro una cuenta
    Then valido que exista el usuario

  @caso-4
  Scenario Outline: Crear una cuenta exitosa - 4
    Given Ingreso a la pagina Advantage
    And navego a la pagina crear cuenta
    When Ingreso el detalle de la cuenta v2
      | usuario            | <usuario>            |
      | correo             | <correo>             |
      | contraseña         | <contraseña>         |
      | confirm-contraseña | <confirm-contraseña> |

    Examples:
      | usuario | correo            | contraseña | confirm-contraseña |
      | Prueba  | prueba@gmail.com  | Testing123 | Testing123         |
      | Prueba1 | prueba1@gmail.com | Testing123 | Testing123         |

  @caso-5 @ok
  Scenario Outline: Crear una cuenta exitosa - 5
    Given Ingreso a la pagina Advantage
    And navego a la pagina crear cuenta
    When Ingreso el detalle de la cuenta v2
      | usuario            | <usuario>    |
      | correo             | <correo>     |
      | contraseña         | <contraseña> |
      | confirm-contraseña | <contraseña> |
    And Ingreso mis datos personales
      | nombre   | <nombre>   |
      | apellido | <apellido> |
      | celular  | <celular>  |
    And Ingreso mi direccion
      | pais          | <pais>          |
      | ciudad        | <ciudad>        |
      | direccion     | <direccion>     |
      | provincia     | <provincia>     |
      | codigo-postal | <codigo-postal> |
    And Accepto los terminos y condiciones
    And registro una cuenta
    Then valido que el usuario "<usuario>" este registrado

    Examples:
      | usuario | correo            | contraseña | nombre  | apellido | celular   | pais | ciudad | direccion | provincia | codigo-postal |
      | Prueba4 | prueba4@gmail.com | Testing123 | Testing | QA       | 999999992 | Peru | Lima   | Lima      | Lima      | 12345         |