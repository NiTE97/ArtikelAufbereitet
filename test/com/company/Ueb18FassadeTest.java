package com.company;

import org.junit.Test;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import static org.junit.Assert.*;

public class Ueb18FassadeTest {

    @Test
    public void getSortedTest1(){
        Lager lager = new Lager (8);
        CD artikel1 = new CD(1234, 50, 10, "TestInterpret", "TestTitel", 12);
        Buch artikel2 = new Buch(1235, 30, 5, "TestAutor", "TestTitel", "TestVerlag");
        Video artikel3 = new Video(1236, 10, 20, "TestTitel", 120, 2020);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.legeAnArtikel(artikel3);
        Ueb18Fassade lagerx = new Ueb18Fassade();
        Artikel [] sorted = lagerx.aufgabe_d_i(lager);
        Artikel actual = sorted[0];
        assertEquals(actual, artikel2);
    }

    @Test
    public void getSortedTest2(){
        Lager lager = new Lager (8);
        CD artikel1 = new CD(1234, 50, 10, "TestInterpret", "TestTitel", 12);
        Buch artikel2 = new Buch(1235, 30, 5, "TestAutor", "TestTitel", "TestVerlag");
        Video artikel3 = new Video(1236, 10, 20, "TestTitel", 120, 2020);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.legeAnArtikel(artikel3);
        Ueb18Fassade lagerx = new Ueb18Fassade();
        Artikel [] sorted = lagerx.aufgabe_d_i(lager);
        Artikel actual = sorted[3];
        assertEquals(actual, artikel3);
    }

    @Test
    public void getSortedTest3(){
        Lager lager = new Lager (8);
        CD artikel1 = new CD(1234, 50, 10, "TestInterpret", "TestTitel", 12);
        Buch artikel2 = new Buch(1235, 30, 5, "TestAutor", "TestTitel", "TestVerlag");
        Video artikel3 = new Video(1236, 10, 20, "TestTitel", 120, 2020);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.legeAnArtikel(artikel3);
        Ueb18Fassade lagerx = new Ueb18Fassade();
        Artikel [] sorted = lagerx.aufgabe_d_i(lager);
        Artikel actual = sorted[6];
        assertEquals(actual, artikel2);
    }

    @Test
    public void aenderePreisAllerArtikelTest1(){
        Lager lager = new Lager (8);
        CD artikel1 = new CD(1234, 50, 10, "TestInterpret", "TestTitel", 12);
        Buch artikel2 = new Buch(1235, 30, 5, "TestAutor", "TestTitel", "TestVerlag");
        Video artikel3 = new Video(1236, 10, 20, "TestTitel", 120, 2020);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.legeAnArtikel(artikel3);
        Ueb18Fassade lagerx = new Ueb18Fassade();
        lagerx.aufgabe_d_ii(lager);
        double actual = lager.getArtikel(0).getPreis();
        assertEquals(actual, 9, 0.0001);
    }

    @Test
    public void aenderePreisAllerArtikelTest2(){
        Lager lager = new Lager (8);
        CD artikel1 = new CD(1234, 50, 10, "TestInterpret", "TestTitel", 12);
        Buch artikel2 = new Buch(1235, 30, 5, "TestAutor", "TestTitel", "TestVerlag");
        Video artikel3 = new Video(1236, 10, 20, "TestTitel", 120, 2020);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.legeAnArtikel(artikel3);
        Ueb18Fassade lagerx = new Ueb18Fassade();
        lagerx.aufgabe_d_ii(lager);
        double actual = lager.getArtikel(2).getPreis();
        assertEquals(actual, 18, 0.0001);
    }

    @Test
    public void suffixTest1(){
        Lager lager = new Lager (8);
        CD artikel1 = new CD(1234, 50, 10, "TestInterpret", "TestTitel", 12);
        Buch artikel2 = new Buch(1235, 30, 5, "TestAutor", "TestTitel", "TestVerlag");
        Video artikel3 = new Video(1236, 10, 20, "TestTitel", 120, 2020);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.legeAnArtikel(artikel3);
        Ueb18Fassade lagerx = new Ueb18Fassade();
        lagerx.aufgabe_d_iii(lager);
        String actual = lager.getArtikel(0).getBezeichnung();
        assertEquals(actual, "Medien (Sonderangebot)");
    }

