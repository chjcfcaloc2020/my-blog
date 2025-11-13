# 📝 My Blog

**My Blog** là hệ thống backend được xây dựng bằng **Spring Boot**, cung cấp nền tảng cho người dùng đăng tải, quản lý và tương tác với các bài viết (blogs).

---

## 🚀 Công nghệ sử dụng

| Thành phần | Công nghệ                             |
|-------------|---------------------------------------|
| **Ngôn ngữ** | Java 21                               |
| **Framework chính** | Spring Boot 3.x                       |
| **ORM & Database** | Spring Data JPA, MySQL                |
| **Bảo mật** | Spring Security, JWT (JSON Web Token) |
| **Build Tool** | Maven                                 |
| **API Documentation** | Swagger / Springdoc OpenAPI           |
| **Quản lý phụ thuộc** | Lombok, ModelMapper, Validation       |

---

## 🧩 Kiến trúc hệ thống

Dự án tuân theo mô hình **3-Layer Architecture**:

- **Controller**: Xử lý request từ client và trả response.
- **Service**: Chứa logic nghiệp vụ chính.
- **Repository**: Tương tác với CSDL thông qua JPA/Hibernate.  