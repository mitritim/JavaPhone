package javaphone;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author iGroup
 */
public class UserList extends ArrayList {
    private DataFileIO userDataFile;
    
    public UserList() {
        userDataFile = new DataFileIO("users.xml", "users", "user");
        this.addAll(userDataFile.read());
    }

    public ArrayList getUserData(User user) {
        return null;
    }

    public boolean changeUserData(User user, HashMap userData) {
        return true;
    }

    public String sendUserPassword(int userId) {
        return null;
    }
}
