package controller;


import entity.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.userRepository;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class usercontroller {
    @Autowired
    private userRepository userRepository;

    @GetMapping("/users")
    public List<user> getAllusers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<user> getuserById(@PathVariable(value = "id") Long id_user)
            throws ResourceNotFoundException {
        user user= userRepository.findById(id_user)
                .orElseThrow(() -> new ResourceNotFoundException("user not found for this id :: " +id_user));
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/users")
    public user createuser(@Valid @RequestBody user user) {
        return userRepository.save(user);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<user> updateuser(@PathVariable(value = "id") Long id_user,
                                             @Valid @RequestBody user userDetails) throws ResourceNotFoundException {
        user user = userDetails.findById(id_user)
                .orElseThrow(() -> new ResourceNotFoundException("user not found for this id :: " + id_user));

        user.setId_user(userDetails.getId_user());
        user.setNom_user(userDetails.getNom_user());
        user.setAdresse_user(userDetails.getAdresse_user());
        user.setTel_user(userDetails.getTel_user());
        user.setPoste_user(userDetails.getPoste_user());
        user.setDepartement_user(userDetails.getDepartement_user());
        final user updateduser= userDetails.save(user);
        return ResponseEntity.ok(updateduser);
    }

    @DeleteMapping("/users/{id}")
    public Map<String, Boolean> deleteuser(@PathVariable(value = "id") Long id_user)
            throws ResourceNotFoundException {
        user user = userRepository.findById(id_user)
                .orElseThrow(() -> new ResourceNotFoundException("user not found for this id :: " + id_user));

        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
}
