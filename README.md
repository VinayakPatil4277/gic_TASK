# Customer Registration and Login App

This Android application allows users to register, log in, and manage their accounts securely using Firebase Firestore and OTP authentication.

## 🚀 Features

- **User Registration** with mandatory fields:
  - Customer Name
  - Contact Number (with Firebase OTP verification)
  - Email ID
  - Address
  - City & Pin Code (Validation against provided data)
  - Password
- **Login Functionality:**
  - Direct login if the mobile number is already registered
  - Password-based authentication
- **Firestore Database Integration** for secure data storage
- **OTP Verification** using Firebase Authentication

## 🛠️ Tech Stack

- **Java** - Programming Language
- **Android SDK** - Development Framework
- **Firebase Firestore** - Cloud Database
- **Firebase Authentication** - OTP Verification
- **XML** - UI Layout Design

## 📦 Project Structure

```
├── app
│   ├── src
│   │   ├── main
│   │   │   ├── java/com/orn/gic_task
│   │   │   │   ├── LoginActivity.java
│   │   │   │   ├── RegisterActivity.java
│   │   │   │   └── DashboardActivity.java
│   │   │   └── res/layout
│   │   │       ├── activity_login.xml
│   │   │       └── activity_register.xml
└── build.gradle
```

## 📥 Installation & Setup

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/your-username/customer-registration-app.git
   cd customer-registration-app
   ```

2. **Open in Android Studio:**

   - File > Open > Select the project folder

3. **Connect Firebase:**

   - Tools > Firebase > Authentication > Phone Authentication > Connect to Firebase

4. **Build & Run the App:**

   - Click on the **Run** button or press `Shift + F10`.

## 🔑 Firebase Setup

1. Go to [Firebase Console](https://console.firebase.google.com/).
2. Create a new project and enable **Firestore Database**.
3. Enable **Phone Authentication** under the **Authentication** section.
4. Download the `google-services.json` file and place it in the `app/` directory.

## 💡 Usage

- **Register:** Fill in all the required fields, verify your phone number with OTP, and register.
- **Login:** Enter your registered contact number and password to log in.
- **Direct Login:** If the contact number is already registered, you'll be redirected to the Dashboard automatically.

## ⚠️ Validation Rules

- All fields are mandatory.
- City & Pin Code must match the provided data.
- Contact number verification via Firebase OTP is required.
- Duplicate numbers trigger direct login.

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature-branch`)
3. Commit your changes (`git commit -m 'Add new feature'`)
4. Push to the branch (`git push origin feature-branch`)
5. Open a Pull Request

## 📄 License

This project is licensed under the [MIT License](LICENSE).

---

**Developed by Vinayak Patil** 🚀

![GIC1](https://github.com/user-attachments/assets/b754465f-6454-4147-9d46-ea74b98bcd11)

![GIC2](https://github.com/user-attachments/assets/cc1f7f4f-dd1e-486c-b50e-c127ebd24355)

![GIC3](https://github.com/user-attachments/assets/7fddf447-4bc9-49ae-b1b9-571e09f0fcbe)



