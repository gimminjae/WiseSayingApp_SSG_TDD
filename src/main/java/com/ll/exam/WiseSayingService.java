package com.ll.exam;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class WiseSayingService {

    private WiseSayingRepository wsRepository;
    public WiseSayingService() {
        wsRepository = new WiseSayingRepository();

    }

    public WiseSaying write(String content, String author) {
        return wsRepository.add(content, author);
    }

    public List<WiseSaying> readlist() {
        return wsRepository.readAll();
    }

    public boolean delete(int idNum) {
        return wsRepository.delete(idNum);
    }

    public void update(int idNum, String newContent, String newAuthor) {
        wsRepository.modify(idNum, newContent, newAuthor);
    }

    public WiseSaying findById(int idNum) {
        return wsRepository.findById(idNum);
    }

    public void dumpToJson() {
        List<WiseSaying> wiseSayings = wsRepository.readAll();

        String json = "[" + wiseSayings
                .stream()
                .map(wiseSaying -> wiseSaying.toJson())
                .collect(Collectors.joining(",")) + "]";

        Util.file.saveToFile("%s/data.json".formatted(App.getDir()), json);
    }

}
