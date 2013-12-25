package javaphone;

import java.util.ArrayList;

/**
 *
 * @author iGroup
 */
public class ServiceDatabase extends FileIO {
    private final String fileName = "services.xml";
    private final String rootElementName = "services";
    private final String objectElementName = "service";
    
    public ServiceDatabase() {
    }

    public ArrayList getFileContents() {
        return readFile(fileName, objectElementName);
    }

    public boolean updateFile(ArrayList fileData) {
        return writeFile(fileName, rootElementName, objectElementName, fileData);
    }
}