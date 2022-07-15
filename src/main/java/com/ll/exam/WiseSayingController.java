package com.ll.exam;

import java.util.Scanner;

public class WiseSayingController {
    private Scanner sc;
    private WiseSayingService wsService;
    public WiseSayingController(Scanner sc) {
        this.sc = sc;
        wsService = new WiseSayingService();

    }
    public void create(Rq rq) {
        System.out.print("명언 : ");
        String content = sc.nextLine();

        System.out.print("작가 : ");
        String author = sc.nextLine();

        WiseSaying ws = wsService.write(content, author);
        System.out.printf("%d번 명언이 등록되었습니다.\n", ws.getId());
    }
    public void read(Rq rq) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("=====================");
        wsService.readAll();
    }

    public void delete(Rq rq) {
        int idNum = rq.getIntParam("id", 0);
        if(idNum == 0) {
            System.out.println("id를 입력하세요.");
            return;
        }
        wsService.delete(idNum);
    }

    public void update(Rq rq) {
        int idNum = rq.getIntParam("id", 0);
        if(idNum == 0) {
            System.out.println("id를 입력하세요.");
            return;
        }
        WiseSaying ws = wsService.findById(idNum);
        if(ws == null) {
            System.out.println(idNum + "번 명언은 존재하지 않습니다.");
            return;
        }
        System.out.println("명언(기존) : " + ws.getContent());
        System.out.print("명언 : ");
        String newContent = sc.nextLine();

        System.out.println("작가(기존) : " + ws.getAuthor());
        System.out.print("작가 : ");
        String newAuthor = sc.nextLine();

        wsService.update(idNum, newContent, newAuthor);

        System.out.printf("%d번 명언이 수정되었습니다.\n", idNum);
    }

}