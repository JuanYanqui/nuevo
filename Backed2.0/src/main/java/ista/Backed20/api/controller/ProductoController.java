package ista.Backed20.api.controller;

import ista.Backed20.api.entity.Productos;
import ista.Backed20.api.service.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    private ProductoServiceImpl productoService;


    @GetMapping("/listarProductos")
    public ResponseEntity<List<Productos>> listarProductos(){
        return new ResponseEntity<>(productoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/listarProductosPorEmpresa/{id_empresa}")
    public ResponseEntity <List<Productos>> listarProductosPorEmpresa(@PathVariable("id_empresa") long id_empresa) {
        return ResponseEntity.ok().body(productoService.findAllProductosDelaEmpresa(id_empresa));
    }

    @PostMapping("/guardarProductos")
    public ResponseEntity <Productos> crearProductos(@RequestBody Productos productos) {
        return new ResponseEntity<>(productoService.save(productos), HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminarProductos/{id}")
    public ResponseEntity <?> eliminarProductos(@PathVariable long id) {
        productoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/actualizarProductos")
    public ResponseEntity<?> updateProductos(@RequestBody Productos productos) {
        productoService.actualizarProducto(productos);
        return new ResponseEntity<>((""), HttpStatus.CREATED);
    }
}
