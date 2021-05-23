# Northwind API


<details>
  <summary>🖱 Click for Swagger2 integration...</summary><br>

## 1. Adding the Maven Dependency

Maven projemize eklemek için pom.xml dosyasında bir bağımlılığa ihtiyacımız var

```xml
<dependency>
 <groupId>io.springfox</groupId>
 <artifactId>springfox-swagger2</artifactId>
 <version>2.9.2</version>
</dependency>
```

## 2. Swagger UI - Enabling Springfox's Swagger UI

Swagger UI, Swagger tarafından oluşturulan API belgeleriyle kullanıcı etkileşimini çok daha kolay hale getiren yerleşik bir çözümdür Ve Swagger kullanıcı arayüzünü kullanmak için ek bir Maven bağımlılığı eklememiz gerekmekte bu yüzden projemizin pom.xml'ine ekliyoruz.

```xml
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.9.2</version>
</dependency>
```

- > pom.xml'in son hali aşağıdaki gibi olmalıdır.

![xmlFile3](https://user-images.githubusercontent.com/49093196/119268687-c10dec80-bbfc-11eb-9d51-cf6b498d3b9e.png)

## 3. Java Configuration

Tüm API'miz için belgeleri Swagger aracılığıyla kullanıma sunacak olan yapılandrımadır
Bu methodun amacı; Springboot projemizdeki <strong>@Bean</strong> anotasyonunu gördüğü zaman belleğe yerleştiriyor ve daha sonra Controller paketlerimizdeki requesthandleri bulup dökumante hale getiriyor.

```java
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
          .select()
          .apis(RequestHandlerSelectors.any())
          .paths(PathSelectors.any())
          .build();
    }
```
java kodunu MainApplication.java classındaki main methodunun altına tanımlıyoruz.
## Son olarak
Application class'ımıza <strong>@EnableSwagger2</strong> anotasyonu ile aktif hale getiriyoruz.
<hr>

### Ve artık Swagger kullanıma hazır ✅
```
http://localhost:8080/swagger-ui.html
```

![responseBody](https://user-images.githubusercontent.com/49093196/119269467-8443f480-bc00-11eb-842d-84d0073bd16c.jpg)
<hr>

![swagger2_](https://user-images.githubusercontent.com/49093196/119268766-12b67700-bbfd-11eb-94e7-cace39e44a0f.jpg)
<hr>
</details>
