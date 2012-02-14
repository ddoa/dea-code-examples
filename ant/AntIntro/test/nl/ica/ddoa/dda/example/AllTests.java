package nl.ica.ddoa.dda.example;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(value=Suite.class)
@SuiteClasses(value={FibTest.class, MathToolsTest.class, UserTest.class })
//@SuiteClasses(value={test.bank.BankrekeningTest.class, test.tools.MathToolTest.class, test.admin.PersoonTest.class })
public class AllTests 
{     
}

