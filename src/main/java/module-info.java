module com.edcards.edcards {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires java.smartcardio;
    requires java.desktop;

    exports com.edcards.edcards;
    exports com.edcards.edcards.FormControllers;
    opens com.edcards.edcards.FormControllers to javafx.fxml;
    opens com.edcards.edcards to javafx.fxml, javafx.graphics;
    exports com.edcards.edcards.tests;
    opens com.edcards.edcards.tests to javafx.fxml, javafx.graphics;
}