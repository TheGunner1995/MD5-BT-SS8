package rikkei.academy.service.user;

import org.springframework.stereotype.Service;
import rikkei.academy.model.User;
import rikkei.academy.service.IGenericService;

public interface IUserService extends IGenericService<User,Long> {
    Iterable<User> findAll();
}
