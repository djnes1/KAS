package guifx;

import controller.Controller;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Hotel;
import model.Konference;
import model.Udflugt;

import java.time.LocalDate;

public class KonferenceWindow extends Stage {
    private Konference konference;

    public KonferenceWindow(String title, Konference konference){
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.konference = konference;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    public KonferenceWindow(String title){
        this(title, null);
    }

    // -------------------------------------------------------------------------

    private TextField txfAdresse, txfNavn, txfPris;

    private LocalDate startDato;
    private LocalDate slutDato;

    private ComboBox<Udflugt> udflugtComboBoxb;
    private ComboBox<Hotel> hotelComboBoxb;

    private Label lblError;

    private final DatePicker dpAnkomstDato = new DatePicker();
    private final DatePicker dpAfrejseDato = new DatePicker();

    private void initContent(GridPane pane){
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblNavn = new Label("Navn");
        pane.add(lblNavn, 0, 0);
        txfNavn = new TextField();
        pane.add(txfNavn, 1, 0);
        txfNavn.setPrefWidth(200);

        Label lblAdresse = new Label("Adresse");
        pane.add(lblAdresse, 0, 1);
        txfAdresse = new TextField();
        pane.add(txfAdresse, 1, 1);
        txfAdresse.setPrefWidth(200);

        Label lblPris = new Label("Pris");
        pane.add(lblPris, 0, 2);
        txfPris = new TextField();
        pane.add(txfPris, 1, 2);
        txfPris.setPrefWidth(200);

        Label lblAnkomstDato = new Label("Ankomstdato:");
        pane.add(lblAnkomstDato, 2, 0);
        pane.add(dpAnkomstDato, 2, 1);

        Label lblAfrejseDato = new Label("Afrejsedato:");
        pane.add(lblAfrejseDato, 2, 2);
        pane.add(dpAfrejseDato, 2, 3);


        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 1, 4);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnOK = new Button("OK");
        pane.add(btnOK, 0, 4);
        GridPane.setHalignment(btnOK, HPos.RIGHT);
        btnOK.setOnAction(event -> this.okAction());

        lblError = new Label();
        pane.add(lblError, 0, 5);
        lblError.setStyle("-fx-text-fill: red");

        this.initControls();
    }

    private void initControls(){
        if (konference != null){
            txfNavn.setText(konference.getNavn());
            txfAdresse.setText(konference.getAdresse());
            txfPris.setText(String.valueOf(konference.getPris()));
        } else {
            txfNavn.clear();
            txfAdresse.clear();
            txfPris.clear();
        }
    }

    // -------------------------------------------------------------------------

    private void cancelAction(){
        this.hide();
    }

    private void okAction(){
        String navn = txfNavn.getText().trim();
        if (navn.length() == 0) {
            lblError.setText("Navn er tom");
        } else {
            String adresse = txfAdresse.getText().trim();
            if (adresse.length() == 0) {
                lblError.setText("Adresse er tom");
            } else {
                int pris = -1;
                try {
                    pris = Integer.parseInt(txfPris.getText().trim());
                } catch (NumberFormatException ex) {
                    // do nothing
                }
                if (pris < 0) {
                    lblError.setText("Pris skal være et positivt tal");
                } else {
                    // Call application.controller methods
                    if (konference != null) {
                        Controller.updateKonference(konference, adresse, navn, startDato, pris);
                    } else {
                        Controller.createKonference(adresse, navn, startDato, slutDato, pris);
                    }
                    this.hide();
                }
            }
        }
    }


}
