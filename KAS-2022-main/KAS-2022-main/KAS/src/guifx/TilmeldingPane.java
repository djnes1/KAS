package guifx;


import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import model.*;
import storage.Storage;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class TilmeldingPane extends GridPane {

    private final TextField txfNavn = new TextField();
    private final TextField txfAdresse = new TextField();
    private final TextField txfBy = new TextField();
    private final TextField txfLand = new TextField();
    private final TextField txfTlfNr = new TextField();
    private final TextField txfFirmaNavn = new TextField();
    private final TextField txfFirmaTlf = new TextField();
    private final TextField txfLedsager = new TextField();

    private TextField txfPris = new TextField();
    private TextField txfSamletPris = new TextField();

    private final CheckBox cbxLedsager = new CheckBox();
    private final CheckBox cbxForedragsHolder = new CheckBox();
    private final CheckBox cbxFirma = new CheckBox();

    private final DatePicker dpAnkomstDato = new DatePicker();
    private final DatePicker dpAfrejseDato = new DatePicker();

    private final ComboBox<Konference> konferenceComboBox = new ComboBox<>();
    private final ComboBox<Hotel> hotelComboBoxb = new ComboBox<>();


    private final ArrayList<CheckBox> tilvalg = new ArrayList<>();
    private final ArrayList<CheckBox> udflugter = new ArrayList<>();


    public TilmeldingPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        Label lblNavn = new Label("Navn:");
        this.add(lblNavn, 0, 0);
        this.add(txfNavn, 0, 1);

        Label lblAdresse = new Label("Adresse:");
        this.add(lblAdresse, 0, 2);
        this.add(txfAdresse, 0, 3);

        Label lblBy = new Label("By:");
        this.add(lblBy, 0, 4);
        this.add(txfBy, 0, 5);

        Label lblLand = new Label("Land:");
        this.add(lblLand, 0, 6);
        this.add(txfLand, 0, 7);

        Label lblTlfNr = new Label("Telefon nummer:");
        this.add(lblTlfNr, 0, 8);
        this.add(txfTlfNr, 0, 9);

        Label lblFirmaBoolean = new Label("Firma:");
        this.add(lblFirmaBoolean, 0, 10);
        this.add(cbxFirma, 0, 11);

        Label lblFirmaNavn = new Label("Firmanavn:");
        this.add(lblFirmaNavn, 0, 12);
        this.add(txfFirmaNavn, 0, 13);

        Label lblFirmaTlf = new Label("Firma telefonnummer:");
        this.add(lblFirmaTlf, 0, 14);
        this.add(txfFirmaTlf, 0, 15);

        Label lblLedsager = new Label("Ledsager:");
        this.add(lblLedsager, 0, 16);
        this.add(cbxLedsager, 0, 17);

        Label lblLedsagerNavn = new Label("Ledsagers navn:");
        this.add(lblLedsagerNavn, 0, 18);
        this.add(txfLedsager, 0, 19);

        Label lblForedragsHolder = new Label("Foredragsholder:");
        this.add(lblForedragsHolder, 2, 4);
        this.add(cbxForedragsHolder, 2, 5);

        Label lblAnkomstDato = new Label("Afrejsedato:");
        this.add(lblAnkomstDato, 2, 8);
        this.add(dpAnkomstDato, 2, 9);

        Label lblAfrejseDato = new Label("Ankomstdato:");
        this.add(lblAfrejseDato, 2, 6);
        this.add(dpAfrejseDato, 2, 7);

        Label konferencer = new Label("Konferencer");
        this.add(konferencer, 2, 0);
        this.add(konferenceComboBox, 2, 1);
        konferenceComboBox.getItems().setAll(Controller.getKonferencer());

        Label lblUdflugter = new Label("Udflugter");
        this.add(lblUdflugter, 2, 16);

        Label lblHotel = new Label("Hoteller:");
        this.add(lblHotel, 3, 0);
        this.add(hotelComboBoxb, 3, 1);
        hotelComboBoxb.getItems().setAll(Controller.getHoteller());


        Label lblTilvalg = new Label("Tilvalg:");
        this.add(lblTilvalg, 3, 2);

        Label lblDagsPris = new Label("Dagspris for konference: ");
        this.add(lblDagsPris, 2, 2);
        this.add(txfPris, 2, 3);
        txfPris.setPrefWidth(10);
        txfPris.setEditable(false);

        Label lblSamletPris = new Label("Samlet pris: ");
        this.add(lblSamletPris, 3, 17);
        this.add(txfSamletPris, 3, 18);
        txfSamletPris.setEditable(false);

        Button tilmeldButton = new Button("Tilmeld");
        this.add(tilmeldButton, 3, 19);
        tilmeldButton.setPrefSize(150, 50);
        tilmeldButton.setFont(Font.font(25));
        tilmeldButton.setOnAction(event -> this.updateControls());
        // -------------------------------------------------------------------------
        //Listeners
        ChangeListener<Hotel> listener1 = (ov, o, n) -> this.hotelTilvalg();
        hotelComboBoxb.getSelectionModel().selectedItemProperty().addListener(listener1);

        ChangeListener<Konference> listener2 = ((observable, oldValue, newValue) -> this.udflugtsvalg());
        konferenceComboBox.getSelectionModel().selectedItemProperty().addListener(listener2);

    }

    // -------------------------------------------------------------------------


    private void selectedTilmeldingChanged() {
        this.updateControls();
    }


    public void updateControls() {

//        String navn = txfNavn.getText();
//        String adresse = txfAdresse.getText();
//        String land = txfLand.getText();
//        String tlfnr = txfTlfNr.getText();
//        String firmaTlf = txfFirmaTlf.getText();
//        String ledsagernavn = txfLedsager.getText().trim();
//        Deltager deltager = Controller.createDeltager(navn, adresse, land, tlfnr, firmaTlf);
//        Hotel hotel = hotelComboBoxb.getValue();
//        boolean foredragsholder = cbxForedragsHolder.isSelected();
//        LocalDate afrejsedato = dpAfrejseDato.getValue();
//        LocalDate ankomstdato = dpAnkomstDato.getValue();
//        Konference konference = konferenceComboBox.getValue();
//        Tilmelding tilmelding = Controller.createTilmelding(foredragsholder, afrejsedato, ankomstdato, 0, konference, deltager);
//        Storage.addTilmelding(tilmelding);

        if (konferenceComboBox.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Der er ét eller flere tomme felter", ButtonType.OK);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.OK) {
                alert.close();
            }
        } else {
            String navn = txfNavn.getText();
            String adresse = txfAdresse.getText();
            String land = txfLand.getText();
            String tlfnr = txfTlfNr.getText();
            String firmaTlf = txfFirmaTlf.getText();
            String ledsagernavn = txfLedsager.getText().trim();
            Deltager deltager = Controller.createDeltager(navn, adresse, land, tlfnr, firmaTlf);
            Hotel hotel = hotelComboBoxb.getValue();
            boolean foredragsholder = cbxForedragsHolder.isSelected();
            LocalDate afrejsedato = dpAfrejseDato.getValue();
            LocalDate ankomstdato = dpAnkomstDato.getValue();
            Konference konference = konferenceComboBox.getValue();
            Tilmelding tilmelding = Controller.createTilmelding(foredragsholder, afrejsedato, ankomstdato, 0, konference, deltager);
            Storage.addTilmelding(tilmelding);

            if (ledsagernavn.length() > 0) {
                Ledsager ledsager = Controller.createLedsager(ledsagernavn, deltager);

                for (int i = 0; i < udflugter.size(); i++) {

                    if (udflugter.get(i).isSelected()) {
                        Controller.addLedsagerTilUdflugt(ledsager, konference.getUdflugter().get(i));
                    }
                }
            }
            for (int i = 0; i < tilvalg.size(); i++) {

                if (tilvalg.get(i).isSelected()) {
                    Controller.addTilvalgTilTilmelding(tilmelding, hotel.getTilvalg().get(i));

                }
            }
            if (hotelComboBoxb.getSelectionModel().getSelectedItem() != null) {
                Controller.addTilmeldingTilHotel(hotel, tilmelding);
            }

            if (hotel != null) {
                Controller.addTilmeldingTilHotel(hotel, tilmelding);
            }


            Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION, "Samlet pris for tilmelding: " + tilmelding.beregnSamletPris(), ButtonType.OK);
            alert1.showAndWait();

            if (alert1.getResult() == ButtonType.OK) {
                txfNavn.clear();
                txfAdresse.clear();
                dpAnkomstDato.setValue(null);
                dpAfrejseDato.setValue(null);
                txfBy.clear();
                txfLand.clear();
                txfFirmaNavn.clear();
                txfFirmaTlf.clear();
                txfLedsager.clear();
                txfTlfNr.clear();
                cbxLedsager.setSelected(false);
                clearUdflugter();
                konferenceComboBox.setValue(null);
                cbxLedsager.setSelected(false);
                txfPris.setText(null);
                txfSamletPris.setText(null);
                alert1.close();
            }
        }
    }

    private void clearTilvalg() {
        for (CheckBox checkBox : tilvalg) {
            checkBox.setVisible(false);
        }
        tilvalg.clear();
    }

    private void hotelTilvalg() {
        Hotel hotel = hotelComboBoxb.getSelectionModel().getSelectedItem();
        if (hotel != null) {
            clearTilvalg();
            if (hotel.getTilvalg() != null) {
                for (int i = 0; i < hotel.getTilvalg().size(); i++) {
                    CheckBox checkBox = new CheckBox();
                    checkBox.setText(hotel.getTilvalg().get(i).getBeskrivelse() + hotel.getTilvalg().get(i).getPris());
                    tilvalg.add(checkBox);
                }
                int h = 3;
                for (CheckBox checkBox : tilvalg) {
                    this.add(checkBox, 3, h);
                    h++;
                }
            }
        }
    }

//    private void samletPris() {
//        int i = 0;
//        i = Integer.parseInt(txfPris.getText());
//        txfSamletPris.setText(i + "");
//    }

    private void udflugtsvalg() {
        Konference konference = konferenceComboBox.getSelectionModel().getSelectedItem();
        if (konference != null) {
            txfPris.setText(konference.getPris() + "");
//            samletPris();
            clearUdflugter();
            if (konference.getUdflugter() != null) {
                for (int i = 0; i < konference.getUdflugter().size(); i++) {
                    CheckBox checkBox = new CheckBox();
                    checkBox.setText(konference.getUdflugter().get(i).getNavn() + ": " + konference.getUdflugter().get(i).getPris());
                    udflugter.add(checkBox);
                }
                int h = 17;
                for (CheckBox checkBox : udflugter) {
                    this.add(checkBox, 2, h);
                }
            }
        }
    }

    private void clearUdflugter() {
        for (CheckBox checkBox : udflugter) {
            checkBox.setVisible(false);
        }
        udflugter.clear();
    }
}
