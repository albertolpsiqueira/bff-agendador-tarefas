package com.javanauta.bffagendadortarefas.business.dto.out;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnderecoDTOResponse {

    private String rua;
    private Long numero;
    private String complemento;
    private String cidade;
    private String estado;
    private String cep;

}
