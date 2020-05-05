package com.company;

public class CD extends Artikel {
    private String titel, interpret;
    private int anzahlTitel;
    public CD(int artikelNr, int bestand, double preis, String interpret, String titel, int anzahlTitel) {
        super(artikelNr, "Medien", bestand, preis);
        setInterpret(interpret);
        setTitel(titel);
        setAnzahlTitel(anzahlTitel);
    }

    public String getBezeichnung(){
        return interpret + " : " + titel;
    }

    public String getTitel() {
        return titel;
    }

    /**
     * Set-Methode fuer Titel
     * @param titel     darf nicht leer sein
     */
    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getInterpret() {
        return interpret;
    }

    /**
     * Set-Methode fuer Interpret
     * @param interpret     darf nicht leer sein
     */
    public void setInterpret(String interpret) {
        this.interpret = interpret;
    }

    public int getAnzahlTitel() {
        return anzahlTitel;
    }

    /**
     * Set-Methode fuer anzahlTitel
     * @param anzahlTitel   muss < 0 sein
     */
    public void setAnzahlTitel(int anzahlTitel) {
        this.anzahlTitel = anzahlTitel;
    }
}
