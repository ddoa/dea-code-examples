public class DictionaryAdapterFactory
{
	private static DictionaryAdapterFactory instance;

	private DictionaryAdapterFactory()
	{
	}
	
	public static DictionaryAdapterFactory getInstance()
	{
		if(instance == null)
			instance = new DictionaryAdapterFactory();
		return instance;
	}
	
	public DictionaryAdapter create(String name)
	{
		if("Koenen".equals(name))
			return new KoenenDictionaryAdapter();
		else if("Kramers".equals(name))
			return new KramersDictionaryAdapter();
        return null;
	}
}
