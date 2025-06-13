<p align="center">
  <img src="https://github.com/user-attachments/assets/669b79c8-ae53-4136-a8cb-603be26b8f0b" width="600" alt="App Banner"/>
</p>

# 🗺️ SakeTour — Explore the Best Sake Shops in Japan🍶

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

## 🖌️ Initial Design (Figma)

You can explore the initial UI mockup on Figma here:  
👉 [Figma Design](https://www.figma.com/design/xzyPG1Na6C7dpVEDEr9Rso/Untitled?node-id=0-1&t=s37gBnlOXjYBLeS5-1)

## 📸 Preview

| Shop List | Shop Detail |
|-----------|-------------|
| <img src="https://github.com/user-attachments/assets/d0272a1c-c7b9-4eaa-bc95-9f11ebf96ff4" width="300"/> | <img src="https://github.com/user-attachments/assets/120fadc2-21f8-47a8-b771-9d929381c428" width="300"/> |

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

![image](https://github.com/user-attachments/assets/9badbb89-4f9c-41dc-b74d-102517183bea)

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

This project is open source and available under the MIT License.
```
MIT License

Copyright (c) [2025] [Alan Geronimo S.]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

```
