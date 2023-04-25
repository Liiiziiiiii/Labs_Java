package ua.lviv.iot.modelTest;

import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.managers.DeskManager;
import ua.lviv.iot.models.*;
import ua.lviv.iot.writer.DeskWriter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

class DeskWriterTest extends TestCase {

    private DeskWriter writer = new DeskWriter();
    private static final String EXPECTED = "EXPECTED.CSV";

    DeskManager deskManager = new DeskManager();
    List<Desk> desk = deskManager.getDesks();


//    private DeskManager deskManager;


    @BeforeEach
    public void setUp() throws IOException {

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

    }

    @Test
    public void testEmptyWrite() throws IOException {
        writer.writeToFile(desk);
        File file = new File(EXPECTED);
        Assertions.assertTrue(file.exists());
    }

    @Test
    public void testWriteListOfDesk() throws IOException {
        writer.writeToFile(desk);
        Path expected = new File(EXPECTED).toPath();
        Path actual = new File(DeskWriter.DEFAULT_FILENAME).toPath();

        Assertions.assertEquals(-1L, Files.mismatch(expected, actual));
    }

    @Test
    public void testFileOverride() throws IOException {
        testWriteListOfDesk();
        testWriteListOfDesk();
    }
}