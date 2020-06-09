package com.company;

public class Artikel {
    private final int artikelNr;
    private String bezeichnung;
    private int bestand;
    private double preis;

    private static final String MSG_ARTIKELNR = "Die Artikelnummer muss 4-stellig und positiv sein!";
    private static final String MSG_BEZEICHNUNG = "Die Bezeichnung darf nicht leer sein!";
    private static final String MSG_BESTAND = "Der Bestand darf nicht negativ sein!";
    private static final String MSG_PREIS = "Der Preis darf nicht kleiner oder gleich 0 sein!";
    private static final String MSG_MENGE = "Die Menge darf nicht kleiner als 0 sein!";


    /**
     * Konstruktor der Klasse Artikel
     * @param artikelNr     Muss 4-stellig sein
     * @param bezeichnung   Darf nicht leer sein
     * @param bestand       Darf nicht negativ sein
     * @param preis         Darf nicht negativ sein
     */
    public Artikel(int artikelNr, String bezeichnung, int bestand, double preis) {
        Validator.check(artikelNr >= 10000 || artikelNr <= 999, MSG_ARTIKELNR);
        Validator.check(bestand < 0, MSG_BESTAND);
        Validator.check(preis <= 0, MSG_PREIS);
        this.artikelNr = artikelNr;
        setBezeichnung(bezeichnung);
        this.bestand = bestand;
        this.preis = preis;
    }

    /**
     * Konstruktor der Klasse Artikel
     * @param artikelNr     Muss 4-stellig sein
     * @param bezeichnung   Darf nicht leer sein
     */
    public Artikel(int artikelNr, String bezeichnung) {
        Validator.check(artikelNr >= 10000 || artikelNr <= 999, MSG_ARTIKELNR);
        this.artikelNr = artikelNr;
        setBezeichnung(bezeichnung);
    }

    /**
     * Methode zum Buchen von Zugang
     *
     * @param menge     Muss positiv sein
     */
    public void bucheZugang(int menge) {
        Validator.check(menge < 0, MSG_MENGE);
        bestand += menge;
    }

    /**
     * Methode zum Buchen von Abgang
     *
     * @param menge     Muss positiv sein
     *                  Bestand darf nicht < 0 sein
     */
    public void bucheAbgang(int menge) {
        Validator.check(menge < 0, MSG_MENGE);
        Validator.check(menge > bestand, MSG_BESTAND);
        bestand -= menge;
    }

    /**
     * toString Methode fuer Artikel
     * @return  String des Artikels
     */
    @Override
    public String toString() {
        return "Artikelnr = " + getArtikelNr() +
                ", Bezeichnung = '" + getBezeichnung() + '\'' +
                ", Bestand = " + getBestand() +
                ", Preis = " + getPreis() + "\n";
    }

    /**
     * get-Methode fuer Artikelnr
     * @return      Artikelnr
     */
    public int getArtikelNr() {
        return artikelNr;
    }

    /**
     * get-Methode fuer Bezeichnung
     * @return      Bezeichnung
     */
    public String getBezeichnung() {
        return bezeichnung;
    }

    /**
     * get-Methode fuer Beschreibung
     * @return      Beschreibung
     *
     * wird von Buch, CD, Video ueberschrieben
     */
    public String getBeschreibung(){
        if (getBezeichnung().equals("Medien")) {
            return null;
        } else {
            return bezeichnung;
        }
    }

    /**
     * Methode zum Aendern des Preises mittels Prozentsatz
     * @param prozent   Prozentsatz der verarbeitet wird
     * @return          Den Artikel
     */
    public Artikel aenderePreis(double prozent){
        Validator.check(prozent < -100, MSG_PREIS);
        Artikel artikel = new Artikel(getArtikelNr(), getBezeichnung(), getBestand(), getPreis());
        double preis  = getPreis();
        preis += preis * prozent / 100;
        setPreis(preis);
        return artikel;
    }

    /**
     * Set-Methode fuer Bezeichnung
     *
     * @param bezeichnung darf nicht leer sein
     */
    public void setBezeichnung(String bezeichnung) {
        Validator.check(bezeichnung == null || bezeichnung.trim().isEmpty(), MSG_BEZEICHNUNG);
        this.bezeichnung = bezeichnung;
    }

    /**
     * get-Methode fuer Bestand
     * @return      Bestand
     */
    public int getBestand() {
        return bestand;
    }

    /**
     * get-Methode fuer Preis
     * @return      Preis
     */
    public double getPreis() {
        return preis;
    }


    /**
     * set-Methode fuer Preis
     * @param preis     Darf nicht kleiner 0 sein
     */
    public void setPreis(double preis){
        Validator.check(preis < 0, MSG_PREIS);
        this.preis = preis;
    }

    /**
     * get-Methode zum Errechnen des Gesamtwertes
     *      Bestand * Preis
     * @return      Gesamtwert
     */
    public double getGesamt(){
        return bestand * preis;
    }
}
