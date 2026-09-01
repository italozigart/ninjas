package br.com.fatec.ninjas.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import  lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Entity
@Table(name="ninja")
@Valid
public class Ninja {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO) // @GeneratedValue com AUTO indica que o BD é responsavel pelo o ID
    private Long id_ninja; //Tipo long tem uma capacidade maior do que int

    @Column (name = "nome_ninja", nullable=false)
    @NotBlank(message="Nome é obrigatório")
    @Size(min=3, max=50, message = "Nome deve conter entre 3 e 50 caracteres")
    private String nome; //Private para proteger os dados

    @Column (name = "cpf_ninja", nullable=false, unique=true)
    @CPF
    private String cpf;

    @Column (name = "email_ninja", nullable=false, unique=true)
    @Email
    private String email;
}
