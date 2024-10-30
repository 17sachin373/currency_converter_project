import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        // Display a welcome message
        System.out.println("Welcome to the Currency Converter!");
        // Main program loop
        while (true) {
            // Display the menu
            System.out.println("\nMenu:");
            System.out.println("1. Convert USD to INR");
            System.out.println("2. Convert INR to USD");
            System.out.println("3. Quit");
            System.out.print("Enter your choice: ");
            // Read the user's choice
            int choice = scanner.nextInt();
            // Perform the chosen operation
            switch (choice) {
                case 1:
                    convertUSDToINR(scanner);
                    break;
                case 2:
                    convertINRToUSD(scanner);
                    break;
                case 3:
                    System.out.println("Thank you for using the Currency Converter!");
                    // Close the scanner
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Conversion rates (hardcoded for simplicity)
    private static double usdToInrRate = 83.96;
    private static double InrToUsdRate = 0.012;

    // Method to convert USD to EUR
    private static void convertUSDToINR(Scanner scanner) {
        System.out.print("Enter the amount in USD: ");
        double usdAmount = scanner.nextDouble();
        double InrAmount = usdAmount * usdToInrRate;
        System.out.println(usdAmount + " USD is equivalent to " + InrAmount + " INR");
    }

    // Method to convert EUR to USD
    private static void convertINRToUSD(Scanner scanner) {
        System.out.print("Enter the amount in INR: ");
        double InrAmount = scanner.nextDouble();
        double usdAmount = InrAmount * InrToUsdRate;
        System.out.println(InrAmount + " INR is equivalent to " + usdAmount + " USD");
    }
}