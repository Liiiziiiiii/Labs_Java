package ua.lviv.iot;

import junit.framework.TestCase;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.TemporaryFolder;
import ua.lviv.iot.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

class DeskWriterTest extends TestCase {

    private DeskWriter writer = new DeskWriter();
    private static final String EXPECTED = "EXPECTED.CSV";
    private static final String ACTUAL = "ACTUAL.CSV";
    List<Desk> desks = new LinkedList<>();


    private DeskManager deskManager;


    @BeforeEach
    public void setUp() throws IOException {

        DeskManager deskManager = new DeskManager();
        deskManager.addDesk(new CoffeeTable("CoffeeTable", 10, 9, 10, false,
                4, 5, 5, 20));
        deskManager.addDesk(new ChildrenTable("ChildrenTable", 11, 8, 10, false,
                2, 20));
        deskManager.addDesk(new DiningTable("DiningTable", 9, 3, 5, false,
                4, 20));
        deskManager.addDesk(new WritingDesk("WritingDesk", 11, 3, 10, true,
                5, 20));

        deskManager.addDesk(new CoffeeTable("CoffeeTable", 15, 15, 15, false, 5, 15, 5, 30));

        deskManager.addDesk(new ChildrenTable("ChildrenTable", 15, 15, 15, false, 1, 25));

        deskManager.addDesk(new DiningTable("DiningTable", 15, 15, 15, false, 8, 25));

        deskManager.addDesk(new WritingDesk("WritingDesk", 17, 17, 17, true, 5, 25));

        writer = new DeskWriter();
//        desks.addAll(deskManager.getDesk);
    }

    @Test
    public void testFileEmpty() throws IOException {
        try {
            FileWriter writer = new FileWriter(EXPECTED);
            writer.write(desks.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            fail("Could not write to the empty list file.");
        }
        File emptyListFile = new File(EXPECTED);
        assertFalse(emptyListFile.length() == 0);
    }


    @Test
    public void testEmptyWrite() throws IOException {
        writer.writeToFile(desks);
        File file = new File(EXPECTED);
        Assertions.assertTrue(file.exists());

    }

    @Test
    public void testWriteListOfDesk() throws IOException {
        writer.writeToFile(desks);
        File file = new File(ACTUAL);

        Path expected = new File(EXPECTED).toPath();
        Path actual = new File(ACTUAL).toPath();

        Assertions.assertEquals(-1L, Files.mismatch(expected, actual));
    }

    @Test
    public void testCollect() throws IOException{
        String fileName = writer.writeToFile(desks);

//        String fileContents = Files.readString(Path.of(fileName));

        Assertions.assertEquals(null, fileName);
    }

    @Test
    public void testFileOverride() throws IOException {
        testWriteListOfDesk();
    }
}