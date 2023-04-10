package ua.lviv.iot;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class DeskManager {

    List<Desk> getDesks() {
        return desks;
    }

    public List<Desk> findAllWithHeightGreaterThan(final int height) {
        return desks.stream()
                .filter(desk -> desk.getHeight() > height)
                .collect(Collectors.toList());
    }

    public List<Desk> findWithKeyboardTray() {
        return desks.stream()
                .filter(desk -> desk.hasKeyboardTray == Boolean.TRUE)
                .collect(Collectors.toList());
    }

    private List<Desk> desks = new LinkedList<>();

    void addDesk(Desk deskList) {
        this.desks.add(deskList);
    }

}

