package javaphone;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class handles the service information when 
 * searching for the service id number.
 * 
 * @author iGroup
 */
public class ServiceList extends ArrayList<HashMap> {
    
    private final DataFileIO serviceDataFile;
    
    /**
     * Adds service to the datafile.
     */
    public ServiceList() {
        serviceDataFile = new DataFileIO("services.xml", "services", "service");
        this.addAll(serviceDataFile.read());
    }

    /**
     * Searches for service with specific serviceId
     * @param serviceId
     * @return service data as HashMap if service found 
     *         null if service not found
     */  
    public HashMap getServiceById(int serviceId) {
        for (HashMap service : this) {
            if (serviceId == (int) service.get("serviceId")) {
                return service;
            }
        }
        return null;
    }    
}
