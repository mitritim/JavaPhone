package javaphone;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author iGroup
 */
public class ServiceList extends ArrayList {
    private DataFileIO serviceDataFile;
    
    public ServiceList() {
        serviceDataFile = new DataFileIO("services.xml", "services", "service");
        Collections.addAll(this, serviceDataFile.read());
    }

    public double getServicePrice(Service service) {
        return 0;
    }

    public boolean setServicePrice(Service service, double price) {
        return false;
    }

}
