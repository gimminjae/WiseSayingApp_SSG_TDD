package com.ll.exam;

public class WiseSayingTable {
    private String dir;
    public WiseSayingTable(String dir) {
        this.dir = dir;
    }

    public void save(WiseSaying ws) {
        Util.file.mkdir("%s/wise_saying".formatted(dir));
        String text = "내용";
        Util.file.saveToFile("%s/wise_saying/%d.json".formatted(dir, ws.getId()), text);
    }
}

