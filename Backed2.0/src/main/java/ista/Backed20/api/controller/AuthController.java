package ista.Backed20.api.controller;

import ista.Backed20.api.login.LoginUsuario;
import ista.Backed20.api.login.MessageResponse;
import ista.Backed20.api.repository.UsuarioRepository;
import ista.Backed20.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginUsuario usuario) {

        //String username = usuario.getUsername();

        usuarioRepository.findByUsername(usuario.getUsername());

        if (usuario.getUsername().equals("admin")){

            return ResponseEntity.ok()
                    .body(new MessageResponse(
                            "Registrado" + usuario.getUsername())
                    );
        }else {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("No registrado!"+ usuario.getUsername() +" " + usuario.getPassword()));
        }
    }
}
