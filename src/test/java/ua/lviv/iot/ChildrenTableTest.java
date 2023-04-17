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

        childrenTable = new ChildrenTable("ChildrenTable",11, 11, 11, false, 2, 20);
    }


    @Test
    void testTheHeightOfTheTableToTheMaximum() {
        childrenTable.increaseTheHeightOfTheTableToTheMaximum(5);
        Assertions.assertEquals(4, childrenTable.getHeight());

    }

    @Test
    void testincreaseTheHeightOfTheTableToTheMaximum() {
        ChildrenTable testtable = new ChildrenTable("ChildrenTable", 11, 11, 11, false, 2, 20);
        testtable.increaseTheHeightOfTheTableToTheMaximum(10);

        Assertions.assertEquals(0, testtable.getHeight(), 2);
    }


    @Test
    void moveDown() {
        ChildrenTable testtable = new ChildrenTable("ChildrenTable",11, 11, 11, false, 2, 20);
        testtable.moveDown(5);

        Assertions.assertEquals(16, testtable.getHeight());

    }

    @Test
    public void testToString(){
        ChildrenTable testtable = new ChildrenTable("ChildrenTable",11, 11, 11, false, 2, 20);
        String expected = "ChildrenTable(super=Desk(height=11, width=11, length=11, hasKeyboardTray=false), ageOfTheChild=2.0, maxHeight=20)";
        assertEquals(expected, childrenTable.toString());
    }

    @Test
    public void testGetHeader(){
        String expected = "name, height, width, length, hasKeyboardTray,ageOfTheChild,maxHeight";
        assertEquals(expected, childrenTable.getHeaders());
    }

    @Test
    public void testToCSV(){
        String expected = childrenTable.getName() + "," + childrenTable.getHeight() + "," + childrenTable.getWidth() + "," + childrenTable.getLength() + "," +childrenTable.isHasKeyboardTray() + "," + childrenTable.getAgeOfTheChild() + "," + childrenTable.getMaxHeight();
        assertEquals(expected, childrenTable.toCSV());
    }
}