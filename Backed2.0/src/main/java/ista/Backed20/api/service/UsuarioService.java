package ista.Backed20.api.service;

import ista.Backed20.api.entity.Persona;
import ista.Backed20.api.entity.Usuario;

import java.util.List;

public interface UsuarioService {

    public Usuario guardarUsuario(Usuario usuario);


    public Usuario obtenerUsuario(String username);

    public Usuario obtenerContrasenia(String contrasenia);
    public void eliminarUsuario(Long id_usuario);

    public List<Persona> findAll();

    public List<Usuario> findAllUsuario();


    // validar
    public List<Usuario> findAllUsuarioDelaEmpresa(long id_empres);

    List<?> buscarPerson(String cedula);




}
