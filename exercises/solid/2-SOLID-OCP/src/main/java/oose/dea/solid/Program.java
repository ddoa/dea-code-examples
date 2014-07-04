package oose.dea.solid;

import java.io.IOException;

/**
 * @author mdkr
 * @version Copyright (c) 2014 HAN University, All rights reserved.
 */
public class Program {
    public static void main(String[] args) throws IOException {
        Report report = new Report();
        report.print();
        System.out.println("Program ended, press a key to continue");
        System.in.read();
    }
}
