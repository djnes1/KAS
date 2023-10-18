package storage;

import model.*;


import java.util.ArrayList;

public class Storage {

    private static final ArrayList<Udflugt> udflugter = new ArrayList<>();
    private static final ArrayList<Ledsager> ledsagere = new ArrayList<>();
    private static final ArrayList<Deltager> deltagere = new ArrayList<>();
    private static final ArrayList<Konference> konferencer = new ArrayList<>();
    private static final ArrayList<Hotel> hoteller = new ArrayList<>();
    private static final ArrayList<Tilvalg> tilvalgs = new ArrayList<>();
    private static final ArrayList<Tilmelding> tilmeldings = new ArrayList<>();

    public static ArrayList<Tilmelding> getTilmeldings() {
        return new ArrayList<Tilmelding>(tilmeldings);
    }

    public static ArrayList<Udflugt> getUdflugter() {
        return new ArrayList<Udflugt>(udflugter);
    }

    public static ArrayList<Ledsager> getLedsagere() {
        return new ArrayList<Ledsager>(ledsagere);
    }

    public static ArrayList<Deltager> getDeltagere() {
        return new ArrayList<Deltager>(deltagere);
    }

    public static ArrayList<Konference> getKonferencer() {
        return new ArrayList<Konference>(konferencer);
    }

    public static ArrayList<Hotel> getHoteller() {
        return new ArrayList<Hotel>(hoteller);
    }

    public static ArrayList<Tilvalg> getTilvalgs() {
        return new ArrayList<Tilvalg>(tilvalgs);
    }

    public static void addTilmelding(Tilmelding tilmelding) {
        tilmeldings.add(tilmelding);
    }

    public static void addUdflugt(Udflugt udflugt) {
        udflugter.add(udflugt);
    }

    public static void addLedsager(Ledsager ledsager) {
        ledsagere.add(ledsager);
    }

    public static void addDeltager(Deltager deltager) {
        deltagere.add(deltager);
    }

    public static void addKonference(Konference konference) {
        konferencer.add(konference);
    }

    public static void addHotel(Hotel hotel) {
        hoteller.add(hotel);
    }

    public static void addTilvalg(Tilvalg tilvalg) {
        tilvalgs.add(tilvalg);
    }


    public static void removeUdflugt(Udflugt udflugt) {
        udflugter.remove(udflugt);
    }

    public static void removeLedsager(Ledsager ledsager) {
        ledsagere.remove(ledsager);
    }

    public static void removeDeltager(Deltager deltager) {
        deltagere.remove(deltager);
    }

    public static void removeKonference(Konference konference) {
        konferencer.remove(konference);
    }

    public static void removeHotel(Hotel hotel) {
        hoteller.remove(hotel);
    }

    public static void removeTilvalg(Tilvalg tilvalg) {
        tilvalgs.remove(tilvalg);
    }

    public static void removeTilmelding(Tilmelding tilmelding){
        tilmeldings.remove(tilmelding);
    }
}
