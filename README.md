# Hospital_Management
 This is a Hospital Management app developed using Java for Android. The app features various functions to manage patient information, appointments, and medical records efficiently. It integrates with a SQL-based backend to securely store and retrieve data, ensuring smooth hospital operations and enhancing user experience with real-time data processing.

## Table of Contents
- [Features](#features)
- [Technologies Used](#technologies-used)
- [App Functionality](#app-functionality)
  - [Home Activity](#home-activity)
  - [Login Activity](#login-activity)
  - [Doctor Find Activity](#doctor-find-activity)
  - [Lab Test Activity](#lab-test-activity)
  - [Lab Test Book Activity](#lab-test-book-activity)
  - [Order Details Activity](#order-details-activity)
  - [Cart Lab Activity](#cart-lab-activity)
- [Database Structure](#database-structure)
- [Setup Instructions](#setup-instructions)
- [Contributing](#contributing)
- [License](#license)

## Features
- **Login & Logout**: Secure login system with user authentication.
- **Doctor Finder**: Search and book consultations with doctors.
- **Lab Test Booking**: Schedule lab tests with a seamless booking system.
- **Order Details**: View and manage the details of booked appointments and tests.
- **Cart Management**: Add, remove, and view lab tests before confirming the booking.
- **Data Storage**: All data is stored and managed securely using an SQL-based backend.
- **Real-time Updates**: Immediate updates for booked services and available options.

## Technologies Used
- **Android SDK** (Java)
- **SQL** (for backend storage)
- **Shared Preferences** (for user sessions)
- **Toast** (for notifications)
- **CardView & ListView** (for UI layout)
- **Shared Preferences** (for storing user credentials and settings)

## App Functionality

### Home Activity
The **HomeActivity** serves as the main dashboard of the app. After successful login, the user is welcomed by their username, and various options are provided:
- **Logout Button**: Allows users to log out and clear session data.
- **Doctor Find Card**: Redirects the user to the **FindDoctorActivity** where they can search for available doctors.
- **Lab Test Card**: Opens the **LabTestActivity** to explore available lab tests.
- **Order Details Card**: Leads to the **CartLabActivity** where users can view and manage their orders.
- **Book Doctor Card**: Takes the user to **LabTestBookActivity** to book lab tests.

### Login Activity
The **LoginActivity** allows users to log into their account by entering their username and password. After successful login, the app redirects to the **HomeActivity**, where users can access all features.

### Doctor Find Activity
In the **FindDoctorActivity**, users can search for doctors by specialization. The app provides a list of doctors with details like name, specialization, and availability. Users can directly book an appointment with the doctor.

### Lab Test Activity
The **LabTestActivity** displays available lab tests that users can choose from. It provides information about each test and allows users to add their selected tests to the cart.

### Lab Test Book Activity
The **LabTestBookActivity** is where users enter personal details such as name, address, contact number, and pincode to confirm the booking of a lab test. The app calculates the total amount for the booking, and upon confirmation, it removes the items from the cart and confirms the booking.

### Order Details Activity
The **OrderDetailsActivity** fetches and displays the order details for the logged-in user. It includes:
- Name
- Address
- Contact Number
- Pincode
- Price
This page uses a **SimpleAdapter** to present the order data in a user-friendly format.

### Cart Lab Activity
The **CartLabActivity** allows users to review all the items they have added to their cart (lab tests). They can proceed to book the tests or remove items if necessary.

## Database Structure

The app uses an SQL-based database for storing all the data related to users, orders, lab tests, and doctors. The structure includes tables such as:
- **Users**: Stores user credentials and session information.
- **Orders**: Stores the details of orders placed by users.
- **Doctors**: Contains doctor information for search and consultation.
- **LabTests**: Stores lab test information and user bookings.

### Sample Data Structure

![Screenshot 2025-01-07 181348](https://github.com/user-attachments/assets/4fc87424-425e-4ea8-af03-0d7661e026bd)




## Setup Instructions
To run this app locally:
1. Clone the repository:
   ```bash
   git clone https://github.com/Densingh/hospital-management-app.git
