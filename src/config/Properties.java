package config;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Properties {

    private Map<String, String> rowsIndex;
    private Float rate;
    private String flightGearIP;
    private int flightGearPort;
    private String normalFlightCsvPath;

    public Properties() {
        rowsIndex=new HashMap();
    }

    public void setRowsIndex(Map<String, String> rowsIndex) {
        this.rowsIndex = rowsIndex;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public void setFlightGearIP(String flightGearIP) {
        this.flightGearIP = flightGearIP;
    }

    public void setFlightGearPort(int flightGearPort) {
        this.flightGearPort = flightGearPort;
    }

    public void setNormalFlightCsvPath(String normalFlightCsvPath) {
        this.normalFlightCsvPath = normalFlightCsvPath;
    }

    public Map<String, String> getRowsIndex() {
        return rowsIndex;
    }

    public Float getRate() {
        return rate;
    }

    public String getFlightGearIP() {
        return flightGearIP;
    }

    public int getFlightGearPort() {
        return flightGearPort;
    }

    public String getNormalFlightCsvPath() {
        return normalFlightCsvPath;
    }

    public String propertyName(String propertyName){ return rowsIndex.get(propertyName);}

    public void setFromAnotherProperties(Properties properties){//copy one Properties data to another Properties object
        setRowsIndex(properties.getRowsIndex());
        setRate(properties.getRate());
        setFlightGearIP(properties.getFlightGearIP());
        setFlightGearPort(properties.getFlightGearPort());
        setNormalFlightCsvPath(properties.getNormalFlightCsvPath());
    }

    public void serializeToXML (String filePath) throws IOException {//from Properties object to xml file
        FileOutputStream fos = new FileOutputStream(filePath);
        XMLEncoder encoder = new XMLEncoder(fos);
        encoder.writeObject(this);
        encoder.close();
        fos.close();
    }
    public Boolean deserializeFromXML(String filePath) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            XMLDecoder decoder = new XMLDecoder(fis);
            Properties decodedSettings =(Properties)decoder.readObject();
            decoder.close();
            fis.close();
            this.setFromAnotherProperties(decodedSettings);
            serializeToXML("settings.xml");
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
