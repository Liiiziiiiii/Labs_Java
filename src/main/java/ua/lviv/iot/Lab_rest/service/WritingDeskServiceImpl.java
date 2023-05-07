package ua.lviv.iot.Lab_rest.service;

import ua.lviv.iot.Lab_rest.model.WritingDesk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class WritingDeskServiceImpl implements WritingDeskService{

    private static final Map<Integer, WritingDesk> CLIENT_REPOSITORY_MAP = new HashMap<>();


    private static final AtomicInteger CLIENT_ID_HOLDER = new AtomicInteger();

    @Override
    public void create(WritingDesk client) {
        final int clientId = CLIENT_ID_HOLDER.incrementAndGet();
        client.setId(clientId);
        CLIENT_REPOSITORY_MAP.put(clientId, client);
    }

    @Override
    public List<WritingDesk> readAll() {
        return new ArrayList<>(CLIENT_REPOSITORY_MAP.values());
    }

    @Override
    public WritingDesk read(int id) {
        return CLIENT_REPOSITORY_MAP.get(id);
    }

    @Override
    public boolean update(WritingDesk writingDesk, int id) {
        if (CLIENT_REPOSITORY_MAP.containsKey(id)) {
            writingDesk.setId(id);
            CLIENT_REPOSITORY_MAP.put(id, writingDesk);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        return CLIENT_REPOSITORY_MAP.remove(id) != null;
    }
}
