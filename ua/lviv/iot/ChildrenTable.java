package ua.lviv.iot;

import lombok.*;

@Setter
@Getter
@ToString (callSuper = true)
public class ChildrenTable extends Desk {
    private float ageOfTheChild;
    private int maxHeight;


    public ChildrenTable (int height, int width, int length, boolean hasKeyboardTray, float ageOfTheChild, int maxHeight) {
        super(height, width, length, hasKeyboardTray);
        this.ageOfTheChild = ageOfTheChild;
        this.maxHeight = maxHeight;
    }

    @Override
    public int increaseTheHeightOfTheTableToTheMaximum(int centimeters) {
        if ((getHeight() + centimeters) < maxHeight) {
            System.out.println("You can increase in by " + Math.abs((getHeight() + centimeters) - maxHeight) + " ChildrenTable");
        } else {
            System.out.println("You can not increase ChildrenTable");
        }
        return centimeters;
    }

    @Override
    public short moveDown (int centimeters) {
        if (getHeight() + centimeters > 0) {
            System.out.println("You can reduce in by " + (getHeight() + centimeters) + "ChildrenTable");
        } else {
            System.out.println("You can not reduce ChildrenTable");
        }

        return 0;
    }

}
