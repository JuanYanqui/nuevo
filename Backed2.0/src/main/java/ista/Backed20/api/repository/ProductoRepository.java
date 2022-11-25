package ista.Backed20.api.repository;

import ista.Backed20.api.entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Productos, Long> {
}
