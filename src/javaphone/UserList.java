package javaphone;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author iGroup
 */
public class UserList extends ArrayList<HashMap> {

    private final DataFileIO userDataFile;

    public UserList() {
        userDataFile = new DataFileIO("users.xml", "users", "user");
        this.addAll(userDataFile.read());
    }

    public HashMap getUserById(int userId) {
        for (HashMap user : this) {
            if (userId == (int) user.get("userId")) {
                return user;
            }
        }
        return null;
    }

    public boolean saveData() {
        return userDataFile.write(this);
    }
}
