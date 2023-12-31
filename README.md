

<div style="display: flex; justify-content: space-between; align-items: center;">
  <h1 style="margin-right: auto;">Twitter Clone Projesi</h1>
  <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/53/X_logo_2023_original.svg/450px-X_logo_2023_original.svg.png" alt="X Logo" width="100" style="margin-left: auto;">
</div>

Bu proje, Java ve Spring Boot kullanılarak geliştirilmiş bir Twitter klonudur. Proje, kullanıcıların tweetler oluşturabildiği, diğer kullanıcıları takip edebildiği ve beğendikleri tweetleri kaydedebildiği bir sosyal medya platformunu simüle eder.

## Proje Yapısı

Proje, aşağıdaki temel bileşenleri içerir:

- **Kullanıcı Yönetimi**: Kullanıcıların kaydolması, giriş yapması ve profillerini yönetmesi.
- **Tweet Yönetimi**: Kullanıcıların tweetler oluşturması, güncellemesi ve silmesi.
- **Yorum Yönetimi**: Kullanıcıların tweetlere yorum yapması, yorumları güncellemesi ve silebilmesi.
- **Beğeni Yönetimi**: Kullanıcıların tweetleri beğenmesi ve beğenileri yönetmesi.

## Kullanılan Teknolojiler

- **Java**: Ana programlama dili.
- **Spring Boot**: Web uygulamaları için hızlı ve kolay bir şekilde yapılandırma sağlar.
- **Spring Data JPA**: Veritabanı işlemleri için kullanılır.
- **Spring Security**: Kimlik doğrulama ve yetkilendirme işlemleri için entegre edilmiştir.
- **PostgreSQL**: Veritabanı olarak kullanılmıştır.

## Güvenlik

Kullanıcı kaydı (register) ve girişi (login) işlemlerinde kullanılan şifreler, güvenlik amacıyla bcrypt şifreleme yöntemi ile saklanmaktadır.

## Nasıl Başlatılır

- Projeyi bilgisayarınıza klonlayın.
- PostgreSQL veritabanınızı oluşturun ve bağlantı ayarlarını `application.properties` dosyasında güncelleyin.
- Proje dizininde terminal veya komut istemcisini açın.
- `mvn spring-boot:run` komutunu kullanarak projeyi çalıştırın.

## API Endpoint'leri

- **Kullanıcı Yönetimi**:
    - `POST /auth/register`: Yeni kullanıcı kaydı oluşturur.
    - `POST /auth/login`: Kullanıcı girişi yapar.

- **Tweet Yönetimi**:
    - `GET /tweet`: Tüm tweetleri listeler.
    - `GET /tweet/{id}`: Belirli bir tweeti getirir.
    - `POST /tweet`: Yeni bir tweet oluşturur.
    - `PUT /tweet/{id}`: Belirli bir tweeti günceller.
    - `DELETE /tweet/{id}`: Belirli bir tweeti siler.

- **Yorum Yönetimi**:
    - `GET /comment`: Belirli parametrelere göre yorumları listeler.
    - `GET /comment/{commentId}`: Belirli bir yorumu getirir.
    - `POST /comment`: Yeni bir yorum oluşturur.
    - `PUT /comment/{commentId}`: Belirli bir yorumu günceller.
    - `DELETE /comment/{commentId}`: Belirli bir yorumu siler.

- **Beğeni Yönetimi**:
    - `GET /like`: Belirli parametrelere göre beğenileri listeler.
    - `GET /like/{id}`: Belirli bir beğeniyi getirir.
    - `POST /like`: Yeni bir beğeni oluşturur.
    - `DELETE /like/{id}`: Belirli bir beğeniyi siler.