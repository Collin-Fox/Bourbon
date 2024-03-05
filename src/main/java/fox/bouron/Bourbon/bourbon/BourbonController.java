package fox.bouron.Bourbon.bourbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bourbon")
public class BourbonController {
    @Autowired
    private BourbonRepository bourbonRepository;

    //Get a list of all bourbons
    @GetMapping("/all")
    public List<Bourbon> getAllBourbon(){
        return (List<Bourbon>) bourbonRepository.findAll();
    }



    //Insert a new bourbon
    @PostMapping(value = "/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bourbon> insertBourbon(@RequestBody final Bourbon bourbon){
        if(!bourbonRepository.existsById(bourbon.getbID())){
            bourbonRepository.save(bourbon);
            return new ResponseEntity<>(bourbon, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(bourbon, HttpStatus.FOUND);
        }
    }


}
