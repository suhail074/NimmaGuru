# NimmaGuru

NimmaGuru is an Android application developed using Kotlin and Jetpack Compose.  
The application is designed to connect students with mentors and provide an easy platform for mentorship, profile management, and learning support.

---

# 📌 Overview

The app provides:

- Mentor and student interaction
- Mentor profile management
- Student profile management
- Session and mentorship support
- Clean and modern UI
- Responsive navigation
- User-friendly experience

The project focuses on creating a simple mentorship platform for students and mentors using modern Android development technologies.

---

# ✨ Features

## 🏠 Home Screen
- Clean and modern dashboard
- Easy navigation
- Quick access cards

## 👨‍🏫 Mentor Module
- Mentor profiles
- Mentor information
- Session details

## 👨‍🎓 Student Module
- Student profile management
- Personalized experience

## 🔍 Search Functionality
- Search mentors easily
- Quick filtering support

## 📅 Calendar Support
- Session scheduling interface
- Organized session management

## 🎨 Responsive UI
- Built using Jetpack Compose
- Material Design support
- Smooth navigation experience

---

# 🛠️ Tech Stack

| Technology | Usage |
|------------|-------|
| Kotlin | Main Programming Language |
| Jetpack Compose | UI Development |
| Android Studio | IDE |
| Material Design | UI Components |
| Firebase | Backend Services |
| Navigation Component | Screen Navigation |

---

# 📂 Project Structure

```text
NimmaGuru/
│
├── app/
│   │
│   ├── src/
│   │   │
│   │   ├── androidTest/
│   │   │   └── java/
│   │   │       └── com/example/nimmaguru/
│   │   │           └── ExampleInstrumentedTest.kt
│   │   │
│   │   ├── test/
│   │   │   └── java/
│   │   │       └── com/example/nimmaguru/
│   │   │           └── ExampleUnitTest.kt
│   │   │
│   │   └── main/
│   │       │
│   │       ├── AndroidManifest.xml
│   │       ├── ic_launcher-playstore.png
│   │       │
│   │       ├── java/
│   │       │   └── com/example/nimmaguru/
│   │       │
│   │       │       ├── Data/
│   │       │       │   └── MentorData.kt
│   │       │       │
│   │       │       ├── model/
│   │       │       │   ├── Mentor.kt
│   │       │       │   ├── Session.kt
│   │       │       │   └── UserProfile.kt
│   │       │       │
│   │       │       ├── repository/
│   │       │       │   ├── MentorRepository.kt
│   │       │       │   └── ProfileRepository.kt
│   │       │       │
│   │       │       ├── ui/
│   │       │       │
│   │       │       │   ├── components/
│   │       │       │   │   ├── FeedCard.kt
│   │       │       │   │   └── WallofFrameCard.kt
│   │       │       │   │
│   │       │       │   ├── screens/
│   │       │       │   │   ├── CalendarScreen.kt
│   │       │       │   │   ├── HomeScreen.kt
│   │       │       │   │   ├── MentorProfileScreen.kt
│   │       │       │   │   ├── ProfileScreen.kt
│   │       │       │   │   ├── RoleSelectionScreen.kt
│   │       │       │   │   ├── SearchScreen.kt
│   │       │       │   │   └── StudentProfileScreen.kt
│   │       │       │   │
│   │       │       │   └── theme/
│   │       │       │       ├── Color.kt
│   │       │       │       ├── LanguageManager.kt
│   │       │       │       ├── ProfileStorage.kt
│   │       │       │       ├── Strings.kt
│   │       │       │       ├── Theme.kt
│   │       │       │       └── Type.kt
│   │       │       │
│   │       │       ├── BottomNavigationBar.kt
│   │       │       ├── MainActivity.kt
│   │       │       ├── MentorActivity.kt
│   │       │       └── StudentActivity.kt
│   │       │
│   │       └── res/
│   │           │
│   │           ├── drawable/
│   │           │   ├── ic_launcher_background.xml
│   │           │   └── ic_launcher_foreground.xml
│   │           │
│   │           ├── layout/
│   │           │   ├── activity_mentor.xml
│   │           │   └── activity_student.xml
│   │           │
│   │           ├── mipmap-anydpi-v26/
│   │           │   ├── ic_launcher.xml
│   │           │   └── ic_launcher_round.xml
│   │           │
│   │           ├── mipmap-hdpi/
│   │           │   ├── ic_launcher.webp
│   │           │   ├── ic_launcher_foreground.webp
│   │           │   └── ic_launcher_round.webp
│   │           │
│   │           ├── mipmap-mdpi/
│   │           │   ├── ic_launcher.webp
│   │           │   ├── ic_launcher_foreground.webp
│   │           │   └── ic_launcher_round.webp
│   │           │
│   │           ├── mipmap-xhdpi/
│   │           │   ├── ic_launcher.webp
│   │           │   ├── ic_launcher_foreground.webp
│   │           │   └── ic_launcher_round.webp
│   │           │
│   │           ├── mipmap-xxhdpi/
│   │           │   ├── ic_launcher.webp
│   │           │   ├── ic_launcher_foreground.webp
│   │           │   └── ic_launcher_round.webp
│   │           │
│   │           ├── mipmap-xxxhdpi/
│   │           │   ├── ic_launcher.webp
│   │           │   ├── ic_launcher_foreground.webp
│   │           │   └── ic_launcher_round.webp
│   │           │
│   │           ├── values/
│   │           │   ├── colors.xml
│   │           │   ├── ic_launcher_background.xml
│   │           │   ├── strings.xml
│   │           │   └── themes.xml
│   │           │
│   │           └── xml/
│   │               ├── backup_rules.xml
│   │               └── data_extraction_rules.xml
│   │
│   ├── build.gradle.kts
│   ├── google-services.json
│   └── proguard-rules.pro
│
├── gradle/
│   └── wrapper/
│
├── .gitignore
├── build.gradle.kts
├── gradle.properties
├── gradlew
├── gradlew.bat
├── settings.gradle.kts
└── README.md
```
# 📸 Screenshots

