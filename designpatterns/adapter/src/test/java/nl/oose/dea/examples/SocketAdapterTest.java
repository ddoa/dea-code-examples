package nl.oose.dea.examples;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SocketAdapterTest {
    public static final int THREE = 3;
    public static final int TWELVE = 12;
    public static final int HUNDRED_TWENTY = 120;
    private SocketAdapter sockAdapter = new SocketObjectAdapter();

    @Test
    public void adapterReturnsThreeVoltWhenAsked() {
        Volt v3 = getVolt(sockAdapter, THREE);
        assertEquals(THREE, v3.getVolts());
    }

    @Test
    public void adapterReturnsTwelveVoltWhenAsked() {
        Volt v12 = getVolt(sockAdapter, TWELVE);
        assertEquals(TWELVE, v12.getVolts());
    }
    @Test
    public void adapterReturnsHundredTwentyVoltWhenAsked() {
        Volt v120 = getVolt(sockAdapter, HUNDRED_TWENTY);
        assertEquals(HUNDRED_TWENTY, v120.getVolts());
    }


    private static Volt getVolt(SocketAdapter sockAdapter, int i) {
        switch (i) {
            case THREE:
                return sockAdapter.get3Volt();
            case 12:
                return sockAdapter.get12Volt();
            case HUNDRED_TWENTY:
                return sockAdapter.get120Volt();
            default:
                return sockAdapter.get120Volt();
        }
    }
}
