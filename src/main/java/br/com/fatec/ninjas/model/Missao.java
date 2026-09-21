package br.com.fatec.ninjas.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import  lombok.Data;

@Data
@Entity
@Table(name="missao")
@Valid
public class Missao {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO) // @GeneratedValue com AUTO indica que o BD é responsavel pelo o ID
    private Long id_missao; //Tipo long tem uma capacidade maior do que int

    @Column (name = "titulo_missao", nullable=false)
    @NotBlank(message="Título da missão é obrigatório")
    @Size(min=3, max=50, message = "Título deve conter entre 3 e 50 caracteres")
    private String titulo; //Private para proteger os dados

    @Column (name = "descricao_missao", nullable=false, unique=true)
    private String descricao;

    @Column (name = "rank_missao", nullable=false, unique=true)
    private String rank;

    @Column (name = "status_missao", nullable=false, unique=true)
    private String status;

    @Column (name = "recompensa_missao", nullable=false, unique=true)
    private String recompensa;
}
