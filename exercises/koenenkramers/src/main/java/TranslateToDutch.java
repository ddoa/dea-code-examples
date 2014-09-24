public class TranslateToDutch {
	private DictionaryAdapterFactory daf = DictionaryAdapterFactory.getInstance();


    public static void main(String[] args) {
        TranslateToDutch translateToDutch = new TranslateToDutch();
        translateToDutch.translate();
    }

    public void translate() {
		String toTranslate = "goat";

        DictionaryAdapter koenen = daf.create("Koenen");
		DictionaryAdapter kramer = daf.create("Kramers");

        String translatedWord = koenen.translate(toTranslate);
        if (translatedWord != null) {
			System.out.println(translatedWord);
		} 
		else if(kramer.translate(toTranslate) != null){
			System.out.println(kramer.translate(toTranslate));
		} else {
			System.out.println("woord niet gevonden");
		}
	}
}
