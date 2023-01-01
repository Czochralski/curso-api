package br.com.czo.api2.services;

import br.com.czo.api2.domain.User;

import java.util.List;

public interface UserService {
    User findById(Integer id);
    List<User> findAll();
}
