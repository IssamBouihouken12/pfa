package controller;
import entity.fournisseur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.fournisseurRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class fournisseurcontroller {
    @Autowired
    private fournisseurRepository fournisseurRepository;
    @GetMapping("/fournisseurs")
    public List<fournisseur> getAllfournisseurs() {
        return fournisseurRepository.findAll();
    }

    @GetMapping("/fournisseurs/{id}")
    public ResponseEntity<fournisseur> getfournisseurByid_four(@PathVariable(value = "id_four") Long id_four)
            throws ResourceNotFoundException {
        fournisseur fournisseur = fournisseurRepository.findById(id_four)
                .orElseThrow(() -> new ResourceNotFoundException("Fournisseur not found for this id :: " + id_four));
        return ResponseEntity.ok().body(fournisseur);
    }

    @PostMapping("/fournisseurs")
    public fournisseur createfournisseur(@Valid @RequestBody fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }

    @PutMapping("/fournisseurs/{id}")
    public ResponseEntity<fournisseur> updatefournisseur(@PathVariable(value = "id") Long id_four,
                                                      @Valid @RequestBody fournisseur fournisseurDetails) throws ResourceNotFoundException {
        fournisseur fournisseur = fournisseurDetails.findById(id_four)
                .orElseThrow(() -> new ResourceNotFoundException("Fournisseur not found for this id :: " + id_four));

        fournisseur.setId_four(fournisseurDetails.getId_four());
        fournisseur.setNom_four(fournisseurDetails.getnom_four());
        fournisseur.settel_four(fournisseurDetails.gettel_four());
        fournisseur.setadresse_four(fournisseurDetails.getadresse_four());
        final fournisseur updatedFournisseur = fournisseurDetails.save(fournisseur);
        return ResponseEntity.ok(updatedFournisseur);
    }

    @DeleteMapping("/fournisseurs/{id}")
    public Map<String, Boolean> deletefournisseur(@PathVariable(value = "id") Long id_four)
            throws ResourceNotFoundException {
        fournisseur fournisseur = fournisseurRepository.findById(id_four)
                .orElseThrow(() -> new ResourceNotFoundException("Fournisseur not found for this id :: " + id_four));

        fournisseurRepository.delete(fournisseur);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


