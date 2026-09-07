# Economic Market Simulator (`econ-market-sim`)

A Java application for modeling supply and demand curves, calculating market imbalances (surpluses and shortages), and dynamically searching for market equilibrium prices.

---

## Features

- **Demand Modeling**: Calculates Quantity Demanded ($Q_d$) based on intercept and slope functions ($Q_d = a - bP$).
- **Supply Modeling**: Calculates Quantity Supplied ($Q_s$) based on intercept and slope functions ($Q_s = c + dP$).
- **Market Dynamics**: Evaluates current market state (Equilibrium, Shortage, or Surplus) based on current prices.
- **Equilibrium Finder**: Algorithmic equilibrium solver to compute the market equilibrium price, quantity demanded, and quantity supplied within a specified tolerance threshold.

---

## Project Structure

```text
econ-market-sim/
├── pom.xml
└── src/
    └── main/
        └── java/
            └── com/
                └── example/
                    ├── Main.java               # Main entry point and simulation runner
                    ├── Market.java             # Core market logic and equilibrium algorithm
                    ├── Demand.java             # Demand curve representation
                    ├── Supply.java             # Supply curve representation
                    └── EquilibriumResult.java  # DTO for equilibrium output data
```

---

## Getting Started

### Prerequisites

- **Java JDK 21** or higher
- **Apache Maven 3.x**

### Building the Project

Compile the project using Maven:

```bash
mvn clean compile
```

### Running the Application

Execute the `Main` class:

```bash
mvn exec:java -Dexec.mainClass="com.example.Main"
```

Or manually with `javac` and `java`:

```bash
javac -d target/classes src/main/java/com/example/*.java
java -cp target/classes com.example.Main
```

---

## Example Usage

```java
// Define Demand: Qd = 108.4 - 0.4 * P
Demand employerDemand = new Demand(108.4, 0.4);

// Define Supply: Qs = 83 + 0.2 * P
Supply candidateSupply = new Supply(83, 0.2);

// Initialize Market at Price 85
Market market = new Market("US Entry-Level Software Developers", 85, employerDemand, candidateSupply);

System.out.println("Market Status: " + market.getStatus());

// Calculate Market Equilibrium
EquilibriumResult result = market.findEquilibrium();
if (result != null) {
    System.out.printf("Equilibrium Price: $%.2f%n", result.getEquilibriumPrice());
    System.out.printf("Quantity Demanded: %.2f%n", result.getEquilibriumQD());
    System.out.printf("Quantity Supplied: %.2f%n", result.getEquilibriumQS());
}
```

---

## License

This project is licensed under the MIT License.
