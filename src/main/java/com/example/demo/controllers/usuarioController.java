package com.example.demo.controllers;

import com.example.demo.models.usuarioModel;
import com.example.demo.services.usuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
}
