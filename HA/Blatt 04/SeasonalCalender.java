/**
 * Ab hier ist Aufgabenteil c)
 */
public class SeasonalCalender {
    Product[] productArray;

//Konstruktor
    public SeasonalCalender(Product[] productArray){
        this.productArray=productArray;
    }

    /**
     * @return Diese Methode gibt die Laenge des laengsten Namens zurück(als int-Wert)
     */
    private int getLongestProductName(){
        int longestName=0;
        for (Product productInProductArray : this.productArray){
            if (productInProductArray.name.length()>longestName){longestName=productInProductArray.name.length();}
        }
    return longestName;
    }

    /**
     * @param gewuenschteLaenge Dieser int gibt an, wie lang der Rueckgabewert sein soll (wieviele Zeichen der String haben wird)
     * @param gewuenschterPlatzhalter   Dieser Char wird genutzt, um den Array auf die gewuenschte Laenge zu bringen, indem er eventuell mehrfach hinten an den EingabeString angehangen wird
     * @param eingabeString Dieser String wird bearbeitet und mithilfe des Platzhalters auf die gewuenschte Laenge gbracht
     * @return
     */
    private String pad(int gewuenschteLaenge, char gewuenschterPlatzhalter,String eingabeString){
        int unterlaenge=eingabeString.length()-gewuenschteLaenge;
        while(unterlaenge<0){
            eingabeString=eingabeString+gewuenschterPlatzhalter;
            unterlaenge++;
        }
        return eingabeString;
    }

    /**
     * @return Diese Methode gibt einen String zurueck, der fuer jedes Produkt in dem Kalender angibt, in welchen Monaten es regional oder als Import verfuegbar ist
     */
    public String stringify(){
        int laengsterName=getLongestProductName();
        String tmp=new String();
        for (int i=0;i<getLongestProductName();i++){tmp=tmp+' ';}
        String firstLine=tmp+"JFMAMJJASOND";
        for(Product product : productArray){firstLine=firstLine+System.lineSeparator()+pad(laengsterName,' ',product.name)+product.stringifyIsRegional()+System.lineSeparator()+tmp+product.stringifyIsImported();}

        return firstLine;
    }

}
