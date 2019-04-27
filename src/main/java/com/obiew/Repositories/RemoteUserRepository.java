package com.obiew.Repositories;

import com.obiew.Entities.User;
import io.grpc.examples.obiew.Server;
import org.springframework.beans.factory.annotation.Autowired;

public class RemoteUserRepository {
    @Autowired
    private Server server;

    public RemoteUserRepository(){}


    public boolean login(User user) {
        try {
            return server.login(user.getUsername(), user.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean register(User user) {
        try {
            return server.register(user.getUsername(), user.getPassword(), "example@example.com", "123456", 0);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
