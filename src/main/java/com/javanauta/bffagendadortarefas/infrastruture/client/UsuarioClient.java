package com.javanauta.bffagendadortarefas.infrastruture.client;

import com.javanauta.bffagendadortarefas.business.dto.in.EnderecoDTORequest;
import com.javanauta.bffagendadortarefas.business.dto.in.TelefoneDTORequest;
import com.javanauta.bffagendadortarefas.business.dto.in.UsuarioDTORequest;
import com.javanauta.bffagendadortarefas.business.dto.out.EnderecoDTOResponse;
import com.javanauta.bffagendadortarefas.business.dto.out.TelefoneDTOResponse;
import com.javanauta.bffagendadortarefas.business.dto.out.UsuarioDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping
    UsuarioDTOResponse buscaUsuarioPorEmail(@RequestParam("email") String email, @RequestHeader(name = "Authorization", required = false) String token);

    @PostMapping
    UsuarioDTOResponse salvaUsuario(@RequestBody UsuarioDTORequest usuarioDTO) ;

    @PostMapping("/login")
    String login(@RequestBody UsuarioDTORequest usuarioDTO) ;

    @DeleteMapping("/{email}")
    void deletaUsuarioPorEmail(@PathVariable String email, @RequestHeader(name = "Authorization", required = false) String token);

    @PutMapping
    UsuarioDTOResponse atualizaDadosUsuariuo(@RequestBody UsuarioDTORequest dto, @RequestHeader(name = "Authorization", required = false) String token);

    @PutMapping("/endereço")
    EnderecoDTOResponse atualizaEndereco(@RequestBody EnderecoDTORequest dto, @RequestParam("id") Long id, @RequestHeader(name = "Authorization", required = false) String token) ;

    @PutMapping("/telefone")
    TelefoneDTOResponse atualizaTelefone(@RequestBody TelefoneDTORequest dto, @RequestParam("id") Long id, @RequestHeader(name = "Authorization", required = false) String token) ;

    @PostMapping("/endereco")
    EnderecoDTOResponse cadastraEndereco(@RequestBody EnderecoDTORequest dto, @RequestHeader(name = "Authorization", required = false) String token);

    @PostMapping("/telefone")
    TelefoneDTOResponse cadastraTelefone(@RequestBody TelefoneDTORequest dto, @RequestHeader(name = "Authorization", required = false) String token) ;

}
