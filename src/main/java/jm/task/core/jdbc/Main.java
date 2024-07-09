package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();

        User user1 = new User("Name1", "LastName1", (byte) 20);
        User user2 = new User("Name2", "LastName2", (byte) 25);
        User user3 = new User("Name3", "LastName3", (byte) 31);
        User user4 = new User("Name4", "LastName4", (byte) 38);

        for (User user : Arrays.asList(user1, user2, user3, user4)) {
            userService.saveUser(user.getName(), user.getLastName(), user.getAge());
            System.out.printf("User с именем – %s добавлен в базу данных %n", user.getName());
        }

        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
