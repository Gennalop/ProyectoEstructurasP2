module com.mycompany.tresenraya {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.tresenraya to javafx.fxml;
    exports com.mycompany.tresenraya;
    
    opens controllers to javafx.fxml;
    exports controllers;
    
    opens modelo to javafx.fxml;
    exports modelo;
    
    opens util to javafx.fxml;
    exports util;
}
