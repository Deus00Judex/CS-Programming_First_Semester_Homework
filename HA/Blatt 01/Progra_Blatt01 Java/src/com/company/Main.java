package com.company;


public class Main {

    public static void main(String[] args) {
        double startbetrag= SimpleIO.getDouble("Geb hier deinen Startbetrag ein");
        double zinssatz= SimpleIO.getDouble("Geb hier deinen Zinssatz in % ein")*0.01;

        int ZielORZeit= SimpleIO.getInt("Wählen sie bitte 1, wenn sie nach einem Ziel berechnen möchten\nWählen sie bitte 0, wenn sie nach einer Zeit berechnen möchten");

        if (ZielORZeit==1){
            double zielbetrag= SimpleIO.getDouble("Geb hier deinen Zielbetrag ein");
            double aktuell = startbetrag;
            int zeit=0;
            while(startbetrag<zielbetrag){
                startbetrag=startbetrag*(1+zinssatz);
                zeit++;
            }
            SimpleIO.output("Es dauert "+zeit+" Jahre bei einem Zinssatz von "+zinssatz*100+"%, um von "+aktuell+"€ auf den Betrag "+zielbetrag+"€ zu sparen. Nach dieser Zeit hat man "+startbetrag+"€.");
        }
        if (ZielORZeit==0){
            int zeit= SimpleIO.getInt("Geb hier deine Zeitspanne in Jahren an ein");
            double steigerung= Math.pow(1+zinssatz,zeit);
            double wert = startbetrag*steigerung;
            SimpleIO.output("Bei einem Zinssatz von "+zinssatz*100+"% und einem Startbetrag von "+startbetrag+"€ hat man nach "+zeit+" Jahren "+wert+"€ gespart.");
        }
    }
}