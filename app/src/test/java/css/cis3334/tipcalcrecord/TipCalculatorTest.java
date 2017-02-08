package css.cis3334.tipcalcrecord;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by tgibbons on 2/8/2017.
 */
public class TipCalculatorTest {
    Double totTip;
    Double tPP;
    TipCalculator calc;

    @Before
    public void setUp() throws Exception {
        totTip = 0.0;
        tPP = 0.0;
        updateViewInterface mockActivity = new mockView();          // create mock activity
        calc = new TipCalculator(mockActivity);                     // create tipCalculator to test
    }

    @Test
    public void singlePersonNormalServiceTest() throws Exception {
        // Arrange
        Double bill = 10.0;
        Integer numParty = 1;
        Double expectedTotTip = 1.0;
        Double expectedTipPerPerson = 1.0;
        boolean outstandingService = false;
        // Act
        calc.calculate(bill,numParty,outstandingService);
        // Assert
        Assert.assertEquals("Tip should be 10% of bill", expectedTotTip, totTip);
        Assert.assertEquals("Tip per person", expectedTipPerPerson, tPP);
    }

    @Test
    public void threePeopleNormalServiceTest() throws Exception {
        // Arrange
        Double bill = 30.0;
        Integer numParty = 3;
        Double expectedTotTip = 3.0;
        Double expectedTipPerPerson = 1.0;
        boolean outstandingService = false;
        // Act
        calc.calculate(bill,numParty,outstandingService);
        // Assert
        Assert.assertEquals("Tip should be 10% of bill", expectedTotTip, totTip);
        Assert.assertEquals("Tip per person", expectedTipPerPerson, tPP);
    }

    @Test
    public void singlePersonOutstandingServiceTest() throws Exception {
        // Arrange
        Double bill = 10.0;
        Integer numParty = 1;
        Double expectedTotTip = 2.0;
        Double expectedTipPerPerson = 2.0;
        boolean outstandingService = true;
        // Act
        calc.calculate(bill,numParty,outstandingService);
        // Assert
        Assert.assertEquals("Tip should be 20% of bill", expectedTotTip, totTip);
        Assert.assertEquals("Tip per person", expectedTipPerPerson, tPP);
    }

    @Test
    public void threePeopleOutstandingServiceTest() throws Exception {
        // Arrange
        Double bill = 30.0;
        Integer numParty = 3;
        Double expectedTotTip = 6.0;
        Double expectedTipPerPerson = 2.0;
        boolean outstandingService = true;
        // Act
        calc.calculate(bill,numParty,outstandingService);
        // Assert
        Assert.assertEquals("Tip should be 20% of bill", expectedTotTip, totTip);
        Assert.assertEquals("Tip per person", expectedTipPerPerson, tPP);
    }

    // Define a move class that implements this interface the the TipCalculator needs
    class mockView implements updateViewInterface {
        @Override
        public void updateView(Double totalTip, Double tipPerPerson) {
            totTip = totalTip;
            tPP = tipPerPerson;
        }
    }

}

