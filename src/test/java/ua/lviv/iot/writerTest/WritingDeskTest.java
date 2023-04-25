package ua.lviv.iot.writerTest;

import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.models.WritingDesk;

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