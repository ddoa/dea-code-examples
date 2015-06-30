package nl.oose.dea.amdahl;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AmdahlTest {
    @Test(expected = NegativeNumberOfProcessors.class)
    public void givenANegativeNumberOfProcessorsAnInstanceOfAmdahlCannotBeCreated()  {
        new Amdahl(-1,0);
    }

    @Test(expected = SequentialFactorOutOfRange.class)
    public void givenANegativeSequentialFactorAnInstanceOfAmdahlCannotBeCreated()  {
        new Amdahl(1,-1);
    }

    @Test(expected = SequentialFactorOutOfRange.class)
    public void givenASequentialFactorGreaterThanOneAnInstanceOfAmdahlCannotBeCreated()  {
        new Amdahl(1,2);
    }

    @Test
    public void givenANumberOfProcessorsOfZeroTheSpeedupIsAlwaysZero()  {
        assertEquals(0, new Amdahl(0, 0.5).calculateSpeedup(), 0);
    }

    @Test
    public void givenASequentialFactorOfOneTheSpeedupIsAlwaysConstant()  {
        long ONE = 1;
        for(int i=1;i<10;i++) {
            double d = new Amdahl(i, 1).calculateSpeedup();
            assertEquals(ONE, d, 0.01);
        }
    }

    @Test
    public void givenASequentialFactorOfZeroTheSpeedupIsEqualToNumberOfProcessors()  {
        for(int i=1;i<10;i++) {
            double d = new Amdahl(i, 0).calculateSpeedup();
            assertEquals(i, d, 0.01);
        }
    }

    @Test
    public void givenValidParametersSpeedupReturnsFine()
    {
        double d = new Amdahl(10, 0.01).calculateSpeedup();
        assertEquals(9.174311926605505, d, 0.01);
    }

    @Test
    public void givenValidParametersEfficiencyReturnsFine() {
        double d = new Amdahl(10, 0.01).calculateEfficiency();
        assertEquals(0.9174311926605505, d, 0.01);
    }
}
