package ista.Backed20.api.service;


import ista.Backed20.api.entity.Rol;
import ista.Backed20.api.entity.Usuario;

import java.util.List;

public interface RolService {

	public Rol save(Rol rol);

    public List<Rol> findAll();

    public Rol findById(Long id);

    public Rol findByName(String name);

    public void delete(Long id);

    public List<Rol> findAllRolesDelaEmpresa(long id_empresa);

}
