package com.ll.exam;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WiseSayingTableTest {

    WiseSayingTable wsTable;
    @BeforeAll
    public void beforeAll() {
        App.mode = "test";
        wsTable = new WiseSayingTable(App.getDir());
    }
    @BeforeEach
    public void method() {
        Util.file.deleteDir(App.getDir());
        wsTable.save("나에게 불가능이란 없다.", "나폴레옹");
        wsTable.save("나의 죽음을 적들에게 알리지 말라.", "이순신");
    }
    @Test
    public void 객체를_저장하면_파일에_저장이_되는지_테스트() {
        int newId = wsTable.getLastId() + 1;
        wsTable.save("자유가 아니면 죽음을 달라!", "페트릭 헨리");

        assertTrue(new File("%s/wise_saying/%d.json".formatted(App.getDir(), newId)).exists());
    }
    @Test
    public void 조회() {
        WiseSaying ws = wsTable.findById(1);

        assertEquals(1, ws.getId());
        assertEquals("나에게 불가능이란 없다.", ws.getContent());
        assertEquals("나폴레옹", ws.getAuthor());
    }
    @Test
    public void 전체조회() {
        List<WiseSaying> wiseSayings = wsTable.findAll();

        assertEquals(2, wiseSayings.size());
        assertEquals(1, wiseSayings.get(0).getId());
        assertEquals("나에게 불가능이란 없다.", wiseSayings.get(0).getContent());
        assertEquals("나폴레옹", wiseSayings.get(0).getAuthor());

        assertEquals(2, wiseSayings.get(1).getId());
        assertEquals("나의 죽음을 적들에게 알리지 말라.", wiseSayings.get(1).getContent());
        assertEquals("이순신", wiseSayings.get(1).getAuthor());
    }
    @Test
    public void 삭제_테스트() {
        wsTable.removeById(1);

        WiseSaying wiseSaying = wsTable.findById(1);

        assertEquals(null, wiseSaying);
    }
}