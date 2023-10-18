package guifx;

import controller.Controller;
import guifx.HotelPane;
import guifx.KonferencePane;
import guifx.TilmeldingPane;
import guifx.UdflugtPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class StartWindow extends Application {


    @Override
    public void init() {
        Controller.init();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("KAS");
        BorderPane pane = new BorderPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private void initContent(BorderPane pane) {
        TabPane tabPane = new TabPane();
        this.initTabPane(tabPane);
        pane.setCenter(tabPane);
    }

    private void initTabPane(TabPane tabPane) {
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Tab tabKonferencer = new Tab("Oversigt");
        tabPane.getTabs().add(tabKonferencer);

        KonferencePane konferencePane = new KonferencePane();
        tabKonferencer.setContent(konferencePane);
        tabKonferencer.setOnSelectionChanged(event -> konferencePane.updateControls());

        Tab tabTilmeldinger = new Tab("Tilmeld Konference");
        tabPane.getTabs().add(tabTilmeldinger);

        TilmeldingPane tilmeldingPane = new TilmeldingPane();
        tabTilmeldinger.setContent(tilmeldingPane);
//        tabTilmeldinger.setOnSelectionChanged(event -> tilmeldingPane.updateControls());

        Tab tabHotels = new Tab("Hotel");
        tabPane.getTabs().add(tabHotels);

        HotelPane hotelPane = new HotelPane();
        tabHotels.setContent(hotelPane);
        tabHotels.setOnSelectionChanged(event -> hotelPane.updateControls());

        Tab tabUdflugter = new Tab("Udflugter");
        tabPane.getTabs().add(tabUdflugter);

        UdflugtPane udflugtPane = new UdflugtPane();
        tabUdflugter.setContent(udflugtPane);
        tabHotels.setOnSelectionChanged(event -> udflugtPane.updateControls());


    }

}
