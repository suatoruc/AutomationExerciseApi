Feature: Automation Exercise Api08 testi

  @api01
  Scenario: Api08 testi
    Given kullanici "verifyLogin" endpointe post islemi icin request gonderir
    Then  kullanici verifylogin endpointine post islemi sonrasi responseCode  400 kodu aldigini dogrular
    And  kullanici post islemi sonrasi gelen cevabin "Bad request, email or password parameter is missing in POST request." oldugunu dogrular