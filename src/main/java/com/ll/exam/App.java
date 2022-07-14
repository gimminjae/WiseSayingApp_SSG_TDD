package com.ll.exam;

import java.util.Scanner;

public class App {
    private Scanner sc;
    private int number;
    public App(Scanner sc) {
        this.sc = sc;
        number = 0;
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
                    ++number;
                    System.out.printf("%d번 명언이 등록되었습니다.\n", number);
                    break;
                case "종료":
                    break loop;

            }
        }
    }
}
