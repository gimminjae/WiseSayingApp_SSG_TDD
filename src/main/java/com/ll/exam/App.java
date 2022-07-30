package com.ll.exam;

import java.util.Scanner;

public class App {
    public static String mode = "prod";
    private WiseSayingController wc;
    private Scanner sc;
    public App(Scanner sc) {
        this.sc = sc;
        wc = new WiseSayingController(sc);
    }
    public static String getDir() {
        return mode + "_data";
    }
    public void run() {
        System.out.println("== 명언 SSG ==");

        loop:
        while(true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine();
            Rq rq = new Rq(cmd);

            switch(rq.getPath()) {
                case "등록":
                    wc.create(rq);
                    break;
                case "목록":
                    wc.read(rq);
                    break;
                case "삭제":
                    wc.delete(rq);
                    break;
                case "수정":
                    wc.update(rq);
                    break;
                case "종료":
                    break loop;
                case "빌드":
                    wc.build(rq);
                    break;
            }
        }
    }
}
