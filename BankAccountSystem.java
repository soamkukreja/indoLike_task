import java.util.Scanner;

class BankAccount{
    private String accountHolderName;
    private int accountNumber;
    private double balance;

    public BankAccount(String name, int number, double initialbalance) {
        accountHolderName =name;
        accountNumber     = number;
        balance           = initialbalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void deposit(double amount){
        if(amount>0){
            balance+=amount;
            System.out.println("Deposit successful. New balance: "+balance);
        }else{
            System.out.println("invalid deposit amount.");
        }

    }
    public void withdraw(double amount){
        if(amount>0 && amount<=balance){
            balance-=amount;
            System.out.println("Withdrawal successful, New balance: "+balance);

        } else if (amount>balance) {
            System.out.println("Insufficient balance.");

        }else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
    public void checkBalance(){
        System.out.println("Current balance: "+balance);
    }
    public void displayAccountDetails(){
        System.out.println("Account Holder: "+accountHolderName);
        System.out.println("Account Number: "+accountNumber);
        System.out.println("Balance: "+balance);
    }

}
public class BankAccountSystem {
    private static BankAccount[] accounts = new BankAccount[100];
    private static int accountCount = 0;
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("*****Welcome to Bank Account System*****");

        while(true){
            System.out.println("\nChoose an option:");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Display Account Details");
            System.out.println("6. Exit");
            System.out.println("Enter your choice: ");
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter account holder name: ");
                    sc.nextLine();
                    String name=sc.nextLine();
                    System.out.println("Enter account number: ");
                    int number=sc.nextInt();
                    System.out.println("Enter initial deposit: ");
                    double initialBalance=sc.nextDouble();
                     accounts[accountCount++]=new BankAccount(name,number,initialBalance);
                    System.out.println("Account created successfully!");
                    break;
                case 2:
                    System.out.println("Enter account number: ");
                    int depositAccountNumber= sc.nextInt();
                    BankAccount depositAccount=findAccount(depositAccountNumber);
                    if(depositAccount!=null){
                        System.out.println("Enter amount to deposit: ");
                        double depositAmount=sc.nextDouble();
                        depositAccount.deposit(depositAmount);
                    }else {
                        System.out.println("Account not found.");
                    } break;
                case 3:
                    System.out.println("Enter account number: ");
                    int withdrawAccountNumber= sc.nextInt();
                    BankAccount withdrawAccount=findAccount(withdrawAccountNumber);
                    if(withdrawAccount!=null){
                        System.out.println("Enter amount to deposit: ");
                        double withdrawAmount=sc.nextDouble();
                        withdrawAccount.deposit(withdrawAmount);
                    }else {
                        System.out.println("Account not found.");
                    } break;
                case 4:
                    System.out.println("Enter account number: ");
                    int balanceAccountNumber= sc.nextInt();
                    BankAccount bankAccount=findAccount(balanceAccountNumber);
                    if(bankAccount!=null){
                        bankAccount.checkBalance();
                    }else{
                        System.out.println("Account not found.");
                    }
                    break;
                case 5:
                    System.out.println("Enter account number: ");
                    int detailsAccountNumber= sc.nextInt();
                    BankAccount detailsAccount=findAccount(detailsAccountNumber);
                    if(detailsAccount!=null){
                        detailsAccount.displayAccountDetails();
                    }else{
                        System.out.println("Account not found.");
                    }
                    break;
                case 6:
                    System.out.println("Thankyou for using the bank Account System.Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again,");




            }
        }


    }
    private static BankAccount findAccount(int accountNumber){
        for(int i=0;i<accountCount;i++){
            if(accounts[i].getAccountNumber()==accountNumber){
                return accounts[i];
            }
        }
        return null;
    } }
