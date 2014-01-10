package javaphone;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class handles the users information when 
 * searching for the user id number.
 * 
 * @author iGroup
 */
public class UserList extends ArrayList<HashMap> {

    private final DataFileIO userDataFile;
    
    /**
     * Adds user to the datafile.
     */
    public UserList() {
        userDataFile = new DataFileIO("users.xml", "users", "user");
        this.addAll(userDataFile.read());
    }

    /**
     * Searches for user with specific userId
     * @param userId
     * @return user data as HashMap if user found 
     *         null if user not found
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
     * Saves data to file.
     * @return to the file
     */
    public boolean saveData() {
        return userDataFile.write(this);
    }
}
