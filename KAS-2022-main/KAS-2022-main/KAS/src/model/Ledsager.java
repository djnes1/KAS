package model;

import java.util.ArrayList;

public class Ledsager {

    private String navn;

    //-----------------------------------------------------------------------------------
    // associering 0..* --> 0..* Udflugter
    private final ArrayList<Udflugt> udflugter = new ArrayList<>();

    //composition 0..1 --> 1 Deltager
    Deltager deltager;
    //-----------------------------------------------------------------------------------

    public Ledsager(String navn) {
        this.navn = navn;
    }


    Ledsager(String navn, Deltager deltager) {  //OBS: package visibility
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }


//-----------------------------------------------------------------------------------

    public ArrayList<Udflugt> getUdflugter() {
        return new ArrayList<Udflugt>(udflugter);
    }

    //Deltager
    public Deltager getDeltager() {
        return deltager;
    }

    public void setDeltager(Deltager deltager) {
        this.deltager = deltager;
    }
    //-----------------------------------------------------------------------------------

    /**
     * Adds the udflugt to this ledsager and the ledsager to the udflugt,
     * if they aren't connected
     */
    public void addUdflugt(Udflugt udflugt) {
        if (!udflugter.contains(udflugt)) {
            udflugter.add(udflugt);
            udflugt.addLedsager(this);
        }
    }

    /**
     * Removes the udflugt from this ledsager and the ledsager from the udflugt,
     * if they are connected
     */
    public void removeUdflugt(Udflugt udflugt) {
        if (udflugter.contains(udflugt)) {
            udflugter.remove(udflugt);
            udflugt.removeLedsager(this);
        }
    }

    //-----------------------------------------------------------------------------------
    //hjælpemetode til beregnsamletpris
    public double udflugtsPris() {
        double pris = 0;

        for (Udflugt udflugt : udflugter) {
            pris += udflugt.getPris();
        }

        return pris;
    }
    //-----------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------

    @Override
    public String toString() {
        return navn;
    }

}
