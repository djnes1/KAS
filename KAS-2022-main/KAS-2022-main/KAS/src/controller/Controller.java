package controller;

import model.*;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {
    /**
     * Creates a new Udflugt.
     */
//    public static Udflugt createUdflugt(String navn, LocalDate dato, String beskrivelse, int pris, String lokation){
//        Udflugt udflugt = new Udflugt(navn, dato, beskrivelse, pris, lokation);
//        Storage.addUdflugt(udflugt);
//        return udflugt;
//    }
    public static Konference createKonference(String adresse, String navn, LocalDate startDato, LocalDate slutDato, int pris) {
        Konference konference = new Konference(adresse, navn, startDato, slutDato, pris);
        Storage.addKonference(konference);
        return konference;
    }

    public static Tilmelding createTilmelding(boolean foredragsholder,  LocalDate ankomstdato, LocalDate afrejsedato,int tilmeldingNR, Konference konference, Deltager deltager) {
        Tilmelding tilmelding = konference.createTilmelding(foredragsholder,  ankomstdato,afrejsedato, tilmeldingNR, konference, deltager);
        Storage.addTilmelding(tilmelding);
        return tilmelding;
    }

    public static Deltager createDeltager(String navn, String adresse, String land, String tlfnr, String firmaTlf) {
        Deltager deltager = new Deltager(navn, adresse, land, tlfnr, firmaTlf);
        Storage.addDeltager(deltager);
        return deltager;
    }

    public static Hotel createHotel(String navn, String adresse, int prisEnkelt, int prisDobbelt) {
        Hotel hotel = new Hotel(navn, adresse, prisEnkelt, prisDobbelt);
        Storage.addHotel(hotel);
        return hotel;
    }

    public static Tilvalg createTilvalg (String beskrivelse, int pris, Hotel hotel){
        Tilvalg tilvalg = hotel.createTilvalg(beskrivelse, pris);
        Storage.addTilvalg(tilvalg);
        return tilvalg;
    }

    public static Udflugt createUdflugt (String navn, LocalDate dato, String beskrivelse, int pris, String lokation, Konference konference){
        Udflugt udflugt = konference.createUdflugt(navn, dato, beskrivelse, pris, lokation);
        Storage.addUdflugt(udflugt);
        return udflugt;
    }

    public static Ledsager createLedsager (String navn, Deltager deltager){
        Ledsager ledsager = deltager.createLedsager(navn);
        Storage.addLedsager(ledsager);
        return ledsager;
    }


    //Updates

    public static void updateKonference(Konference konference, String adresse, String navn, LocalDate dato, int pris) {
        konference.setStartDato(dato);
        konference.setPris(pris);
        konference.setNavn(navn);
        konference.setAdresse(adresse);
    }

    public static void updateTilmelding(Tilmelding tilmelding, Hotel hotel, boolean foredragsholder, LocalDate afrejsedato, LocalDate ankomstdato, int tilmeldingNR, Konference konference, Deltager deltager) {
        tilmelding.setDeltager(deltager);
        tilmelding.setHotel(hotel);
        tilmelding.setKonference(konference);
        tilmelding.setTilmeldingNR(tilmeldingNR);
        tilmelding.setAfrejsedato(afrejsedato);
        tilmelding.setAnkomstdato(ankomstdato);
        tilmelding.setForedragsholder(foredragsholder);
    }

    public static void updateDeltager(Deltager deltager, Ledsager ledsager, String navn, String adresse, String land, String tlfnr, String firmaTlf) {
        deltager.setLedsager(ledsager);
        deltager.setFirmaTlf(firmaTlf);
        deltager.setAdresse(adresse);
        deltager.setLand(land);
        deltager.setTlfnr(tlfnr);
        deltager.setNavn(navn);
    }

    public static void updateHotel(Hotel hotel, Tilmelding tilmelding, Tilvalg tilvalg, String navn, String adresse, int prisEnkelt, int prisDobbelt) {
        hotel.setPrisDobbelt(prisDobbelt);
        hotel.setPrisEnkelt(prisEnkelt);
        hotel.setAdresse(adresse);
        hotel.setNavn(navn);
    }

//Addere
   /* public static void addDeltagerToTilmelding(Deltager deltager, Tilmelding tilmelding){
        tilmelding.setDeltager(deltager);
    }*/

    public static void addTilmeldingToKonference(Tilmelding tilmelding, Konference konference) {
        tilmelding.setKonference(konference);
    }

    public static void addTilvalgToHotel(Tilvalg tilvalg, Hotel hotel){
        hotel.getTilvalg().add(tilvalg);
    }

    public static void addUdflugtToKonference(Udflugt udflugt, Konference konference){
        konference.getUdflugter().add(udflugt);
    }

    public static void addLedsagerToDeltager(Ledsager ledsager, Deltager deltager){
        deltager.setLedsager(ledsager);
    }
    public static void addLedsagerTilUdflugt(Ledsager ledsager, Udflugt udflugt){
        ledsager.addUdflugt(udflugt);
        udflugt.addLedsager(ledsager);
    }
    public static void addTilvalgTilTilmelding(Tilmelding tilmelding, Tilvalg tilvalg){
        tilmelding.addTilvalg(tilvalg);
    }
    public static void addTilmeldingTilHotel(Hotel hotel, Tilmelding tilmelding){
        hotel.addTilmelding(tilmelding);
    }


    //Gettere

    public static ArrayList<Konference> getKonferencer() {
        return Storage.getKonferencer();
    }

    public static ArrayList<Tilmelding> getTilmeldinger() {
        return Storage.getTilmeldings();
    }

    public static ArrayList<Deltager> getDeltagere() {
        return Storage.getDeltagere();
    }

    public static ArrayList<Hotel> getHoteller() {
        return Storage.getHoteller();
    }

    public static ArrayList<Udflugt> getUdflugter(){

        return Storage.getUdflugter();
    }

    public static ArrayList<Ledsager> getLedsagere(){

        return Storage.getLedsagere();
    }


    public static ArrayList<Ledsager> getLedsagereFraUdflugt(Udflugt udflugt){
        return udflugt.getLedsagere();
    }

    public static void deleteKonference(Konference konference){
        Storage.removeKonference(konference);
    }

//    //Updates
//
//    public static void updateKonference(Konference konference, String adresse, String navn, LocalDate dato, int pris) {
//        konference.setDato(dato);
//        konference.setPris(pris);
//        konference.setNavn(navn);
//        konference.setAdresse(adresse);
//    }
//
//    public static void updateTilmelding(Tilmelding tilmelding, Hotel hotel, boolean foredragsholder, LocalDate afrejsedato, LocalDate ankomstdato, int tilmeldingNR, Konference konference, Deltager deltager) {
//        tilmelding.setDeltager(deltager);
//        tilmelding.setHotel(hotel);
//        tilmelding.setKonference(konference);
//        tilmelding.setTilmeldingNR(tilmeldingNR);
//        tilmelding.setAfrejsedato(afrejsedato);
//        tilmelding.setAnkomstdato(ankomstdato);
//        tilmelding.setForedragsholder(foredragsholder);
//    }
//
//    public static void updateDeltager(Deltager deltager, Ledsager ledsager, String navn, String adresse, String land, String tlfnr, String firmaTlf) {
//        deltager.setLedsager(ledsager);
//        deltager.setFirmaTlf(firmaTlf);
//        deltager.setAdresse(adresse);
//        deltager.setLand(land);
//        deltager.setTlfnr(tlfnr);
//        deltager.setNavn(navn);
//    }
//
//    public static void updateHotel(Hotel hotel, Tilmelding tilmelding, Tilvalg tilvalg, String navn, String adresse, int prisEnkelt, int prisDobbelt) {
//        hotel.setPrisDobbelt(prisDobbelt);
//        hotel.setPrisEnkelt(prisEnkelt);
//        hotel.setAdresse(adresse);
//        hotel.setNavn(navn);
//    }
//
//    //Addere
//   /* public static void addDeltagerToTilmelding(Deltager deltager, Tilmelding tilmelding){
//        tilmelding.setDeltager(deltager);
//    }*/
//
//    public static void addTilmeldingToKonference(Tilmelding tilmelding, Konference konference) {
//        tilmelding.setKonference(konference);
//    }

    //Gettere

//    public static ArrayList<Konference> getKonferencer() {
//        return Storage.getKonferencer();
//    }
//
//    public static ArrayList<Tilmelding> getTilmeldinger() {
//        return Storage.getTilmeldings();
//    }
//
//    public static ArrayList<Deltager> getDeltagere() {
//        return Storage.getDeltagere();
//    }
//
//    public static ArrayList<Hotel> getHoteller() {
//        return Storage.getHoteller();
//    }

    public static ArrayList<Deltager> getDeltagerePåHotel(Hotel hotel){
        ArrayList<Deltager> deltagere = new ArrayList<>();
        for (Tilmelding til : hotel.getTilmeldinger() ) {
            deltagere.add(til.getDeltager());
        }
        return deltagere;
    }


    //Ny metode
   public static ArrayList<Ledsager> getLedsagerPåUdflugt (Udflugt udflugt){
        ArrayList<Ledsager> ledsagere = new ArrayList<>();
        for (Ledsager led : udflugt.getLedsagere()){
            udflugt.getLedsagere().get(0);

        }
        return ledsagere;
    }



    public static void initStorage() {
        Konference k1 = Controller.createKonference("Odense Universitet", "Hav og Himmel", LocalDate.of(2022, 5, 18),LocalDate.of(2022,5,20), 1500);
        Konference k2 = Controller.createKonference("Gigantium i Aalborg", "Red Naturen", LocalDate.of(2023, 10, 1), LocalDate.of(2022,10,5),1050);
        Konference k3 = Controller.createKonference("Boxen i Herning", "Hjælp Dyrene", LocalDate.of(2024, 6, 15),LocalDate.of(2022,6,20), 1600);

        Udflugt u1 = Controller.createUdflugt("Byrundtur", LocalDate.of(2022, 5, 18), "En hyggelig gåtur i det fri", 125, "Odense", k1);
        Udflugt u2 = Controller.createUdflugt("Egeskov", LocalDate.of(2022, 5, 19), "Mærk historiens vingesus", 75, "Kværndrup", k2);
        Udflugt u3 = Controller.createUdflugt("Trapholt Museum", LocalDate.of(2022, 5, 20), "Moderne kunst og design i verdensklasse", 200, "Kolding",k3);

        Hotel h1 = Controller.createHotel("Den Hvide Svane", "Knudrisgade 62", 1050, 1250);
        Hotel h2 = Controller.createHotel("Høtel Phønix", "Læsøegade 4", 600, 800);
        Hotel h3 = Controller.createHotel("Pension Tusindfryd", "Vestergade 34", 500, 600);

        Tilvalg ti1 = Controller.createTilvalg("WIFI", 50, h1);
        Tilvalg ti11 = Controller.createTilvalg("Bad",200, h2);
        Tilvalg ti2 = Controller.createTilvalg("WIFI", 75, h2);
        Tilvalg ti3 = Controller.createTilvalg("Morgenmad", 100, h3);

        Deltager d1 = Controller.createDeltager("Jørgen Severinsen", "Tretommervej 8, 8920 Jyderup", "Danmark", "84848495", "23525423");
        Deltager d2 = Controller.createDeltager("Johnny Petterson", "Rolighetvej 55, 12414 Gøteborg", "Sverige", "+46 85858585", "+46 7833242");
        Deltager d3 = Controller.createDeltager("Karen O. Ingvarsen", "Helgenæsgade 21, 8000 Aarhus C", "Danmark", "49494949", "43020020");
        Deltager d4 = Controller.createDeltager("Winnie Thomsen", "Silkevejen, 2000 København K", "Danmark", "84848495", "23525423");
        Deltager d5 = Controller.createDeltager("Jens Hans Olesen", "Østergade, 5000 Odense", "Danmark", "85858585", "7833242");
        Deltager d6 = Controller.createDeltager("Ronja Ankersen", "Aarhusvej 7, 8600 Skanderborg", "Danmark", "49494949", "43020020");

        Ledsager l1 = Controller.createLedsager("Lenny Severinsen", d1);
        Ledsager l2 = Controller.createLedsager("Lars Jensen",d2);
        Ledsager l3 = Controller.createLedsager("Lotte Frederiksen",d3);

        Tilmelding t1 = Controller.createTilmelding(true, LocalDate.of(2022, 5, 18), LocalDate.of(2022, 5, 20), 1, k1, d1);
        Tilmelding t2 = Controller.createTilmelding(true, LocalDate.of(2022, 5, 18), LocalDate.of(2022, 5, 19), 2, k2, d2);
        Tilmelding t3 = Controller.createTilmelding(true, LocalDate.of(2022, 5, 18), LocalDate.of(2022, 5, 20), 3, k3, d3);
        Tilmelding t4 = Controller.createTilmelding(false, LocalDate.of(2022, 5, 18), LocalDate.of(2022, 5, 18), 4, k1, d4);
        Tilmelding t5 = Controller.createTilmelding(true, LocalDate.of(2022, 5, 18), LocalDate.of(2022, 5, 20), 5, k2, d5);
        Tilmelding t6 = Controller.createTilmelding(true, LocalDate.of(2022, 5, 18), LocalDate.of(2022, 5, 18), 6, k3, d6);

        Controller.addTilmeldingTilHotel(h1, t1);
        Controller.addTilmeldingTilHotel(h2, t2);
        Controller.addTilmeldingTilHotel(h3, t3);

        Controller.addLedsagerTilUdflugt(l2, u2);


    }

    public static void init() {

        initStorage();

    }


}
