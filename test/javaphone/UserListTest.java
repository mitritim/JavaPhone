package javaphone;

import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test for class UserList.
 * 
 * @author iGroup
 */
public class UserListTest {
    /**
     * Test of getUserById method, of class UserList.
     * A new user gets added to the list of users.
     * If user id exists, user information will be revealed.
     */    
    @Test
    public void testGetUserById() {
        System.out.println("getUserById");
        UserList userList = new UserList();
        
        HashMap newUser = new HashMap();
        newUser.put("userName", "John Brown");
        newUser.put("userId", 9999);
        userList.add(newUser);
        
        HashMap result = userList.getUserById(9999);
        assertEquals(result.get("userId"), 9999);
        assertEquals(result.get("userName"), "John Brown");
        
    } 
}
