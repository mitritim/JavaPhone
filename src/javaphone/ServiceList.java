package javaphone;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class holds a list of all services and provides methods to access it.
 *
 * @author iGroup
 */
public class ServiceList extends ArrayList<HashMap> {

    private final DataFileIO serviceDataFile;

    /**
     * Constructor for the class ServiceList. <br />
     * First creates an instance of DataFileIO <br />
     * and adds reference to HashMap objects it gets from an xml-file.
     */
    public ServiceList() {
        serviceDataFile = new DataFileIO("services.xml", "services", "service");
        this.addAll(serviceDataFile.read());
    }

    /**
     * Searches for service with specific serviceId
     *
     * @param serviceId
     * @return service data as HashMap if service found null if service not
     * found
     */
    public HashMap getServiceById(int serviceId) {
        for (HashMap service : this) {
            if (serviceId == (int) service.get("serviceId")) {
                return service;
            }
        }
        return null;
    }

    /**
     * Saves data to xml file.
     *
     * @return  true if data was saved <br />
     *          false if data was not saved
     */
    public boolean saveData() {
        return serviceDataFile.write(this);
    }

    /**
     * Creates a statistics report and writes it as an xml file.
     *
     * @param customerCountByService containing the number of customers for every service
     * @return  true if the report had been created successfully<br />
     *          false if report creation failed
     */
    public boolean createReport(HashMap customerCountByService) {
        ArrayList<HashMap> reportData = new ArrayList();
        for (HashMap service : this) {
            int customerCount = (int) customerCountByService
                    .get(service.get("serviceId"));
            HashMap reportItem = new HashMap();
            reportItem.put("serviceName", service.get("serviceName"));
            reportItem.put("servicePrice", service.get("servicePrice"));
            reportItem.put("customerCount", customerCount);
            reportItem.put("income", customerCount * (int) service.get("servicePrice"));
            reportData.add(reportItem);
        }
        DataFileIO reportDataFile = new DataFileIO("report.xml", "report", "service");
        return reportDataFile.write(reportData);
    }
}
