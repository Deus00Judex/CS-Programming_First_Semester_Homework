/**
 * Hier ist Aufgabenteil a)
 */
public class BooleanStringHelper {
    /**
     * @Author Daniel
     * @param compare Der zu Vergleichende Array
     * @param compareTo Der Char, mit dem verglichen wird
     * @return Der Boolean-Array, der zurückgegeben wird
     */
    public static boolean[] parse(String compare,char compareTo){
        boolean[] compareArray = new boolean[compare.length()];
        for(int i=0;i<compare.length();i++){
    //Vergleiche den String an der Stelle i mit dem übergebenen Char
            if(compare.charAt(i)==compareTo){compareArray[i]=true;}
            else if(compare.charAt(i)!=compareTo){compareArray[i]=false;}
        }
        return compareArray;
    }


    /**
     * @Author Daniel
     * @param trueFalseArray    Array mit boolean-Werten, der zu einem String gemacht werden soll
     * @param ifTrue Char, der geschrieben werden soll, falls trueFalseArray[i]==true
     * @param ifFalse Char, der geschrieben werden soll, falls trueFalseArray[i]==false
     * @return
     */
    public static String stringify(boolean[] trueFalseArray,char ifTrue,char ifFalse){
        int i=0;
        char [] rueckgabe=new char[trueFalseArray.length];
        for(boolean check : trueFalseArray){
            if(check){rueckgabe[i]=ifTrue;}
            if(!check){rueckgabe[i]=ifFalse;}
            i++;
        }
        String lol=new String(rueckgabe);
        return lol;

    }
}
