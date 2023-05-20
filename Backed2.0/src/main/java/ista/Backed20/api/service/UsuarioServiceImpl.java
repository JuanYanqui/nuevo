package ista.Backed20.api.service;


import ista.Backed20.api.entity.Persona;
import ista.Backed20.api.repository.PersonaRepository;
import ista.Backed20.api.repository.RolRepository;
import ista.Backed20.api.repository.UsuarioRepository;
import ista.Backed20.api.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PersonaRepository personaRepository;


    @Autowired
    private RolRepository rolRepository;



    // Esto es pa incriptar CONSTRASEÑAS
    
    private final PasswordEncoder passwordEncoder;
    
    public UsuarioServiceImpl (UsuarioRepository usuarioRepository) {
    	this.usuarioRepository = usuarioRepository;
    	this.passwordEncoder = new BCryptPasswordEncoder();
    }

    //
    
    @Override
	public Usuario guardarUsuario(Usuario usuario) {
		Usuario usuarioLocal= usuarioRepository.findByUsername(usuario.getUsername());
        
        if(usuarioLocal!=null){
            System.out.println("El usuario ya existe");
        }else{

        	String encoderPassword = this.passwordEncoder.encode(usuario.getContrasenia());
            usuario.setContrasenia(encoderPassword);
        	usuarioLocal = usuarioRepository.save(usuario);

        }
        return usuarioLocal;
	}


    @Override
    public void eliminarUsuario(Long id_usuario){
        usuarioRepository.deleteById(id_usuario);
    }


	// LOGIN

	@Override
    public Usuario obtenerUsuario(String username) {
        // TODO Auto-generated method stub
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public Usuario obtenerContrasenia(String contrasenia) {
        // TODO Auto-generated method stub
        return usuarioRepository.findByContrasenia(contrasenia);
    }

    //


    @Override
    @Transactional(readOnly= true)
    public List<Persona> findAll() {
        // TODO Auto-generated method stub
        return (List<Persona>) personaRepository.findAll();
    }

    @Override
    public List<Usuario> findAllUsuario() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @Override
    public List<Usuario> findAllUsuarioDelaEmpresa(long id_empres) {
        return (List<Usuario>) usuarioRepository.findAllUsuarioDelaEmpresa(id_empres);
    }


    @Override
    public List<?> buscarPerson(String cedula) {
        return personaRepository.buscarPerson(cedula);
    }



}
