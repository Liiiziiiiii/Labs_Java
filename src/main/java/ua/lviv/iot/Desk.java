package ua.lviv.iot;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
public abstract class Desk {
    private int height;
    private int width;
    private int length;
    protected boolean hasKeyboardTray;

    public abstract void increaseTheHeightOfTheTableToTheMaximum(int centimeters);
    public abstract void moveDown (int centimeters);

    public Object deleteModelInfo(){
        return null;
    };

    public boolean hasKeyboardTray() {
        return true;
    }


}