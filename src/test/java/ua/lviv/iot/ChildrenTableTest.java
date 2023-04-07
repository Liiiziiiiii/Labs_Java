package ua.lviv.iot;

import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import static org.junit.jupiter.api.Assertions.*;

class ChildrenTableTest extends TestCase {

    private ChildrenTable childrenTable;

    @BeforeEach
    public void setUp() {

        childrenTable = new ChildrenTable(11, 11, 11, Boolean.FALSE, 2, 20);
    }

    @Test
    void testGetMaxHeight(){
        var childrenTable = new ChildrenTable(11, 11, 11, Boolean.FALSE, 2, 20);
        Assertions.assertEquals(20, childrenTable.getMaxHeight());
    }

    @Test
    void testGetAgeOfTheChild(){
        var childrenTable = new ChildrenTable(11, 11, 11, Boolean.FALSE, 2, 20);
        Assertions.assertEquals(2, childrenTable.getAgeOfTheChild());
    }

    @Test
    public void testSetMaxHeight(){
        var childrenTable = new ChildrenTable(11, 11, 11, Boolean.FALSE, 2, 20);
        childrenTable.setMaxHeight(25);
        Assertions.assertEquals(25, childrenTable.getMaxHeight());
    }

    @Test
    public void testSetAgeOfTheChild(){
        var childrenTable = new ChildrenTable(11, 11, 11, Boolean.FALSE, 2, 20);
        childrenTable.setAgeOfTheChild(30);
        Assertions.assertEquals(30 , childrenTable.getAgeOfTheChild());
    }

    @Test
    void testTheHeightOfTheTableToTheMaximum() {
        childrenTable.increaseTheHeightOfTheTableToTheMaximum(10);
        Assertions.assertEquals(11, childrenTable.getHeight());

    }

    @Test
    void testincreaseTheHeightOfTheTableToTheMaximum() {
        ChildrenTable testtable = new ChildrenTable(11, 11, 11, Boolean.FALSE, 2, 20);
        testtable.increaseTheHeightOfTheTableToTheMaximum(10);

        Assertions.assertEquals(11, testtable.getHeight(), 2);

        testtable.increaseTheHeightOfTheTableToTheMaximum(20);

        Assertions.assertEquals(11, testtable.getHeight(), 2);


        testtable.increaseTheHeightOfTheTableToTheMaximum(30);

        Assertions.assertEquals(11, testtable.getHeight(), 2);

    }


    @Test
    void moveDown() {
        ChildrenTable testtable = new ChildrenTable(11, 11, 11, Boolean.FALSE, 2, 20);
        testtable.moveDown(10);

        Assertions.assertEquals(11, testtable.getHeight(), 2);

        testtable.increaseTheHeightOfTheTableToTheMaximum(20);

        Assertions.assertEquals(11, testtable.getHeight(), 2);


        testtable.increaseTheHeightOfTheTableToTheMaximum(30);

        Assertions.assertEquals(11, testtable.getHeight(), 2);

    }
}