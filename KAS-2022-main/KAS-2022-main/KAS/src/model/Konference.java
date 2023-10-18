package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Konference {

    private String adresse;
    private String navn;
    private LocalDate startDato;
    private final LocalDate slutDato;
    private int pris;
    //-----------------------------------------------------------------------------------
    // enkeltrettet composition 1 --> 0..* Udflugt
    private final ArrayList<Udflugt> udflugter = new ArrayList<>();
    //
    private final ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();
    //Her forbinder vi klasserne model.Hotel og model.Konference
    //jf. enkeltrettet til mange asso. i bogen

    private final ArrayList<Hotel> hoteller = new ArrayList<>();

    //-----------------------------------------------------------------------------------

    public Konference(String adresse, String navn, LocalDate startDato,LocalDate slutDato, int pris) {
        this.adresse = adresse;
        this.navn = navn;
        this.startDato = startDato;
        this.pris = pris;
        this.slutDato = slutDato;
    }

    //--------------------------------------------------------------------------------------------------------------------

    //Tilmelding

    /**
     *
     * @return
     */
    public ArrayList<Tilmelding> getTilmeldinger(){
        return new ArrayList<>(tilmeldinger);
    }

    public Tilmelding createTilmelding(boolean foredragsholder, LocalDate afrejsedato, LocalDate ankomstdato, int tilmeldingNR, Konference konference, Deltager deltager){
        Tilmelding tilmelding = new Tilmelding(foredragsholder,afrejsedato,ankomstdato,tilmeldingNR,konference, deltager);
        tilmeldinger.add(tilmelding);
        return tilmelding;
    }

    //Hotel

    /**
     * @return
     */
    public ArrayList<Hotel> getHoteller() {
        return new ArrayList<>(hoteller);
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public void setStartDato(LocalDate startDato) {
        this.startDato = startDato;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    //Ingen prbetingelse her, da det er mange til mange. Modsat mange til 0..1.

    /**
     * @param hotel
     */
    public void addHotel(Hotel hotel) {
        if (!hoteller.contains(hotel)) {
            hoteller.add(hotel);

        }
    }

    /**
     * @param hotel
     */
    public void removePerson(Hotel hotel) {
        hoteller.remove(hotel);
    }
    //-----------------------------------------------------------------------------------
    //Udflugt

    /**
     * @return
     */
    public ArrayList<Udflugt> getUdflugter() {
        return new ArrayList<>(udflugter);
    }

    public Udflugt createUdflugt(String navn, LocalDate dato, String beskrivelse, int pris, String lokation) {
        Udflugt udflugt = new Udflugt(navn, dato, beskrivelse, pris, lokation);
        udflugter.add(udflugt);
//        udflugt.konference = this;
        return udflugt;
    }
    //-----------------------------------------------------------------------------------
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
    //-----------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------

    @Override
    public String toString() {
        return navn + ", " + adresse + ", " + startDato + ", " + pris + "kr";
    }
}


