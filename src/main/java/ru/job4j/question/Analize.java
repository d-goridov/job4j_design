package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        int added = 0;
        int changed = 0;
        int deleted;
        int endSize = 0;

        Map<Integer, String> map = new HashMap<>();
        for (User user: previous) {
            map.put(user.getId(), user.getName());
        }
        for (User user: current) {
            String str = map.get(user.getId());

            if (str == null) {
                added++;
            }

            if (str != null && !str.equals(user.getName())) {
                changed++;
            }

            if (map.containsKey(user.getId())) {
                endSize++;
            }
        }
        deleted = previous.size() - endSize;
        return new Info(added, changed, deleted);
    }
}
