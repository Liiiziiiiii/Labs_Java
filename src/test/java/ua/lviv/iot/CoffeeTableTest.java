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
    void testGetMaxHeight(){
        var coffeeTable = new CoffeeTable(11, 11, 11, Boolean.FALSE, 2, 20, 8, 20);
        Assertions.assertEquals(20, coffeeTable.getMaxHeight());
    }
    @Test
    void testGetNumberOfGuests(){
        var coffeeTable = new CoffeeTable(11, 11, 11, Boolean.FALSE, 2, 20, 8, 20);
        Assertions.assertEquals(2, coffeeTable.getNumberOfGuests());
    }

    @Test
    void testSetNumberOfGuests(){
        var coffeeTable = new CoffeeTable(11, 11, 11, Boolean.FALSE, 2, 20, 8, 20);
        coffeeTable.setNumberOfGuests(4);
        Assertions.assertEquals(4, coffeeTable.getNumberOfGuests());
    }
    @Test
    void testGetNumberOfShelves(){
        var coffeeTable = new CoffeeTable(11, 11, 11, Boolean.FALSE, 2, 20, 8, 20);
        Assertions.assertEquals(20, coffeeTable.getNumberOfShelves());
    }

    @Test
    void testSetNumberOfShelves(){
        var coffeeTable = new CoffeeTable(11, 11, 11, Boolean.FALSE, 2, 20, 8, 20);
        coffeeTable.setNumberOfShelves(2);
        Assertions.assertEquals(2, coffeeTable.getNumberOfShelves());
    }

    @Test
    public void testSetMaxHeight(){
        var coffeeTable = new CoffeeTable(11, 11, 11, Boolean.FALSE, 2, 20, 8, 20);
        coffeeTable.setMaxHeight(25);
        Assertions.assertEquals(25, coffeeTable.getMaxHeight());
    }
    @Test
    void testTheHeightOfTheTableToTheMax() {
        coffeeTable.increaseTheHeightOfTheTableToTheMaximum(5);
        Assertions.assertEquals(11, coffeeTable.getHeight());
    }

    @Test
    void testTheHeightOfTheTableToTheMin(){
        coffeeTable.moveDown(5);
        Assertions.assertEquals(11, coffeeTable.getHeight());
    }

    @Test
    void increaseTheHeightOfTheTableToTheMaximum() {
        CoffeeTable testtable = new CoffeeTable(11, 11, 11, Boolean.FALSE, 2, 20, 9 ,20);
        testtable.increaseTheHeightOfTheTableToTheMaximum(10);

        Assertions.assertEquals(11, testtable.getHeight(), 2);

        testtable.increaseTheHeightOfTheTableToTheMaximum(20);

        Assertions.assertEquals(11, testtable.getHeight(), 2);


        testtable.increaseTheHeightOfTheTableToTheMaximum(30);

        Assertions.assertEquals(11, testtable.getHeight(), 2);

    }

    @Test
    void moveDown() {
        CoffeeTable testtable = new CoffeeTable(11, 11, 11, Boolean.FALSE, 2, 20, 9 ,20);
        testtable.moveDown(10);

        Assertions.assertEquals(11, testtable.getHeight(), 2);

        testtable.increaseTheHeightOfTheTableToTheMaximum(20);

        Assertions.assertEquals(11, testtable.getHeight(), 2);


        testtable.increaseTheHeightOfTheTableToTheMaximum(30);

        Assertions.assertEquals(11, testtable.getHeight(), 2);
    }
}