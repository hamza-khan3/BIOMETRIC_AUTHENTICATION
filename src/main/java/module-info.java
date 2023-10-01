module com.application.project.biometricauth {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.application.project.biometricauth to javafx.fxml;
    exports com.application.project.biometricauth;
}