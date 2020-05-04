package com.company;

public class Artikel {
    private int artikelNr;
    private String bezeichnung;
    private int bestand;
    private double preis;

    public Artikel(int artikelNr, String bezeichnung, int bestand, double preis) {
        this.artikelNr = artikelNr;
        this.bezeichnung = bezeichnung;
        this.bestand = bestand;
        this.preis = preis;
    }

    public Artikel(int artikelNr, String bezeichnung) {
        this.artikelNr = artikelNr;
        this.bezeichnung = bezeichnung;
    }

    /**
     * Methode zum Buchen von Zugang
     * @param menge muss positiv sein
     *              bestand darf nicht < 0 sein
     */
    public void bucheZugang(int menge) {
        bestand +=  menge;
    }
    /**
     * Methode zum Buchen von Abgang
     * @param menge muss positiv sein
     *              bestand darf nicht < 0 sein
     */
    public void bucheAbgang(int menge) {
        bestand -= menge;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Artikel{");
        sb.append("artikelNr=").append(artikelNr);
        sb.append(", bezeichnung='").append(bezeichnung).append('\'');
        sb.append(", bestand=").append(bestand);
        sb.append(", preis=").append(preis);
        sb.append('}');
        return sb.toString();
    }

    public String getBeschreibung(){
        return bezeichnung;
    }

    public int getArtikelNr() {
        return artikelNr;
    }

    /**
     * Set-Methode fuer Artikelnr
     * @param artikelNr muss 4-stellig sein
     */
    public void setArtikelNr(int artikelNr) {
        this.artikelNr = artikelNr;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Set-Methode fuer Bezeichnung
     * @param bezeichnung   darf nicht leer sein
     */
    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public int getBestand() {
        return bestand;
    }

    /**
     * Set-Methode fuer Bestand
     * @param bestand   darf nicht < 0 sein
     */
    public void setBestand(int bestand) {
        this.bestand = bestand;
    }

    public double getPreis() {
        return preis;
    }

    /**
     * Set-Methode fuer Preis
     * @param preis     darf nicht <= 0 sein
     */
    public void setPreis(double preis) {
        this.preis = preis;
    }
}
