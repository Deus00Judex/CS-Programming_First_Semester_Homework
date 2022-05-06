import java.util.Set;

public class Launcher {


    public static void putEntries(WriteableMap<String,Integer> thisMap){
        thisMap.put("sizeInMB",Integer.valueOf(42));
        thisMap.put("version",Integer.valueOf(4));
        thisMap.put("yearOfRelease",Integer.valueOf(2015));
    }

    public static void printEntries(ReadableMap<String,Integer> thisMap) throws UnknownExeption {
        try {
            Set<String> lol=thisMap.keysAsSet();
            for(String key : lol){
                System.out.println(key+": "+ thisMap.getOrThrow(key));
            }
        }
        catch (UnknownExeption use){
            throw new UnknownExeption("Es gab einen Fehler in der Methode printEntries.");
        }

    }

    public static void main(String args[]) throws UnknownExeption {

        Entry<String,Integer>[] platzhalter=new Entry[0];
        MutableMap <String,Integer> map = new MutableMap<String,Integer> (platzhalter);
        putEntries(map);
        printEntries(map);
        ImmutableMap<String,Integer> immutable= map.asImmutableMap();
        printEntries(immutable);











    }
}
