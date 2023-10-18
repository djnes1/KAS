package controller;

import model.*;
import storage.Storage;

import java.time.LocalDate;

public class TestController {
    public static void main(String[] args) {
        Controller.initStorage();
        System.out.println(Storage.getDeltagere());
        System.out.println(Storage.getKonferencer());
        System.out.println(Storage.getTilmeldings());
        System.out.println(Storage.getHoteller());
        System.out.println(Storage.getLedsagere());
        System.out.println(Storage.getUdflugter());
        System.out.println(Storage.getTilvalgs());
        /*Controller.getLedsagerPåUdflugt();*/

    }
}
