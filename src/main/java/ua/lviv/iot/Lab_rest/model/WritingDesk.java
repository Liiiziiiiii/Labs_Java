package ua.lviv.iot.Lab_rest.model;
import lombok.*;
@Setter
@Getter
@RequiredArgsConstructor
public class WritingDesk {
    private int id;
    private String name;
    private int height;

    public WritingDesk(int id, String name, int height) {
        this.id = id;
        this.name = name;
        this.height = height;
    }
}
