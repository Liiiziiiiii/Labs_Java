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
    void increaseTheHeightOfTheTableToTheMaximum() {
        DiningTable diningTable = new DiningTable(15, 10, 10, Boolean.FALSE, 10,20);
        diningTable.increaseTheHeightOfTheTableToTheMaximum(5);
        Assertions.assertEquals(0, diningTable.getHeight(), 2);
    }

    @Test
    void moveDown() {
        DiningTable diningTable = new DiningTable(13, 10, 10, Boolean.FALSE, 10,20);
        diningTable.moveDown(5);
        Assertions.assertEquals(18, diningTable.getHeight(), 2);

    }

    @Test
    public void testToString(){
        DiningTable diningTable = new DiningTable(13, 10, 10, Boolean.FALSE, 10,20);
        String expected = "DiningTable(super=Desk(height=13, width=10, length=10, hasKeyboardTray=false), numberOfSeats=10, maxHeight=20)";
        assertEquals(expected, diningTable.toString() );
    }


}