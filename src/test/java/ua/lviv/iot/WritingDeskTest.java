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
        writingDesk = new WritingDesk("WritingDesk",9,10, 5, true, 5, 20);
    }


    @Test
    void increaseTheHeightOfTheTableToTheMaximum() {
        WritingDesk writingDesk = new WritingDesk("WritingDesk",10,10, 5,true, 5, 20);

        writingDesk.increaseTheHeightOfTheTableToTheMaximum(10);
        Assertions.assertEquals(0, writingDesk.getHeight());
    }

    @Test
    void moveDown() {
        WritingDesk writingDesk = new WritingDesk("WritingDesk",10,10, 5, true, 5, 20);

        writingDesk.moveDown(10);
        Assertions.assertEquals(0, writingDesk.getHeight());

    }
    @Test
    public void testToString(){
        WritingDesk writingDesk = new WritingDesk("WritingDesk",9,10, 5, true, 5, 20);
        String expected = "WritingDesk(super=Desk(height=9, width=10, length=5, hasKeyboardTray=true), miniHeight=5, maxHeight=20)";
        assertEquals(expected, writingDesk.toString());
    }


    @Test
    public void testGetHeader(){
        String expected = "name, height, width, length, hasKeyboardTray, miniHeight, maxHeight";
        assertEquals(expected, writingDesk.getHeaders());
    }

    @Test
    public void testToCSV(){
        String expected = writingDesk.getName() + "," + writingDesk.getHeight() + "," + writingDesk.getWidth() + "," + writingDesk.getLength() + "," +writingDesk.isHasKeyboardTray() + "," + writingDesk.getMiniHeight() + "," + writingDesk.getMaxHeight();
        assertEquals(expected, writingDesk.toCSV());
    }
}