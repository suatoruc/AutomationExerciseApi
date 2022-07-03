# AutomationExerciseApiTests

Otomasyon yaparken kullanıdığımız otomasyon sitesi olan # Automation Exercise 
sitesindeki # Api # testlerinin cözümünü iki farklı yöntemle yaptım. 
Bildiginiz gibi api testlerinde bize dönen responce Json formatında gelir 
bizde bu responce göre assert lerimizi kullanarak dogrulamalarımızı yapıyorduk 
ama bu sitede bize responce olarak html/text geliyor.

ilk cözüm yolumuzda list ler map ler sting manipülation gibi kullanarak genel bir java tekrarı yaptım adeta :)
ikinci yol olarak da #html/text convert to json# kullanarak assert lerimizi genel responce göre yapabiliyoruz.
gelen responce deki alanları alabilmk içinde bir fori ile ihtiyacımız olan yapıyı kurabildik.

# pojo class yapısı kullanıldı
# framework olarak çok kullanışlı olmasa da cucumber kullandım.
# log lama olarak LOG4J class'ını kullandım.

# umarım otomasyon pratigi için faydalı olur. 
