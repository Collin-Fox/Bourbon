package fox.bouron.Bourbon.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import fox.bouron.Bourbon.user.User;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    // Returns a user by user id
    Optional<User> findUserByUserID(int UserID);

    Optional<User> findUserByEmail(String email);

}
