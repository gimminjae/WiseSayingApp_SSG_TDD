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

    public void save(String content, String author) {
        int id = getLastId() + 1;

        WiseSaying ws = new WiseSaying(id, content, author);
        save(ws);
        saveLastId(id);
    }

    private void saveLastId(int id) {
        Util.file.saveToFile("%s/wise_saying/last_id.txt".formatted(dir), id + "");
    }

    private int getLastId() {
        String lastId = Util.file.readFromFile("%s/wise_saying/last_id.txt".formatted(dir), "");

        if (lastId.isEmpty()) {
            return 0;
        }
        return Integer.valueOf(lastId);
    }
}

