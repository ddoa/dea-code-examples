public class KramersDictionaryAdapter implements DictionaryAdapter
{
    private KramersDictionary kramersDictionary = new KramersDictionary();

    @Override
    public String getName()
    {
        return "Kramers";
    }

    @Override
    public String translate(String input)
    {
        return kramersDictionary.find(input);
    }
}
