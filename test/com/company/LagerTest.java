package com.company;

import org.junit.Test;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.Assert.*;

public class LagerTest {

    //Konstruktor Tests
    @Test (expected = IllegalArgumentException.class)
    public void KonstruktorTestSizeNull(){
        Lager lager = new Lager(0);
        lager.ausgebenBestandsListe();
    }

    @Test (expected = IllegalArgumentException.class)
    public void KonstruktorTestSizeNegativ(){
        Lager lager = new Lager(-1);
        lager.ausgebenBestandsListe();
    }

    //Methoden Tests
    @Test
    public void legeAnArtikelTest1(){
        Lager lager = new Lager (2);
        Artikel artikel1 = new Artikel(1234, "Hund", 10, 10);
        Artikel artikel2 = new Artikel(1235, "Katze", 10, 10);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        Artikel actual = lager.getArtikel(1);
        assertEquals(artikel2, actual);
    }

    @Test (expected = IllegalArgumentException.class)
    public void legeAnArtikelTestZuViele(){
        Lager lager = new Lager (1);
        Artikel artikel1 = new Artikel(1234, "Hund", 10, 10);
        Artikel artikel2 = new Artikel(1235, "Katze", 10, 10);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        Artikel actual = lager.getArtikel(1);
        assertEquals(artikel2, actual);
    }

    @Test (expected = IllegalArgumentException.class)
    public void legeAnArtikelTestDoppelteNr(){
        Lager lager = new Lager (1);
        Artikel artikel1 = new Artikel(1234, "Hund", 10, 10);
        Artikel artikel2 = new Artikel(1234, "Katze", 10, 10);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        Artikel actual = lager.getArtikel(1);
        assertEquals(artikel2, actual);
    }

    @Test
    public void entferneArtikelTest1(){
        Lager lager = new Lager (2);
        Artikel artikel1 = new Artikel(1234, "Hund", 10, 10);
        Artikel artikel2 = new Artikel(1235, "Katze", 10, 10);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.entferneArtikel(1234);
        Artikel actual = lager.getArtikel(0);
        assertEquals(artikel2, actual);
    }

    @Test (expected = IllegalArgumentException.class)
    public void entferneArtikelTestNichtGefunden(){
        Lager lager = new Lager (2);
        Artikel artikel1 = new Artikel(1234, "Hund", 10, 10);
        Artikel artikel2 = new Artikel(1235, "Katze", 10, 10);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.entferneArtikel(1236);
        Artikel actual = lager.getArtikel(0);
        assertEquals(artikel2, actual);
    }

    @Test (expected = IllegalArgumentException.class)
    public void entferneArtikelTestArtikelNrZuKlein(){
        Lager lager = new Lager (2);
        Artikel artikel1 = new Artikel(1234, "Hund", 10, 10);
        Artikel artikel2 = new Artikel(1235, "Katze", 10, 10);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.entferneArtikel(123);
        Artikel actual = lager.getArtikel(0);
        assertEquals(artikel2, actual);
    }

    @Test
    public void bucheZugangTest1(){
        Lager lager = new Lager (2);
        Artikel artikel1 = new Artikel(1234, "Hund", 10, 10);
        Artikel artikel2 = new Artikel(1235, "Katze", 10, 10);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.bucheZugang(1234, 10);
        int actual = lager.getArtikel(0).getBestand();
        int expected = 20;
        assertEquals(expected, actual);
    }

    @Test
    public void bucheZugangTest2(){
        Lager lager = new Lager (2);
        Artikel artikel1 = new Artikel(1234, "Hund", 10, 10);
        Artikel artikel2 = new Artikel(1235, "Katze", 10, 10);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.bucheZugang(1235, 10);
        int actual = lager.getArtikel(1).getBestand();
        int expected = 20;
        assertEquals(expected, actual);
    }

    @Test (expected = IllegalArgumentException.class)
    public void bucheZugangTestNegativ(){
        Lager lager = new Lager (2);
        Artikel artikel1 = new Artikel(1234, "Hund", 10, 10);
        Artikel artikel2 = new Artikel(1235, "Katze", 10, 10);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.bucheZugang(1235, -1);
        int actual = lager.getArtikel(1).getBestand();
        int expected = 20;
        assertEquals(expected, actual);
    }

    @Test (expected = IllegalArgumentException.class)
    public void bucheZugangTestArtikelNrFalsch(){
        Lager lager = new Lager (2);
        Artikel artikel1 = new Artikel(1234, "Hund", 10, 10);
        Artikel artikel2 = new Artikel(1235, "Katze", 10, 10);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.bucheZugang(1236, 10);
        int actual = lager.getArtikel(1).getBestand();
        int expected = 20;
        assertEquals(expected, actual);
    }

