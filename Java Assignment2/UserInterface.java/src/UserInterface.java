import java.util.Scanner;

/**
 * Calculator class with overloaded methods for arithmetic operations.
 */
class Calculator {

    /**
     * Adds two integers.
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * Adds two doubles.
     */
    public double add(double a, double b) {
        return a + b;
    }

    /**
     * Adds three integers.
     */
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    /**
     * Subtracts two integers.
     */
    public int subtract(int a, int b) {
        return a - b;
    }

    /**
     * Multiplies two doubles.
     */
    public double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Divides two integers, handling divide-by-zero.
     */
    public double divide(int a, int b) {
        try {
            if (b == 0) throw new ArithmeticException("Divide by zero");
            return (double) a / b;
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
            return -1.0;
        }
    }
}

/**
 * UserInterface class for user interaction.
 */
public class UserInterface {
    private Scanner scanner;
    private Calculator calc;

    public UserInterface() {
        scanner = new Scanner(System.in);
        calc = new Calculator();
    }

    public void performAddition() {
        System.out.println("\nAddition Options:");
        System.out.println("1. Two integers");
        System.out.println("2. Two doubles");
        System.out.println("3. Three integers");
        System.out.print("Choose: ");
        int opt = getInt();
        switch (opt) {
            case 1:
                System.out.print("First int: "); int x1 = getInt();
                System.out.print("Second int: "); int x2 = getInt();
                System.out.println("Result: " + calc.add(x1, x2));
                break;
            case 2:
                System.out.print("First double: "); double y1 = getDouble();
                System.out.print("Second double: "); double y2 = getDouble();
                System.out.println("Result: " + calc.add(y1, y2));
                break;
            case 3:
                System.out.print("First int: "); int z1 = getInt();
                System.out.print("Second int: "); int z2 = getInt();
                System.out.print("Third int: "); int z3 = getInt();
                System.out.println("Result: " + calc.add(z1, z2, z3));
                break;
            default: System.out.println("Invalid option.");
        }
    }

    public void performSubtraction() {
        System.out.print("\nFirst int: "); int a = getInt();
        System.out.print("Second int: "); int b = getInt();
        System.out.println("Result: " + calc.subtract(a, b));
    }

    public void performMultiplication() {
        System.out.print("\nFirst double: "); double c = getDouble();
        System.out.print("Second double: "); double d = getDouble();
        System.out.println("Result: " + calc.multiply(c, d));
    }

    public void performDivision() {
        System.out.print("\nNumerator: "); int num = getInt();
        System.out.print("Denominator: "); int den = getInt();
        double res = calc.divide(num, den);
        if (res != -1.0) {
            System.out.println("Result: " + res);
        } else {
            System.out.println("Division failed.");
        }
    }

    public void mainMenu() {
        int choice;
        do {
            System.out.println("\nWelcome to the Calculator Application!");
            System.out.println("1. Add Numbers");
            System.out.println("2. Subtract Numbers");
            System.out.println("3. Multiply Numbers");
            System.out.println("4. Divide Numbers");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = getInt();
            switch (choice) {
                case 1: performAddition(); break;
                case 2: performSubtraction(); break;
                case 3: performMultiplication(); break;
                case 4: performDivision(); break;
                case 5: System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 5);
        scanner.close();
    }

    private int getInt() {
        while (!scanner.hasNextInt()) {
            System.out.print("Enter integer: ");
            scanner.next();
        }
        int val = scanner.nextInt();
        scanner.nextLine();
        return val;
    }

    private double getDouble() {
        while (!scanner.hasNextDouble()) {
            System.out.print("Enter double: ");
            scanner.next();
        }
        double val = scanner.nextDouble();
        scanner.nextLine();
        return val;
    }

    public static void main(String[] args) {
        new UserInterface().mainMenu();
    }
}
