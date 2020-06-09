package com.company;

public class Buch extends Artikel {
    private String autor;
    private String titel;
    private String verlag;
    private static final String MSG_AUTOR = "Der Autor darf nicht leer sein!";
    private static final String MSG_TITEL = "Der Titel darf nicht leer sein!";
    private static final String MSG_VERLAG = "Der Verlag darf nicht leer sein!";

    /**
     * Konstruktor der Klasse Buch
     *      Greift auf super zu
     * @param artikelNr     Muss 4-stellig sein
     * @param bestand       Darf nicht negativ sein
     * @param preis         Darf nicht negativ sein
     * @param autor         Darf nicht leer sein
     * @param titel         Darf nicht leer sein
     * @param verlag        Darf nicht leer sein
     */
    public Buch(int artikelNr, int bestand, double preis, String autor, String titel, String verlag) {
        super(artikelNr, "Medien", bestand, preis);
        setAutor(autor);
        setTitel(titel);
        setVerlag(verlag);
    }

    /**
     * get-Methode fuer Beschreibung
     *      Autor : Titel
     * @return      Autor : Titel des Buches
     */
    @Override
    public String getBeschreibung(){
        return getAutor() + " : " + getTitel();
    }


    /**
     * get-Methode fuer Autor
     * @return      String Autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Set-Methode fuer Autor
     * @param autor     darf nicht leer sein
     */
    public void setAutor(String autor) {
        Validator.check(autor == null || autor.trim().isEmpty(), MSG_AUTOR);
        this.autor = autor;
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
     * Set-Methode fuer Verlag
     * @param verlag    darf nicht leer sein
     */
    public void setVerlag(String verlag) {
        Validator.check(verlag == null || verlag.trim().isEmpty(), MSG_VERLAG);
        this.verlag = verlag;
    }

    /**
     * get-Methode fuer Verlag
     * @return      String Verlag
     */
    public String getVerlag() {
        return verlag;
    }
}
