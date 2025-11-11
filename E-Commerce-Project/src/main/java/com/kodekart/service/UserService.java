package com.kodekart.service;

import com.kodekart.dao.UserDao;
import com.kodekart.dao.impl.UserDaoImpl;
import com.kodekart.model.User;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Scanner;

public class UserService {
    private final UserDao userDao = new UserDaoImpl();
    private final Scanner in = new Scanner(System.in);

    public void seedAdminIfMissing() {
        userDao.ensureAdminSeeded("admin@kodekart.com", "admin123");
    }

    public void register() {
        System.out.println("\n-- Register --");
        System.out.print("Name: ");
        String name = in.nextLine().trim();
        System.out.print("Email: ");
        String email = in.nextLine().trim();
        System.out.print("Phone: ");
        String phone = in.nextLine().trim();
        System.out.print("Password: ");
        String pwd = in.nextLine();

        if (userDao.emailExists(email)) {
            System.out.println("Email already registered.");
            return;
        }

        String hash = BCrypt.hashpw(pwd, BCrypt.gensalt(12));
        User u = new User(name, email, phone, hash, "USER");
        int id = userDao.save(u);
        System.out.println(id > 0 ? "Registered successfully!" : "Registration failed.");
    }

    public User login() {
        System.out.println("\n-- Login --");
        System.out.print("Email: ");
        String email = in.nextLine().trim();
        System.out.print("Password: ");
        String pwd = in.nextLine();

        User u = userDao.findByEmailAndPassword(email, pwd);
        if (u == null) {
            System.out.println("Invalid credentials.");
            return null;
        }
        System.out.println("Welcome, " + u.getName() + " (" + u.getRole() + ")");
        return u;
    }
}
