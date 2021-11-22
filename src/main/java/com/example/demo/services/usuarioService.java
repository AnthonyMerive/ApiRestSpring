package com.example.demo.services;

import com.example.demo.models.usuarioModel;
import com.example.demo.repositories.usuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

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

    //metodo busqueda usuario FIND:
    public Optional<usuarioModel> obtenerPorId(Long id){
        return usuarioRepository.findById(id);
    }

    public ArrayList<usuarioModel> obtenerPorPrioridad(Integer prioriodad){
        return usuarioRepository.findByPrioridad(prioriodad);
    }

    //metodo eliminar usuario DELETE:
    public boolean eliminarUsuario(Long id){
        try {
            usuarioRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

}
