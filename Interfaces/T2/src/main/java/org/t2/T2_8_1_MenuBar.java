package org.t2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T2_8_1_MenuBar extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane borderPane = new BorderPane();

        MenuBar mainBar = new MenuBar();
        borderPane.setTop(mainBar);

        //Nivel file 1
        Menu menuFileLv1 = new Menu("File");
        mainBar.getMenus().addAll(menuFileLv1, new Menu("HOLA MUNDO"));

        String[] namesLv1 = {"New",
                "Open...",
                "Recent Projects",
                "Close Project",
                "Settings...",
                "Project Structure...",
                "Plugins...",
                "File Properties",
                "Local History",
                "Save All",
                "Reload All from Disk",
                "Repair IDE",
                "Invalidate Caches...",
                "Manage IDE Settings",
                "New Projects Setup",
                "Save File as Template",
                "Export",
                "Print...",
                "Power Save Mode",
                "Exit"};

        int[] excluidosLv1 = {0, 2, 7, 8, 13, 14, 16};

        List<MenuItem> menuItemsLv1 = getElementosList(namesLv1, excluidosLv1);


        menuFileLv1.getItems().addAll(menuItemsLv1);

        int[] incluidosAtj1 = {4, 5, 9, 10};
        String[] atajos1 = {
                "Ctrl+Alt+S",
                "Ctrl+Alt+SHIFT+S", // "Mayús" no es reconocido por JavaFX
                "Ctrl+S",
                "Ctrl+Alt+Y"
        };

        int[] incluidosImg1 = {1, 4, 5, 9, 10, 17};
        String[] rutasImg1 = {
                "file:src/main/resources/img/open.png",
                "file:src/main/resources/img/settings.png",
                "file:src/main/resources/img/projectStructure.png",
                "file:src/main/resources/img/save.png",
                "file:src/main/resources/img/reloadAllFromDisk.png",
                "file:src/main/resources/img/print.png"
        };

        setImagenesRuta(
                menuItemsLv1,
                incluidosImg1,
                rutasImg1,
                incluidosAtj1,
                atajos1
        );

        // Nivel 1.0 new
        String[] namesNewLv2 = {
                "Project...",
                "Project from Existing Sources...",
                "Project from Version Control...",
                "Module...",
                "Module from Existing Sources...",
                "Java Class",
                "Kotlin Class/File",
                "File",
                "Package",
                "FXML File",
                "JavaFX Application",
                "package-info.java",
                "module-info.java",
                "Resource Bundle"
        };
        int[] excluidosNewLv2= {5};

        List<MenuItem> menuNewItemsLv2 = getElementosList(namesNewLv2, excluidosNewLv2);
        Menu newMenu = (Menu) menuItemsLv1.get(0);
        newMenu.getItems().addAll(menuNewItemsLv2);

        String[] rutasNewLv2 = {
                "file:src/main/resources/img/newLv2/class.png",
                "file:src/main/resources/img/newLv2/kotlin_dark.png",
                "file:src/main/resources/img/newLv2/inlayRenameInNoCodeFiles.png",
                "file:src/main/resources/img/newLv2/package_dark.png",
                "file:src/main/resources/img/newLv2/xml.png",
                "file:src/main/resources/img/newLv2/class.png",
                "file:src/main/resources/img/newLv2/java_dark.png",
                "file:src/main/resources/img/newLv2/java.png",
                "file:src/main/resources/img/newLv2/settings.png"
        };
        int[] incluidosNewImgLv2 = {5, 6, 7, 8, 9, 10, 11, 12, 13};
        setImagenesRuta(
                menuNewItemsLv2,
                incluidosNewImgLv2,
                rutasNewLv2,
                new int[0],
                new String[0]
        );

        //nivel 1.2 RecentProjects
        String[] namesRecentProjectsLv2 = {
                "~/Escritorio/DAM/PSP/PSP_Proyecto",
                "~/Escritorio/DAM/PSP/FastBox",
                "~/Escritorio/DAM/Moviles_&_PSP/FastBox",
                "~/Escritorio/DAM/Moviles_kotlin_0",
                "Kotlin1",
                "~/Escritorio/DAM/Moviles_&_PSP/kotlin_0",
                "~/Escritorio/DAM/Moviles_&_PSP/PSP_Proyecto",
                "Manage Projects..."
        };


        List<MenuItem> menuRecentProjectsLv2 = getElementosList(namesRecentProjectsLv2, new int[0]);
        Menu recentProjects = (Menu) menuItemsLv1.get(2);
        recentProjects.getItems().addAll(menuRecentProjectsLv2);

        //nivel 1.7 FileProperties
        String[] namesFilePropertiesLv2 = {
                "File Encoding",
                "Remove BOM",
                "Add BOM",
                "Associate with File Type...",
                "Make file read-only",
                "Line Separators"
        };

        int[] excluidosFilePropertiesLv2 = {5};

        List<MenuItem> menuItemsFilePropertiesLv2 =
                getElementosList(
                        namesFilePropertiesLv2,
                        excluidosFilePropertiesLv2
                );

        Menu fileProperties = (Menu) menuItemsLv1.get(7);
        fileProperties.getItems().addAll(menuItemsFilePropertiesLv2);

        //nivel 1.8 LocalHistory
        String[] namesLocalHistoryLv2 = {
                "Show History...",
                "Show History for Selection...",
                "Show Project History...",
                "Recent Changes",
                "Put Label..."
        };

        List<MenuItem> itemsLocalHistoryLv2 = getElementosList(namesLocalHistoryLv2, new int[0] );
        itemsLocalHistoryLv2.get(3).setAccelerator(KeyCombination.keyCombination("Ctrl+Shift+C"));
        Menu localHistory = (Menu) menuItemsLv1.get(8);
        localHistory.getItems().addAll(itemsLocalHistoryLv2);

        //nivel 1.7.0 LineSeparators
        String[] namesLineSeparatorsLv3  = {
                "CRLF - Windows (\\r\\n)",
                "LF - Unix and macOS (\\n)",
                "CR - Classic Mac OS (\\r)"
        };
        List<MenuItem> itemsLineSeparatorsLv3 = getElementosList(namesLineSeparatorsLv3, new int[0]);
        Menu lineSeparators = (Menu) menuItemsFilePropertiesLv2.get(5);
        lineSeparators.getItems().addAll(itemsLineSeparatorsLv3);

        //nivel 1.13 ManageIDESettings
        String[] namesManageIDESettingsLv2  = {
                "Import Settings...",
                "Export Settings...",
                "Restore Default Settings...",
                "Backup and Sync..."
        };
        List<MenuItem> itemsManageIDESettings = getElementosList(namesManageIDESettingsLv2, new int[0]);
        Menu manageIDESettings = (Menu) menuItemsLv1.get(13);
        manageIDESettings.getItems().addAll(itemsManageIDESettings);


        //nivel 1.14 NewProjectsSetup
        String[] namesNewProjectsSetupLv2 = {
                "Settings for New Projects...",
                "Run Configuration Templates...",
                "Save Project as Template...",
                "Manage Project Templates..."
        };
        List<MenuItem> itemsNewProjectsSetupLv2 = getElementosList(namesNewProjectsSetupLv2, new int[0]);
        Menu newProjectsSetup = (Menu) menuItemsLv1.get(14);
        newProjectsSetup.getItems().addAll(itemsNewProjectsSetupLv2);

        //nivel 1.16 Export
        String[] namesExportLv2 = {"Files or Selection to HTML...", "Project to Eclipse..."};
        List<MenuItem> itemsExportLv2 = getElementosList(namesExportLv2, new int[0]);
        Menu export = (Menu) menuItemsLv1.get(16);
        export.getItems().addAll(itemsExportLv2);

        Scene scene = new Scene(borderPane, 400, 150);
        primaryStage.setTitle("T2.8.1 MenuBar");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /*
        Esta funcion permite crear una lista entera de objetos tipo Menu y MenuItem
        excluyendo unicamente las posiciones seleccionadas en "excluidos".
    */
    public static List<javafx.scene.control.MenuItem> getElementosList(
            String[] namesLv, int[] excluidos) {

        boolean[] boolMenuItems = new boolean[namesLv.length];
        Arrays.fill(boolMenuItems, true);

        for (Integer i : excluidos) {
            boolMenuItems[i] = false;
        }

        List<javafx.scene.control.MenuItem> lista = new ArrayList<>();

        for (int i = 0; i < namesLv.length; i++) {
            String name = namesLv[i];

            if (boolMenuItems[i]) {
                lista.add(new javafx.scene.control.MenuItem(name));
            } else {
                lista.add(new javafx.scene.control.Menu(name));
            }
        }

        return lista;
    }

    /*
        Esta funcion permite añadir a una lista de elementos MenuItem
        un atajo o un icono en la posicion correspondiente.
    */
    public static void setImagenesRuta(
            List<javafx.scene.control.MenuItem> lista,
            int[] incluidosImg,
            String[] rutasImg,
            int[] incluidosAtj,
            String[] atajos) {

        int contImg = 0;
        int contAtj = 0;

        for (int i = 0; i < lista.size(); i++) {

            if (contImg < incluidosImg.length && i == incluidosImg[contImg]) {

                Image image = new Image(rutasImg[contImg]);
                ImageView imageView = new ImageView(image);

                imageView.setFitWidth(15);
                imageView.setFitHeight(15);

                lista.get(i).setGraphic(imageView);

                contImg++;
            }

            if (contAtj < incluidosAtj.length && i == incluidosAtj[contAtj]) {
                lista.get(i).setAccelerator(KeyCombination.keyCombination(atajos[contAtj]));
                contAtj++;
            }
        }
    }
}



