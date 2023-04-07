package ua.lviv.iot;

import lombok.*;

@Setter
@Getter
@ToString (callSuper = true)
public class DiningTable extends Desk {
    private int numberOfSeats;
    private int maxHeight;

    public DiningTable (int height, int width, int length, boolean hasKeyboardTray, int numberOfSeats, int maxHeight) {
        super(height, width, length, hasKeyboardTray);
        this.numberOfSeats = numberOfSeats;
        this.maxHeight =  maxHeight;
    }

    @Override
    public int increaseTheHeightOfTheTableToTheMaximum(int centimeters) {

        if ((getHeight() + centimeters) < maxHeight) {
            System.out.println("You can increase in by " + Math.abs((getHeight() + centimeters) - maxHeight) + " WritingDesk");
        } else {
            System.out.println("You can not increase WritingDesk");
        };

        return 0;
    }

    @Override
    public short moveDown (int centimeters) {
        if (getHeight() + centimeters > 0) {
            System.out.println("You can reduce in by " + (getHeight() + centimeters) + "DiningTable");
        } else {
            System.out.println("You can not reduce DiningTable");
        }

        return 0;
    }
}
