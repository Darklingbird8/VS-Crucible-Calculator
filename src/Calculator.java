import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Calculator {
    public static void main(String[] args) {
        List<Metal> metals = new ArrayList<>();
        metals.add(new Metal("Copper", 0, 0, 1084, false));
        metals.add(new Metal("Tin", 0, 0, 232, false));
        metals.add(new Metal("Zinc", 0, 0, 419, false));
        metals.add(new Metal("Tin Bronze", 0, 0, 950, true));
        metals.add(new Metal("Brass", 0, 0, 920, true));

        List<Recipe> recipes = new ArrayList<>();
        recipes.add(new Recipe("Copper", new ArrayList<>(), metals.get(0)));
        recipes.add(new Recipe("Tin", new ArrayList<>(), metals.get(1)));
        recipes.add(new Recipe("Zinc", new ArrayList<>(), metals.get(2)));
        List<RecipeInput> tinBronzeInputs = new ArrayList<>();
        tinBronzeInputs.add(new RecipeInput(metals.get(0), 90));
        tinBronzeInputs.add(new RecipeInput(metals.get(1), 10));
        recipes.add(new Recipe("Tin Bronze", tinBronzeInputs, metals.get(3)));

        List<RecipeInput> brassInputs = new ArrayList<>();
        brassInputs.add(new RecipeInput(metals.get(0), 60));
        brassInputs.add(new RecipeInput(metals.get(2), 40));
        recipes.add(new Recipe("Brass", brassInputs, metals.get(4)));
      
        List<Fuel> fuels = new ArrayList<>();
        fuels.add(new Fuel("Firewood", 0, 0, 700));
        fuels.add(new Fuel("Peat", 0, 0, 900));
        fuels.add(new Fuel("Brown Coal", 0, 0, 1100));
        fuels.add(new Fuel("Black Coal", 0, 0, 1200));
        fuels.add(new Fuel("Anthracite", 0, 0, 1200));
        fuels.add(new Fuel("Charcoal", 0, 0, 1300));
        fuels.add(new Fuel("Coke", 0, 0, 1340));
        
        int choice = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Vintage Story Crucible Calculator!");

        while (true) {
            System.out.println("\nPlease select the recipe you want to use:");
            System.out.println(" - Base Metals -");
            System.out.println("1. Copper");
            System.out.println("2. Tin");
            System.out.println("3. Zinc");
            System.out.println(" - Alloys -");
            System.out.println("4. Tin Bronze");
            System.out.println("5. Brass");
            System.out.println("0. Exit");

            System.out.print("\nEnter your choice (0-5): ");
            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                scanner.next();
                continue;
            }

            choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Thanks for using the calculator!");
                break;
            }

            if (choice < 1 || choice > recipes.size()) {
                System.out.println("Invalid choice. Please select a number from 0 to 5.");
                continue;
            }

            Recipe selectedRecipe = recipes.get(choice - 1);
            Metal selectedMetal = selectedRecipe.getOutput();

            System.out.print("How much output do you desire (units)? ");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a whole number.");
                scanner.next();
                System.out.print("How much output do you desire (units)? ");
            }

            int desiredOutput = scanner.nextInt();

            System.out.println("\nRecipe selected: " + selectedRecipe.getName());
            System.out.println("Desired output: " + desiredOutput + " units");

            if (selectedMetal.isAlloy()) {
                System.out.println("Required base metals:");
                for (RecipeInput input : selectedRecipe.getInputs()) {
                    int requiredAmount = (desiredOutput * input.getAmount()) / 100;
                    System.out.println(
                        " - " + input.getMetal().getName() + ": " + requiredAmount + " units"
                    );
                }
            }

            System.out.println("Required melting point: " + selectedMetal.getMeltingPoint() + "C");
            System.out.println("Fuels that can melt this recipe:");

            boolean fuelFound = false;
            for (Fuel fuel : fuels) {
                if (fuel.getFuelValue() >= selectedMetal.getMeltingPoint()) {
                    System.out.println(
                        " - " + fuel.getName() + " (max temp: " + fuel.getFuelValue() + "C)"
                    );
                    fuelFound = true;
                }
            }

            if (!fuelFound) {
                System.out.println(" - No available fuel can reach this melting point.");
            }

            scanner.nextLine();
            System.out.print("\nPress Enter to continue...");
            scanner.nextLine();
        }

        scanner.close();
    }
}