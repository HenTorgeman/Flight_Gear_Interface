package anomalyDetectors;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.layout.AnchorPane;
import config.TimeSeries;

public interface AnomalyDetector{
    StringProperty selectedFeature=new SimpleStringProperty();
    IntegerProperty numOfRow= new SimpleIntegerProperty();
    void learnNormal(TimeSeries ts);
    void detect(TimeSeries ts);
    AnchorPane paint();
}
