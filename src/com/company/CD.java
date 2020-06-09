package com.company;

public class CD extends Artikel {
    private String titel, interpret;
    private final int anzahlTitel;
    private static final String MSG_INTERPRET = "Der Interpret darf nicht leer sein!";
    private static final String MSG_TITEL = "Der Titel darf nicht leer sein!";
    private static final String MSG_ANZAHLTITEL = "Die Anzahl der Titel darf nicht kleiner oder gleich 0 sein!";

    /**
     * Konstruktor der Klasse CD
     *      Greift auf super zu
     * @param artikelNr     Muss 4-stellig sein
     * @param bestand       Darf nicht negativ sein
     * @param preis         Darf nicht negativ sein
     * @param interpret     Darf nicht leer sein
     * @param titel         Darf nicht leer sein
     * @param anzahlTitel   Darf nicht negativ oder 0 sein
     */
    public CD(int artikelNr, int bestand, double preis, String interpret, String titel, int anzahlTitel) {
        super(artikelNr, "Medien", bestand, preis);
        Validator.check(anzahlTitel <= 0, MSG_ANZAHLTITEL);
        setInterpret(interpret);
        setTitel(titel);
        this.anzahlTitel = anzahlTitel;
    }

    /**
     * get-Methode fuer Beschreibung
     *      Interpret : Titel
     *
     *      Ueberschreibt Methode in Artikel
     * @return      String Bezeichnung
     */
    @Override
    public String getBeschreibung(){
        return getInterpret() + " : " + getTitel();
    }

    /**
     * get-Methode fuer Titel
     * @return      String Titel
     */
    public String getTitel() {
        return titel;
    }

    /**
     * Set-Methode fuer Titel
     * @param titel     darf nicht leer sein
     */
    public void setTitel(String titel) {
        Validator.check(titel == null || titel.trim().isEmpty(), MSG_TITEL);
        this.titel = titel;
    }

    /**
     * get-Methode fuer Interpret
     * @return      String Interpret
     */
    public String getInterpret() {
        return interpret;
    }

    /**
     * Set-Methode fuer Interpret
     * @param interpret     darf nicht leer sein
     */
    public void setInterpret(String interpret) {
        Validator.check(interpret == null || interpret.trim().isEmpty(), MSG_INTERPRET);
        this.interpret = interpret;
    }

    /**
     * get-Methode fuer AnzahlTitel
     * @return      int AnzahlTitel
     */
    public int getAnzahlTitel() {
        return anzahlTitel;
    }
}
