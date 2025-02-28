import java.util.Scanner;


public class Calculator {
    public static void main(String[] args) {
Scanner scanner =new Scanner(System.in);

while(true){
    System.out.println("\nSimple Calculator");
    System.out.println("1. Addition");
    System.out.println("2. Subtraction");
    System.out.println("3. Multiplication");
    System.out.println("4. Division");
    System.out.println("5. Modulus");
    System.out.println("6. Power(x^y)");
    System.out.println("7. Square Root");
    System.out.println("8. Exit");
    System.out.println("Choose an option(1-8)");
    int choice=scanner.nextInt();
    if (choice == 8) {
        System.out.println("Exiting the calculator. Goodbye!");
        scanner.close();
        return;
    }
    double num1 = 0, num2 = 0;
    if (choice >= 1 && choice <= 6) {
        System.out.print("Enter the first number: ");
        num1 = scanner.nextDouble();
        System.out.print("Enter the second number: ");
        num2 = scanner.nextDouble();
    }
switch (choice){
    case 1:
        System.out.println("Result: "+(num1+num2));
        break;
    case 2:
        System.out.println("Result: "+(num1-num2));
        break;
    case 3:
        System.out.println("Result: "+(num1*num2));
        break;
    case 4:
        if(num2!=0)
            System.out.println("Result: "+(num1/num2));

        else
            System.out.println("Division by zero is not possible");

        break;
    case 5:
        System.out.println("Result: "+(num1%num2));
        break;
    case 6:
        double result=1;
        for(int i=0;i<(int)num2;i++){
            result*=num1;
        }
        System.out.println("Result: "+result);
        break;
    case 7:
        System.out.println("which number do you want the square root of: ");
        double sqrtNumber=scanner.nextDouble();

        if(sqrtNumber>=0){
        System.out.println("Result: "+Math.sqrt(sqrtNumber));}
        else{
            System.out.println("can't calculate square root of negative number");
        }
        break;

    default:
        System.out.println("Invalid choice. please try again");
}
}
    }
}