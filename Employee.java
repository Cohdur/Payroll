import java.util.Scanner;

public class Employee extends PayrollDollars
{
    private String Name;

    public void Input()
    {
        Scanner in = new Scanner(System.in);
        //PayrollDollars dollarClass = new PayrollDollars();

        System.out.println("Welcome to the Payroll Program\n\n");

        System.out.print("Enter full name: ");
        Name = in.nextLine();

        System.out.print("Hours worked this week: ");
        set_hours(in.nextDouble());
        while(get_hours() < 0.0)
        {
            System.out.print("Entered a negative value! New -> ");
            set_hours(in.nextDouble());
        }

        System.out.print("Payrate: ");
        set_new_pay_rate(in.nextDouble());
        while(get_rate() < 0.0)
        {
            System.out.print("Entered a negative value! New -> ");
            set_new_pay_rate(in.nextDouble());
        }

        System.out.print("Number of dependents you are responsible for: ");
        set_dependents(in.nextInt());
        while(get_dependents() < 0.0)
        {
            System.out.print("Entered a negative value! New -> ");
            set_dependents(in.nextInt());
        }


        System.out.println("\n");
        set_rate_insurance(get_dependents());
        calulate_earning_gross();
        calulate_earning_net();
        
        in.close();
        
    }

    public void Output1()
    {

        System.out.printf("Payroll Stub: %s\n\n", Name);
        System.out.printf("Hours:   %.2f\n", get_hours());
        System.out.printf("Rate:  $ %.2f\n", get_rate());
        System.out.printf("Gross:  $ %.2f\n\n", get_check_gross());
        System.out.printf("SocSec:  $ %.2f\n", get_SS());
        System.out.printf("Federal Tax:  $ %.2f\n", Fed_rate());
        System.out.printf("State Tax:  $ %.2f\n", state_rate());
        System.out.printf("Union:  $ %.2f\n", union_rate());
        System.out.printf("Insurance:  $ %.2f\n\n\n", get_insurance_rate());
        System.out.printf("Net:  $ %.2f\n\n", get_check_net());
        System.out.print("Thank you for using the Payroll Program!");
        
        
    }

    public void Output2()
    {
        System.out.printf("Payroll Stub: %s\n\n", Name);
        System.out.printf("Hours:   %.2f\n", get_hours());
        System.out.printf("Rate:  $ %.2f\n", get_rate());
        System.out.printf("Gross:  $ %.2f\n\n", get_check_gross());
        System.out.printf("SocSec:  $ %.2f\n", get_SS());
        System.out.printf("Federal Tax:  $ %.2f\n", Fed_rate());
        System.out.printf("State Tax:  $ %.2f\n\n", state_rate());
        System.out.printf("Net:  $ %.2f\n\n", get_check_net());
        System.out.println("Employee Owes:\n\n");

        System.out.printf("Union:  $ %.2f\n", union_rate());
        System.out.printf("Insurance:  $ %.2f\n\n\n", get_insurance_rate());
    }

    public static void main(String[] args)
    {
        Employee classObj = new Employee();

        classObj.Input();

        if(classObj.is_negative() == false)
        {
            classObj.Output1();
        }
        else
        {
            classObj.Output2();
        }
    }
    
}
