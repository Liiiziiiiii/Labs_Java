package ua.lviv.iot.managers;

import ua.lviv.iot.models.Desk;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class DeskManager {

   public List<Desk> getDesks() {
        return desks;
    }

    public List<Desk> findAllWithHeightGreaterThan(final int height) {
        return desks.stream()
                .filter(desk -> desk.getHeight() > height)
                .collect(Collectors.toList());
    }

    public List<Desk> findWithKeyboardTray() {
        return desks.stream()
                .filter(desk -> desk.isHasKeyboardTray() == Boolean.TRUE)
                .collect(Collectors.toList());
    }

    final private List<Desk> desks = new LinkedList<>();

    public void addDesk(Desk deskList) {
        this.desks.add(deskList);
    }

}