    @Test
    public void bucheAbgangTest1(){
        Lager lager = new Lager (2);
        Artikel artikel1 = new Artikel(1234, "Hund", 10, 10);
        Artikel artikel2 = new Artikel(1235, "Katze", 10, 10);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.bucheAbgang(1234, 10);
        int actual = lager.getArtikel(0).getBestand();
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void bucheAbgangTest2(){
        Lager lager = new Lager (2);
        Artikel artikel1 = new Artikel(1234, "Hund", 10, 10);
        Artikel artikel2 = new Artikel(1235, "Katze", 10, 10);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.bucheAbgang(1235, 10);
        int actual = lager.getArtikel(1).getBestand();
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test (expected = IllegalArgumentException.class)
    public void bucheAbgangTestNegativ(){
        Lager lager = new Lager (2);
        Artikel artikel1 = new Artikel(1234, "Hund", 10, 10);
        Artikel artikel2 = new Artikel(1235, "Katze", 10, 10);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.bucheAbgang(1235, -1);
        int actual = lager.getArtikel(1).getBestand();
        int expected = 20;
        assertEquals(expected, actual);
    }

    @Test (expected = IllegalArgumentException.class)
    public void bucheAbgangTestArtikelNrFalsch(){
        Lager lager = new Lager (2);
        Artikel artikel1 = new Artikel(1234, "Hund", 10, 10);
        Artikel artikel2 = new Artikel(1235, "Katze", 10, 10);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.bucheAbgang(1236, 10);
        int actual = lager.getArtikel(1).getBestand();
        int expected = 20;
        assertEquals(expected, actual);
    }

    @Test
    public void aenderePreisAllerArtikelTest1(){
        Lager lager = new Lager (2);
        Artikel artikel1 = new Artikel(1234, "Hund", 10, 10);
        Artikel artikel2 = new Artikel(1235, "Katze", 10, 10);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.aenderePreisAllerArtikel(10);
        double actual = lager.getArtikel(0).getPreis();
        double expected = 11;
        assertEquals(expected, actual, 0.001);
    }

    @Test (expected = IllegalArgumentException.class)
    public void aenderePreisAllerArtikelTestUnterNull(){
        Lager lager = new Lager (2);
        Artikel artikel1 = new Artikel(1234, "Hund", 10, 10);
        Artikel artikel2 = new Artikel(1235, "Katze", 10, 10);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.aenderePreisAllerArtikel(-101);
        double actual = lager.getArtikel(0).getPreis();
        double expected = 11;
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void getArtikelTest1(){
        Lager lager = new Lager (2);
        Artikel artikel1 = new Artikel(1234, "Hund", 10, 10);
        Artikel artikel2 = new Artikel(1235, "Katze", 10, 10);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        Artikel actual = lager.getArtikel(0);
        assertEquals(artikel1, actual);
    }

    @Test (expected = IllegalArgumentException.class)
    public void getArtikelTestNichtVorhanden(){
        Lager lager = new Lager (2);
        Artikel artikel1 = new Artikel(1234, "Hund", 10, 10);
        Artikel artikel2 = new Artikel(1235, "Katze", 10, 10);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        Artikel actual = lager.getArtikel(3);
        assertEquals(artikel1, actual);
    }

    @Test (expected = IllegalArgumentException.class)
    public void getArtikelTestNegativ(){
        Lager lager = new Lager (2);
        Artikel artikel1 = new Artikel(1234, "Hund", 10, 10);
        Artikel artikel2 = new Artikel(1235, "Katze", 10, 10);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        Artikel actual = lager.getArtikel(-1);
        assertEquals(artikel1, actual);
    }

    @Test
    public void toStringTest(){
        Lager lager = new Lager (2);
        Artikel artikel1 = new Artikel(1234, "Hund", 10, 10);
        Artikel artikel2 = new Artikel(1235, "Katze", 10, 10);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        String expected = "Artikelnr = 1234, Bezeichnung = 'Hund', Bestand = 10, Preis = 10.0\nArtikelnr = 1235, Bezeichnung = 'Katze', Bestand = 10, Preis = 10.0\n";
        String actual = lager.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void getArtikelAnzahlTest(){
        Lager lager = new Lager (2);
        Artikel artikel1 = new Artikel(1234, "Hund", 10, 10);
        Artikel artikel2 = new Artikel(1235, "Katze", 10, 10);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        int expected = 2;
        int actual = lager.getArtikelAnzahl();
        assertEquals(expected, actual);
    }

    @Test
    public void getLagerGroesseTest(){
        Lager lager = new Lager (8);
        Artikel artikel1 = new Artikel(1234, "Hund", 10, 10);
        Artikel artikel2 = new Artikel(1235, "Katze", 10, 10);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        int expected = 8;
        int actual = lager.getLagerGroesse();
        assertEquals(expected, actual);
    }

    @Test
    public void bestandslisteTest(){
        Lager lager = new Lager (8);
        Artikel artikel1 = new Artikel(1234, "Hund", 10, 10);
        Artikel artikel2 = new Artikel(1235, "Katze", 10, 10);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.ausgebenBestandsListe();
    }

    @Test
    public void getSortedTest1(){
        Lager lager = new Lager (8);
        Artikel artikel1 = new Artikel(1234, "Katze", 10, 10);
        Artikel artikel2 = new Artikel(1235, "Hund", 10, 10);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        BiPredicate<Artikel, Artikel> alphabetPredicate = (artikelx, artikely) -> artikelx.getBezeichnung().compareTo(artikely.getBezeichnung()) > 0;
        Artikel [] liste = lager.getSorted(alphabetPredicate);
        Artikel actual = liste[0];
        assertEquals(actual, artikel2);
    }

    @Test
    public void getSortedTest2(){
        Lager lager = new Lager (8);
        Artikel artikel1 = new Artikel(1234, "Katze", 10, 10);
        Artikel artikel2 = new Artikel(1235, "Hund", 10, 10);
        Artikel artikel3 = new Artikel(1236, "Artikel", 10, 10);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.legeAnArtikel(artikel3);
        BiPredicate<Artikel, Artikel> alphabetPredicate = (artikelx, artikely) -> artikelx.getBezeichnung().compareTo(artikely.getBezeichnung()) > 0;
        Artikel [] liste = lager.getSorted(alphabetPredicate);
        Artikel actual = liste[0];
        assertEquals(actual, artikel3);
    }

    @Test
    public void getSortedTest3(){
        Lager lager = new Lager (8);
        Artikel artikel1 = new Artikel(1234, "Katze", 10, 10);
        Artikel artikel2 = new Artikel(1235, "Hund", 5, 10);
        Artikel artikel3 = new Artikel(1236, "Artikel", 20, 10);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.legeAnArtikel(artikel3);
        BiPredicate<Artikel, Artikel> bestandPredicate = (artikelx, artikely) -> artikelx.getBestand() > (artikely.getBestand());
        Artikel [] liste = lager.getSorted(bestandPredicate);
        Artikel actual = liste[0];
        assertEquals(actual, artikel2);
    }

    @Test
    public void getSortedTest4(){
        Lager lager = new Lager (8);
        Artikel artikel1 = new Artikel(1234, "Katze", 10, 10);
        Artikel artikel2 = new Artikel(1235, "Hund", 5, 5);
        Artikel artikel3 = new Artikel(1236, "Artikel", 20, 20);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.legeAnArtikel(artikel3);
        BiPredicate<Artikel, Artikel> preisPredicate = (artikelx, artikely) -> artikelx.getPreis() > artikely.getPreis();
        Artikel [] liste = lager.getSorted(preisPredicate);
        Artikel actual = liste[0];
        assertEquals(actual, artikel2);
    }

    @Test
    public void getSortedTest4_1(){
        Lager lager = new Lager (8);
        Artikel artikel1 = new Artikel(1234, "Katze", 10, 10);
        Artikel artikel2 = new Artikel(1235, "Hund", 5, 5);
        Artikel artikel3 = new Artikel(1236, "Artikel", 20, 20);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.legeAnArtikel(artikel3);
        BiPredicate<Artikel, Artikel> preisPredicate = (artikelx, artikely) -> artikelx.getPreis() < artikely.getPreis();
        Artikel [] liste = lager.getSorted(preisPredicate);
        Artikel actual = liste[0];
        assertEquals(actual, artikel3);
    }

    @Test
    public void getSortedTest5(){
        Lager lager = new Lager (8);
        CD artikel1 = new CD(1234, 50, 10, "TestInterpret", "TestTitel", 12);
        Buch artikel2 = new Buch(1235, 30, 5, "TestAutor", "TestTitel", "TestVerlag");
        Video artikel3 = new Video(1236, 10, 20, "TestTitel", 120, 2020);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.legeAnArtikel(artikel3);
        BiPredicate<Artikel, Artikel> alphabetPredicate = (artikelx, artikely) -> artikelx.getClass().getName().compareTo(artikely.getClass().getName()) > 0;
        Artikel [] liste = lager.getSorted(alphabetPredicate);
        Artikel actual = liste[0];
        assertEquals(actual, artikel2);
    }

    @Test
    public void getSortedTestNichtsTauschen(){
        Lager lager = new Lager (8);
        Artikel artikel1 = new Artikel(1234, "Hund", 10, 10);
        Artikel artikel2 = new Artikel(1235, "Katze", 10, 10);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        BiPredicate<Artikel, Artikel> alphabetPredicate = (artikelx, artikely) -> artikelx.getBezeichnung().compareTo(artikely.getBezeichnung()) > 0;
        Artikel [] liste = lager.getSorted(alphabetPredicate);
        Artikel actual = liste[0];
        assertEquals(actual, artikel1);
    }

    @Test
    public void filterTest1(){
        Lager lager = new Lager (8);
        Artikel artikel1 = new Artikel(1234, "Katze", 0, 10);
        Artikel artikel2 = new Artikel(1235, "Hund", 10, 10);
        Artikel artikel3 = new Artikel(1236, "Maus", 20, 10);
        Artikel artikel4 = new Artikel(1237, "Ratte", 0, 10);
        Artikel artikel5 = new Artikel(1238, "Vogel", 100, 10);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.legeAnArtikel(artikel3);
        lager.legeAnArtikel(artikel4);
        lager.legeAnArtikel(artikel5);
        Predicate<Artikel> filterPredicate = (artikelx) -> artikelx.getBestand() > 10;
        Artikel [] liste = lager.filter(filterPredicate);
        Artikel actual = liste[0];
        assertEquals(actual, artikel3);
    }

    @Test
    public void filterTest2(){
        Lager lager = new Lager (8);
        Artikel artikel1 = new Artikel(1234, "Katze", 0, 10);
        Artikel artikel2 = new Artikel(1235, "Hund", 10, 100);
        Artikel artikel3 = new Artikel(1236, "Maus", 20, 90);
        Artikel artikel4 = new Artikel(1237, "Ratte", 0, 50);
        Artikel artikel5 = new Artikel(1238, "Vogel", 100, 300);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.legeAnArtikel(artikel3);
        lager.legeAnArtikel(artikel4);
        lager.legeAnArtikel(artikel5);
        Predicate<Artikel> filterPredicate = (artikelx) -> artikelx.getPreis() > 100;
        Artikel [] liste = lager.filter(filterPredicate);
        Artikel actual = liste[0];
        assertEquals(actual, artikel5);
    }

    @Test
    public void applyToArticlesTest1(){
        Lager lager = new Lager (8);
        Artikel artikel1 = new Artikel(1234, "Katze", 0, 10);
        Artikel artikel2 = new Artikel(1235, "Hund", 10, 100);
        Artikel artikel3 = new Artikel(1236, "Maus", 20, 90);
        Artikel artikel4 = new Artikel(1237, "Ratte", 0, 50);
        Artikel artikel5 = new Artikel(1238, "Vogel", 100, 300);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.legeAnArtikel(artikel3);
        lager.legeAnArtikel(artikel4);
        lager.legeAnArtikel(artikel5);
        Function<Artikel, Artikel> func = (artikel) -> {
            double preis = artikel.getPreis();
            double newPreis = preis * (-10.00 / 100.00);
            artikel.setPreis(preis + newPreis);
            return artikel;
        };
        lager.applyToArticles(func);
        double actual = artikel1.getPreis();
        assertEquals(actual, 9, 0.001);
    }

    @Test
    public void applyToArticlesTest2(){
        Lager lager = new Lager (8);
        Artikel artikel1 = new Artikel(1234, "Katze", 0, 10);
        Artikel artikel2 = new Artikel(1235, "Hund", 10, 100);
        Artikel artikel3 = new Artikel(1236, "Maus", 20, 90);
        Artikel artikel4 = new Artikel(1237, "Ratte", 0, 50);
        Artikel artikel5 = new Artikel(1238, "Vogel", 100, 300);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.legeAnArtikel(artikel3);
        lager.legeAnArtikel(artikel4);
        lager.legeAnArtikel(artikel5);
        Function<Artikel, Artikel> func = (Artikel artikel) -> {
            double preis = artikel.getPreis();
            double newPreis = preis * (-10.00 / 100.00);
            artikel.setPreis(preis + newPreis);
            return artikel;
        };
        lager.applyToArticles(func);
        double actual = artikel2.getPreis();
        assertEquals(actual, 90, 0.001);
    }

    @Test
    public void applyToArticlesTest3(){
        Lager lager = new Lager (8);
        Artikel artikel1 = new Artikel(1234, "Katze", 0, 10);
        Artikel artikel2 = new Artikel(1235, "Hund", 10, 100);
        Artikel artikel3 = new Artikel(1236, "Maus", 20, 90);
        Artikel artikel4 = new Artikel(1237, "Ratte", 0, 50);
        Artikel artikel5 = new Artikel(1238, "Vogel", 100, 300);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.legeAnArtikel(artikel3);
        lager.legeAnArtikel(artikel4);
        lager.legeAnArtikel(artikel5);
        Function<Artikel, Artikel> func = (Artikel artikel) -> {
            double preis = artikel.getPreis();
            double newPreis = preis * (-10.00 / 100.00);
            artikel.setPreis(preis + newPreis);
            return artikel;
        };
        lager.applyToArticles(func);
        double actual = artikel4.getPreis();
        assertEquals(actual, 45, 0.001);
    }

}