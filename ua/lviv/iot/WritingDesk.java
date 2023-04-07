package ua.lviv.iot;

import lombok.*;

@Setter
@Getter
@ToString(callSuper = true)
public class WritingDesk extends Desk {
    private int miniHeight;
    private int maxHeight;


    public WritingDesk (int height, int width, int length, boolean hasKeyboardTray, int miniHeight, int maxHeight) {
        super (height, width, length, hasKeyboardTray);
        this.miniHeight = miniHeight;
        this.maxHeight = maxHeight;
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
            System.out.println("You can reduce in by " + (getHeight() + centimeters) + "WritingDesk");
        } else {
            System.out.println("You can not reduce WritingDesk");
        }
        return 0;
    }

}
