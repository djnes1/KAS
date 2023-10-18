package guifx;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.Deltager;
import model.Hotel;
import model.Tilmelding;
import model.Tilvalg;

import java.util.ArrayList;

public class HotelPane extends GridPane {

    private TextField txfInforOmHotel;

    private final ListView<Hotel> lvwHoteller = new ListView<>();
    private final ListView<Deltager> lvwDeltagere = new ListView<>();

    private final ListView<Tilvalg> lvwTilvalg = new ListView<>();

    private final ArrayList<Hotel> hoteller = new ArrayList<>();
    private final ArrayList<Deltager> deltagers = new ArrayList<>();


    public HotelPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        Label lblHoteller = new Label("Hoteller");
        this.add(lblHoteller, 0, 0);
        this.add(lvwHoteller, 0, 1);
        lvwHoteller.getItems().setAll(Controller.getHoteller());


        Label lblReserveringer = new Label("Reseverende gæster");
        this.add(lblReserveringer, 1, 0);
        this.add(lvwDeltagere, 1, 1);


        Label lblTilvalg = new Label("Tilvalg");
        this.add(lblTilvalg,2,0);
        this.add(lvwTilvalg,2,1);





        ChangeListener<Hotel> listener = (ov, oldHotel, newHotel) -> this.selectedHotelChanged();
        lvwHoteller.getSelectionModel().selectedItemProperty().addListener(listener);

        if (lvwDeltagere.getItems().size() > 0){
            lvwDeltagere.getSelectionModel().select(0);
        }
    }
       //----------------------------------------------------------------------------------



    public void selectedHotelChanged(){
        this.updateControls();
    }


    public void updateControls() {

        Hotel hotel = lvwHoteller.getSelectionModel().getSelectedItem();
        if (hotel != null) {
            lvwDeltagere.getItems().setAll(Controller.getDeltagerePåHotel(hotel));
        }
    }

    }

