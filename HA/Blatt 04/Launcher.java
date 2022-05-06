/**
 * Aufgabenteil d)
 * In den einzelnen Array-Feldern werden die Produkte mit 3 Strings für Name, regionale Verfügbarkeit und Verfügbarkeit als ImportProdukt erzeugt
 * Dieser Array wird anschließend dem neuen Objekt der Klasse SeasonalCalender übergeben
 * Dieser gibt über seine Methode stringify eine Übersicht zurück, welches Produkt wann regional oder als Import verfügbar ist
 */
public class Launcher {
    public static void main(String[] args) {
        //Initialisierung und Befuellung des Arrays
        Product[] productArray = new Product[6];

        productArray[0] = new Product("Apfel", "111111001111", "111111111111");
        productArray[1] = new Product("Banane", "000000000000", "111111111111");
        productArray[2] = new Product("Erdbeere", "000011100000", "000110000000");
        productArray[3] = new Product("Blumenkohl", "000001111100", "111100000011");
        productArray[4] = new Product("Feldsalat", "1000011001111", "111100001111");
        productArray[5] = new Product("Zwiebel", "111110011111", "001111100000");

        //Neues Objekt vom Typ SeasonalCalendar wird erstellt, dem als Konstruktor der eben erstellte Array übergeben wird
        SeasonalCalender userCalender = new SeasonalCalender(productArray);


        System.out.println(userCalender.stringify());
    }
}
