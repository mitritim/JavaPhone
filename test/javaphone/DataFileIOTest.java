package javaphone;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for class DataFileIO.
 * 
 * @author iGroup
 */
public abstract class DataFileIOTest {

    /**
     * Test for methods write and read of class DataFileIO. A file test.xml is
     * created, some data is written to it. Data is then read from file and
     * compared to what was to be written. File is deleted.
     */
    @Test
    public void testWriteRead() {
        ArrayList<HashMap> fileData = new ArrayList<>();
        HashMap object1 = new HashMap();
        HashMap object2 = new HashMap();

        object1.put("Price", 123.12);
        object1.put("ProductName", "A great Java program");

        object2.put("customerName", "John Doe");
        object2.put("customerAge", 45);

        fileData.add(object1);
        fileData.add(object2);

        DataFileIO testFile = new DataFileIO("test.xml", "objects", "object");
        assert(testFile.write(fileData));
        
        assertEquals(testFile.read().get(0).get("Price"), object1.get("Price").toString());
        assertEquals(testFile.read().get(1).get("customerName"), object2.get("customerName"));
    }

    @AfterClass
    public static void tearDownClass() {
        File file = new File("data/test.xml");
        assert(file.delete());
    }

}
