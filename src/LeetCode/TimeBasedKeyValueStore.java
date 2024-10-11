package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStore {
    private class Pair {
        String value;
        int timestamp;

        Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    private Map<String, List<Pair>> map;

    public TimeBasedKeyValueStore() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<Pair>()).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        return binarySearch(map.get(key), timestamp);
    }

    private String binarySearch(List<Pair> list, int time) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid).timestamp > time) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            ;
        }
        return list.get(left).timestamp <= time ? list.get(left).value : "";
    }
}