    @Test
    public void suffixTest2(){
        Lager lager = new Lager (8);
        Artikel artikel1 = new Artikel(1234, "Test");
        Buch artikel2 = new Buch(1235, 30, 5, "TestAutor", "TestTitel", "TestVerlag");
        Video artikel3 = new Video(1236, 10, 20, "TestTitel", 120, 2020);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.legeAnArtikel(artikel3);
        Ueb18Fassade lagerx = new Ueb18Fassade();
        lagerx.aufgabe_d_iii(lager);
        String actual = lager.getArtikel(0).getBezeichnung();
        assertEquals(actual, "Test (Sonderangebot)");
    }

    @Test
    public void konkatenierenTest1(){
        Lager lager = new Lager (8);
        Artikel artikel1 = new Artikel(1234, "Test");
        Buch artikel2 = new Buch(1235, 30, 5, "TestAutor", "TestTitel", "TestVerlag");
        Video artikel3 = new Video(1236, 10, 20, "TestTitel", 120, 2020);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.legeAnArtikel(artikel3);
        Ueb18Fassade lagerx = new Ueb18Fassade();
        lagerx.aufgabe_d_iv(lager);
        String actual = lager.getArtikel(0).getBezeichnung();
        assertEquals(actual, "Test (Sonderangebot)");
    }

    @Test
    public void konkatenierenTest2(){
        Lager lager = new Lager (8);
        Artikel artikel1 = new Artikel(1234, "Test", 10, 10);
        Buch artikel2 = new Buch(1235, 30, 5, "TestAutor", "TestTitel", "TestVerlag");
        Video artikel3 = new Video(1236, 10, 20, "TestTitel", 120, 2020);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.legeAnArtikel(artikel3);
        Ueb18Fassade lagerx = new Ueb18Fassade();
        lagerx.aufgabe_d_iv(lager);
        double actual = lager.getArtikel(0).getPreis();
        assertEquals(actual, 9, 0.0001);
    }

    @Test
    public void konkatenierenTest3(){
        Lager lager = new Lager (8);
        CD artikel1 = new CD(1234, 50, 10, "TestInterpret", "TestTitel", 12);
        Buch artikel2 = new Buch(1235, 30, 5, "TestAutor", "TestTitel", "TestVerlag");
        Video artikel3 = new Video(1236, 10, 20, "TestTitel", 120, 2020);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.legeAnArtikel(artikel3);
        Ueb18Fassade lagerx = new Ueb18Fassade();
        lagerx.aufgabe_d_iv(lager);
        String actual = lager.getArtikel(0).getBezeichnung();
        assertEquals(actual, "Medien (Sonderangebot)");
    }

    @Test
    public void konkatenierenTest4(){
        Lager lager = new Lager (8);
        CD artikel1 = new CD(1234, 50, 10, "TestInterpret", "TestTitel", 12);
        Buch artikel2 = new Buch(1235, 30, 5, "TestAutor", "TestTitel", "TestVerlag");
        Video artikel3 = new Video(1236, 10, 20, "TestTitel", 120, 2020);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.legeAnArtikel(artikel3);
        Ueb18Fassade lagerx = new Ueb18Fassade();
        lagerx.aufgabe_d_iv(lager);
        double actual = lager.getArtikel(0).getPreis();
        assertEquals(actual, 9, 0.0001);
    }

    @Test
    public void someArticlesTest1(){
        Lager lager = new Lager (8);
        CD artikel1 = new CD(1234, 50, 10, "TestInterpret", "TestTitel", 12);
        Buch artikel2 = new Buch(1235, 30, 5, "TestAutor", "TestTitel", "TestVerlag");
        Video artikel3 = new Video(1236, 10, 20, "TestTitel", 120, 2020);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.legeAnArtikel(artikel3);
        Ueb18Fassade lagerx = new Ueb18Fassade();
        lagerx.aufgabe_h_i(lager);
        double actual = lager.getArtikel(0).getPreis();
        assertEquals(actual, 11, 0.0001);
    }

    @Test
    public void someArticlesTest2(){
        Lager lager = new Lager (8);
        CD artikel1 = new CD(1234, 50, 10, "TestInterpret", "TestTitel", 12);
        Buch artikel2 = new Buch(1235, 30, 5, "TestAutor", "TestTitel", "TestVerlag");
        Video artikel3 = new Video(1236, 10, 20, "TestTitel", 120, 2020);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.legeAnArtikel(artikel3);
        Ueb18Fassade lagerx = new Ueb18Fassade();
        lagerx.aufgabe_h_i(lager);
        double actual = lager.getArtikel(1).getPreis();
        assertEquals(actual, 5.0, 0.0001);
    }

