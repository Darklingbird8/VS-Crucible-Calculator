# VS Crucible Calculator

A simple Java CLI tool for calculating crucible recipes seen in the Vintage Story game, required base metal amounts for alloys, and which fuels can reach the needed temperature.

## Features

- Separate menus for `Base Metals` and `Alloys`
- Supports castable, implemented metals from Vintage Story
- Alloy output breakdown into required base-metal amounts
- Fuel filtering based on required melting temperature
- Alloy melting requirement uses the highest melting point among its base metal inputs

## Included Metals

### Base Metals

- Copper
- Gold
- Silver
- Bismuth
- Lead
- Tin
- Zinc
- Nickel

### Alloys

- Tin Bronze
- Bismuth Bronze
- Black Bronze
- Brass
- Lead Solder
- Molybdochalkos
- Silver Solder
- Electrum
- Cupronickel

## Project Structure

- `src/Calculator.java` - main program and menu flow
- `src/Metal.java` - metal model (name, melting point, alloy flag)
- `src/Recipe.java` - recipe model (inputs and output metal)
- `src/RecipeInput.java` - alloy input definition (metal + percent)
- `src/Fuel.java` - fuel model with max temperature
- `src/Item.java` - shared base item model

## Requirements

- Java JDK 8+ (JDK 17+ recommended)

## Build and Run

Recommended: use VS Code's built-in Run features.

1. Open the project folder in VS Code.
2. Open `src/Calculator.java`.
3. Click the `Run` button (or use `Run` -> `Run Without Debugging`).
4. Interact with the program in the VS Code terminal panel.

## How to Use

1. Start the app.
2. Choose a category:
   - `1` Base Metals
   - `2` Alloys
3. Choose a recipe from that category.
4. Enter desired output amount (units).
5. Review:
   - Required base metals (for alloys)
   - Required melting point
   - Fuels that can melt the recipe

## Notes

- This is a console utility focused on crucible calculations.
- Uncastable metals (such as Iron/Steel progression metals) are intentionally excluded from recipe options.
