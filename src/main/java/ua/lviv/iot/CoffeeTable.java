package ua.lviv.iot;

import lombok.*;

@Setter
@Getter
@ToString (callSuper = true)
public class CoffeeTable extends Desk {
    private int numberOfGuests;
    private int numberOfShelves;
    private int miniHeight;
    private int maxHeight;


    public CoffeeTable(int height, int width, int length, boolean hasKeyboardTray, int numberOfGuests, int numberOfShelves, int miniHeight, int maxHeight) {
        super(height, width, length, hasKeyboardTray);
        this.numberOfGuests = numberOfGuests;
        this.numberOfShelves = numberOfShelves;
        this.maxHeight = maxHeight;
        this.miniHeight = miniHeight;
    }




    @Override
    public int increaseTheHeightOfTheTableToTheMaximum(int centimeters) {
        if ((getHeight() + centimeters) < maxHeight) {
            System.out.println("You can increase in by " + Math.abs((getHeight() + centimeters) - maxHeight) + " CoffeeTable");
        } else {
            System.out.println("You can not increase CoffeeTable");
        }
        return 0;
    }

    @Override
    public short moveDown(int centimeters) {
        if (getHeight() + centimeters > 0) {
            System.out.println("You can reduce in by " + (getHeight() + centimeters) + "CoffeeTable");
        } else {
            System.out.println("You can not reduce CoffeeTable");
        }
        return 0;
    }
}