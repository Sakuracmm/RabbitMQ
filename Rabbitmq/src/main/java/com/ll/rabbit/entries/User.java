package com.ll.rabbit.entries;

/**
 * @author LL
 * @date 2019/9/4
 * @description User对象
 */
public class User {
    int age;
    String username;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", username='" + username + '\'' +
                '}';
    }
}
