import java.text.DecimalFormat;
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


    public static void main (String args[]) {

        Scanner sc = new Scanner(System.in);
        System.out.print("\u001B[32mEnter Monthly Salary ( MMK ) : ");
        monthlySalary = sc.nextDouble();
        annualSalary = 12 * monthlySalary;
        System.out.print("Enter Number of Months : ");
        int months = sc.nextInt();
        personalRelief = (months * monthlySalary) * 20 / 100;

        sc.nextLine();
        while (true) {
            System.out.print("Do You Have A Father ( Yes / No ) ? ");
            String quesFather = sc.nextLine();
            if (quesFather.equals("Yes")) {
                parentRelief += 1000000;
                break;
            } else if (quesFather.equals("No")) {
                break;
            } else {
                System.out.println("Invalid Input Pls Try Again ");
            }
        }

        while (true) {
            System.out.print("Do You Have A Mother ( Yes / No ) ? ");
            String quesMother = sc.nextLine();
            if (quesMother.equals("Yes")) {
                parentRelief += 1000000;
                break;
            } else if (quesMother.equals("No")) {
                break;
            } else {
                System.out.println("Invalid Input Pls Try Again ");
            }
        }

        while (true) {
            System.out.print("Do You Have A Spouse ( Yes / No ) ? ");
            String quesSpouse = sc.nextLine();
            if (quesSpouse.equals("Yes")) {
                spouseRelief = 1000000;
                break;
            } else if (quesSpouse.equals("No")) {
                break;
            } else {
                System.out.println("Invalid Input Pls Try Again ");
            }
        }

        while (true) {
            System.out.print("Do You Have A Children ( Yes / No ) ? ");
            String quesChildren = sc.nextLine();
            if (quesChildren.equals("Yes")) {
                System.out.print("How Many Children Do You Have ? ");
                int nunOfChildren = sc.nextInt();
                childrenRelief = nunOfChildren * 500000;
                sc.nextLine();
                break;
            } else if (quesChildren.equals("No")) {
                break;
            } else {
                System.out.println("Invalid Input Pls Try Again ");
            }
        }

        while (true) {
            System.out.print("Do You Have Other Deductibles (Social Security Contributions, etc) ? ");
            String insurance = sc.nextLine();
            if (insurance.equals("Yes")) {
                System.out.print("Enter Amount For Other Deductibles in MMK : ");
                deductibles += sc.nextDouble();
                break;
            } else if (insurance.equals("No")) {
                break;
            } else {
                System.out.println("Invalid Input Pls Try Again ");
            }
        }

        taxableIncome = (months * monthlySalary) - (personalRelief + parentRelief + spouseRelief + childrenRelief + deductibles);

        DecimalFormat df = new DecimalFormat("#,###.00");
        System.out.println("\u001B[34m \n\n\nRESULT\n");
        System.out.println("Monthly Salary                   "+df.format(monthlySalary));
        System.out.println("Annual Salary                    "+df.format(annualSalary));
        System.out.println("Income for "+months+" months             "+df.format(months*monthlySalary));
        System.out.println("Personal Relief                  "+df.format(personalRelief));
        System.out.println("Parent Relief                    "+df.format(parentRelief));
        System.out.println("Spouse Relief                    "+df.format(spouseRelief));
        System.out.println("Children Relief                  "+df.format(childrenRelief));
        System.out.println("Other deductibles                "+df.format(deductibles));
        System.out.println("Taxable Income                   "+df.format(taxableIncome));

        int taxable;
        int taxamount;
        totalTax=0;
        System.out.println("\u001B[32m\n\n\nDetails\n");
        System.out.println("Description              Rate            Taxable           taxamount");
        if ( taxableIncome<2000000){
            System.out.println("Up to 20 Lakh            0%              0.00              0.00");
            System.out.println("                                                           0.00");
        }
        if (taxableIncome>2000000 ){
            taxable= (int) (taxableIncome-2000000);
            System.out.println("Up to 20 Lakh            0%              2,000,000         0.00");
            if(taxable>3000000){
                System.out.println("20 Lakh - 50 Lakh        5%              3,000,000         "+df.format(150000));
                totalTax+=150000;
            }else {
                taxamount= (taxable)*5/100;
                System.out.println("20 Lakh - 50 Lakh        5%              "+df.format(taxable)+"         "+df.format(taxamount));
                totalTax=taxamount;
            }
        }

        if(taxableIncome>5000000) {
            taxable = (int) (taxableIncome - 5000000);

            if (taxable > 5000000) {
                System.out.println("50 Lakh - 100 Lakh       10%             5,000,000         "+df.format(500000));
                totalTax+=500000;
            } else {
                taxamount = (taxable) * 10 / 100;
                System.out.println("50 Lakh - 100 Lakh       10%             "+df.format(taxable)+"         "+df.format(taxamount));

                totalTax+=taxamount;
            }
        }

        if(taxableIncome>10000000){
            taxable = (int) (taxableIncome - 10000000);

            if (taxable > 10000000) {
                System.out.println("100 Lakh - 200 Lakh      15%            10,000,000         "+df.format(1500000));
                totalTax+=1500000;
            } else {
                taxamount = (taxable) * 15 / 100;
                System.out.println("100 Lakh - 200 Lakh      15%            "+df.format(taxable)+"         "+df.format(taxamount));
                totalTax+=taxamount;
            }
        }

        if(taxableIncome>20000000){
            taxable = (int) (taxableIncome - 20000000);

            if (taxable > 10000000) {
                System.out.println("200 Lakh - 300 Lakh      20%            10,000,000         "+df.format(2000000));
                totalTax+=2000000;
                taxamount = (taxable) * 20 / 100;
                System.out.println("Above 300 Lakh           25%            10,000,000         "+ df.format(taxamount));
            } else {
                taxamount = (taxable) * 20 / 100;
                System.out.println("200 Lakh - 300 Lakh      20%            "+df.format(taxable)+"         "+df.format(taxamount));                totalTax+=taxamount;
            }
        }
        System.out.println("                                                            "+df.format(totalTax));



        monthlyTax=totalTax/12;
        System.out.println("\u001B[34m\n\n\nTotal Tax                        "+df.format(totalTax));
        System.out.println("Monthly Tax                      "+df.format(monthlyTax));


    };

};
