package bethacode.clinimais.resource;

import bethacode.clinimais.model.Consulta;
import bethacode.clinimais.model.Procedimento;
import bethacode.clinimais.repository.ConsultaRepository;
import bethacode.clinimais.repository.ProcedimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/consulta")
public class ConsultaController {
    @Autowired
    private ConsultaRepository repository;

    @GetMapping
    public List<Consulta> getConsulta() {
        return repository.findAll();
    }

    @PostMapping
    public Consulta create(@Valid @RequestBody Consulta consulta){
        return repository.save(consulta);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
