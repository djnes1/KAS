package model;

import model.*;
import org.xml.sax.ext.Locator2;

import java.time.LocalDate;

public class Tester {
    public static void main(String[] args) {


        Deltager d1 = new Deltager("Finn madsen", "adresse", "123", "123", "123");
        Konference k1 = new Konference("Jernbanevej", "Hav og himmel", LocalDate.of(2022, 10, 10),LocalDate.of(2022,10,12), 1500);
        Udflugt u1 = k1.createUdflugt("Egeskov", LocalDate.of(2022, 10, 10), "hygge", 75, "vej");
        Udflugt u2 = k1.createUdflugt("Trapholt", LocalDate.of(2022, 10, 10), "hygge", 200, "vej");
        Udflugt u3 = k1.createUdflugt("Byrundtur", LocalDate.of(2022, 10, 10), "hygge", 125, "vej");



        Tilmelding t1 = new Tilmelding(false, LocalDate.of(2022, 10, 10), LocalDate.of(2022, 10, 12), 1, k1, d1);
        Hotel h1 = new Hotel("Den hvide svane", "mike hawk vej", 1050, 1250);
        k1.addHotel(h1);
        System.out.println(t1.beregnSamletPris());
        Tilvalg t11 = h1.createTilvalg("Wifi", 50);

        Deltager d2 = new Deltager("Niels Petersen", "123", "Len", "213", "123");
        Tilmelding t2 = new Tilmelding(false,LocalDate.of(2022, 10, 10), LocalDate.of(2022, 10, 12),2,k1,d2 );
        h1.addTilmelding(t2);
        System.out.println(t2.beregnSamletPris());

        Deltager d3 = new Deltager("Peter Sommer", "123", "123", "123", "123");
        Tilmelding t3 = new Tilmelding(false, LocalDate.of(2022, 10, 10), LocalDate.of(2022, 10, 12), 3, k1, d3);
        Ledsager l1 = d3.createLedsager("Mie Sommer");
        l1.addUdflugt(u1);
        l1.addUdflugt(u2);
        h1.addTilmelding(t3);
        t3.addTilvalg(t11);
        System.out.println(t3.beregnSamletPris());


        Deltager d4 = new Deltager("Lone Jensen", "123", "123", "123", "123");
        Tilmelding t4 = new Tilmelding(true, LocalDate.of(2022, 10, 10), LocalDate.of(2022, 10, 12),4,k1,d4);
        Ledsager l2 = d4.createLedsager("Jan Madsen");
        h1.addTilmelding(t4);
        t4.addTilvalg(t11);
        l2.addUdflugt(u1);
        l2.addUdflugt(u3);
        System.out.println(t4.beregnSamletPris());








//        hotel.addTilmelding(tilmelding);
//        konference.addHotel(hotel);
//        tilmelding.addTilvalg(t1);
//
//        tilmelding.getDeltager().getLedsager().addUdflugt(udflugt);
//        System.out.println("asd" + tilmelding.getDeltager().getLedsager().getUdflugter());
//        System.out.println(konference.getUdflugter());
//
//
//        System.out.println(tilmelding.beregnSamletPris());
//        System.out.println(tilmelding);
//        System.out.println(konference.getUdflugter());
//        System.out.println(l1.udflugtsPris());
//        System.out.println(tilmelding.getDeltager().getLedsager().udflugtsPris());
    }
}