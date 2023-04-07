package ua.lviv.iot;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public abstract class Desk {
    private int height;
    private int width;
    private int length;
    protected boolean hasKeyboardTray;

    public abstract int increaseTheHeightOfTheTableToTheMaximum(int centimeters);
    public abstract short moveDown (int centimeters);


}