    @Test
    public void getArticlesTest1(){
        Lager lager = new Lager (8);
        CD artikel1 = new CD(1234, 50, 10, "TestInterpret", "TestTitel", 12);
        Buch artikel2 = new Buch(1235, 30, 5, "TestAutor", "TestTitel", "TestVerlag");
        Video artikel3 = new Video(1236, 10, 20, "TestTitel", 120, 2020);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.legeAnArtikel(artikel3);
        Predicate<Artikel> filterPredicate = (artikelx) -> artikelx.getPreis() > 5;
        BiPredicate<Artikel, Artikel> preisPredicate = (artikelx, artikely) -> artikelx.getPreis() > artikely.getPreis();
        Artikel [] sorted = lager.getArticles(filterPredicate, preisPredicate);
        double actual = sorted[0].getPreis();
        assertEquals(actual, 10.0, 0.0001);
    }

    @Test
    public void getArticlesTest2(){
        Lager lager = new Lager (8);
        CD artikel1 = new CD(1234, 50, 10, "TestInterpret", "TestTitel", 12);
        Buch artikel2 = new Buch(1235, 30, 5, "TestAutor", "TestTitel", "TestVerlag");
        Video artikel3 = new Video(1236, 10, 20, "TestTitel", 120, 2020);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.legeAnArtikel(artikel3);
        Predicate<Artikel> filterPredicate = (artikelx) -> artikelx.getPreis() > 5;
        BiPredicate<Artikel, Artikel> preisPredicate = (artikelx, artikely) -> artikelx.getPreis() < artikely.getPreis();
        Artikel [] sorted = lager.getArticles(filterPredicate, preisPredicate);
        double actual = sorted[0].getPreis();
        assertEquals(actual, 20.0, 0.0001);
    }

    @Test
    public void filterAllTest1(){
        Lager lager = new Lager (8);
        Buch artikel1 = new Buch(1234, 30, 20, "TestAutor", "TestTitel1", "TestVerlag");
        Buch artikel2 = new Buch(1235, 30, 15, "TestAutor", "TestTitel2", "TestVerlag");
        Buch artikel3 = new Buch(1236, 30, 10, "TestAutor", "TestTitel3", "TestVerlag");
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.legeAnArtikel(artikel3);
        Predicate<Artikel> preisPredicateMax = (artikel) -> artikel.getPreis() < 20.0;
        Predicate<Artikel> preisPredicateMin = (artikel) -> artikel.getPreis() > 5.0;
        Predicate<Artikel> [] predicates = new Predicate[]{preisPredicateMin, preisPredicateMax};
        Artikel [] sorted = lager.filterAll(predicates);
        Artikel actual = sorted[0];
        assertEquals(actual, artikel2);
    }

    @Test
    public void filterAllTest2(){
        Lager lager = new Lager (8);
        Buch artikel1 = new Buch(1234, 30, 20, "TestAutor", "TestTitel1", "TestVerlag");
        Buch artikel2 = new Buch(1235, 30, 15, "TestAutor", "TestTitel2", "TestVerlag");
        Buch artikel3 = new Buch(1236, 30, 10, "TestAutor", "TestTitel3", "TestVerlag");
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.legeAnArtikel(artikel3);
        Predicate<Artikel> preisPredicateMax = (artikel) -> artikel.getPreis() < 20.0;
        Predicate<Artikel> preisPredicateMin = (artikel) -> artikel.getPreis() > 5.0;
        Predicate<Artikel> [] predicates = new Predicate[]{preisPredicateMin, preisPredicateMax};
        Artikel [] sorted = lager.filterAll(predicates);
        Artikel actual = sorted[0];
        assertEquals(actual, artikel2);
    }

    @Test
    public void h_ii_Test1(){
        Lager lager = new Lager (8);
        Buch artikel1 = new Buch(1234, 3, 20, "TestAutor", "TestTitel1", "TestVerlag");
        Buch artikel2 = new Buch(1235, 2, 15, "TestAutor", "TestTitel2", "TestVerlag");
        Buch artikel3 = new Buch(1236, 1, 10, "TestAutor", "TestTitel3", "TestVerlag");
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.legeAnArtikel(artikel3);
        Ueb18Fassade lagerx = new Ueb18Fassade();
        lagerx.aufgabe_h_ii(lager);
        double actual = lager.getArtikel(0).getPreis();
        assertEquals(actual, 20, 0.0001);
    }

