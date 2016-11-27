package oose.dea.dataaccess;

import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@PrepareForTest(JdbcConnectionFactory.class)
public class JdbcConnectionFactoryTest {

    public static final String DEZE_CLASS_BESTAAT_NIET = "deze.class.bestaat.Niet";
    public static final String KAN_GEEN_PROPERTIES_LEZEN = "Kan geen properties lezen";
    private static final String USER = "sa";
    private static final String PASS = "";
    private static final String URL = "jdbc:h2";
    private static final String DRIVER = "org.h2.Driver";

    @Test
    public void createWithExistingPropertyFile() throws Exception {
        JdbcConnectionFactory jdbcConnectionFactory = new JdbcConnectionFactory();
        assertNotNull(jdbcConnectionFactory.create());
    }

    @Test
    public void whenDriverCannotBeFoundAnExceptionIsLogged() {
        Logger mockLogger = mock(Logger.class);
        Whitebox.setInternalState(JdbcConnectionFactory.class, "logger", mockLogger);

        Properties properties = mock(Properties.class);
        when(properties.getProperty("driver")).thenReturn(DEZE_CLASS_BESTAAT_NIET);

        new JdbcConnectionFactory(properties);

        verify(mockLogger).severe(DEZE_CLASS_BESTAAT_NIET);
    }

    @Test
    public void whenPropertiesCannotBeLoadedAnExceptionIsLogged() throws IOException {
        Logger mockLogger = mock(Logger.class);
        Whitebox.setInternalState(JdbcConnectionFactory.class, "logger", mockLogger);

        Properties properties = mock(Properties.class);
        doThrow(new IOException(KAN_GEEN_PROPERTIES_LEZEN)).when(properties).load(any(InputStream.class));

        new JdbcConnectionFactory(properties);

        verify(mockLogger).severe(KAN_GEEN_PROPERTIES_LEZEN);
    }

    @Test
    public void whenAConnectionCannotBeCreatedASQLExcepionIsLogged() {
        Logger mockLogger = mock(Logger.class);
        Whitebox.setInternalState(JdbcConnectionFactory.class, "logger", mockLogger);

        Properties properties = mock(Properties.class);
        when(properties.getProperty("user")).thenReturn(USER);
        when(properties.getProperty("password")).thenReturn(PASS);
        when(properties.getProperty("databaseurl")).thenReturn(URL);
        when(properties.getProperty("driver")).thenReturn(DRIVER);

        JdbcConnectionFactory jdbcConnectionFactory = new JdbcConnectionFactory(properties);
        jdbcConnectionFactory.create();
        verify(mockLogger).severe(anyString());

    }
}