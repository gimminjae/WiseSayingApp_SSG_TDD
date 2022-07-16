package com.ll.exam;

import java.util.List;

public class WiseSayingRepository {
    private WiseSayingTable wsTable;
    WiseSayingRepository() {
        wsTable = new WiseSayingTable(App.getDir());
    }
    public WiseSaying add(String content, String author) {

        return wsTable.save(content, author);
    }

    public List<WiseSaying> readAll() {
        return wsTable.findAll();
    }

    public boolean delete(int idNum) {
        return wsTable.removeById(idNum);
    }
    public WiseSaying findById(int idNum) {
        return wsTable.findById(idNum);
    }

    public boolean modify(int idNum, String newContent, String newAuthor) {
        return wsTable.save(idNum, newContent, newAuthor);
    }
}
