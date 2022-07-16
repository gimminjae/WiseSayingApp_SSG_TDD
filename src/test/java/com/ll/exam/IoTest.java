package com.ll.exam;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IoTest {
    @Test
    public void 스캐너에_키보드가_아닌_문자열을_입력으로_설정() {
        Scanner sc = TestUtil.genScanner("안녕");

        String cmd = sc.nextLine().trim();
        assertEquals("안녕", cmd);
    }
    @Test
    public void 문자열을_파일에_저장() {
        //파일 생성
        Util.file.mkdir(App.getDir());

        //쓰기
        Util.file.saveToFile(App.getDir() + "/1.txt", "안녕");

        //읽기
        String body = Util.file.readFromFile(App.getDir() + "/1.txt", "");

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
