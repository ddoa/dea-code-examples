package nl.ica.ddoa.maven.example;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListLogger {
    private Logger logger;

    public ListLogger() {
        logger = Logger.getLogger(getClass().getName());
    }

    public void printList(List<Integer> sortedList) {
        for (Integer i : sortedList) {
            logger.log(Level.INFO, i.toString());
        }
    }
}