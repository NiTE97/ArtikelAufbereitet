package com.company;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Dialog zum Testen der Klasse Lager
 *
 */
public class LagerDialog {

    //Klassenkonstanten
    private static final int ANLEGEN = 3;
    private static final int ENTFERNEN = 7;
    private static final int ZUGANG = 4;
    private static final int ABGANG = 5;
    private static final int PREIS = 6;
    private static final int LISTE = 8;
    private static final int LAGER = 1;
    private static final int LAGER2 = 2;
    private static final int BESTAND = 9;
    private static final int ENDE = 0;
    private final Scanner input = new Scanner(System.in);

    private Lager lager;

    /**
     * Hauptschleife des Testprogramms
     * Erst Testen ob bereits ein Lager angelegt ist, fall nicht 
     *      -> Lager anlegen Dialog
     *
     * Abfangen der Exceptions
     *
     */
    public void start() {
        int funktion = -1;
        while (funktion != ENDE) {
            if (lager == null)
            {
                lagerAnlegen();
            }else{
                try {
                    funktion = einlesenFunktion();
                    ausfuehrenFunktion(funktion);
                } catch (IllegalArgumentException e) {
                    System.out.println(e);
                } catch (InputMismatchException e) {
                    System.out.println("Falsche Eingabe.");
                    System.out.println("Bitte erneut eingeben!");
                    input.nextLine();
                } catch (Exception e) {
                    System.out.println("Ausnahme gefangen: " + e);
                }
            }
        }
    }

    /**
     * Main-Methode zum Erzeugen des Dialogobjektes und zum Starten des Dialogs
     *
     * @param args  Argumente der Main Methode
     */
    public static void main(String[] args) {
        new LagerDialog().start();
    }

    /**
     * Methode zum Ausgeben der Funktionen
     */
    private int einlesenFunktion() {
        System.out.print("+++Hauptmenü+++\n"
                + ANLEGEN + ": Neuen Artikel anlegen\n"
                + ZUGANG + ": Zugang buchen\n"
                + ABGANG + ": Abgang buchen\n"
                + PREIS + ": Preis aller Artikel aendern\n"
                + ENTFERNEN + ": Artikel aus dem Lager entfernen\n"
                + LISTE + ": Artikel anzeigen\n"
                + BESTAND + ": Bestandsliste anzeigen\n"
                + ENDE + ": Beenden ->");
        return input.nextInt();
    }

    /**
     * Methode zum Ausfuehren des Dialogfeldes
     * Cases fuer die verschiedenen Funktionen
     *
     * @param funktion  Funktion die ausgefuehrt werden soll
     */
    private void ausfuehrenFunktion(int funktion) {
        switch (funktion) {
            case ANLEGEN:
                artikelAuswahl();
                break;
            case ZUGANG:
                zugangBuchen();
                break;
            case ABGANG:
                abgangBuchen();
                break;
            case PREIS:
                preisAendern();
                break;
            case LISTE:
                System.out.println(lager.toString());
                break;
            case ENTFERNEN:
                artikelEntfernen();
                break;
            case BESTAND:
                System.out.println(lager.ausgebenBestandsListe());
                break;
            case ENDE:
                System.out.println("Programmende.\n");
                break;
            default:
                System.out.println("Funktion nicht vorhanden!");
                break;
        }
    }

    /**
     * Dialog der aufgerufen wird, wenn noch kein Lager angelegt wurde
     *
     *
     * Cases fuer verschiedene Konstruktoren
     */
    private void lagerAnlegen(){
        System.out.println("Wollen Sie ein Lager mit beliebiger Größe oder mit 10 Plätzen erstellen?\n"
                + LAGER + ": Beliebige Größe\n"
                + LAGER2 + ": 10 Plätze\n");
        int lagerFunktion = input.nextInt();
        input.nextLine();
        switch (lagerFunktion) {
            case LAGER:
                System.out.println("Geben Sie die Groesse des Lagers ein: ");
                int dim = input.nextInt();
                lager = new Lager(dim);
                System.out.println("Lager wurde angelegt!");
                break;
            case LAGER2:
                lager = new Lager();
                System.out.println("Lager wurde angelegt!");
                break;
        }
    }


