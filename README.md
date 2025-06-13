<p align="center">
  <img src="https://github.com/user-attachments/assets/13f2e804-48a6-4455-8030-ec6cfd4692dc" width="800" alt="App Banner"/>
</p>

# 🗺️ SakeTour — Explore the Best Sake Shops in Japan🍶

SakeTour is a modern Android app built with Jetpack Compose, MVVM, and Clean Architecture.  
It helps travelers discover and explore top-rated sake shops across Japan, from Kyoto to Tokyo and beyond.

---

## 🧠 Solo Scrum-Style Planning

Even though this was a solo project, I followed a simplified Scrum-inspired workflow to stay organized and focused:

- 📋 Created a **product backlog** in ClickUp with all major features and enhancements
- 🏁 Divided the work into small **sprint-like groups** (e.g., UI setup, navigation, architecture, testing)
- ✅ Used task status columns (To Do → In Progress → Done) to track progress

Here’s an image showing how I structured the project plan and subtasks:

![Project Planning](https://github.com/user-attachments/assets/8e8a0160-ce11-47ac-86c8-c56547f042b2)

You can also view the full board on ClickUp here:  
🔗 [ClickUp Board – SakeTour Project](https://app.clickup.com/90131138852/v/li/901314036231)

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
git clone https://github.com/algeronimo92/SakeTour.git
```

2. Open in Android Studio (Giraffe or higher)

3. Run the app on an emulator or real device

---

## 🧰 Scripts & Commands

- Run unit tests:
```bash
./gradlew testDebugUnitTest
```
![image](https://github.com/user-attachments/assets/d9092a1b-ab32-45dc-b234-8593995ea06a)

- Run ktlint check:
```bash
./gradlew ktlintCheck
```
![image](https://github.com/user-attachments/assets/a601c3f7-4e60-4d36-bfe8-eb228a8e5b5c)

- Run instrumentation tests:
```bash
./gradlew connectedAndroidTest
```
![image](https://github.com/user-attachments/assets/9395862c-9012-48f6-a29f-1111a427b525)

---

## 🚀 Future Improvements (If Maintained Long-Term)

If I were to continue developing and maintaining this project over time, these are the next improvements I would prioritize, organized by category:

---

### 🧩 Feature Enhancements
- 🗺️ **Map-based Navigation**  
  Integrate a real-time map with clustered sake shop pins and user geolocation support.

- 🧾 **Sake Details & Reviews**  
  Add product pages with sake descriptions, user ratings, and historical information.

- 🔍 **Search and Filtering**  
  Allow users to search by region, rating, flavor profile, or shop name.

- 🌐 **Multi-language Support**  
  Implement English and Japanese localization to serve a broader audience.

---

### 🧪 Quality & Testing
- 🧪 **Add more Automated UI Tests**  
  Expand test coverage with end-to-end tests using Jetpack Compose testing APIs.

- 🧱 **Environment Configuration (Fake / QA / Production)**  
  Set up build variants for QA and Production environments with proper API keys and endpoints.

---

### 📊 Observability & Analytics
- 📊 **Event Tracking & Analytics**  
  Add tools like Firebase Analytics or mParticle to monitor feature usage and user behavior.

---

### ♿ Accessibility & UX
- 📱 **Dark Theme**  
  Add dark mode to enhance visual comfort and battery efficiency.

- ♿ **Accessibility Improvements**  
  Improve support for screen readers, contrast ratios, touch targets, and scalable fonts.

---

### ☁️ Architecture & Scalability
- ☁️ **Cloud Backend Integration**  
  Migrate from static data to Firebase or a dynamic backend for real-time updates.

- 🧠 **Offline Mode**  
  Cache data locally to support offline exploration and improve performance.

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
