package com.ll.exam;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AppTest { //아래에서 위로 진행함
    @BeforeAll
    public void beforeAll() {
        App.setMode("test");
    }
    @BeforeEach
    public void beforeEach() {
        Util.file.deleteDir(App.getDir());
    }

    @Test
    public void 수정기능_예외처리_테스트() {
        String rs = AppTestRunner.run("""
                등록
                현재를 사랑하라
                작자미상
                수정
                수정?id=
                종료
                """);
        assertTrue(rs.contains("id를 입력하세요."));
        assertTrue(rs.contains("id를 입력하세요."));
    }
    @Test
    public void 명언과_작가_수정시_목록에_반영이_되는지() {
        String rs = AppTestRunner.run("""
                등록
                현재를 사랑하라
                작자미상
                목록
                수정?id=1
                과거를 사랑하라
                홍길동
                목록
                종료""");
        assertTrue(rs.contains("1 / 작자미상 / 현재를 사랑하라"));
        assertTrue(rs.contains("1 / 홍길동 / 과거를 사랑하라"));
    }
    @Test
    public void 수정명령어_입력시_기존것을_출력하고_새로_입력을_받는지() {
        String rs = AppTestRunner.run("""
                등록
                현재를 사랑하라
                작자미상
                수정?id=1
                과거를 사랑하라
                홍길동
                종료
                """);
        assertTrue(rs.contains("명언(기존) : 현재를 사랑하라"));
        assertTrue(rs.contains("명언 : "));
        assertTrue(rs.contains("작가(기존) : "));
        assertTrue(rs.contains("작가 : "));
    }

    @Test
    public void 삭제기능_모든_예외처리() {
        String rs = AppTestRunner.run("""
                등록
                현재를 사랑하라
                작자 모름
                등록
                과거를 사랑하라
                작자없음
                삭제
                삭제?id
                삭제?id=1
                삭제?id=1
                종료""");
        assertTrue(rs.contains("id를 입력하세요."));
        assertTrue(rs.contains("id를 입력하세요."));
        assertTrue(rs.contains("1번 명언이 삭제되었습니다."));
        assertTrue(rs.contains("1번 명언은 존재하지 않습니다."));
    }
    @Test
    public void 삭제_테스트() {
        String rs = AppTestRunner.run("""
                등록
                현재를 사랑하라
                작자 모름
                등록
                과거를 사랑하라
                작자없음
                삭제?id=1
                목록
                종료""");
        assertTrue(rs.contains("2 / 작자없음 / 과거를 사랑하라"));
        assertTrue(rs.contains("1번 명언이 삭제되었습니다."));
        assertFalse(rs.contains("1 / 작자 모름 / 현재를 사랑하라"));
    }
    @Test
    public void 등록하고_목록_입력시_명언목록이_출력되는지() {
        String rs = AppTestRunner.run("""
                등록
                현재를 사랑하라
                작자 모름
                등록
                과거를 사랑하라
                작자없음
                목록
                종료
                """);
        assertTrue(rs.contains("번호 / 작가 / 명언"));
        assertTrue(rs.contains("====================="));
        assertTrue(rs.contains("2 / 작자없음 / 과거를 사랑하라"));
        assertTrue(rs.contains("1 / 작자 모름 / 현재를 사랑하라"));

    }
    @Test
    public void 명언_여러개_등록시_명언번호가_증가하는지() {
        String rs = AppTestRunner.run("""
                등록
                현재를 사랑하라
                작자미상
                등록
                과거를 사랑하라
                작자 알 수 없음
                종료
                """);
        assertTrue(rs.contains("1번 명언이 등록되었습니다."));
        assertTrue(rs.contains("2번 명언이 등록되었습니다."));

    }
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


}
