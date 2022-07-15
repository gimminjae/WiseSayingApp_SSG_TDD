package com.ll.exam;

import java.util.LinkedList;
import java.util.List;

public class WiseSayingService {
    private List<WiseSaying> list;
    private int number;
    public WiseSayingService() {
        number = 0;
        list = new LinkedList<>();
    }

    public WiseSaying write(String content, String author) {
        ++number;

        WiseSaying ws = new WiseSaying(number, content, author);
        list.add(ws);
        return ws;
    }

    public void readAll() {
        for(int i = list.size() - 1; i >= 0; i--) {
            WiseSaying ws = list.get(i);
            System.out.printf("%d / %s / %s\n", ws.getId(), ws.getAuthor(), ws.getContent());
        }
    }

    public void delete(int idNum) {
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() == idNum) {
                list.remove(i);
                System.out.println(idNum + "번 명언이 삭제되었습니다.");
                return;
            }
        }
        System.out.println(idNum + "번 명언은 존재하지 않습니다.");
    }

    public void update(int idNum, String newContent, String newAuthor) {
        WiseSaying ws = findById(idNum);
        ws.setContent(newContent);
        ws.setAuthor(newAuthor);
    }
    public WiseSaying findById(int idNum) {
        for(int i = 0; i < list.size(); i++) {
            WiseSaying ws = list.get(i);
            if(ws.getId() == idNum) return ws;
        }
        return null;
    }
}
