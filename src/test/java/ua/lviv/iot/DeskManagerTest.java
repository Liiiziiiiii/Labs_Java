package ua.lviv.iot;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DeskManagerTest {

    DeskManager deskManage;


    private Desk oldCoffeeTable;
    private Desk newCoffeeTable;
    private Desk oldChildrenTable;
    private Desk newChildrenTable;
    private Desk oldDiningTable;
    private Desk newDiningTable;
    private Desk oldWritingDesk;
    private Desk newWritingDesk;


    @BeforeEach
    public void setUp() {
        List<Desk> desks = new ArrayList<>();
        deskManage = new DeskManager();


        Desk oldCoffeeTable = new CoffeeTable(0, 9, 0, Boolean.FALSE,
                4, 5, 0, 0);

        Desk oldChildrenTable = new ChildrenTable(11, 8, 10, Boolean.FALSE,
                2, 20);

        Desk oldDiningTable = new DiningTable(9, 3, 5, Boolean.FALSE,
                4, 20);

        Desk oldWritingDesk = new WritingDesk(11, 3, 10, Boolean.TRUE,
                5, 20);

        deskManage.addDesk(oldCoffeeTable);
        deskManage.addDesk(oldWritingDesk);
        deskManage.addDesk(oldChildrenTable);
        deskManage.addDesk(oldDiningTable);
    }


    @Test
    public void testFindAllWithHeightGreaterThan() {
        List<Desk> filterList = deskManage.findAllWithHeightGreaterThan(10);
        Assertions.assertEquals(2, filterList.size());
        Assertions.assertTrue(filterList.get(0).getHeight() > 10);
    }

    @Test
    public void testFindWithKeyboardTray() {
        List<Desk> filterList = deskManage.findWithKeyboardTray();
        Assertions.assertEquals(1, filterList.size());
        Assertions.assertEquals(filterList.get(0).hasKeyboardTray, (boolean) Boolean.TRUE);
    }


    @Test
    public void testAddDesk() {
        DeskManager deskManager = new DeskManager();
        Desk newChildrenTable = new ChildrenTable(6, 8, 10, Boolean.FALSE,
                2, 20);
        deskManage.addDesk(newChildrenTable);
        assertTrue(deskManage.getDesks().contains(newChildrenTable));
    }


}

