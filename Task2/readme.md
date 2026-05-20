# Weather Application using Java REST API

A Java console application that consumes a public REST API to fetch live weather data and display it in a structured format.

This project demonstrates how to:

- Consume a REST API using Java
- Send HTTP GET requests
- Handle API responses
- Parse JSON manually without external libraries
- Process real-time weather information
- Display structured data in the console

---

## Project Overview

This application fetches live weather information from the Open-Meteo API using geographic coordinates and displays:

- Temperature
- Wind Speed
- Wind Direction
- Weather Code
- Time of report

The project uses Java's built-in `HttpClient` and custom JSON parsing methods instead of third-party libraries.

---

## API Used

Open-Meteo provides free weather APIs without requiring an API key.

API Endpoint:

https://api.open-meteo.com

Sample Request:

```url
https://api.open-meteo.com/v1/forecast?latitude=22.3072&longitude=73.1812&current_weather=true
```

Current implementation uses coordinates of:

Location: Vadodara, Gujarat, India

Latitude: 22.3072  
Longitude: 73.1812

---

## Technologies Used

- Java
- REST API
- Java HttpClient
- JSON Processing
- Exception Handling
- Console-based UI

---

## Project Structure

```text
Task2/
│
└── WeatherApp.java
```

---

## Features

### Fetches real-time weather data

Gets current weather information directly from an online API.

### Uses Java HttpClient

Uses Java's modern built-in HTTP request system.

### Manual JSON Parsing

Instead of using libraries like Gson or Jackson, this project implements custom methods:

- `extractJsonObject()`
- `extractJsonValue()`

for extracting data from JSON responses.

### Structured Output

Displays weather information in a clean report format.

---

## Working Flow

Step 1:
Send an HTTP GET request to Open-Meteo API

↓

Step 2:
Receive JSON response

↓

Step 3:
Extract current weather object

↓

Step 4:
Extract required fields manually

↓

Step 5:
Display formatted weather report

---

## Important Methods

### extractJsonObject()

Extracts a complete nested JSON object from API response.

Example:

```java
String weatherJson =
extractJsonObject(jsonResponse,"current_weather");
```

Purpose:

Finds and returns the complete current_weather JSON object.

---

### extractJsonValue()

Extracts values associated with a specific JSON key.

Example:

```java
extractJsonValue(weatherJson,"temperature");
```

Purpose:

Returns values like:

- temperature
- windspeed
- weathercode
- time

---

## Sample Console Output

```text
========== WEATHER REPORT ==========

Location: Vadodara

Temperature: 31.8 °C

Wind Speed: 11.4 km/h

Wind Direction: 240°

Weather Code: 3

Time: 2026-05-20T12:00

====================================
```

---

## How to Run

### Step 1: Compile

```bash
javac Task2/WeatherApp.java
```

### Step 2: Run

```bash
java Task2.WeatherApp
```

---

## Requirements

- Java JDK 11 or above
- Internet connection

No external dependencies required.

---

## Concepts Demonstrated

This project demonstrates:

- REST API Consumption
- HTTP GET Requests
- JSON Response Handling
- String Processing
- Manual JSON Parsing
- Exception Handling
- Object-Oriented Programming
- Real-time Data Processing

---

## Future Improvements

Possible enhancements:

- Add city input from user
- Add weather descriptions
- Create graphical user interface using Java Swing
- Display weather icons
- Add forecast for upcoming days
- Use Gson/Jackson for advanced JSON parsing
- Add search history

---

## Learning Outcome

Through this project, the following concepts are practiced:

✔ API Integration  
✔ Java Networking  
✔ JSON Processing  
✔ Error Handling  
✔ Console Application Development

---

## Author

Jay Bhoi

Graphic Designer | Developer

---