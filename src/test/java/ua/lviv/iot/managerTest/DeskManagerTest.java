package ua.lviv.iot.managerTest;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.managers.DeskManager;
import ua.lviv.iot.models.*;

import java.util.List;


class DeskManagerTest {

    private DeskManager deskManager;

    @BeforeEach
    public void setUp() {
        deskManager = new DeskManager();
        deskManager.addDesk(new CoffeeTable("CoffeeTable", 10, 9, 0, false,
                4, 5, 0, 0));
        deskManager.addDesk(new ChildrenTable("ChildrenTable", 11, 8, 10, false,
                2, 20));
        deskManager.addDesk(new DiningTable("DiningTable", 9, 3, 5, false,
                4, 20));
        deskManager.addDesk(new WritingDesk("WritingDesk", 11, 3, 10, true,
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
            Assertions.assertTrue(desk.isHasKeyboardTray());
        }
    }
}

