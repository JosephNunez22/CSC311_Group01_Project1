module edu.farmingdale.csc311_group01_project1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens edu.farmingdale.csc311_group01_project1 to javafx.fxml;
    exports edu.farmingdale.csc311_group01_project1;
}