import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestClass
{
    @Test
    public void TestingForDependents()
    {
        PayrollDollars classObj = new PayrollDollars();

        classObj.set_rate_insurance(3);
        double insurance = classObj.get_insurance_rate();

        //the third argument is a needed argument for float values for precision 
       assertEquals(35.0, insurance, .0001);
    }

    @Test
    public void TestingForPayRate()
    {
        PayrollDollars classObj = new PayrollDollars();
        classObj.get_rate();
        assertEquals(16.75, classObj.get_rate(),.001);

        classObj.set_new_pay_rate(40.75);
        assertEquals(40.75, classObj.get_rate(), .001);
    }

    @Test
    public void TestingForGross()
    {
        PayrollDollars classObj = new PayrollDollars();

        //This is using the default value of the payrate 16.78
        // need to use set_new_pay_rate() for other values
        classObj.set_hours(41);
        classObj.calulate_earning_gross();

        assertEquals(696.37, classObj.get_check_gross(), .001);
    }
    
}
