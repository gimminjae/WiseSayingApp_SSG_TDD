package com.ll.exam;

import java.util.LinkedList;
import java.util.List;

public class WiseSayingService {

    private WiseSayingRepository wsRepository;
    public WiseSayingService() {
        wsRepository = new WiseSayingRepository();

    }

    public WiseSaying write(String content, String author) {
        return wsRepository.write(content, author);
    }

    public void readAll() {
        wsRepository.readAll();
    }

    public void delete(int idNum) {
        wsRepository.delete(idNum);
    }

    public void update(int idNum, String newContent, String newAuthor) {
        wsRepository.update(idNum, newContent, newAuthor);
    }

    public WiseSaying findById(int idNum) {
        return wsRepository.findById(idNum);
    }
}
