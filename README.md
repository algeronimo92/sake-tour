# 🗺️ SakeTour — Explore the Best Sake Shops in Japan 🇯🇵🍶

SakeTour is a modern Android app built with Jetpack Compose, MVVM, and Clean Architecture.  
It helps travelers discover and explore top-rated sake shops across Japan, from Kyoto to Tokyo and beyond.

---

## ✨ Features

- 📍 Browse curated sake shop listings by rating and location
- 🖼️ View elegant shop cards with address and Google Maps links
- ⚛️ Built with Jetpack Compose UI
- 🧠 Clean Architecture: data / domain / presentation
- 🌐 Handles API failure gracefully using a local JSON fallback
- 🔍 Fully tested: use cases, mappers, ViewModels
- 💡 Modular codebase for scalability and clarity

---

## 📸 Preview

| Shop List | Shop Detail |
|-----------|-------------|
| ![List Screenshot](screenshots/shop_list.png) | ![Detail Screenshot](screenshots/shop_detail.png) |

---

## 📐 Architecture

```
📦 app
├── presentation (Compose UI, ViewModels)
├── di (Koin injection)
📦 data
├── dto, repository, mapper, network
📦 domain
├── models, use cases, interfaces
📦 designsystem
├── UI components, theme, spacing, typography
```

> Follows Clean Architecture + Modularization for maintainability and testability.

---

## 🧪 Testing

- ✅ Unit Tests for:
  - Use Cases
  - Repository fallback logic
  - DTO ↔ Domain mappers
  - ViewModel StateFlow
- 🧪 Instrumentation tests for assets fallback (JSON)
- 🧭 End-to-end test for navigation using Compose UI Test

---

## ⚙️ Tech Stack

| Layer         | Tech                                      |
|---------------|-------------------------------------------|
| UI            | Jetpack Compose, Material3                |
| DI            | Koin                                      |
| Networking    | Retrofit + Gson                           |
| Async         | Kotlin Coroutines                         |
| Architecture  | MVVM + Clean Architecture (modular)       |
| Testing       | JUnit5, Turbine, MockK, Coroutine Test    |
| Code Quality  | ktlint, Lint + `.editorconfig` enforced   |

---

## 🚀 Getting Started

1. Clone the repo
```bash
git clone https://github.com/yourusername/SakeTour.git
```

2. Open in Android Studio (Giraffe or higher)

3. Run the app on an emulator or real device

---

## 🧰 Scripts & Commands

- Run unit tests:
```bash
./gradlew testDebugUnitTest
```

- Run ktlint check:
```bash
./gradlew ktlintCheck
```

- Run instrumentation tests:
```bash
./gradlew connectedAndroidTest
```

---

## 👨‍💻 Author

**Alan Gerónimo**  
Senior Android Developer — Kotlin | Compose | Clean Architecture  
📍 Trujillo, Peru  
🔗 [LinkedIn](https://www.linkedin.com/in/alan-ger%C3%B3nimo-sanes) · [GitHub](https://github.com/algeronimo92)

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).
