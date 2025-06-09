import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        

        boolean aleCalc = true;

        while (aleCalc) {
            
            System.out.print("Enter an operation (+, -, *, /, or exit): ");
            String operation = scanner.nextLine().trim();

           
            if (!(operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("/") || operation.equalsIgnoreCase("exit"))) {
                System.out.println("Invalid operation! Please enter +, -, *, /, or exit.");
                continue;
            }

          
            if (operation.equalsIgnoreCase("exit")) {
                break;
            }

           
            double num1 = getValidNumber(scanner, "Enter the first number (0 to 1000): ");

           
            double num2 = getValidNumber(scanner, "Enter the second number (0 to 1000): ");

           
            double result = 0;
            boolean validCalculation = true;

            switch (operation) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
            
                    if (num2 == 0) {
                        System.out.println("Error: Division by zero is not allowed.");
                        validCalculation = false;
                    } else {
                        result = num1 / num2;
                    }
                    break;
                default:
                    validCalculation = false;
                    System.out.println("Unknown operation.");
                    break;
            }

            if (validCalculation) {
                System.out.printf("The result of %.4f %s %.4f = %.4f%n", num1, operation, num2, result);
            }

            
            System.out.print("Would you like to perform another operation (yes/no)? ");
            String answer = scanner.nextLine().trim();

            if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
                aleCalc = false;
            }
        }

        System.out.println("Thank you for using the Java Calculator! Goodbye!");
        scanner.close();
    }

   
    private static double getValidNumber(Scanner scanner, String prompt) {
        double number;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                number = scanner.nextDouble();
                scanner.nextLine(); 

                if (number >= 0 && number <= 1000) {
                    return number;
                } else {
                    System.out.println("Number out of range. Please enter a number between -1000 and 1000.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); 
            }
        }
    }
}