## 🏠 Home Screen
- Browse mentors and educational guidance
- Quick access to student and mentor sections
- Modern Jetpack Compose UI

<p align="center">
  <img src="screenshots/home_screen.png" width="250"/>
</p>

---

## 👨‍🏫 Mentor Profile Screen
- View mentor information
- Session details and expertise
- Mentor profile management

<p align="center">
  <img src="screenshots/mentor_profile.png" width="250"/>
</p>

---

## 🎓 Student Profile Screen
- Student profile management
- Learning preferences and details
- Personalized experience

<p align="center">
  <img src="screenshots/student_profile.png" width="250"/>
</p>

---

## 🔍 Search Screen
- Search mentors easily
- Browse available mentors
- Quick filtering and navigation

<p align="center">
  <img src="screenshots/search_screen.png" width="250"/>
</p>

---

## 📅 Calendar Screen
- Track mentoring sessions
- Schedule and manage meetings
- Organized learning activities

<p align="center">
  <img src="screenshots/calendar_screen.png" width="250"/>
</p>

---

## 🌐 Multi Language Support
- Kannada language support
- User-friendly interface
- Easy accessibility for regional users

<p align="center">
  <img src="screenshots/language_support.png" width="250"/>
</p>

---

# 🚀 Installation

## Clone Repository

```bash
git clone https://github.com/suhail074/NimmaGuru.git
```

---

## Open in Android Studio

1. Open Android Studio  
2. Select **"Open Project"**  
3. Choose the project folder  
4. Sync Gradle  
5. Run the application  

---

# 📱 Minimum Requirements

- Android 7.0+
- SDK 24+
- Android Studio Hedgehog or above
- Internet Connection (optional for future updates)

---

# 🎯 Objective

The objective of NimmaGuru is to:

- Connect students with experienced mentors
- Provide career and educational guidance
- Improve mentor-student interaction
- Simplify session management
- Create an easy-to-use learning platform

---

# 🔮 Future Enhancements

- Firebase Integration
- Real-time Chat System
- User Authentication
- Online Session Booking
- AI Chat Assistant
- Push Notifications
- Video Calling Feature
- Offline Support

---

# 👨‍💻 Developed By

**Syed Sohail Mehdi**

---

# 📜 License

This project is created for educational and internship purposes.

---

# ⭐ Support

If you like this project, give it a ⭐ on GitHub.

---

# 📖 Inspiration

> “Technology can bridge the gap between students and opportunities.”

If you like this project, give it a ⭐ on GitHub.

---

# 📖 Inspiration

> “Technology should not only serve cities, but also empower villages.”
