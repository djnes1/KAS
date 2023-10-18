package model;

public class Tilvalg {

    private final String beskrivelse;
    private int pris;
    //-----------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------

    Tilvalg(String beskrivelse, int pris) {
        this.beskrivelse = beskrivelse;
        this.pris = pris;
    }
    
    //-----------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------


    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    @Override
    public String toString() {
        return "Tilvalg{" +
                "beskrivelse='" + beskrivelse + '\'' +
                ", pris=" + pris +
                '}';
    }
}
