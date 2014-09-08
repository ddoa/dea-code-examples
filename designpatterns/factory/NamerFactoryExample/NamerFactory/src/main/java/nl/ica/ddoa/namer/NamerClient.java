package nl.ica.ddoa.namer;

public class NamerClient {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            NamerClient nc = new NamerClient();
            Namer namer = nc.getNamer();
            namer.parseName("Rody Middelkoop");
            System.out.println(namer.getFirstName());
            System.out.println(namer.getLastName());
        } catch (InvalidNameException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private Namer getNamer() {
        NamerFactory nf = NamerFactory.getInstance();
        return nf.getNamer("EN");
    }

}
