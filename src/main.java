import java.util.Scanner;

public class main {
    private static double monthlySalary;
    private static double annualSalary;
    private static double personalRelief;
    private static double parentRelief=0;
    private static double spouseRelief=0;
    private static double childrenRelief=0;
    private static double deductibles=0;
    private static double taxableIncome;
    private static double totalTax;
    private static double monthlyTax;

    public static void main (String args[]){

        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Monthly Salary ( MMK ) : ");
        monthlySalary=sc.nextDouble();
        annualSalary=12*monthlySalary;
        System.out.print("Enter Number of Months : ");
        int months=sc.nextInt();
        personalRelief=(months*monthlySalary)*20/100;

        sc.nextLine();
        while(true){
            System.out.print("Do You Have A Father ( Yes / No ) ? ");
            String quesFather = sc.nextLine();
            if (quesFather.equals("Yes") ) {
                parentRelief+=1000000;
                break;
            }
            else if(quesFather.equals("No")){
                break;
            }
            else {
                System.out.println("Invalid Input Pls Try Again ");
            }
        }

        while(true){
            System.out.print("Do You Have A Mother ( Yes / No ) ? ");
            String quesMother = sc.nextLine();
            if (quesMother.equals("Yes")) {
                parentRelief+=1000000;
                break;
            }
            else if(quesMother.equals("No")){
                break;
            }else {
                System.out.println("Invalid Input Pls Try Again ");
            }
        }

        while(true){
            System.out.print("Do You Have A Spouse ( Yes / No ) ? ");
            String quesSpouse = sc.nextLine();
            if (quesSpouse.equals("Yes")) {
                spouseRelief=1000000;
                break;
            }
            else if(quesSpouse.equals("No")) {
                break;
            }
            else {
                System.out.println("Invalid Input Pls Try Again ");
            }
        }

        while(true){
            System.out.print("Do You Have A Children ( Yes / No ) ? ");
            String quesChildren = sc.nextLine();
            if (quesChildren.equals("Yes")) {
                System.out.print("How Many Children Do You Have ? ");
                int nunOfChildren=sc.nextInt();
                childrenRelief=nunOfChildren*500000;
                break;
            }
            else if(quesChildren.equals("No")){
                break;
            }
            else {
                System.out.println("Invalid Input Pls Try Again ");
            }
        }

        while(true){
            System.out.print("Do You Have Other Deductibles (Social Security Contributions, etc) ? ");
            String insurance = sc.nextLine();
            if (insurance.equals("Yes")) {
                System.out.print("Enter Amount For Other Deductibles in MMK : ");
                deductibles+=sc.nextDouble();
                break;
            }
            else if(insurance.equals("No")){
                break;
            }
            else {
                System.out.println("Invalid Input Pls Try Again ");
            }
        }

        taxableIncome=(months*monthlySalary)-(personalRelief+parentRelief+spouseRelief+childrenRelief+deductibles);

        if(taxableIncome<2000000){
            totalTax=taxableIncome;
        }
        else if(taxableIncome>2000000 || taxableIncome< 5000000){
            totalTax=(taxableIncome-2000000)*5/100;
        }
        else if(taxableIncome>5000000 || taxableIncome< 10000000){
            totalTax=150000+((taxableIncome-5000000)*10/100);
        }
        else if(taxableIncome>10000000 || taxableIncome< 20000000){
            totalTax=150000+500000+((taxableIncome-1000000)*15/100);
        }
        else if(taxableIncome>20000000 || taxableIncome< 30000000){
            totalTax=150000+500000+1500000+((taxableIncome-1000000)*20/100);
        }
        else{
            totalTax=150000+500000+1500000+200000+((taxableIncome-1000000)*25/100);
        }

        monthlyTax=totalTax/12;

        System.out.println("RESULT");
        System.out.println("Monthly Salary                   "+monthlySalary);
        System.out.println("Annual Salary                    "+annualSalary);
        System.out.println("Income for "+months+" months              "+months*monthlySalary);
        System.out.println("Personal Relief                  "+personalRelief);
        System.out.println("Parent Relief                    "+parentRelief);
        System.out.println("Spouse Relief                    "+spouseRelief);
        System.out.println("Children Relief                  "+childrenRelief);
        System.out.println("Other deductibles                "+deductibles);
        System.out.println("Taxable Income                   "+(int)taxableIncome);
        System.out.println("Total Tax                        "+totalTax);
        System.out.println("Monthly Tax                      "+monthlyTax);

    };

};
