/**
 * @Author Daniel
 * Ab hier ist Aufgabenteil b)
 */



public class Product {
    String name;
    boolean[] regional=new boolean[12];
    boolean[] importWare=new boolean[12];
    String StringRegional;
    String StringImportWare;

    /**
     * @Author Daniel
     * @param name gibt den Namen des Produktes an
     * @param regional Ein Array der für jeden Monat angibt, ob das Produkt regional verfügbar ist
     * @param importWare Ein Array, der für jeden Monat angibt, ob das Produkt als Import verfügbar ist
     */
    public Product(String name,boolean[] regional,boolean[]importWare){
        this.name=name;
        this.importWare=importWare;
        this.regional=regional;
    }

    /**
     *
     * @param name String, der den Namen des Produktes festlegt
     * @param StringRegional Ein String aus {0,1}^* der konvertiert werden kann, und angibt, in welchem Monat ein Produkt regional verfügbar ist
     * @param StringImportWare Ein String aus {0,1}^* der konvertiert werden kann, und angibt, in welchem Monat ein Produkt als Import verfügbar ist
     */
    public Product(String name,String StringRegional,String StringImportWare){
        this.name=name;
        this.regional=BooleanStringHelper.parse(StringRegional, (char)'1');
        this.importWare=BooleanStringHelper.parse(StringImportWare, (char)'1');
    }

//Getter

    /**
     * @return diese Methode gibt den Namen des Objektes zurück, mit dem sie aufgerufen wurde
     */
    private String getName() {return name;}

    /**
     * @return Diese Methode gibt einen String zurück, der aus einem Boolean-Array einen String zur regionalen Verfügbarkeit des aufrufenden Produktes macht.
     */
    public String stringifyIsRegional(){
        return BooleanStringHelper.stringify(this.regional,'R',' ');
        }

    /**
     * @return Diese Methode gibt einen String zurück, der angiebt, in welchem Monat das aufrufende Produkt zum Import verfügbar ist.
     */
    public String stringifyIsImported(){
        return BooleanStringHelper.stringify(this.importWare,'I',' ');
    }



}
