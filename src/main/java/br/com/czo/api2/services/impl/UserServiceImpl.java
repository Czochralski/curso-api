package br.com.czo.api2.services.impl;

import br.com.czo.api2.domain.User;
import br.com.czo.api2.repositories.UserRepository;
import br.com.czo.api2.services.UserService;
import br.com.czo.api2.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;
    @Override
    public User findById(Integer id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
