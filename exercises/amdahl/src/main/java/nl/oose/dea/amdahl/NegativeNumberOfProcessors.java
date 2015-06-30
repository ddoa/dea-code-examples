package nl.oose.dea.amdahl;

public class NegativeNumberOfProcessors extends RuntimeException {
    public NegativeNumberOfProcessors(String message) {
        super(message);
    }
}
