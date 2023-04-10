package ua.lviv.iot;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;


class DeskManagerTest {

    private DeskManager deskManager;

    @BeforeEach
    public void setUp() {
        deskManager = new DeskManager();
        deskManager.addDesk(new CoffeeTable(0, 9, 0, Boolean.FALSE,
                4, 5, 0, 0));
        deskManager.addDesk( new ChildrenTable(11, 8, 10, Boolean.FALSE,
                2, 20));
        deskManager.addDesk( new DiningTable(9, 3, 5, Boolean.FALSE,
                4, 20));
        deskManager.addDesk( new WritingDesk(11, 3, 10, Boolean.TRUE,
                5, 20));
    }

    @Test
    public void testFindAllWithHeightGreaterThan() {
        List<Desk> filterList = deskManager.findAllWithHeightGreaterThan(10);
        Assertions.assertEquals(2, filterList.size());
        for (var desk : filterList) {
            Assertions.assertTrue(desk.getHeight() > 10);
        }
    }

    @Test
    public void testFindWithKeyboardTray() {
        List<Desk> filterList = deskManager.findWithKeyboardTray();
        Assertions.assertEquals(1, filterList.size());
        for (var desk : filterList) {
            Assertions.assertTrue(desk.hasKeyboardTray());
        }
    }
}

