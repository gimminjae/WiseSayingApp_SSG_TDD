package com.ll.exam;

import java.util.LinkedList;
import java.util.List;

public class WiseSayingRepository {
    private List<WiseSaying> list;
    private int number;
    WiseSayingRepository() {
        number = 0;
        list = new LinkedList<>();
    }
    public WiseSaying add(String content, String author) {
        ++number;

        WiseSaying ws = new WiseSaying(number, content, author);
        list.add(ws);
        return ws;
    }

    public List<WiseSaying> readAll() {
        return list;
    }

    public void delete(int idNum) {
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() == idNum) {
                list.remove(i);
                return;
            }
        }
        System.out.println(idNum + "번 명언은 존재하지 않습니다.");
    }
    public WiseSaying findById(int idNum) {
        for(int i = 0; i < list.size(); i++) {
            WiseSaying ws = list.get(i);
            if(ws.getId() == idNum) return ws;
        }
        return null;
    }

    public void modify(int idNum, String newContent, String newAuthor) {
        WiseSaying ws = findById(idNum);
        ws.setContent(newContent);
        ws.setAuthor(newAuthor);
    }
}
