package ua.lviv.iot;

import junit.framework.TestCase;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.TemporaryFolder;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class DeskWriterTest extends TestCase {
    private DeskWriter writer = new DeskWriter();
    private static final String EXPECTED = "EXPECTED.CSV";
    private static final String ACTUAL = "ACTUAL.CSV";
    List<Desk> deskList = new LinkedList<>();


    @Rule
    public TemporaryFolder folder = new TemporaryFolder();


    private DeskManager deskManager;


    @BeforeEach
    public void setUp() throws IOException {
        deskManager = new DeskManager();
        deskManager.addDesk(new CoffeeTable("CoffeeTable", 10, 9, 0, false,
                4, 5, 0, 0));
        deskManager.addDesk(new ChildrenTable("ChildrenTable", 11, 8, 10, false,
                2, 20));
        deskManager.addDesk(new DiningTable("DiningTable", 9, 3, 5, false,
                4, 20));
        deskManager.addDesk(new WritingDesk("WritingDesk", 11, 3, 10, true,
                5, 20));
        writer = new DeskWriter();
//        Files.delete(Path.of(RESULT)) ;
    }

//    @AfterEach
//    public void tearDown() throws IOException{
//        Files.deleteIfExists(Path.of(RESULT));
//    }

    //
    @Test
    public void testFileEmpty() throws IOException {
        try {
            FileWriter writer = new FileWriter(EXPECTED);
            writer.write(deskList.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            fail("Could not write to the empty list file.");
        }
        File emptyListFile = new File(EXPECTED);
        assertFalse(emptyListFile.length() == 0);
    }


    @Test
    public void testEmptytWrite() throws IOException {
        writer.writeToFile(deskList);
        File file = new File(EXPECTED);
        Assertions.assertTrue(file.exists());

    }

    @Test
    public void testWriteListOfDesk() throws IOException {
        writer.writeToFile(deskList);
        File file = new File(EXPECTED);

        Path expected = new File(EXPECTED).toPath();
        Path actual = new File(ACTUAL).toPath();

        Assertions.assertEquals(-1L, Files.mismatch(expected, actual));
    }

    @Test
    public void testFileOverride() throws IOException {
        testWriteListOfDesk();
    }

}
