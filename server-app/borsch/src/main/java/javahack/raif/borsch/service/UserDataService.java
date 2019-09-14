package javahack.raif.borsch.service;

import javahack.raif.borsch.domain.User;
import javahack.raif.borsch.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.repository.support.SimpleCassandraRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserDataService {

    @Autowired
    private UserRepo userRepo;

    @PutMapping("user/{userId}")
    public String addUser(@PathVariable UUID userId) {
        User user = new User(userId);
        userRepo.save(user);
        return "User " + userId + "saved successfully";
    }


    @GetMapping("user/{userId}")
    public String getUserById(@PathVariable UUID userId) {
        Optional<User> userOpt = userRepo.findById(userId);
        if (userOpt.isPresent()) {
            return userOpt.get().toString();
        }
        throw new RuntimeException("User not found");
    }

}
