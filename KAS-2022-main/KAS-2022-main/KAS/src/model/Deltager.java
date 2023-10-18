package model;

import java.util.ArrayList;

public class Deltager {

    private String navn;
    private String adresse;
    private String land;
    private String tlfnr;
    private String firmaTlf;

    //-----------------------------------------------------------------------------------
    // composition 1-->0..1 Ledsager
    private Ledsager ledsager;

    //associering 1-->0..* enkeltrettet tilmelding
    //-----------------------------------------------------------------------------------

    public Deltager(String navn, String adresse, String land, String tlfnr, String firmaTlf) {
        this.navn = navn;
        this.adresse = adresse;
        this.land = land;
        this.tlfnr = tlfnr;
        this.firmaTlf = firmaTlf;
    }

    //------------
    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getTlfnr() {
        return tlfnr;
    }

    public void setTlfnr(String tlfnr) {
        this.tlfnr = tlfnr;
    }

    public String getFirmaTlf() {
        return firmaTlf;
    }

    public void setFirmaTlf(String firmaTlf) {
        this.firmaTlf = firmaTlf;
    }
    // -----------------------------------------------------------------------
    // Ledsager

    /**
     * Pre: Deltager har ikke en ledsager
     */
    public Ledsager createLedsager(String navn) {
        Ledsager ledsager = new Ledsager(navn);
        this.ledsager = ledsager;
        ledsager.deltager = this;
        return ledsager;
    }

    public Ledsager getLedsager() {
        return this.ledsager;
    }

    public void setLedsager(Ledsager ledsager) {
        this.ledsager = ledsager;
    }
    //-----------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------

    @Override
    public String toString() {
        return navn + "(" + ledsager.getNavn() + ")";
    }

}
