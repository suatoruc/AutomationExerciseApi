Feature: Automation Exercise Api01 testi

  @api01
  Scenario: Api01 test
    Given kullanici "productsList" endpointine request gonderir
    Then  kullanici status codu dogrular
    And kullanici urunlerin sayisinin 34 oldugunu dogrular
    And kullanici fiyati 1000 den kucuk olan urunleri log dosyasina yazdirir



