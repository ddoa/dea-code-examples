package oose.dea.micdemo;

/**
 * Created by Michel Koolwaaij on 01-07-16.
 * Les 2: Unit testen
 */
public class MicInt {

    private long l;

    public MicInt(int i){

        this.l = i;
    }

    public void inc(){

        l = l+1;
    }

    public long getValue(){
        return l;
    }
}
