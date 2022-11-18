module gestiune.farmacie {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens gestiune.farmacie to javafx.fxml;
    exports gestiune.farmacie;
}