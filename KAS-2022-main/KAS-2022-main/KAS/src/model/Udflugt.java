package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Udflugt {

    private final String navn;
    private LocalDate dato;
    private final String beskrivelse;
    private int pris;
    private final String lokation;
    //---------------------------------------------------------------------
    // associering 0..* --> 0..* Ledsager
    private final ArrayList<Ledsager> ledsagere = new ArrayList<>();
    //
//    Konference konference;

    //---------------------------------------------------------------------

    Udflugt(String navn, LocalDate dato, String beskrivelse, int pris, String lokation) {
        this.navn = navn;
        this.dato = dato;
        this.beskrivelse = beskrivelse;
        this.pris = pris;
        this.lokation = lokation;

    }


    //---------------------------------------------------------------------

    public ArrayList<Ledsager> getLedsagere() {
        return new ArrayList<>(ledsagere);
    }

    public LocalDate getDato() {
        return dato;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

//    public Konference getKonference() {
//        return konference;
//    }

    public String getNavn() {
        return navn;
    }

    //---------------------------------------------------------------------
    //ledsager

    /**
     * Adds the ledsager to this udflugt and the udflugt to the ledsager,
     * if they aren't connected.
     */
    public void addLedsager(Ledsager ledsager) {
        if (!ledsagere.contains(ledsager)) {
            ledsagere.add(ledsager);
            ledsager.addUdflugt(this);
        }
    }

    /**
     * Removes the ledsager from this udflugt and the udflugt from the ledsager,
     * if they are connected.
     */
    public void removeLedsager(Ledsager ledsager) {
        if (ledsagere.contains(ledsager)) {
            ledsagere.remove(ledsager);
            ledsager.removeUdflugt(this);
        }
    }
    //---------------------------------------------------------------------

    //-----------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------


    @Override
    public String toString() {
        return navn;
    }
}