    @Test
    public void h_ii_Test2(){
        Lager lager = new Lager (8);
        Buch artikel1 = new Buch(1234, 3, 20, "TestAutor", "TestTitel1", "TestVerlag");
        Buch artikel2 = new Buch(1235, 2, 15, "TestAutor", "TestTitel2", "TestVerlag");
        Buch artikel3 = new Buch(1236, 1, 10, "TestAutor", "TestTitel3", "TestVerlag");
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.legeAnArtikel(artikel3);
        Ueb18Fassade lagerx = new Ueb18Fassade();
        lagerx.aufgabe_h_ii(lager);
        double actual = lager.getArtikel(1).getPreis();
        assertEquals(actual, 14.25, 0.0001);
    }

    @Test
    public void h_iii_Test1(){
        Lager lager = new Lager (8);
        Buch artikel1 = new Buch(1234, 3, 20, "TestAutor", "TestTitel1", "TestVerlag");
        Buch artikel2 = new Buch(1235, 2, 15, "TestAutor2", "TestTitel2", "TestVerlag");
        Buch artikel3 = new Buch(1236, 1, 10, "TestAutor", "TestTitel3", "TestVerlag");
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.legeAnArtikel(artikel3);
        Ueb18Fassade lagerx = new Ueb18Fassade();
        lagerx.aufgabe_h_iii(lager, "TestAutor");
        double actual = lager.getArtikel(0).getPreis();
        assertEquals(actual, 19, 0.0001);
    }

    @Test
    public void h_iii_Test2(){
        Lager lager = new Lager (8);
        Buch artikel1 = new Buch(1234, 3, 20, "TestAutor", "TestTitel1", "TestVerlag");
        Buch artikel2 = new Buch(1235, 2, 15, "TestAutor2", "TestTitel2", "TestVerlag");
        Buch artikel3 = new Buch(1236, 1, 10, "TestAutor", "TestTitel3", "TestVerlag");
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.legeAnArtikel(artikel3);
        Ueb18Fassade lagerx = new Ueb18Fassade();
        lagerx.aufgabe_h_iii(lager, "TestAutor");
        double actual = lager.getArtikel(1).getPreis();
        assertEquals(actual, 15, 0.0001);
    }

    @Test
    public void h_v_Test1(){
        Lager lager = new Lager (8);
        CD artikel1 = new CD(1234, 50, 10, "TestInterpret", "TestTitel", 12);
        Buch artikel2 = new Buch(1235, 2, 15, "cTestAutor", "TestTitel2", "TestVerlag");
        Buch artikel3 = new Buch(1236, 1, 10, "aTestAutor", "TestTitel3", "TestVerlag");
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.legeAnArtikel(artikel3);
        Ueb18Fassade lagerx = new Ueb18Fassade();
        Artikel [] sorted = lagerx.aufgabe_h_v(lager);
        Artikel actual = sorted[0];
        assertEquals(actual, artikel3);
    }

    @Test
    public void h_vi_Test1(){
        Lager lager = new Lager (8);
        CD artikel1 = new CD(1234, 50, 10, "TestInterpret", "TestTitel", 12);
        Buch artikel2 = new Buch(1235, 2, 15, "aTestAutor", "TestTitel2", "TestVerlag");
        Buch artikel3 = new Buch(1236, 1, 10, "cTestAutor", "TestTitel3", "TestVerlag");
        Buch artikel4 = new Buch(1237, 2, 100, "aTestAutor", "TestTitel4", "TestVerlag");
        Buch artikel5 = new Buch(1238, 2, 20, "aTestAutor", "TestTitel5", "TestVerlag");
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.legeAnArtikel(artikel3);
        lager.legeAnArtikel(artikel4);
        lager.legeAnArtikel(artikel5);
        Ueb18Fassade lagerx = new Ueb18Fassade();
        Artikel [] sorted = lagerx.aufgabe_h_vi(lager, "aTestAutor", 10, 30);
        Artikel actual = sorted[0];
        assertEquals(actual, artikel2);
    }


}