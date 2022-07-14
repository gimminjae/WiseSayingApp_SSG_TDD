package com.ll.exam;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {
    @Test
    public void 등록시_등록번호와_함께_등록완료문자_출력() {
        String rs = AppTestRunner.run("""
                등록
                현재를 사랑하라
                작자미상
                종료
                """);

        assertTrue(rs.contains("1번 명언이 등록되었습니다."));
    }
    @Test
    public void 등록시_명언과_작가를_입력받는지() {
        String rs = AppTestRunner.run("""
                등록
                나의 죽음을 적에게 알리지 마라
                이순신
                종료
                """);

        assertTrue(rs.contains("명언 : "));
        assertTrue(rs.contains("작가 : "));
    }
    @Test
    public void 프로그램_시작시_타이틀출력_그리고_종료() {
        String rs = AppTestRunner.run("""
                종료
                """);
    }
    @Test
    public void 테스트() {
        assertTrue(1 == 1);
        assertEquals(1, 1);
    }
    @Test
    public void 스캐너에_키보드가_아닌_문자열을_입력으로_설정() {
        Scanner sc = TestUtil.genScanner("안녕");

        String cmd = sc.nextLine().trim();
        assertEquals("안녕", cmd);
    }
    @Test
    public void 문자열을_파일에_저장() {
        //파일 생성
        Util.file.mkdir("test_data");

        //쓰기
        Util.file.saveToFile("test_data/1.txt", "안녕");

        //읽기
        String body = Util.file.readFromFile("test_data/1.txt");

        assertEquals("안녕", body);

    }
    @Test
    public void 출력을_모니터에_하지_않고_문자열로_얻기() {
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();
        System.out.print("안녕");
        String rs = output.toString();
        TestUtil.clearSetOutToByteArray(output);
    }
}
