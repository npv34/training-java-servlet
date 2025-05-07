package org.app.demo3.models;

import org.app.demo3.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserModel {
    private static final List<User> data = new ArrayList<>();

    public static void loadData() {
        User u1 = new User(1, "nam", "nam@gmail.com", "090990809", "Ha Noi");
        User u2 = new User(2, "quan", "quan@gmail.com", "090990809", "Ha Noi");
        User u3 = new User(1, "hoang", "hoang@gmail.com", "090990809", "Ha Noi");
        User u4 = new User(1, "bao", "bao@gmail.com", "090990809", "Ha Noi");
        data.add(u1);
        data.add(u2);
        data.add(u3);
        data.add(u4);
    }

    public static List<User> getAll() {
        return data;
    }

    public static User findByID(int id) {
        User user = null;
        for (User item: data) {
            if (item.getId() == id) {
                user = item;
                break;
            }
        }
        return user;
    }

    public static void removeUser(int id) {
        User userRemove = findByID(id);
        data.remove(userRemove);
    }

}
