package nl.oose.dea.amdahl;

public class Amdahl {


    private int numberOfProcessors;
    private double sequentialFactor;

    /**
     * @param numberOfProcessors (value restricted to 0 and greater)
     * @param sequentialFactor (value restricted between 0.0 and 1.0)
     */
    public Amdahl(int numberOfProcessors, double sequentialFactor) {
        handleNegativeProcessors(numberOfProcessors);
        handleSequentialFactorOutOfRange(sequentialFactor);

        this.numberOfProcessors = numberOfProcessors;
        this.sequentialFactor = sequentialFactor;
    }

    public double calculateSpeedup() {
        return ((double)numberOfProcessors)/(1+sequentialFactor*((double)numberOfProcessors-1));
    }

    public  double calculateEfficiency()
    {
        return calculateSpeedup()/numberOfProcessors;
    }

    private void handleSequentialFactorOutOfRange(double sequentialFactor) {
        if (isInvalidSequentialFactor(sequentialFactor))
            throw new SequentialFactorOutOfRange("Sequentiele factor moet tussen 0 en 1 liggen");
    }

    private boolean isInvalidSequentialFactor(double sequentialFactor) {
        return sequentialFactor < 0 || sequentialFactor > 1;
    }

    private  void handleNegativeProcessors(int numberOfProcessors) {
        if (isInvalidNumberOfProcessors(numberOfProcessors))
            throw new NegativeNumberOfProcessors("Aantal processoren moet 0 of groter zijn");
    }

    private boolean isInvalidNumberOfProcessors(int numberOfProcessors) {
        return numberOfProcessors < 0;
    }
}
