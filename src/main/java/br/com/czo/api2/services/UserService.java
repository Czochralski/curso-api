package br.com.czo.api2.services;

import br.com.czo.api2.domain.User;

public interface UserService {
    User findById(Integer id);
}
