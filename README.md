# Akbar's Delicious Sandwiches
### During this capstone, we aimed to create a point-of-sale application for a sandwich shop to help it transition from paper documentation to an automated order process.

## Table of Contents
- [Requirements](#requirements)
- [Usage](#usage)
- [How it Works](#how-it-works)
- [Features](#features)
- [Screenshots](#screenshots)

## Requirements
- Git
- Java 17 or Higher
- IntelliJ IDEA

## Usage
1. Clone the repo:
``` 
    git clone https://github.com/Saidakramov/AkbarsDeliciousSandwiches.git
    cd AkbarsDeliciousSandwiches
```
2. Launch Project in IntelliJ IDEA:
   - Click Open and select project directory.
3. Run the Application 
    - Open `UserInterface.java` file inside `src/main/java/com/pluralsight` directory.
    - Right-click on the `UserInterface` class and select `Run UserInterface.main()`
4. Interact with the CLI:
   - Follow the instructions displayed in the terminal.

## How It Works
- `Home Screen` gives the user following options: 
  - (1) - New Order: if the user enter `1` a program will direct them to the `Order Screen`. 
  - (0) - Exit : `0` will exit the applications.
- `Order Screen` gives the user following options:
  - (1) - Add Sandwich :  the add sandwich screen will walk the user through
    several options to create the sandwich.
  - (2) - Add Drink :  drink screen will prompt the user to select drink size and flavor.
  - (3) - Add Chips : will ask if user wants to add chips and flavor.
  - (4) - Checkout : displays order details and the price.
  - (0) - Cancel Order : deletes the order and goes back to the `Home Screen`.
## Features
- The `Add Sandwich` option will ask users the following questions: Most questions provide a list of items from a `Menu` class and saves user input and build a sandwich. 
    - Select your bread: 
    - Select the sandwich size: 
    - Select premium toppings from meats list : 
    - Select premium toppings from cheese list : 
    - Select regular toppings from regular (included and free) toppings list: 
    - Select sauces from sauces list: 
    - Select sides from sides list:
    - Would you like it toasted ?:
    - Would you like extra meat ?:
    - Would you like extra cheese ?:
    - Would you like to add another sandwich to your order?: 
- The `Add Drink` option provides drink sizes and prices and prompts user for input. After input, it provides a list of flavors from the `Menu` class.
- The `Add Chips` option asks if a user wants to add chips to their order. If so, it provides a list of flavors and saves the user's input.
- The `Checkout` option displays the order details and itemized total cost and asks users to:
  - (1) - Confirm : `1` confirms the order and saves the receipt in the `receipts` folder with current date and time as a filename, and goes back to `Home Screen`.
  - (2) - Cancel : `2` cancels the order and goes back to `Home Screen`.
## Screenshots