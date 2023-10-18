package guifx;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Konference;
import model.Tilmelding;

import java.util.Optional;

public class KonferencePane extends GridPane {

    private final ListView<Konference> lvwKonferenceNavn = new ListView<>();
    private final TextArea txaDeltagere;

    public KonferencePane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        Label lblKonferencer = new Label("Konferencer");
        this.add(lblKonferencer, 0, 0);
        GridPane.setValignment(lblKonferencer, VPos.TOP);
        this.add(lvwKonferenceNavn, 0, 1);
        lvwKonferenceNavn.getItems().setAll(Controller.getKonferencer());

        Label lblDeltagere = new Label("Deltagere");
        this.add(lblDeltagere, 1, 0);
        GridPane.setValignment(lblDeltagere, VPos.TOP);

        txaDeltagere = new TextArea();
        this.add(txaDeltagere, 1, 1);
        txaDeltagere.setPrefWidth(200);
        txaDeltagere.setPrefHeight(100);
        txaDeltagere.setEditable(false);
        txaDeltagere.setWrapText(true);

        ChangeListener<Konference> listener = (ov, oldKonference, newKonference) -> this.selectedKonferenceChanged();
        lvwKonferenceNavn.getSelectionModel().selectedItemProperty().addListener(listener);

        //Dette skal måske slettes..
        if (lvwKonferenceNavn.getItems().size() > 0) {
            lvwKonferenceNavn.getSelectionModel().select(0);
        }

        VBox vbxButtons = new VBox(40);
        this.add(vbxButtons, 0, 2, 1, 1);
        vbxButtons.setPadding(new Insets(5, 0, 0, 0));
        vbxButtons.setAlignment(Pos.BASELINE_LEFT);

        Button btnCreate = new Button("Opret konference");
        vbxButtons.getChildren().add(btnCreate);
        btnCreate.setOnAction(event -> this.createAction());

        Button btnUpdate = new Button("Opdater konference");
        vbxButtons.getChildren().add(btnUpdate);
        btnUpdate.setOnAction(event -> this.updateAction());

        Button btnDelete = new Button("Slet konference");
        vbxButtons.getChildren().add(btnDelete);
        btnDelete.setOnAction(event -> this.deleteAction());

    }

    // -------------------------------------------------------------------------

    private void createAction() {
        KonferenceWindow dia = new KonferenceWindow("Opret konference");
        dia.showAndWait();

        // Wait for the modal dialog to close

        lvwKonferenceNavn.getItems().setAll(Controller.getKonferencer());
        int index = lvwKonferenceNavn.getItems().size() - 1;
        lvwKonferenceNavn.getSelectionModel().select(index);
    }

    private void updateAction() {
        Konference konference = lvwKonferenceNavn.getSelectionModel().getSelectedItem();
        if (konference != null) {

            KonferenceWindow dia = new KonferenceWindow("Update Konference", konference);
            dia.showAndWait();

            // Wait for the modal dialog to close

            int selectIndex = lvwKonferenceNavn.getSelectionModel().getSelectedIndex();
            lvwKonferenceNavn.getItems().setAll(Controller.getKonferencer());
            lvwKonferenceNavn.getSelectionModel().select(selectIndex);
        }
    }

    private void deleteAction() {
        Konference konference = lvwKonferenceNavn.getSelectionModel().getSelectedItem();
        if (konference != null) {

            if (konference.getTilmeldinger().contains(null)) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Delete Konference");
                // alert.setContentText("Are you sure?");
                alert.setHeaderText("Are you sure?");
                Optional<ButtonType> result = alert.showAndWait();
                if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
                    Controller.deleteKonference(konference);
                    lvwKonferenceNavn.getItems().setAll(Controller.getKonferencer());
                    this.updateControls();
                }

            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Delete Konference");
                alert.setHeaderText("Konferencen har aktive tilmeldinger");
                // wait for the modal dialog to close
                alert.show();
            }
        }
    }

    // -------------------------------------------------------------------------

    private void selectedKonferenceChanged() {
        this.updateControls();
    }

    public void updateControls() {
        Konference konference = lvwKonferenceNavn.getSelectionModel().getSelectedItem();
        if (konference != null) {
            StringBuilder sb = new StringBuilder();
            for (Tilmelding tilmeld : konference.getTilmeldinger()) {
                sb.append(tilmeld + "\n");
            }
            txaDeltagere.setText(sb.toString());
        } else {
            txaDeltagere.clear();
        }
    }
}