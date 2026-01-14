# Ignacio Bank - Banking Management System

> A banking account management system developed in Java as part of the RA4 practice.

## Description

**Ignacio Bank** is a console application that simulates basic banking operations. It allows managing multiple bank accounts, performing deposits, withdrawals, transfers, and checking balances in a simple and intuitive way.

## Features

- **Balance inquiry** - Check the balance of any account
- **Deposits** - Add money to existing accounts
- **Withdrawals** - Withdraw money with available balance validation
- **Transfers** - Move money between accounts securely
- **Validations** - Insufficient balance and non-existent account controls
- **Multiple users** - Manage several accounts simultaneously

## Getting Started

### Prerequisites

- Java JDK 8 or higher
- An IDE like NetBeans, IntelliJ IDEA, or Eclipse (optional)

### Installation

1. Clone or download this repository
2. Open the project in your favorite IDE
3. Ensure the package structure is correct: `com.mycompany.cuentabancaria`

### Running

```bash
# Compile
javac com/mycompany/cuentabancaria/*.java

# Run
java com.mycompany.cuentabancaria.Bank
```

Or simply run the `Bank.java` class from your IDE.

## Usage

### Creating Accounts

When starting the program, you'll be asked to create 2 bank accounts:

```
=== BIENVENIDO AL IGNACIO-BANK ===
Introduce el nombre del usuario 1: 
> Juan
Introduce el saldo inicial del usuario 1:
> 1000
```

### Main Menu

Once accounts are created, you'll access the main menu:

```
========== MENU ==========
1. Consultar saldo
2. Ingresar dinero
3. Sacar dinero
4. Realizar transferencia
5. Salir
==========================
INGRESE UNA OPCION: 
```

### Available Operations

#### Balance Inquiry
- Enter the account holder's name
- The system will display the current balance

#### Deposit Money
- Enter the account holder's name
- Specify the amount to deposit
- The balance will be automatically updated

#### Withdraw Money
- Enter the account holder's name
- Specify the amount to withdraw
- The system will verify sufficient balance

#### Make Transfer
- Enter the origin account holder's name
- Enter the destination account holder's name
- Specify the amount to transfer
- Both balances will be updated if there are sufficient funds

## Project Structure

```
cuentabancaria/
│
├── Account.java          # Class representing a bank account
│   ├── Attributes: number, balance, holder
│   ├── Constructor and getters/setters
│   └── Static ArrayList of accounts
│
└── Bank.java            # Main class with bank logic
    ├── main()           # Program entry point
    ├── mostrarMenu()    # Displays menu options
    ├── getBalance()     # Balance inquiry
    ├── depositMoney()   # Deposit money
    ├── withdrawMoney()  # Withdraw money
    ├── makeTransfer()   # Make transfer
    ├── exit()           # Exit program
    └── findAccountHolder() # Find account by holder
```

## Technical Details

### Account Class

```java
public class Account {
    private int number;        // Unique account number
    private double balance;    // Current balance
    private String holder;     // Account holder's name
    
    static ArrayList<Account> accounts;  // List of all accounts
}
```

### Implemented Validations

- Sufficient balance verification before withdrawals
- Sufficient balance verification before transfers
- Positive amount validation
- Existing account verification
- Error handling with clear messages

## Usage Example

```
=== BIENVENIDO AL IGNACIO-BANK ===
Introduce el nombre del usuario 1: 
> María
Introduce el saldo inicial del usuario 1:
> 5000
Cuenta creada exitosamente!

Introduce el nombre del usuario 2: 
> Pedro
Introduce el saldo inicial del usuario 2:
> 3000
Cuenta creada exitosamente!

========== MENU ==========
1. Consultar saldo
2. Ingresar dinero
3. Sacar dinero
4. Realizar transferencia
5. Salir
==========================
INGRESE UNA OPCION: 4

--- REALIZAR TRANSFERENCIA ---
Introduce el nombre del titular origen: 
> María
Introduce el nombre del titular destino: 
> Pedro
Saldo actual de María: 5000.0€
Introduce la cantidad a transferir: 
> 1000
Transferencia realizada correctamente.
Nuevo saldo de María: 4000.0€
Nuevo saldo de Pedro: 4000.0€
```

## Testing

The project includes specifications for 10 unit tests that verify:

1. Creation of 2 accounts via menu
2. Balance inquiry operation displays data
3. Balance inquiry operation handles non-existent holder
4. Deposit operation adds amount to balance
5. Withdraw operation subtracts amount from balance
6. Withdraw operation prevents overdraft
7. Transfer operation updates both balances
8. Transfer operation validates origin account balance
9. Transfer operation validates account holders
10. Exit operation terminates correctly

## Author

**Ignacio Brenas**
- GitHub: [@ignaciobrenas](https://github.com/ignaciobrenas)
- Project: MP0485 - Programming
- Course: DAW1
- Practice: RA4Pr1 - Bank Account Management

## License

This project is part of an educational practice for the Programming module.

---

**Found a bug?** Open an issue and we'll resolve it together.

**Want to contribute?** Pull requests are welcome!
