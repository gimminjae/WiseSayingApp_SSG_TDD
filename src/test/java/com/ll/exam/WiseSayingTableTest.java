package com.ll.exam;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WiseSayingTableTest {
    @Test
    public void 객체를_저장하면_파일에_저장이_되는지_테스트() {
        WiseSayingTable wsTable = new WiseSayingTable("test_data");
        wsTable.save("나에게 불가능이란 없다.", "나폴레옹");
        assertTrue(new File("test_data/wise_saying/1.json").exists());
        wsTable.save("나의 죽음을 적들에게 알리지 말라.", "이순신");
        assertTrue(new File("test_data/wise_saying/2.json").exists());
    }
}