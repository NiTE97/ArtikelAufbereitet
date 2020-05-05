package com.company;

public class Video extends Artikel{
    private String titel;
    private int spieldauer, jahr;
    public Video(int artikelNr, int bestand, double preis, String titel, int spieldauer, int jahr) {
        super(artikelNr, "Medien", bestand, preis);
        setTitel(titel);
        setSpieldauer(spieldauer);
        setJahr(jahr);
    }

    public String getBezeichnung(){
        return getTitel();
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

    public int getSpieldauer() {
        return spieldauer;
    }

    /**
     * Set-Methode fuer Spieldauer
     * @param spieldauer    muss > 0 sein
     */
    public void setSpieldauer(int spieldauer) {
        this.spieldauer = spieldauer;
    }

    public int getJahr() {
        return jahr;
    }

    /**
     * Set-Methode fuer Jahr
     * @param jahr  muss zwischen 1950 und 2020 liegen
     */
    public void setJahr(int jahr) {
        this.jahr = jahr;
    }
}
