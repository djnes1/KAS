package model;

import java.util.ArrayList;

public class Hotel {

    private String navn;
    private String adresse;
    private int prisEnkelt;
    private int prisDobbelt;
    //--------------------------------------------------------------------------------------------------------------------
    // associering 0..1 --> 0..* model.Tilmelding
    private final ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();

    //composition  1 -->0..* model.Tilvalg
    private ArrayList<Tilvalg> tilvalgs = new ArrayList<>();

    //--------------------------------------------------------------------------------------------------------------------
    public Hotel(String navn, String adresse, int prisEnkelt, int prisDobbelt) {
        this.navn = navn;
        this.adresse = adresse;
        this.prisEnkelt = prisEnkelt;
        this.prisDobbelt = prisDobbelt;
    }



    //--------------------------------------------------------------------------------------------------------------------
    //model.Tilmelding

    /**
     *
     * @return
     */
    public ArrayList<Tilmelding> getTilmeldinger(){
        return new ArrayList<>(tilmeldinger);
    }

    /**
     * PRE: the Tilmelding is NOT connected to this hotel
     * @param tilmelding
     */
    public void addTilmelding(Tilmelding tilmelding){
        tilmeldinger.add(tilmelding);
        tilmelding.setHotel(this);
    }

    /**
     * PRE: the Tilmelding is connected to this hotel
     * @param tilmelding
     */
    public void removeTilmelding(Tilmelding tilmelding){
        tilmeldinger.remove(tilmelding);
    }

    //--------------------------------------------------------------------------------------------------------------------
    //model.Tilvalg

    /**
     * @return
     */
    public ArrayList<Tilvalg> getTilvalg() {
        return new ArrayList<>(tilvalgs);
    }

    /**
     * @param beskrivelse
     * @param pris
     * @return
     */
    public Tilvalg createTilvalg(String beskrivelse, int pris) {
        Tilvalg tilvalg = new Tilvalg(beskrivelse, pris);
        tilvalgs.add(tilvalg);
        return tilvalg;
    }


    //--------------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------


    public int getPrisEnkelt() {
        return prisEnkelt;
    }

    public int getPrisDobbelt() {
        return prisDobbelt;
    }

    public void setPrisEnkelt(int prisEnkelt) {
        this.prisEnkelt = prisEnkelt;
    }

    public void setPrisDobbelt(int prisDobbelt) {
        this.prisDobbelt = prisDobbelt;
    }
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public ArrayList<Tilvalg> getTilvalgs() {
        return tilvalgs;
    }

    public void setTilvalgs(ArrayList<Tilvalg> tilvalgs) {
        this.tilvalgs = tilvalgs;
    }

    @Override
    public String toString() {
        return navn;
    }


}
