package nl.ica.ddoa.dda.example;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(value=Suite.class)
@SuiteClasses(value={FibTest.class, MathToolsTest.class, UserTest.class })
public class AllTests
{     
}

