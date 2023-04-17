package ua.lviv.iot;

import lombok.*;

@Setter
@Getter
@ToString(callSuper = true)
public class WritingDesk extends Desk {
    private int miniHeight;
    private int maxHeight;


    public WritingDesk(final String name, final int height, final int width, final int length, final boolean hasKeyboardTray, final int miniHeight, final int maxHeight) {
        super(name, height, width, length, hasKeyboardTray);
        this.miniHeight = miniHeight;
        this.maxHeight = maxHeight;
    }


    @Override
    public void increaseTheHeightOfTheTableToTheMaximum(final int centimeters) {
        if ((getHeight() + centimeters) < maxHeight) {
            setHeight(Math.abs((getHeight() + centimeters) - maxHeight));
        } else {
            setHeight(0);
        }
    }

    @Override
    public void moveDown(final int centimeters) {
        if ((getHeight() + centimeters) < maxHeight) {
            setHeight(getHeight() + centimeters);
        } else {
            setHeight(0);
        }
    }

    public String getHeaders(){
        return HEADER + ", miniHeight" + ", maxHeight";

    }

    public String toCSV() {
        return super.toCSV() + "," + miniHeight + "," + maxHeight;
    }


}

