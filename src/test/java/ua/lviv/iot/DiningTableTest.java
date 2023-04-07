package ua.lviv.iot;

import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiningTableTest extends TestCase {

    private DiningTable diningTable;

    @BeforeEach
    public void setUp() {
        DiningTable diningTable = new DiningTable(10, 10, 10, Boolean.FALSE, 10,20);
    }
    @Test
    void testGetMaxHeight(){
        DiningTable diningTable = new DiningTable(10, 10, 10, Boolean.FALSE, 10,20);
        Assertions.assertEquals(20, diningTable.getMaxHeight());
    }

    @Test
    public void testGetNumberOfSeats(){
        DiningTable diningTable = new DiningTable(10, 10, 10, Boolean.FALSE, 10,20);
        Assertions.assertEquals(10, diningTable.getNumberOfSeats());
    }


    @Test
    public void testSetMaxHeight(){
        WritingDesk writingDesk = new WritingDesk(9,10, 5, Boolean.TRUE, 5, 20);
        writingDesk.setMaxHeight(25);
        Assertions.assertEquals(25, writingDesk.getMaxHeight());
    }
    @Test
    public void testSetNumberOfSeats() {
        DiningTable diningTable = new DiningTable(10, 10, 10, Boolean.FALSE, 10,20);
        diningTable.setNumberOfSeats(15);
        Assertions.assertEquals(15, diningTable.getNumberOfSeats());
    }
    @Test
    void increaseTheHeightOfTheTableToTheMaximum() {
        DiningTable diningTable = new DiningTable(15, 10, 10, Boolean.FALSE, 10,20);
        diningTable.increaseTheHeightOfTheTableToTheMaximum(10);
        Assertions.assertEquals(15, diningTable.getHeight(), 2);

        diningTable.increaseTheHeightOfTheTableToTheMaximum(20);
        Assertions.assertEquals(15, diningTable.getHeight(), 2);

        diningTable.increaseTheHeightOfTheTableToTheMaximum(30);
        Assertions.assertEquals(15, diningTable.getHeight(), 2);
    }

    @Test
    void moveDown() {
        DiningTable diningTable = new DiningTable(13, 10, 10, Boolean.FALSE, 10,20);
        diningTable.moveDown(10);
        Assertions.assertEquals(13, diningTable.getHeight(), 2);

        diningTable.moveDown(20);
        Assertions.assertEquals(13, diningTable.getHeight(), 2);

        diningTable.moveDown(30);
        Assertions.assertEquals(13, diningTable.getHeight(), 2);
    }


}