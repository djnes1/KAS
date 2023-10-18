package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Tilmelding {

    private boolean foredragsholder;
    private LocalDate afrejsedato;
    private LocalDate ankomstdato;
    private int tilmeldingNR;

    //--------------------------------------------------------------------------------------------------------------------
    //enkeltrettet associering 0..* --> 0..* model.Tilvalg
    private final ArrayList<Tilvalg> tilvalgs = new ArrayList<>(); //final?

    // enkeltrettet associering 0..* --> 1 model.Deltager
    private Deltager deltager; //final?

    // associering 0..* --> 0..1 model.Hotel
    private Hotel hotel; //final?

    //composition 0..* --> 0..* konference
    private Konference konference;
    //--------------------------------------------------------------------------------------------------------------------


    //Tilvalg
    public ArrayList<Tilvalg> getTilvalgs() {
        return new ArrayList<>(tilvalgs);
    }

    /**
     * PRE: this tilvalg is NOT connected to this Tilmelding
     *
     * @param tilvalg
     */
    public void addTilvalg(Tilvalg tilvalg) {
        tilvalgs.add(tilvalg);
    }

    /**
     * PRE: this tilvalg is connected to this Tilmelding
     *
     * @param tilvalg
     */
    public void removeTilvalg(Tilvalg tilvalg) {
        tilvalgs.remove(tilvalg);
    }

    public Deltager getDeltager() {
        return this.deltager;
    }

    //--------------------------------------------------------------------------------------------------------------------
    //
    //--------------------------------------------------------------------------------------------------------------------
    //model.Hotel


    public Tilmelding(boolean foredragsholder, LocalDate ankomstdato, LocalDate afrejsedato, int tilmeldingNR, Konference konference, Deltager deltager) {
        this.foredragsholder = foredragsholder;
        this.afrejsedato = afrejsedato;
        this.ankomstdato = ankomstdato;
        this.tilmeldingNR = tilmeldingNR;
        this.konference = konference;
        this.deltager = deltager;
    }


    public double beregnSamletPris() {
        double samletPris = 0;

        int daysBetweenHotel = (int) ankomstdato.until(afrejsedato, ChronoUnit.DAYS);

        if (hotel != null && deltager.getLedsager() != null) {
            samletPris += hotel.getPrisDobbelt() * daysBetweenHotel;
        }

        double prisTilvalg = 0;

        for (Tilvalg tilvalg : tilvalgs) {
            prisTilvalg += tilvalg.getPris();
        }

        samletPris += prisTilvalg * daysBetweenHotel;

        if (hotel != null && deltager.getLedsager() == null) {
            samletPris += hotel.getPrisEnkelt() * daysBetweenHotel;
        }

        int daysBetweenKonference = (int) ankomstdato.until(afrejsedato, ChronoUnit.DAYS) + 1;

        if (!foredragsholder) {
            samletPris += konference.getPris() * daysBetweenKonference;
        }

        if (deltager.getLedsager() != null) {
            samletPris += deltager.getLedsager().udflugtsPris();
        }

        return samletPris;
    }
    //--------------------------------------------------------------------------------------------------------------------
//    int sum = 0;
//        for (Deltager d : deltagere) {
//        for (Hotel h : hoteller) {
//            if (d.getLedsager() != null) {
//                sum += h.getPrisDobbelt() * (ankomstdato.until(afrejsedato, ChronoUnit.DAYS));
//            } else {
//                sum += h.getPrisEnkelt() * (ankomstdato.until(afrejsedato, ChronoUnit.DAYS));
//            }
//
//        }
//        sum += konference.getPris() * (ankomstdato.until(afrejsedato, ChronoUnit.DAYS));
//        for (Tilvalg tilvalg : tilvalgs) {
//            sum += tilvalg.getPris();
//        }
//    }
//        for (Tilvalg t : tilvalgs) {
//        sum += t.getPris();
//    }
//
//        return sum;
    //--------------------------------------------------------------------------------------------------------------------
    public void setDeltager(Deltager deltager) {
        this.deltager = deltager;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Konference getKonference() {
        return konference;
    }

    public void setKonference(Konference konference) {
        this.konference = konference;
    }

    public boolean isForedragsholder() {
        return foredragsholder;
    }

    public void setForedragsholder(boolean foredragsholder) {
        this.foredragsholder = foredragsholder;
    }

    public LocalDate getAfrejsedato() {
        return afrejsedato;
    }

    public void setAfrejsedato(LocalDate afrejsedato) {
        this.afrejsedato = afrejsedato;
    }

    public LocalDate getAnkomstdato() {
        return ankomstdato;
    }

    public void setAnkomstdato(LocalDate ankomstdato) {
        this.ankomstdato = ankomstdato;
    }

    public int getTilmeldingNR() {
        return tilmeldingNR;
    }

    public void setTilmeldingNR(int tilmeldingNR) {
        this.tilmeldingNR = tilmeldingNR;
    }
    //--------------------------------------------------------------------------------------------------------------------


    @Override
    public String toString() {
        return "" + deltager.getNavn() + ", foredragsholder: " +
                foredragsholder +
                ", tilmeldingNR: " + tilmeldingNR +
                ", ankomstdato=" + ankomstdato + '\n';
    }
}
