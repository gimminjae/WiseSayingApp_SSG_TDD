package com.ll.exam;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class App {
    private WiseSayingController ws;
    private Rq rq;
    private Scanner sc;
    public App(Scanner sc) {
        this.sc = sc;
        ws = new WiseSayingController(sc);
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
                    ws.create(rq);
                    break;
                case "목록":
                    ws.read(rq);
                    break;
                case "삭제":
                    ws.delete(rq);
                    break;
                case "수정":
                    ws.update(rq);
                    break;
                case "종료":
                    break loop;

            }
        }
    }
}
