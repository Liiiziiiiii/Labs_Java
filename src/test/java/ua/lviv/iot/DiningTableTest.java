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
        diningTable = new DiningTable("DiningTable",10, 10, 10, false, 10,20);
    }


    @Test
    void increaseTheHeightOfTheTableToTheMaximum() {
        DiningTable diningTable = new DiningTable("DiningTable",15, 10, 10, false, 10,20);
        diningTable.increaseTheHeightOfTheTableToTheMaximum(5);
        Assertions.assertEquals(0, diningTable.getHeight(), 2);
    }

    @Test
    void moveDown() {
        DiningTable diningTable = new DiningTable("DiningTable",13, 10, 10, false, 10,20);
        diningTable.moveDown(5);
        Assertions.assertEquals(18, diningTable.getHeight(), 2);

    }

    @Test
    public void testGetHeader(){
        String expected = "name, height, width, length, hasKeyboardTray, numberOfSeats, maxHeight";
        assertEquals(expected, diningTable.getHeaders());
    }

    @Test
    public void testToCSV(){
        String expected = diningTable.getName() + "," + diningTable.getHeight() + "," + diningTable.getWidth() + "," + diningTable.getLength() + "," + diningTable.isHasKeyboardTray() + "," + diningTable.getNumberOfSeats() + "," + diningTable.getMaxHeight();
        assertEquals(expected, diningTable.toCSV());
    }


}