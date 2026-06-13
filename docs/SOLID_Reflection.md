# SOLID Reflection

# Single Responsibility Principle (SRP)

Each class has one responsibility.

Examples:

* RiderService manages riders.
* DriverService manages drivers.
* RideService manages rides.

# Open Closed Principle (OCP)

The system can be extended by adding new strategies without modifying existing code.

Examples:

* New FareStrategy
* New RideMatchingStrategy

# Liskov Substitution Principle (LSP)

Any implementation of FareStrategy or RideMatchingStrategy can replace another implementation.

# Interface Segregation Principle (ISP)

Small interfaces are used:

* FareStrategy
* RideMatchingStrategy

# Dependency Inversion Principle (DIP)

RideService depends on interfaces instead of concrete classes.
