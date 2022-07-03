Feature: Api01_01

  Scenario: Api01Json ile
    Given kullanici "productsList" endpointine response almak icin request gonderir
    Then  kullanici genel response un status codunun 200 oldugunu dogrular
    And kullanici response ile gelen urunlerin sayisinin 34 oldugunu dogrular
    And kullanici response ile gelen urunlerin fiyati 1000 den kucuk olan urunleri log dosyasina yazdirir
