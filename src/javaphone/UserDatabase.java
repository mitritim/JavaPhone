package javaphone;

import java.util.ArrayList;

/**
 *
 * @author iGroup
 */
public class UserDatabase extends FileIO {
    private final String fileName = "users.xml";
    private final String rootElementName = "users";
    private final String objectElementName = "user";
    
    public UserDatabase() {
    }

    public ArrayList getFileContents() {
        return readFile(fileName, objectElementName);
    }

    public boolean updateFile(ArrayList fileData) {
        return writeFile(fileName, rootElementName, objectElementName, fileData);
    }
}