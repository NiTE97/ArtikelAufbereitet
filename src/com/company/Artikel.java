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

    public void bucheZugang(int menge) {
    }

    public void bucheAbgang(int menge) {
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

    public int getArtikelNr() {
        return artikelNr;
    }

    public void setArtikelNr(int artikelNr) {
        this.artikelNr = artikelNr;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public int getBestand() {
        return bestand;
    }

    public void setBestand(int bestand) {
        this.bestand = bestand;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }
}
