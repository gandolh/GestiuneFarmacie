module gestiune.farmacie {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.microsoft.sqlserver.jdbc;
    requires java.sql;

    opens gestiune.farmacie to javafx.fxml;
    exports gestiune.farmacie;
    exports gestiune.farmacie.controllers;
    opens gestiune.farmacie.controllers to javafx.fxml;
    requires java.naming;
    requires java.mail;
    opens gestiune.farmacie.data.objects to javafx.base;
}
