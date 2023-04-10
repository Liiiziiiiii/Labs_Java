package ua.lviv.iot;

import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoffeeTableTest extends TestCase {
    private CoffeeTable coffeeTable;

    @BeforeEach
    public void setUp() {

        coffeeTable = new CoffeeTable(11, 11, 11, Boolean.FALSE, 2, 20, 8, 20);
    }

    @Test
    void testTheHeightOfTheTableToTheMax() {
        coffeeTable.increaseTheHeightOfTheTableToTheMaximum(5);
        Assertions.assertEquals(4, coffeeTable.getHeight());
    }

    @Test
    void testTheHeightOfTheTableToTheMin(){
        coffeeTable.moveDown(5);
        Assertions.assertEquals(16, coffeeTable.getHeight());
    }

    @Test
    void increaseTheHeightOfTheTableToTheMaximum() {
        CoffeeTable testtable = new CoffeeTable(11, 11, 11, Boolean.FALSE, 2, 20, 9 ,30);
        testtable.increaseTheHeightOfTheTableToTheMaximum(5);

        Assertions.assertEquals(14, testtable.getHeight());
    }

    @Test
    void moveDown() {
        CoffeeTable testtable = new CoffeeTable(11, 11, 11, Boolean.FALSE, 2, 20, 9 ,30);
        testtable.moveDown(5);

        Assertions.assertEquals(16, testtable.getHeight());
    }

    @Test
    public void testToString(){
        CoffeeTable testtable = new CoffeeTable(11, 11, 11, Boolean.FALSE, 2, 20, 9 ,20);
        String expected = "CoffeeTable(super=Desk(height=11, width=11, length=11, hasKeyboardTray=false), numberOfGuests=2, numberOfShelves=20, miniHeight=8, maxHeight=20)";
        assertEquals(expected, coffeeTable.toString());
    }
}