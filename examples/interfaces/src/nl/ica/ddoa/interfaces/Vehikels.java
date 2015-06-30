package nl.ica.ddoa.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Description for the class Vehikels:
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
public class Vehikels {
    public static void main(String[] args)
    {
        List<Auto> autos = new ArrayList<Auto>();
        autos.add(new AmfibieVoertuig());
        autos.add(new VrachtAuto());

        List<Boot> boten = new ArrayList<Boot>();
        boten.add(new AmfibieVoertuig());
        boten.add(new Hovercraft());

        for(int i=0;i<autos.size();i++)
        {
            autos.get(i).rijden();
        }

        for(int i=0;i<boten.size();i++)
        {
            boten.get(i).varen();
        }
    }
}