    // Ausgelagerte Funktionen
    /**
     * Dialog fuer die Auswahl des Artikels der angelegt wird
     *
     * Cases fuer verschiedene Konstruktoren
     */
    private void artikelAuswahl(){
        final int BUCH = 1;
        final int CD = 2;
        final int VIDEO = 3;
        final int ARTIKEL = 4;
        final int ENDE = 0;
        System.out.println("Welche Art Artikel möchten Sie anlegen?\n" + "1: Buch\n" + "2: CD\n" + "3: Video\n" + "4: Artikel\n" + "5: Ende\n");
        int artikelArt = input.nextInt();
        input.nextLine();
        switch (artikelArt){
            case BUCH:
                buchAnlegen();
                break;
            case CD:
                cdAnlegen();
                break;
            case VIDEO:
                videoAnlegen();
                break;
            case ARTIKEL:
                artikelAnlegen();
                break;
            case ENDE:
                System.out.println("Gehe zurück zum Hauptmenu:\n");
                break;
            default:
                System.out.println("Funktion nicht vorhanden!");
                break;
        }
    }

    private void buchAnlegen() {
        int artikelNr, bestand;
        double preis;
        String autor, titel, verlag;
        System.out.println("Geben Sie die Artikelnr. des Buches an:");
        artikelNr = input.nextInt();
        input.nextLine();
        System.out.println("Geben Sie den Bestand des Buches an:");
        bestand = input.nextInt();
        input.nextLine();
        System.out.println("Geben Sie den Preis des Buches an:");
        preis = input.nextDouble();
        input.nextLine();
        System.out.println("Geben Sie den Autor des Buches an:");
        autor = input.nextLine();
        System.out.println("Geben Sie den Titel des Buches an:");
        titel = input.nextLine();
        System.out.println("Geben Sie den Verlag des Buches an:");
        verlag = input.nextLine();
        Artikel buch = new Buch (artikelNr, bestand, preis, autor, titel, verlag);
        lager.legeAnArtikel(buch);
        System.out.println("Artikel wurde angelegt!\n" + lager.toString());
    }

    private void cdAnlegen(){
        int artikelNr, bestand, anzTitel;
        double preis;
        String titel, interpret;
        System.out.println("Geben Sie die Artikelnr. der CD an:");
        artikelNr = input.nextInt();
        input.nextLine();
        System.out.println("Geben Sie den Bestand der CD an:");
        bestand = input.nextInt();
        input.nextLine();
        System.out.println("Geben Sie den Preis der CD an:");
        preis = input.nextDouble();
        input.nextLine();
        System.out.println("Geben Sie den Interpret der CD an:");
        interpret = input.nextLine();
        System.out.println("Geben Sie den Titel der CD an:");
        titel = input.nextLine();
        System.out.println("Geben Sie die Anzahl der Titel an:");
        anzTitel = input.nextInt();
        input.nextLine();
        Artikel cd = new CD (artikelNr, bestand, preis, interpret, titel, anzTitel);
        lager.legeAnArtikel(cd);
        System.out.println("Artikel wurde angelegt!\n" + lager.toString());
    }

