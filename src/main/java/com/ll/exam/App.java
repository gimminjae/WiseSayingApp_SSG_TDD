package com.ll.exam;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class App {
    private List<WiseSaying> list;
    private Scanner sc;
    private int number;
    private Rq rq;
    public App(Scanner sc) {

        this.sc = sc;
        number = 0;
        list = new LinkedList<>();
    }
    public void run() {
        System.out.println("== 명언 SSG ==");

        loop:
        while(true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine();
            rq = new Rq(cmd);

            switch(rq.getPath()) {
                case "등록":
                    System.out.print("명언 : ");
                    String content = sc.nextLine();
                    System.out.print("작가 : ");
                    String author = sc.nextLine();
                    ++number;
                    list.add(new WiseSaying(number, content, author));
                    System.out.printf("%d번 명언이 등록되었습니다.\n", number);
                    break;
                case "목록":
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("=====================");
                    for(int i = list.size() - 1; i >= 0; i--) {
                        WiseSaying ws = list.get(i);
                        System.out.printf("%d / %s / %s\n", ws.getId(), ws.getAuthor(), ws.getContent());
                    }
                    break;
                case "삭제":
                    int idNum = rq.getIntParam("id", 0);
                    for(int i = 0; i < list.size(); i++) {
                        if(list.get(i).getId() == idNum) list.remove(i);
                        break;
                    }
                    System.out.println(idNum + "번 명언이 삭제되었습니다.");
                    break;
                case "종료":
                    break loop;

            }
        }
    }
}
