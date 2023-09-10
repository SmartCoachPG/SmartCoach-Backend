package com.smartcoach.smartcoachBackend.Business.user.services;
import com.smartcoach.smartcoachBackend.Business.user.entities.Usuario;
import com.smartcoach.smartcoachBackend.Persistence.user.UsuarioRepository;
import com.smartcoach.smartcoachBackend.Security.AuthService;
import com.smartcoach.smartcoachBackend.Security.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AuthService authService;

    @Autowired
    private PasswordService passwordService;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario save(Usuario usuario) {
        String password = usuario.getContrasenna();
        usuario.setContrasenna(passwordService.encryptPassword(password));
        return usuarioRepository.save(usuario);
    }

    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }


    public Optional<Usuario> validarSesion(String email, String contrasenna) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(email);
        if (usuarioOpt.isPresent()){
            String hashPassword = usuarioOpt.get().getContrasenna();
            if (passwordService.checkPassword(contrasenna, hashPassword)) {
                Usuario usuario = usuarioOpt.get();
                String token = authService.getJWTToken(usuario.getEmail());
                usuario.setToken(token);
                return Optional.of(usuario);
            }
        }
        return Optional.empty();
    }


    @Transactional
    public void hashAllExistingPasswords() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        for (Usuario usuario : usuarios) {
            String plainPassword = usuario.getContrasenna();
            String hashedPassword = passwordService.encryptPassword(plainPassword);
            usuario.setContrasenna(hashedPassword);
        }
        usuarioRepository.saveAll(usuarios);
    }



}