    private void videoAnlegen(){
        int artikelNr, bestand, spieldauer, jahr;
        double preis;
        String titel;
        System.out.println("Geben Sie die Artikelnr. des Videos an:");
        artikelNr = input.nextInt();
        input.nextLine();
        System.out.println("Geben Sie den Bestand des Videos an:");
        bestand = input.nextInt();
        input.nextLine();
        System.out.println("Geben Sie den Preis des Videos an:");
        preis = input.nextDouble();
        input.nextLine();
        System.out.println("Geben Sie den Titel des Videos an:");
        titel = input.nextLine();
        System.out.println("Geben Sie die Spieldauer des Videos an:");
        spieldauer = input.nextInt();
        input.nextLine();
        System.out.println("Geben Sie das Jahr der Erscheinung an:");
        jahr = input.nextInt();
        input.nextLine();
        Artikel video = new Video(artikelNr, bestand, preis, titel, spieldauer, jahr);
        lager.legeAnArtikel(video);
        System.out.println("Artikel wurde angelegt!\n" + lager.toString());
    }

    private void artikelAnlegen(){
        int artikelNr, bestand;
        double preis;
        String bezeichnung;
        System.out.println("Wie möchten Sie den Artikel anlegen?\n1: Artikelnr, Bezeichnung, Bestand, Preis\n2: Artikelnr, Bezeichnung");
        int artikeltyp = input.nextInt();
        input.nextLine();
        if(artikeltyp == 1) {
            System.out.println("Geben Sie die Artikelnr. des Artikel an:");
            artikelNr = input.nextInt();
            input.nextLine();
            System.out.println("Geben Sie die Bezeichnung des Artikels an:");
            bezeichnung = input.nextLine();
            System.out.println("Geben Sie den Bestand des Artikels an:");
            bestand = input.nextInt();
            input.nextLine();
            System.out.println("Geben Sie den Preis des Artikels an:");
            preis = input.nextDouble();
            input.nextLine();
            Artikel artikel = new Artikel(artikelNr, bezeichnung, bestand, preis);
            lager.legeAnArtikel(artikel);
            System.out.println("Artikel wurde angelegt!\n" + lager.toString());
        }else if(artikeltyp == 2){
            System.out.println("Geben Sie die Artikelnr. des Artikel an:");
            artikelNr = input.nextInt();
            input.nextLine();
            System.out.println("Geben Sie die Bezeichnung des Artikels an:");
            bezeichnung = input.nextLine();
            Artikel artikel = new Artikel(artikelNr, bezeichnung);
            lager.legeAnArtikel(artikel);
            System.out.println("Artikel wurde angelegt!\n" + lager.toString());
        } else {
            System.out.println("Bitte wählen Sie eine der Möglichkeiten aus!");
            artikelAnlegen();
        }
    }

    private void zugangBuchen(){
        int menge, artikelNr;
        System.out.println("Geben Sie die Artikelnr. des Artikels ein: ");
        artikelNr = input.nextInt();
        input.nextLine();
        System.out.println("Geben Sie die zuzubuchende Menge ein: ");
        menge = input.nextInt();
        input.nextLine();
        lager.bucheZugang(artikelNr, menge);
        System.out.println("Menge wurde zugebucht!\n" + lager.toString());
    }

    private void abgangBuchen(){
        int artikelNr, menge;
        System.out.println("Geben Sie die Artikelnr. des Artikels ein: ");
        artikelNr = input.nextInt();
        input.nextLine();
        System.out.println("Geben Sie die abzubuchende Menge ein: ");
        menge = input.nextInt();
        input.nextLine();
        lager.bucheAbgang(artikelNr, menge);
        System.out.println("Menge wurde zugebucht!\n" + lager.toString());
    }

    private void preisAendern(){
        int prozent;
        System.out.println("Geben Sie den Prozentsatz ein, um den die Preise geaendert werden sollen: ");
        prozent = input.nextInt();
        lager.aenderePreisAllerArtikel(prozent);
        System.out.println("Preise wurden aktualisiert!\n" + lager.toString());
    }

    private void artikelEntfernen() {
        System.out.println("Geben Sie die Artikelnr. des zu loeschenden Artikels ein: ");
        int artikelnr = input.nextInt();
        input.nextLine();
        lager.entferneArtikel(artikelnr);
        System.out.println("Artikel wurde entfernt!" + lager.toString());
    }

}