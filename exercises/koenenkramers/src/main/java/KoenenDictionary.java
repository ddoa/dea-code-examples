import java.util.Hashtable;

public class KoenenDictionary {
  private Hashtable words;

  /**
   * Creates an empty dictionary
   */
  public KoenenDictionary() {
    words = new Hashtable();
  }

  /**
   * Adds English-Dutch word pairs to dictionary
   */
  public void openEnglishDutch() {
    words.put("aeroplane", "vliegtuig");
    words.put("bicycle", "fiets");
    words.put("bird", "vogel");
    words.put("boat", "boot");
    words.put("car", "auto");
    words.put("cat", "kat");
    words.put("chicken", "kip");
    words.put("cow", "koe");
    words.put("dog", "hond");
    words.put("donkey", "ezel");
    words.put("elephant", "olifant");
    words.put("fish", "vis");
    words.put("fly", "vlieg");
    words.put("fox", "vos");
    words.put("horse", "paard");
    words.put("lion", "leeuw");
    words.put("rabbit", "konijn");
    words.put("monkey", "aap");
    words.put("mouse", "muis");
    words.put("pig", "varken");
    words.put("shark", "haai");
    words.put("sheep", "schaap");
    words.put("snake", "slang");
    words.put("tiger", "tijger");
    words.put("train", "trein");
    words.put("whale", "walvis");
  }

  /**
   * Adds Dutch-English word pairs to dictionary
   */
  public void openDutchEnglish() {
    words.put("aap", "monkey");
    words.put("auto", "car");
    words.put("boot", "boat");
    words.put("ezel", "donkey");
    words.put("fiets", "bicycle");
    words.put("haai", "shark");
    words.put("hond", "dog");
    words.put("kat", "cat");
    words.put("kip", "chicken");
    words.put("koe", "cow");
    words.put("konijn", "rabbit");
    words.put("leeuw", "lion");
    words.put("muis", "mouse");
    words.put("olifant", "elephant");
    words.put("paard", "horse");
    words.put("schaap", "sheep");
    words.put("slang", "snake");
    words.put("tijger", "tiger");
    words.put("trein", "train");
    words.put("varken", "pig");
    words.put("vis", "fish");
    words.put("vlieg", "fly");
    words.put("vliegtuig", "aeroplane");
    words.put("vogel", "bird");
    words.put("vos", "fox");
    words.put("walvis", "whale");
  }

  /**
   * Looks the word up in the dictionary and returns its translation
   *
   * @param word  the word that will be searched in the dictionary
   * @return      the translation of the word or null if the word is not found
   */
  public String lookUp(String word) {
    return (String)(words.get(word));
  }
}
