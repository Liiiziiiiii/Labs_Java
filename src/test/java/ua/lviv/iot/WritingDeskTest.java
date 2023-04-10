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
    void increaseTheHeightOfTheTableToTheMaximum() {
        WritingDesk writingDesk = new WritingDesk(10,10, 5, Boolean.TRUE, 5, 20);

        writingDesk.increaseTheHeightOfTheTableToTheMaximum(10);
        Assertions.assertEquals(0, writingDesk.getHeight());
    }

    @Test
    void moveDown() {
        WritingDesk writingDesk = new WritingDesk(10,10, 5, Boolean.TRUE, 5, 20);

        writingDesk.moveDown(10);
        Assertions.assertEquals(0, writingDesk.getHeight());

    }
    @Test
    public void testToString(){
        WritingDesk writingDesk = new WritingDesk(9,10, 5, Boolean.TRUE, 5, 20);
        String expected = "WritingDesk(super=Desk(height=9, width=10, length=5, hasKeyboardTray=true), miniHeight=5, maxHeight=20)";
        assertEquals(expected, writingDesk.toString());
    }
}