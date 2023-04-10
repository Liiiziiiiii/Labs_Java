package ua.lviv.iot;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true)
public class ChildrenTable extends Desk {
    private float ageOfTheChild;
    private int maxHeight;

    public ChildrenTable(final int height, final int width, final int length, final boolean hasKeyboardTray, final float ageOfTheChild, final int maxHeight) {
        super(height, width, length, hasKeyboardTray);
        this.ageOfTheChild = ageOfTheChild;
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
        if (getHeight() + centimeters > 0) {
            setHeight(getHeight() + centimeters);
        } else {
            setHeight(0);
        }
    }

}
