package ista.Backed20.api.repository;


import ista.Backed20.api.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);

    Usuario findByContrasenia(String contrasenia);

    @Query(value = "SELECT * FROM usuario WHERE usuario.empresa_id_empresa = ?",
            nativeQuery = true
    )
    List<Usuario> findAllUsuarioDelaEmpresa(long id_empres);


}
