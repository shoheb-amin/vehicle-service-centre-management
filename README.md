# Vehicle Service Centre Management System

A console-based Java application developed using JDBC and MySQL for managing vehicle service centre operations such as customer records, vehicle details, service bookings, billing, and service history.

## Features

- Add and manage customer details
- Register vehicle information
- Book vehicle services
- View service history
- Generate bills and invoices
- Update and delete records
- Database connectivity using JDBC
- Console/Terminal-based user interface

## Tech Stack

- Java
- JDBC
- MySQL
- IntelliJ IDEA

## Project Structure

```bash
src/
 ├── ServiceCentre/
 ├── model/
 ├── dao/
 ├── service/
 ├── utility/
 └── Main.java
```

## Database Setup

1. Create a MySQL database.
2. Import the SQL file (if available).
3. Update database credentials in the project.

Example:

```java
String url = "jdbc:mysql://localhost:3306/servicecentre";
String username = "root";
String password = "your_password";
```

## How to Run

1. Clone the repository

```bash
git clone https://github.com/yourusername/vehicle-service-centre-management.git
```

2. Open the project in IntelliJ IDEA

3. Configure MySQL database connection

4. Run the `Main.java` file

## Git Commands Used

```bash
git init
git add .
git commit -m "Initial commit"
git branch -M main
git remote add origin https://github.com/yourusername/vehicle-service-centre-management.git
git push -u origin main
```

## Future Improvements

- GUI Integration
- Online Booking System
- Admin Dashboard
- Email Notifications
- Service Status Tracking

## Author

Shoheb Amin
```
