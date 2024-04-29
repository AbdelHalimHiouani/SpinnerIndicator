package com.flexible.control;

import com.flexible.annotations.Controller;
import com.flexible.annotations.JavaVersion;
import com.flexible.impl.StyleSheet;
import javafx.scene.control.ProgressIndicator;

import java.util.Objects;

@JavaVersion(version = "21.0.1")
@Controller(name = "MFASpinnerIndicator")
public class MFASpinnerIndicator extends ProgressIndicator implements StyleSheet {
    private final static String STYLE_NAME = "mfa-spinner-indicator";

    @SuppressWarnings("unused")
    public static MFASpinnerIndicator SPINNER_INDICATOR =
            new MFASpinnerIndicator();

    public MFASpinnerIndicator() {
        initialize();
    }

    @Override
    public void initialize() {
        /**
         * ADD A NEW CLASS STYLE
         **/
        this.getStyleClass().add(STYLE_NAME);

        /**
         * SET DEFAULT SIZE OF THIS CONTROLLER
         **/
        this.setPrefSize(15,15);
    }


    @Override
    public String getRequireStyleSheet() {
        return Objects.requireNonNull(getClass().getResource("/com/flexible/style/mfa-spinner-indicator.css")).toExternalForm();
    }

    @Override
    public String getUserAgentStylesheet() {
        return getRequireStyleSheet();
    }
}
