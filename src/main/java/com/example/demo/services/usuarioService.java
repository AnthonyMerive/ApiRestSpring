package com.example.demo.services;

import com.example.demo.models.usuarioModel;
import com.example.demo.repositories.usuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class usuarioService {
    @Autowired
    usuarioRepository usuarioRepository;

    //metodo buscar usuario GET:
    public ArrayList<usuarioModel> obtenerUsuarios(){
        return (ArrayList<usuarioModel>) usuarioRepository.findAll();
    }

    //metodo guardar usuario POST:
    public usuarioModel guardarUsuario(usuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

}
