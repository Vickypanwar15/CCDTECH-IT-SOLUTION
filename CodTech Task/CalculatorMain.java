import java.util.InputMismatchException;
import java.util.Scanner;

class Calculator {
    public void add(double a, double b) {
        double result = a + b;
        System.out.println(a+" + "+b+" = "+result);
    }

    public void subtract(double a, double b) {
        double result = a - b;
        System.out.println(a+" - "+b+" = "+result);
    }

    public void multiply(double a, double b) {
        double result = a * b;
        System.out.println(a+" * "+b+" = "+result);
    }

    public void divide(double a, double b) {
        double result = a / b;
        System.out.println(a+" / "+b+" = "+result);
    }
    public void powerofNumber(double a,double b) {
    	int num1 = (int)a;
    	int num2 = (int)b;
    	int result=1;
    	for(int i=1;i<=num2;i++) {
    		result*=num1;
    	}
    	System.out.println(num1+"^"+num2+" = "+result);
    	
    }
}

public class CalculatorMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Text-Based Calculator");

        while (true) {
            System.out.println("You have 5 choices to perform any one operation");
            System.out.println("Press  1: Addition(+)");
            System.out.println("Press  2: Subtration(-)");
            System.out.println("Press  3: Multiple(*)");
            System.out.println("Press  4: Divide(/)");
            System.out.println("Press  5: Power(a^b)");
            System.out.println("Press  6: Exit");
            System.out.println("Enter your choice: ");

            int choice = sc.nextInt();

            if (choice == 6) {
                System.out.println("Exiting the calculator...");
                break;
            }

            try {
                System.out.println("Enter first number: ");
                double num1 = sc.nextDouble();
                System.out.println("Enter second number: ");
                double num2 = sc.nextDouble();

                Calculator calculator = new Calculator();

                	switch (choice) {
                    	case 1:
                    		calculator.add(num1, num2);
                    		break;
                    	case 2:
                    		calculator.subtract(num1, num2);
                    		break;
                    	case 3:
                    		calculator.multiply(num1, num2);
                    		break;
                    	case 4:
                    		calculator.divide(num1, num2);
                    		break;
                    	case 5:
                    		calculator.powerofNumber(num1, num2);
                    		break;
                    	default:
                        System.out.println("Invalid choice. Please try again.");
                    	}
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a number.");
                        sc.nextLine(); // Clear the input buffer
                    }
                }
        	sc.close();
          System.out.println("Thank you for using the Text-Based Calculator!");
          }
   
  }