# Kullanıcı Yönetim Sistemi

Bu proje, rol tabanlı erişim kontrolü (RBAC) ile basit bir kullanıcı yönetim sistemi sağlar. Spring Boot ve Spring Security'yi kullanarak kullanıcı kimlik doğrulama ve yetkilendirme özelliklerini içerir.

## Nesneler

### User Entity

- `User` sınıfı, sistemin bir kullanıcısını temsil eder.
- Alanlar arasında ad, kullanıcı adı, parola, yetkiler ve hesap durumunu belirten bayraklar bulunur.
  
### Role Enum

- `Role` enum'u, sistemdeki bir rolü temsil eder.
- Önceden tanımlanmış rolleri içerir: USER, ADMIN, MOD.

## Şifre Kodlama

### PasswordEncoderConfig

- `PasswordEncoderConfig`, şifre kodlaması için bir BCryptPasswordEncoder bean sağlar. Bu bean sayesinde şifre kodlanarak veritabanına kaydedilir.

## Güvenlik Yapılandırması

### SecurityConfig

- `SecurityConfig`, Spring Security'yi HTTP Temel kimlik doğrulaması ve rol tabanlı yetkilendirme için yapılandırır.
- Genel ve özel kaynaklar için erişim kurallarını tanımlar.
- H2 Console erişimini ADMIN rolü için etkinleştirir.

## Servisler

### UserService

- `UserService`, kullanıcı yönetimi için iş mantığını sağlar.
- Kullanıcı oluşturma ve kullanıcı adına göre kullanıcı alma gibi yöntemleri içerir.

## Kullanıcı Ayrıntıları Servisi Uygulaması

### UserDetailsServiceImpl

- `UserDetailsServiceImpl`, UserDetailsService arayüzünü uygular.
- Kullanıcı ayrıntılarını UserService'den alır ve bunları UserDetails'e dönüştürür.

## Controllers

### PublicController

- `/public` endpoint'inde basit bir selamlama için bir API uç noktası sağlar.

### PrivateController

- `/private` endpoint'inde özel selamlamalar için API uç noktaları sağlar.
- KULLANICI ve YÖNETİCİ rolleri için özel selamlamalar içerir.

## Kullanım

Projenin yerel ortamınızda çalıştırılabilmesi için aşağıdaki adımları takip edebilirsiniz:

1. **Depoyu Klonlayın:**
    ```bash
    git clone https://github.com/ADBERILGEN35/BasicAuthApplication.git
    ```

2. **Proje Dosyalarını Açın:**
    Proje dosyalarını tercih ettiğiniz IDE veya metin düzenleyici ile açın.

3. **Veritabanı Yapılandırması:**
    Veritabanınızın doğru bir şekilde yapılandırıldığından emin olun (örneğin, H2 bellek içi veritabanı).

4. **Uygulamayı Çalıştırın:**
    ```
   bash./gradlew bootRun
    ```

6. **Public Erişim:**
    Postman'den [http://localhost:8080/public](http://localhost:8080/public) adresine istek atın.

7. **Private Erişim:**
    Tarayıcınızda [http://localhost:8080/private](http://localhost:8080/private) adresine istek atın ve uygun kimlik doğrulama bilgilerine sahip olduğunuzdan emin olun.

Not: Uygulamayı çalıştırmadan önce gerekli bağımlılıkları yüklemek için Gradle veya başka bir bağımlılık yönetici kullanmanız gerekebilir.

