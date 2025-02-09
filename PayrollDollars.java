
/**
 * This class will handle the paycheck variables 
 */

public class PayrollDollars
{
    private double payrate = 16.78;
    private double OT_pay;
    private double regular_pay;
    static private boolean Owes = false;

    private double socialSecurityTax;
    private double federalTax;
    private double stateTax;
    private double insurance_rate;
    final private double UNION_DUES = 10.00;

    private double check_gross;
    private double check_net;

    private double hours;
    private double hoursOT;
    private int dependents;

    public void set_dependents( int dependents)
    {
        if(dependents <= 0)
        {
            this.dependents = 0;
        }
        this.dependents = dependents;
    }

    public void set_hours(double hours)
    {
        this.hours = hours;
    }

    //Is there a different pay amount?
    public void set_new_pay_rate(double pay)
    {
        this.payrate = pay;
    }

    public void calulate_earning_gross()
    {
        if(hours <= 40.00)
        {
            check_gross = (payrate * hours);
        }
        else
        {
            hoursOT = hours - 40.00;
            OT_pay = ((payrate * 1.5) * hoursOT);
            regular_pay = (payrate * 40);
            check_gross = regular_pay + OT_pay;
        }
    }

    public void set_rate_insurance(int dependents)
    {
        if(dependents >= 3)
        {
            insurance_rate = 35.0;
        }
        else
        {
            insurance_rate = 15.0;
        }
    }

    public void calulate_earning_net()
    {
        socialSecurityTax = check_gross * 0.06;
        federalTax = check_gross * 0.14;
        stateTax = check_gross * 0.05;

        if(check_gross < (socialSecurityTax + federalTax + stateTax + insurance_rate + UNION_DUES))
        {
            Owes = true;
            check_net = check_gross - (socialSecurityTax + federalTax + stateTax);
        }
        else
        {
            check_net = check_gross - (socialSecurityTax + federalTax + stateTax + insurance_rate + UNION_DUES);
        }
    }

    /**
     * This will be the accessor for gross pay
     * @return the gross pay for the Payroll 
     */
    final public double get_check_gross()
    {
        return check_gross;
    }

    /**
     * This will be the accessor for net pay
     * @return the net pay for the Payroll 
     */
    public double get_check_net()
    {
        return check_net;
    }

    /**
     * This will be the accessor for payrate
     * @return the payrate for the Payroll 
     */
    final public double get_insurance_rate()
    {
        return insurance_rate;
    }

    /**
     * This will be the accessor for hours
     * @return the hours for the Payroll 
     */
    final public double get_hours()
    {
        return hours;
    }

    /**
     * This will be the accessor for pay rate
     * @return the pay for the Payroll 
     */
    final public double get_rate()
    {
        return payrate;
    }

    /**
     * This will be the accessor for social security tax
     * @return the social security tax for the Payroll 
     */
    final public double get_SS()
    {
        return socialSecurityTax;
    }

    /**
     * This will be the accessor for federal tax
     * @return the federal tax for the Payroll 
     */
    final public double Fed_rate()
    {
        return federalTax;
    }

    /**
     * This will be the accessor for state tax
     * @return the state tax for the Payroll 
     */
    final public double state_rate()
    {
        return stateTax;
    }

    /**
     * This will be the accessor for state tax
     * @return the state tax for the Payroll 
     */
    final public double union_rate()
    {
        return UNION_DUES;
    }


    /**
     * This will be the accessor for amount of children the employee claims
     * @return the dependents for the Payroll 
     */
    final public int get_dependents()
    {
        return dependents;
    }

    /**
     * Boolean variable will inform the system if the employee will go negative
     * @return if employee Owes after all deductions
     */
    public Boolean is_negative()
    {
        return Owes;
    }
}