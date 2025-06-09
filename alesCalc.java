import java.util.Scanner;


public class alesCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keepGoing = true;
        System.out.println("Welcome to Ales Calculator");
        while (keepGoing) {
            System.out.print("Enter an operation (+, -, *, /, or exit): ");
            String operation = scanner.nextLine();
            if (operation.equals("exit")) {
                keepGoing = false;
                System.out.println("Thank you for using Ales Calculator Goodbye!");
                break;
            }
            if (!(operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("/"))) {
                System.out.println("Invalid operation. Please try again.");
                continue;
            }
            System.out.print("Enter the first number: ");
            double num1 = 0;
            if (scanner.hasNextDouble()) {
                num1 = scanner.nextDouble();
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }
            System.out.print("Enter the second number: ");
            double num2 = 0;
            if (scanner.hasNextDouble()) {
                num2 = scanner.nextDouble();
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }
            scanner.nextLine();
            if (num1 < -1000 || num1 > 1000 || num2 < -1000 || num2 > 1000) {
                System.out.println("Numbers must be between -1000 and 1000.");
                continue;
            }
            if (operation.equals("/") && num2 == 0) {
                System.out.println("Error: Division by zero is not allowed.");
                continue;
            }
            double result = 0;
            if (operation.equals("+")) {
                result = num1 + num2;
            } else if (operation.equals("-")) {
                result = num1 - num2;
            } else if (operation.equals("*")) {
                result = num1 * num2;
            } else if (operation.equals("/")) {
                result = num1 / num2;
            }
            System.out.println("Result: " + num1 + " " + operation + " " + num2 + " = " + result);
            System.out.print("Would you like to perform another operation? (yes/no): ");
            String answer = scanner.nextLine();
            if (!answer.equalsIgnoreCase("yes")) {
                keepGoing = false;
                System.out.println("Thank you for using Ales Calculator Goodbye!");
            }
        }
        scanner.close();
    }
}
