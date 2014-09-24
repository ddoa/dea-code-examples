public class KoenenDictionaryAdapter implements DictionaryAdapter {
	
	private KoenenDictionary kd;
	
	public KoenenDictionaryAdapter(){
		kd = new KoenenDictionary();
		kd.openEnglishDutch();
		kd.openDutchEnglish();
	}

	public String getName() {
		return "Koenen";
	}

	public String translate(String word) {
		return kd.lookUp(word);
	}

}
