package javaphone;

import java.util.ArrayList;

/**
 *
 * @author iGroup
 */
public class CustomerDatabase extends FileIO {
    private final String fileName = "customers.xml";
    private final String rootElementName = "vustomers";
    private final String objectElementName = "customer";
    
    public CustomerDatabase() {
    }

    public ArrayList getFileContents() {
        return readFile(fileName, objectElementName);
    }

    public boolean updateFile(ArrayList fileData) {
        return writeFile(fileName, rootElementName, objectElementName, fileData);
    }
}