package com.ll.exam;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WiseSayingTable {
    private String dir;
    public WiseSayingTable(String dir) {
        this.dir = dir;
    }

    public void save(WiseSaying ws) {
        Util.file.mkdir("%s/wise_saying".formatted(dir));
        String text = ws.toJson();
        Util.file.saveToFile("%s/wise_saying/%d.json".formatted(dir, ws.getId()), text);
    }

    public WiseSaying save(String content, String author) {
        int id = getLastId() + 1;

        WiseSaying ws = new WiseSaying(id, content, author);
        save(ws);
        saveLastId(id);

        return ws;
    }
    public boolean save(int id, String content, String author) {
        WiseSaying ws = new WiseSaying(id, content, author);
        save(ws);
        return true;
    }

    private void saveLastId(int id) {
        Util.file.saveToFile("%s/wise_saying/last_id.txt".formatted(dir), id + "");
    }

    public int getLastId() {
        String lastId = Util.file.readFromFile("%s/wise_saying/last_id.txt".formatted(dir), "");

        if (lastId.isEmpty()) {
            return 0;
        }
        return Integer.valueOf(lastId);
    }
    public WiseSaying findById(int id) {
        String path = "%s/wise_saying/%d.json".formatted(dir, id);

        if (new File(path).exists() == false) {
            return null;
        }

        Map<String, Object> map = Util.json.jsonToMapFromFile(path);

        if (map == null) {
            return null;
        }

        return new WiseSaying((int) map.get("id"), (String) map.get("content"), (String) map.get("author"));
    }
    public List<WiseSaying> findAll() {
        List<Integer> fileIds = getFileIds();

        return fileIds
                .stream()
                .map(id -> findById(id))
                .collect(Collectors.toList());
    }

    private List<Integer> getFileIds() {
        String path = "%s/wise_saying".formatted(dir);
        List<String> fileNames = Util.file.getFileNamesFromDir(path);

        return fileNames
                .stream()
                .filter(fileName -> !fileName.equals("last_id.txt"))
                .filter(fileName -> !fileName.equals("data.json")) // 영상에는 이 부분이 빠져있습니다. 꼭 추가해주세요.
                .filter(fileName -> fileName.endsWith(".json"))
                .map(fileName -> fileName.replace(".json", ""))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
    public boolean removeById(int id) {
        String path = "%s/wise_saying/%d.json".formatted(dir, id);

        new File(path).delete();
        return true;
    }

}

