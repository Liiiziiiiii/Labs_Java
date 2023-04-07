package ua.lviv.iot.algo.part1.lab1;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class WritingDesk {

    private int numberOfDrawers;
    private String hasKeyboardTray;     //boolean
    private int maxWeightCapacity;
    private int currentHeight;
    private int maxHeight ;

    public final int CENTIMETERS = 2;

    public static WritingDesk defaultWritingDesk = new WritingDesk();

    private static WritingDesk getInstance() {
        return defaultWritingDesk;
    }

    public static void main(String[] args) {
        WritingDesk[] desks = {
                new WritingDesk(),
                new WritingDesk(4, "yes", 9, 2, 100),
                WritingDesk.getInstance(),
                WritingDesk.getInstance()

        };
        for (WritingDesk writingDesk : desks) {
            System.out.println(writingDesk + " ");
        }
    }

    @Override
    public String toString() {
        return "WritingDesk:"
                + "numberOfDrawers" + " " + numberOfDrawers + " "
                + "hasKeyboardTray" + " " + hasKeyboardTray + " "
                + "maxWeightCapacity" + " " + maxWeightCapacity + " "
                + "currentHeight" + " " + currentHeight + " "
                + "maxHeight" + " " + maxHeight;
    }


    public void adjustHeight(int centimeters) {
        if ((currentHeight + centimeters) < maxHeight) {
            System.out.println("You can increase in by " + Math.abs((currentHeight + centimeters) - maxHeight));
        } else {
            System.out.println("You can not increase");
        }
    }

    public void moveDown(int centimeters) {
        if (currentHeight + centimeters > 0) {
            System.out.println("You can reduce in by " + (currentHeight + centimeters));
        } else {
            System.out.println("You can not reduce");
        }
    }
}

