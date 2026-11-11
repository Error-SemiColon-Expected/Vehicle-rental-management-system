# Vehicle Rental Management System

A console-based Java application for a vehicle rental company, built as
Case Study 4 for ITC C209 – Object-Oriented Programming.

## Features
- View registered vehicles by type (Car, Van, Motorcycle, Luxury Car)
- Rent an available vehicle with a cost breakdown
- Return a rented vehicle
- Input validation and error handling for invalid operations

## Rental cost formulas
| Vehicle | Formula |
|---|---|
| Car | R × D |
| Motorcycle | R × D |
| Van | (R × D) + (R × D × 0.10) |
| Luxury Car | (R × D) + (R × D × 0.15) |

R = daily rate, D = number of rental days

## OOP concepts demonstrated
- **Abstraction:** `Vehicle` is an abstract parent class
- **Encapsulation:** private fields with validated getters and setters
- **Inheritance:** `Car`, `Van`, `Motorcycle` extend `Vehicle`; `LuxuryCar` extends `Car`
- **Polymorphism:** an `ArrayList<Vehicle>` holds all vehicle types, and overridden
  `calculateRentalCost()` and `displayVehicleDetails()` run at runtime

## How to run
```bash
javac *.java
java Main
```

## Project structure
- `Vehicle.java` – abstract parent class
- `Car.java`, `Van.java`, `Motorcycle.java` – vehicle subclasses
- `LuxuryCar.java` – subclass of `Car` with a 15% premium
- `Main.java` – menu and program flow
