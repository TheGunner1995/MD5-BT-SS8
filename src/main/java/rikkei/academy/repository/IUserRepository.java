package rikkei.academy.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import rikkei.academy.model.User;
@Repository
public interface IUserRepository extends PagingAndSortingRepository<User, Long> {
}
