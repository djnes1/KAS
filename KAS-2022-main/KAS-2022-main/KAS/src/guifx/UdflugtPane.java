package guifx;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.Konference;
import model.Ledsager;
import model.Udflugt;
import javafx.scene.control.TextArea;
import java.util.ArrayList;

public class UdflugtPane extends GridPane {
    private TextField txfUdflugter;

    private final ListView<Ledsager> lvwLedsagerNavn = new ListView<>();
    private final ListView<Udflugt> lvwUdflugtNavn = new ListView<>();

    private final ArrayList<Ledsager> ledsagere = new ArrayList<>();
    private final ArrayList<Udflugt> udflugter = new ArrayList<>();

    private TextArea txaLedsagere;

    public UdflugtPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        Label lblUdflugt = new Label("Udflugt:");
        this.add(lblUdflugt, 0, 0);
        GridPane.setValignment(lblUdflugt, VPos.TOP);
        this.add(lvwUdflugtNavn, 0, 1);
        lvwUdflugtNavn.getItems().setAll(Controller.getUdflugter());


        //Herunder er der en listener. Når musen trykker på en konference, skal ledsager ListView opdateres.
        ChangeListener<Udflugt> listener = (ov, oldUdflugt, newUdflugt) -> this.selectedUdflugtChanged();
        lvwUdflugtNavn.getSelectionModel().selectedItemProperty().addListener(listener);


        Label lblLedsagere = new Label("Ledsager:");
        this.add(lblLedsagere, 1, 0);
        GridPane.setValignment(lblLedsagere, VPos.TOP);
        this.add(lvwLedsagerNavn,1,1);

        txaLedsagere = new TextArea();
        this.add(txaLedsagere, 1, 1);
        txaLedsagere.setPrefWidth(200);
        txaLedsagere.setPrefHeight(100);
        txaLedsagere.setEditable(false);
        txaLedsagere.setWrapText(true);

    }

    private void selectedUdflugtChanged() {
        this.updateControls();
    }

    public void updateControls() {
    Udflugt udflugt = lvwUdflugtNavn.getSelectionModel().getSelectedItem();
    if (udflugt != null){
        lvwLedsagerNavn.getItems().setAll(Controller.getLedsagereFraUdflugt(udflugt));
    } else {
        lvwLedsagerNavn.getItems().clear();
    }





/*        Udflugt udflugt = lvwUdflugtNavn.getSelectionModel().getSelectedItem();
        if (udflugt != null) {
            StringBuilder sb = new StringBuilder();
            for (Ledsager ledsag : udflugt.getLedsagere()) {
                sb.append(ledsag + "\n");
            }
            txaLedsagere.setText(sb.toString());
        } else
            txaLedsagere.clear();*/

    }

}
