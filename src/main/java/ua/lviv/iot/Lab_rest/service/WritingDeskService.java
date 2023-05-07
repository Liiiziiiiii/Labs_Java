package ua.lviv.iot.Lab_rest.service;

import org.springframework.context.annotation.Bean;
import ua.lviv.iot.Lab_rest.model.WritingDesk;

import java.util.List;

public interface WritingDeskService {
    @Bean
    void create(WritingDesk writingDesk);

    @Bean
    List<WritingDesk> readAll();
    @Bean
    WritingDesk read(int id);

    @Bean
    boolean update(WritingDesk writingDesk, int id);

    @Bean
    boolean delete(int id);
}
