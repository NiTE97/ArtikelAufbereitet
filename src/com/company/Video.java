package com.company;

public class Video extends Artikel{
    private String titel;
    private final int spieldauer, jahr;
    private static final String MSG_TITEL = "Der Titel darf nicht leer sein!";
    private static final String MSG_SPIELDAUER = "Die Spieldauer darf nicht kleiner oder gleich 0 sein!";
    private static final String MSG_JAHR = "Das Jahr darf nicht in der Zukunft sein!";

    /**
     * Konstruktor der Klasse Video
     *      Greift auf super zu
     *
     * @param artikelNr     Muss 4-stellig sein
     * @param bestand       Darf nicht negativ sein
     * @param preis         Darf nicht negativ sein
     * @param titel         Darf nicht leer sein
     * @param spieldauer    Darf nicht negativ oder 0 sein
     * @param jahr          Darf nicht in der Zukunft liegen
     */
    public Video(int artikelNr, int bestand, double preis, String titel, int spieldauer, int jahr) {
        super(artikelNr, "Medien", bestand, preis);
        Validator.check(spieldauer <= 0, MSG_SPIELDAUER);
        Validator.check(jahr > 2020, MSG_JAHR);
        setTitel(titel);
        this.spieldauer = spieldauer;
        this.jahr = jahr;
    }

    /**
     * get-Methode zum Ausgeben der Beschreibung
     *      Ueberschreibt in Artikel
     * @return      String Beschreibung<br>
     *                      -> Titel
     */
    @Override
    public String getBeschreibung(){
        return getTitel();
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
     * get-Methode fuer Titel
     * @return  String Titel
     */
    public String getTitel() {
        return titel;
    }

    /**
     * get-Methode fuer Spieldauer
     * @return  int Spieldauer
     */
    public int getSpieldauer() {
        return spieldauer;
    }

    /**
     * get-Methode fuer Jahr
     * @return  int Jahr
     */
    public int getJahr() {
        return jahr;
    }
}
