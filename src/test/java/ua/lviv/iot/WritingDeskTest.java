package ua.lviv.iot;

import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WritingDeskTest extends TestCase {

    private WritingDesk writingDesk;

    @BeforeEach
    public void setUp() {
        WritingDesk writingDesk = new WritingDesk(9,10, 5, Boolean.TRUE, 5, 20);
    }

    @Test
    void testGetMiniHeight(){
        WritingDesk writingDesk = new WritingDesk(9,10, 5, Boolean.TRUE, 5, 20);
        Assertions.assertEquals(5, writingDesk.getMiniHeight());
    }
    @Test
    void testGetMaxHeight(){
        WritingDesk writingDesk = new WritingDesk(9,10, 5, Boolean.TRUE, 5, 20);
        Assertions.assertEquals(20, writingDesk.getMaxHeight());
    }

    @Test
    void testSetMiniHeight(){
        WritingDesk writingDesk = new WritingDesk(9,10, 5, Boolean.TRUE, 5, 20);
        writingDesk.setMiniHeight(4);
        Assertions.assertEquals(4, writingDesk.getMiniHeight());
    }

    @Test
    void testSetMaxHeight(){
        WritingDesk writingDesk = new WritingDesk(9,10, 5, Boolean.TRUE, 5, 20);
        writingDesk.setMaxHeight(25);
        Assertions.assertEquals(25, writingDesk.getMaxHeight());
    }

    @Test
    void increaseTheHeightOfTheTableToTheMaximum() {
        WritingDesk writingDesk = new WritingDesk(9,10, 5, Boolean.TRUE, 5, 20);

        writingDesk.increaseTheHeightOfTheTableToTheMaximum(10);
        Assertions.assertEquals(10, writingDesk.getHeight(), 2);

        writingDesk.increaseTheHeightOfTheTableToTheMaximum(20);
        Assertions.assertEquals(10, writingDesk.getHeight(), 2);

        writingDesk.increaseTheHeightOfTheTableToTheMaximum(30);
        Assertions.assertEquals(10, writingDesk.getHeight(), 2);

    }

    @Test
    void moveDown() {
        WritingDesk writingDesk = new WritingDesk(9,10, 5, Boolean.TRUE, 5, 20);

        writingDesk.moveDown(10);
        Assertions.assertEquals(11, writingDesk.getHeight(), 2);

        writingDesk.increaseTheHeightOfTheTableToTheMaximum(20);
        Assertions.assertEquals(11, writingDesk.getHeight(), 2);

        writingDesk.increaseTheHeightOfTheTableToTheMaximum(30);
        Assertions.assertEquals(11, writingDesk.getHeight(), 2);
    }
}