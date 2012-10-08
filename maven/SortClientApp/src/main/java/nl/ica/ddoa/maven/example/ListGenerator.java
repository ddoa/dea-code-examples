package nl.ica.ddoa.maven.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Description for the class ListGenerator:
 * <p/>
 * Example usage:
 * <p/>
 * <pre>
 *
 * </pre>
 *
 * @author mdkr
 * @version Copyright (c) 2012 HAN University, All rights reserved.
 */
public class ListGenerator {
    public List<Integer> generate(int length) {
        List<Integer> generatedList = new ArrayList<Integer>();
        for(int i=0;i<length;i++)
        {
            generatedList.add((int)Math.round(Math.random()*length));
        }
        return generatedList;
    }
}
