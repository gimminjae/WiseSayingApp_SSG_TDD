package com.ll.exam;

import java.util.Scanner;

public class App {
    private Scanner sc;
    public App(Scanner sc) {
        this.sc = sc;
    }
    public void run() {
        System.out.println("== 명언 SSG ==");

        loop:
        while(true) {
            System.out.println("명령) ");
            String cmd = sc.nextLine();

            switch(cmd) {
                case "등록":
                    System.out.println("명언 : ");
                    String content = sc.nextLine();
                    System.out.println("작가 : ");
                    String author = sc.nextLine();
                    System.out.println("1번 명언이 등록되었습니다.");
                    break;
                case "종료":
                    break loop;

            }
        }
    }
}
