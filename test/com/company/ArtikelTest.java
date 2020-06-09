package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArtikelTest {

//Artikel Konstruktor Tests
    @Test (expected = IllegalArgumentException.class)
    public void KonstruktorTestArtikelNrZuKlein(){
        Artikel artikel = new Artikel(999, "Hund", 10, 10);
    }

    @Test (expected = IllegalArgumentException.class)
    public void KonstruktorTestArtikelNrZuGross(){
        Artikel artikel = new Artikel(10000, "Hund", 10, 10);
    }

    @Test (expected = IllegalArgumentException.class)
    public void KonstruktorTestArtikelNrNegativ(){
        Artikel artikel = new Artikel(-1000, "Hund", 10, 10);
    }

    @Test (expected = IllegalArgumentException.class)
    public void KonstruktorTestBezeichnungNull(){
        Artikel artikel = new Artikel(1234, null, 10, 10);
    }

    @Test (expected = IllegalArgumentException.class)
    public void KonstruktorTestBezeichnungLeer(){
        Artikel artikel = new Artikel(1234, "", 10, 10);
    }

    @Test (expected = IllegalArgumentException.class)
    public void KonstruktorTestBestandNegativ(){
        Artikel artikel = new Artikel(1234, "Hund", -1, 10);
    }

    @Test (expected = IllegalArgumentException.class)
    public void KonstruktorTestPreisNull(){
        Artikel artikel = new Artikel(1234, "Hund", 10, 0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void KonstruktorTestPreisNegativ(){
        Artikel artikel = new Artikel(1234, "Hund", 10, -10);
    }

    @Test (expected = IllegalArgumentException.class)
    public void Konstruktor2TestArtikelnummerZuKlein(){
        Artikel artikel = new Artikel(123, "Hund", 10, 10);
    }

    @Test (expected = IllegalArgumentException.class)
    public void Konstruktor2TestArtikelnummerZuGross(){
        Artikel artikel = new Artikel(12345, "Hund", 10, 10);
    }

    @Test (expected = IllegalArgumentException.class)
    public void Konstruktor2TestBezeichungLeer(){
        Artikel artikel = new Artikel(1234, "", 10, 10);
    }

    @Test (expected = IllegalArgumentException.class)
    public void Konstruktor2TestBezeichungNull(){
        Artikel artikel = new Artikel(1234, null, 10, 10);
    }

    @Test (expected = IllegalArgumentException.class)
    public void Konstruktor2TestBezeichungTab(){
        Artikel artikel = new Artikel(1234, "   ", 10, 10);
    }

    //CD Konstruktor Tests
    @Test (expected = IllegalArgumentException.class)
    public void CDKonstruktorTestInterpretLeer(){
        CD cd = new CD(1234, 10, 10, "","TestTitel", 10);
    }

    @Test (expected = IllegalArgumentException.class)
    public void CDKonstruktorTestInterpretNull(){
        CD cd = new CD(1234, 10, 10, null,"TestTitel", 10);
    }

    @Test (expected = IllegalArgumentException.class)
    public void CDKonstruktorTestTitelLeer(){
        CD cd = new CD(1234, 10, 10, "TestInterpret","", 10);
    }

    @Test (expected = IllegalArgumentException.class)
    public void CDKonstruktorTestTitelNull(){
        CD cd = new CD(1234, 10, 10, "TestInterpret",null, 10);
    }

    @Test (expected = IllegalArgumentException.class)
    public void CDKonstruktorTestTitelAnzahlNegativ(){
        CD cd = new CD(1234, 10, 10, "TestInterpret","TestTitel", -1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void CDKonstruktorTestTitelAnzahlNull(){
        CD cd = new CD(1234, 10, 10, "TestInterpret","TestTitel", 0);
    }

    //Video Konstruktor Tests
    @Test (expected = IllegalArgumentException.class)
    public void VideoKonstruktorTestTitelLeer(){
        Video video = new Video(1234, 10, 10, "",120, 2020);
    }

    @Test (expected = IllegalArgumentException.class)
    public void VideoKonstruktorTestTitelNull(){
        Video video = new Video(1234, 10, 10, null,120, 2020);
    }

    @Test (expected = IllegalArgumentException.class)
    public void VideoKonstruktorTestSpieldauerNull(){
        Video video = new Video(1234, 10, 10, "TestTitel",0, 2020);
    }

    @Test (expected = IllegalArgumentException.class)
    public void VideoKonstruktorTestSpieldauerNegativ(){
        Video video = new Video(1234, 10, 10, "TestTitel",-1, 2020);
    }

    @Test (expected = IllegalArgumentException.class)
    public void VideoKonstruktorTestJahrZukunft(){
        Video video = new Video(1234, 10, 10, "TestTitel",120, 2021);
    }

    //Buch Konstruktor Tests
    @Test (expected = IllegalArgumentException.class)
    public void BuchKonstruktorTestAutorLeer(){
        Buch buch = new Buch(1234, 10, 10, "","TestTitel", "TestVerlag");
    }

    @Test (expected = IllegalArgumentException.class)
    public void BuchKonstruktorTestAutorNull(){
        Buch buch = new Buch(1234, 10, 10, null,"TestTitel", "TestVerlag");
    }

    @Test (expected = IllegalArgumentException.class)
    public void BuchKonstruktorTestTitelLeer(){
        Buch buch = new Buch(1234, 10, 10, "TestAutor","", "TestVerlag");
    }

    @Test (expected = IllegalArgumentException.class)
    public void BuchKonstruktorTestTitelNull(){
        Buch buch = new Buch(1234, 10, 10, "TestAutor",null, "TestVerlag");
    }

    @Test (expected = IllegalArgumentException.class)
    public void BuchKonstruktorTestVerlagLeer(){
        Buch buch = new Buch(1234, 10, 10, "TestAutor","TestTitel", "");
    }

    @Test (expected = IllegalArgumentException.class)
    public void BuchKonstruktorTestVerlagNull(){
        Buch buch = new Buch(1234, 10, 10, "TestAutor","TestTitel", null);
    }


    //Artikel Methoden Tests
    @Test
    public void bucheZugangTest1() {
        Artikel artikel = new Artikel(1234, "Hund", 10, 10.00);
        artikel.bucheZugang(10);
        int expected = 20;
        int actual = artikel.getBestand();
        assertEquals(expected, actual);
    }

    @Test
    public void bucheZugangTest2() {
        Artikel artikel = new Artikel(1234, "Hund", 10, 10.00);
        artikel.bucheZugang(20);
        int expected = 30;
        int actual = artikel.getBestand();
        assertEquals(expected, actual);
    }

    @Test (expected = IllegalArgumentException.class)
    public void bucheZugangTestNegativeZahl() {
        Artikel artikel = new Artikel(1234, "Hund", 10, 10.00);
        artikel.bucheZugang(-1);
        int expected = 10;
        int actual = artikel.getBestand();
        assertEquals(expected, actual);
    }

    @Test
    public void bucheAbgangTest1() {
        Artikel artikel = new Artikel(1234, "Hund", 10, 10.00);
        artikel.bucheAbgang(5);
        int expected = 5;
        int actual = artikel.getBestand();
        assertEquals(expected, actual);
    }

    @Test
    public void bucheAbgangTest2() {
        Artikel artikel = new Artikel(1234, "Hund", 10, 10.00);
        artikel.bucheAbgang(8);
        int expected = 2;
        int actual = artikel.getBestand();
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void bucheAbgangTestNegativeZahl() {
        Artikel artikel = new Artikel(1234, "Hund", 10, 10.00);
        artikel.bucheAbgang(-1);
        int expected = 10;
        int actual = artikel.getBestand();
        assertEquals(expected, actual);
    }

    @Test (expected = IllegalArgumentException.class)
    public void bucheAbgangTestNegativesErgebnis() {
        Artikel artikel = new Artikel(1234, "Hund", 10, 10.00);
        artikel.bucheAbgang(11);
        int expected = 10;
        int actual = artikel.getBestand();
        assertEquals(expected, actual);
    }

    //Bezeichnung Tests
    @Test
    public void bezeichnungArtikelTest() {
        Artikel artikel = new Artikel(1234, "Hund", 10, 10.00);
        String expected = "Hund";
        String actual = artikel.getBezeichnung();
        assertEquals(expected, actual);
    }
    @Test
    public void bezeichnungCDTest() {
        CD cd = new CD (1234, 10, 10, "TestInterpret", "TestTitel", 10);
        String expected = "TestInterpret : TestTitel";
        String actual = cd.getBeschreibung();
        assertEquals(expected, actual);
    }

    @Test
    public void bezeichnungVideoTest() {
        Video video = new Video (1234, 10, 10, "TestTitel", 120, 2020);
        String expected = "TestTitel";
        String actual = video.getBeschreibung();
        assertEquals(expected, actual);
    }

    @Test
    public void bezeichnungBuchTest() {
        Buch buch = new Buch (1234, 10, 10, "TestAutor", "TestTitel", "TestVerlag");
        String expected = "TestAutor : TestTitel";
        String actual = buch.getBeschreibung();
        assertEquals(expected, actual);
    }

}