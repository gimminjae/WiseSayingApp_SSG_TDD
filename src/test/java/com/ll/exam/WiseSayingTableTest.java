package com.ll.exam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WiseSayingTableTest {
    WiseSayingTable wsTable;
    WiseSayingTableTest() {
        wsTable = new WiseSayingTable("test_data");
    }
    @BeforeEach
    public void method() {
        Util.file.deleteDir("test_data");
        wsTable.save("나에게 불가능이란 없다.", "나폴레옹");
        wsTable.save("나의 죽음을 적들에게 알리지 말라.", "이순신");
    }
    @Test
    public void 객체를_저장하면_파일에_저장이_되는지_테스트() {
        int newId = wsTable.getLastId() + 1;
        wsTable.save("자유가 아니면 죽음을 달라!", "페트릭 헨리");

        assertTrue(new File("test_data/wise_saying/%d.json".formatted(newId)).exists());
    }
    @Test
    public void 조회() {
        WiseSaying ws = wsTable.findById(1);

        assertEquals(1, ws.getId());
        assertEquals("나에게 불가능이란 없다.", ws.getContent());
        assertEquals("나폴레옹", ws.getAuthor());
    }
}