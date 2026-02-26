uimport java.util.Scanner;

class Account{
    //Class Variables
    float balance;
    float previousTransaction;
    String customerName;
    String customerID;

    //Constructor
    Account(String cName, String cID){
        customerName = cName;
        customerID = cID;
    }

    //Deposite money function
    void deposite(float amount){
       if(amount != 0){
        balance = balance + amount;
        previousTransaction = amount;
       }

    }

    //Withdraw money function
    void withdraw(float amount){
    if(amount != 0){
        balance = balance - amount;
        previousTransaction = -amount;
      }
    }

    //function showing the previous transaction
    void getPreviousTransaction(){
      if(previousTransaction > 0){
        System.out.println("Deposited : "+ previousTransaction);
      }
      else if(previousTransaction < 0){
        System.out.println("Withderawn : "+ previousTransaction);
      }
      else{
        System.out.println("NO previous transaction");
      }
    }

    //Calculate Interest Function
    void calculateInterest(float years){
        double interest = 2.05;
        double newBalance = (balance * interest * years)/100 ;
        double totalBalance = newBalance + balance;
        System.out.println("current interest rate : " + interest);
        System.out.println("After " + years + " years, your balance will be : " + totalBalance);
    }

    //function showing main menu
    void showMenu(){
        char option;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome," + customerName + ".");
        System.out.println("ID : " + customerID);
        System.out.println();
        System.out.println("What would you like to do : ");
        System.out.println();
        System.out.println("A) Check your balance.");
        System.out.println("B) Make a deposite.");
        System.out.println("C) Make a withdrawal.");
        System.out.println("D) View the previous transaction.");
        System.out.println("E) Calculate Interest.");
        System.out.println("F) Exit.");

        do{
            System.out.println();
            System.out.println("Enter an option : ");
            char option2 = sc.next().charAt(0);
            option = Character.toUpperCase(option2);
            System.out.println();

            switch(option){

                //option 'A' allows the user to check account balance
                case 'A': System.out.println("***************************************");
                          System.out.println("  Total Balance : $ " + balance);
                          System.out.println("***************************************");
                          System.out.println();
                          break;
                
                //option 'B' allows the user to deposite money into their account
                case 'B': System.out.println("Enter an amount to deposite : $ ");
                          float amount = sc.nextFloat();
                          deposite(amount);
                          System.out.println("***************************************");
                          System.out.println();
                          break;

                //option 'C' allows the user to withdraw money from their account
                case 'C': System.out.println("Enter an amount to withdraw : $ ");
                          float amount2 = sc.nextFloat();
                          withdraw(amount2);
                          System.out.println("***************************************");
                          System.out.println();
                          break;
                     
                //option 'D' allows the user to view previous transactions
                case 'D': System.out.println("***************************************");
                          getPreviousTransaction();
                          System.out.println("***************************************");
                          System.out.println();
                          break;

                //option 'E' calculate the accrued interest on the account after 
                case 'E': System.out.println("Enter how many years of accrued interest : ");
                           float years = sc.nextFloat();
                           calculateInterest(years);
                           System.out.println("***************************************");
                           System.out.println();
                           break;

                case 'F': System.out.println("***************************************");
                          break;

                default : System.out.println("Invalid option. Please choose the option A, B, C, D or F only ");
                          break;
            }

        } while(option != 'F');
        sc.close();
        System.out.println("Thank you for Banking with us");
    }
}