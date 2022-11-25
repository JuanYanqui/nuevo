package ista.Backed20.api.controller;

import ista.Backed20.api.entity.Persona;
import ista.Backed20.api.entity.Usuario;
import ista.Backed20.api.repository.PersonaRepository;
import ista.Backed20.api.service.RolServiceImpl;
import ista.Backed20.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    private PersonaRepository personaRepository;

    @Autowired
	private RolServiceImpl rolService;

    @PostMapping("/guardarUsuario")
    public ResponseEntity <Usuario> guardarUsuario(@RequestBody Usuario usuario) {
        return new ResponseEntity<>(usuarioService.guardarUsuario(usuario), HttpStatus.CREATED);
    }

    

    @GetMapping("/{username}")
    public Usuario obtenerUsuario(@PathVariable("username") String username){
        return usuarioService.obtenerUsuario(username);
    }


    @GetMapping("/traerDatos/{cedula}")
    public ResponseEntity<List<?>> TraerDatosPersona(@PathVariable("cedula") String cedula) {
        return ResponseEntity.ok(usuarioService.buscarPerson(cedula));

    }




}
