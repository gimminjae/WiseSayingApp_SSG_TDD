package com.ll.exam;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private List<WiseSaying> list;
    private Scanner sc;
    private int number;
    private Rq rq;
    public WiseSayingController(Scanner sc) {
        this.sc = sc;
        number = 0;
        list = new LinkedList<>();
    }
    public void create(Rq rq) {
        System.out.print("명언 : ");
        String content = sc.nextLine();

        System.out.print("작가 : ");
        String author = sc.nextLine();

        ++number;

        list.add(new WiseSaying(number, content, author));
        System.out.printf("%d번 명언이 등록되었습니다.\n", number);
    }
    public void read(Rq rq) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("=====================");

        for(int i = list.size() - 1; i >= 0; i--) {
            WiseSaying ws = list.get(i);
            System.out.printf("%d / %s / %s\n", ws.getId(), ws.getAuthor(), ws.getContent());
        }
    }

    public void delete(Rq rq) {
        int idNum = rq.getIntParam("id", 0);
        if(idNum == 0) {
            System.out.println("id를 입력하세요.");
            return;
        }

        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() == idNum) {
                list.remove(i);
                System.out.println(idNum + "번 명언이 삭제되었습니다.");
                return;
            }
        }
        System.out.println(idNum + "번 명언은 존재하지 않습니다.");
    }

    public void update(Rq rq) {
        int idNum = rq.getIntParam("id", 0);
        if(idNum == 0) {
            System.out.println("id를 입력하세요.");
            return;
        }

        for(int i = 0; i < list.size(); i++) {
            WiseSaying ws = list.get(i);
            if(ws.getId() == idNum) {
                System.out.println("명언(기존) : " + ws.getContent());
                System.out.print("명언 : ");
                String newContent = sc.nextLine();

                System.out.println("작가(기존) : " + ws.getAuthor());
                System.out.print("작가 : ");
                String newAuthor = sc.nextLine();

                ws.setContent(newContent);
                ws.setAuthor(newAuthor);
                return;
            }
        }
        System.out.println(idNum + "번 명언은 존재하지 않습니다.");
    }
}
