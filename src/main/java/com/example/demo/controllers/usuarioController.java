package com.example.demo.controllers;

import com.example.demo.models.usuarioModel;
import com.example.demo.services.usuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
//donde se instanciara estos metodos
@RequestMapping("/usuario")
public class usuarioController {
    @Autowired
    usuarioService usuarioService;

    //mapeo del GET:
    @GetMapping()
    public ArrayList<usuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    //mapeo del POST:
    @PostMapping()
    public usuarioModel guardarUsuario(@RequestBody usuarioModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }

    //mapeo del FIND:
    @GetMapping(path = "/{id}")
    public Optional<usuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id){
        return this.usuarioService.obtenerPorId(id);
    }

    @GetMapping(path = "/query")
    public ArrayList<usuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.usuarioService.obtenerPorPrioridad(prioridad);
    }

    //mapeo DELETE:
    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if(ok){
            return "Se elimino el usuario con el ID: "+ id;
        }
        else {
            return "No existe el ID, no se pudo eliminar el usuario con ID: " + id;
        }
    }

}
