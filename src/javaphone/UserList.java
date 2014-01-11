package javaphone;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class holds a list of all users and provides methods to access it.
 *
 * @author iGroup
 */
public class UserList extends ArrayList<HashMap> {

    private final DataFileIO userDataFile;

    /**
     * Constructor for the class UserList. <br />
     * First creates an instance of DataFileIO <br />
     * and adds reference to HashMap objects it gets from an xml-file.
     */
    public UserList() {
        userDataFile = new DataFileIO("users.xml", "users", "user");
        this.addAll(userDataFile.read());
    }

    /**
     * Searches for user with specific userId
     *
     * @param userId
     * @return user data as HashMap if user found null if user not found
     */
    public HashMap getUserById(int userId) {
        for (HashMap user : this) {
            if (userId == (int) user.get("userId")) {
                return user;
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
        return userDataFile.write(this);
    }
}
