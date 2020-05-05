package com.company;

public class Buch extends Artikel {
    private String autor, titel, verlag;
    public Buch(int artikelNr, int bestand, double preis, String autor, String titel, String verlag) {
        super(artikelNr, "Medien", bestand, preis);
        setAutor(autor);
        setTitel(titel);
        setVerlag(verlag);
    }

    public String getBezeichnung(){
        return autor + " : " + titel;
    }

    public String getAutor() {
        return autor;
    }

    /**
     * Set-Methode fuer Autor
     * @param autor     darf nicht leer sein
     */
    public void setAutor(String autor) {
        this.autor = autor;
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

    public String getVerlag() {
        return verlag;
    }

    /**
     * Set-Methode fuer Verlag
     * @param verlag    darf nicht leer sein
     */
    public void setVerlag(String verlag) {
        this.verlag = verlag;
    }
}
