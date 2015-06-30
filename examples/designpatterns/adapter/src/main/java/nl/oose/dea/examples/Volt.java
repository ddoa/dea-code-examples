package nl.oose.dea.examples;

/**
 * Source: http://www.journaldev.com/1487/adapter-design-pattern-in-java-example-tutorial
 */
public class Volt {

    private int volts;

    public Volt(int v){
        this.volts=v;
    }

    public int getVolts() {
        return volts;
    }

    public void setVolts(int volts) {
        this.volts = volts;
    }

}