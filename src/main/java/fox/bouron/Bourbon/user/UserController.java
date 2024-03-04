package fox.bouron.Bourbon.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    // Get a list of all users
    @GetMapping("/all")
    public List<User> getAllUsers(){
        return (List<User>) userRepository.findAll();
    }

    //Returns a single user by their email
    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email) {
        Optional<User> user = userRepository.findUserByEmail(email);

        if(user.isPresent()){
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //Returns a user by their id
    @GetMapping("/id/{id}")
    public ResponseEntity<User> getUserByID(@PathVariable("id") int id){
        Optional<User> user = userRepository.findUserByUserID(id);

        if(user.isPresent()){
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    // Insert a new user NEEDS TESTING
    @PostMapping(value = "/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser (@RequestBody final User user){
        if(!userRepository.existsById(user.getUserID())){
            userRepository.save(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(user, HttpStatus.FOUND);
        }
    }

    // Updates a user NEEDS TESTING
    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateUser (@RequestBody final User user){
        if(userRepository.existsById(user.getUserID())){
            return new ResponseEntity<>(userRepository.save(user), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}
