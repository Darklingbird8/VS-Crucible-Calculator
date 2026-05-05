package src;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Calculator {
    public static void main(String[] args) {
        List<Metal> metals = new ArrayList<>();
        metals.add(new Metal("Copper", 0, 0, 1084, false));
        metals.add(new Metal("Gold", 0, 0, 1063, false));
        metals.add(new Metal("Silver", 0, 0, 961, false));
        metals.add(new Metal("Bismuth", 0, 0, 271, false));
        metals.add(new Metal("Lead", 0, 0, 327, false));
        metals.add(new Metal("Tin", 0, 0, 232, false));
        metals.add(new Metal("Zinc", 0, 0, 419, false));
        metals.add(new Metal("Nickel", 0, 0, 1325, false));
        metals.add(new Metal("Tin Bronze", 0, 0, 950, true));
        metals.add(new Metal("Bismuth Bronze", 0, 0, 850, true));
        metals.add(new Metal("Black Bronze", 0, 0, 1020, true));
        metals.add(new Metal("Brass", 0, 0, 920, true));
        metals.add(new Metal("Lead Solder", 0, 0, 327, true));
        metals.add(new Metal("Molybdochalkos", 0, 0, 902, true));
        metals.add(new Metal("Silver Solder", 0, 0, 758, true));
        metals.add(new Metal("Electrum", 0, 0, 1010, true));
        metals.add(new Metal("Cupronickel", 0, 0, 1171, true));

        List<Recipe> recipes = new ArrayList<>();
        recipes.add(new Recipe("Copper", new ArrayList<>(), metals.get(0)));
        recipes.add(new Recipe("Gold", new ArrayList<>(), metals.get(1)));
        recipes.add(new Recipe("Silver", new ArrayList<>(), metals.get(2)));
        recipes.add(new Recipe("Bismuth", new ArrayList<>(), metals.get(3)));
        recipes.add(new Recipe("Lead", new ArrayList<>(), metals.get(4)));
        recipes.add(new Recipe("Tin", new ArrayList<>(), metals.get(5)));
        recipes.add(new Recipe("Zinc", new ArrayList<>(), metals.get(6)));
        recipes.add(new Recipe("Nickel", new ArrayList<>(), metals.get(7)));

        List<RecipeInput> tinBronzeInputs = new ArrayList<>();
        tinBronzeInputs.add(new RecipeInput(metals.get(0), 90));
        tinBronzeInputs.add(new RecipeInput(metals.get(5), 10));
        recipes.add(new Recipe("Tin Bronze", tinBronzeInputs, metals.get(8)));

        List<RecipeInput> bismuthBronzeInputs = new ArrayList<>();
        bismuthBronzeInputs.add(new RecipeInput(metals.get(3), 20));
        bismuthBronzeInputs.add(new RecipeInput(metals.get(0), 50));
        bismuthBronzeInputs.add(new RecipeInput(metals.get(6), 30));
        recipes.add(new Recipe("Bismuth Bronze", bismuthBronzeInputs, metals.get(9)));

        List<RecipeInput> blackBronzeInputs = new ArrayList<>();
        blackBronzeInputs.add(new RecipeInput(metals.get(0), 76));
        blackBronzeInputs.add(new RecipeInput(metals.get(1), 12));
        blackBronzeInputs.add(new RecipeInput(metals.get(2), 12));
        recipes.add(new Recipe("Black Bronze", blackBronzeInputs, metals.get(10)));

        List<RecipeInput> brassInputs = new ArrayList<>();
        brassInputs.add(new RecipeInput(metals.get(0), 60));
        brassInputs.add(new RecipeInput(metals.get(6), 40));
        recipes.add(new Recipe("Brass", brassInputs, metals.get(11)));

        List<RecipeInput> leadSolderInputs = new ArrayList<>();
        leadSolderInputs.add(new RecipeInput(metals.get(4), 50));
        leadSolderInputs.add(new RecipeInput(metals.get(5), 50));
        recipes.add(new Recipe("Lead Solder", leadSolderInputs, metals.get(12)));

        List<RecipeInput> molybdochalkosInputs = new ArrayList<>();
        molybdochalkosInputs.add(new RecipeInput(metals.get(0), 10));
        molybdochalkosInputs.add(new RecipeInput(metals.get(4), 90));
        recipes.add(new Recipe("Molybdochalkos", molybdochalkosInputs, metals.get(13)));

        List<RecipeInput> silverSolderInputs = new ArrayList<>();
        silverSolderInputs.add(new RecipeInput(metals.get(2), 45));
        silverSolderInputs.add(new RecipeInput(metals.get(5), 55));
        recipes.add(new Recipe("Silver Solder", silverSolderInputs, metals.get(14)));

        List<RecipeInput> electrumInputs = new ArrayList<>();
        electrumInputs.add(new RecipeInput(metals.get(1), 50));
        electrumInputs.add(new RecipeInput(metals.get(2), 50));
        recipes.add(new Recipe("Electrum", electrumInputs, metals.get(15)));

        List<RecipeInput> cupronickelInputs = new ArrayList<>();
        cupronickelInputs.add(new RecipeInput(metals.get(0), 70));
        cupronickelInputs.add(new RecipeInput(metals.get(7), 30));
        recipes.add(new Recipe("Cupronickel", cupronickelInputs, metals.get(16)));
      
        List<Fuel> fuels = new ArrayList<>();
        fuels.add(new Fuel("Firewood", 0, 0, 700));
        fuels.add(new Fuel("Peat", 0, 0, 900));
        fuels.add(new Fuel("Brown Coal", 0, 0, 1100));
        fuels.add(new Fuel("Black Coal", 0, 0, 1200));
        fuels.add(new Fuel("Anthracite", 0, 0, 1200));
        fuels.add(new Fuel("Charcoal", 0, 0, 1300));
        fuels.add(new Fuel("Coke", 0, 0, 1340));
        
        List<Recipe> baseMetalRecipes = recipes.subList(0, 8);
        List<Recipe> alloyRecipes = recipes.subList(8, recipes.size());

        int categoryChoice = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Vintage Story Crucible Calculator!");

        while (true) {
            System.out.println("\nPlease select a category:");
            System.out.println("1. Base Metals");
            System.out.println("2. Alloys");
            System.out.println("0. Exit");

            System.out.print("\nEnter your choice (0-2): ");
            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                scanner.next();
                continue;
            }

            categoryChoice = scanner.nextInt();

            if (categoryChoice == 0) {
                System.out.println("Thanks for using the calculator!");
                break;
            }

            if (categoryChoice < 1 || categoryChoice > 2) {
                System.out.println("Invalid choice. Please select a number from 0 to 2.");
                continue;
            }

            List<Recipe> selectedCategory = categoryChoice == 1 ? baseMetalRecipes : alloyRecipes;
            String categoryName = categoryChoice == 1 ? "Base Metals" : "Alloys";

            System.out.println("\n" + categoryName + ":");
            for (int i = 0; i < selectedCategory.size(); i++) {
                System.out.println((i + 1) + ". " + selectedCategory.get(i).getName());
            }
            System.out.println("0. Back");

            System.out.print("\nEnter your choice (0-" + selectedCategory.size() + "): ");
            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                scanner.next();
                continue;
            }

            int recipeChoice = scanner.nextInt();
            if (recipeChoice == 0) {
                continue;
            }

            if (recipeChoice < 1 || recipeChoice > selectedCategory.size()) {
                System.out.println("Invalid choice. Please select a number from 0 to " + selectedCategory.size() + ".");
                continue;
            }

            Recipe selectedRecipe = selectedCategory.get(recipeChoice - 1);
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

            int requiredMeltingPoint = selectedMetal.getMeltingPoint();
            if (selectedMetal.isAlloy()) {
                for (RecipeInput input : selectedRecipe.getInputs()) {
                    if (input.getMetal().getMeltingPoint() > requiredMeltingPoint) {
                        requiredMeltingPoint = input.getMetal().getMeltingPoint();
                    }
                }
            }

            System.out.println("Required melting point: " + requiredMeltingPoint + "C");
            System.out.println("Fuels that can melt this recipe:");

            boolean fuelFound = false;
            for (Fuel fuel : fuels) {
                if (fuel.getFuelValue() >= requiredMeltingPoint) {
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