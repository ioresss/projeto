package domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@Table(name="funcionario")
@NoArgsConstructor 
@AllArgsConstructor
public class Funcionario {
	
	@Id
	@NotNull
	@Min(value=1)
	private Integer matricula;
	
	
	@Column(length = 50, nullable = false)
	@NotBlank(message="O campo nome é obrigatório")
	private String nome;
	
	@Column(length = 14, nullable = false)
	@NotBlank(message="O campo CPF é obrigatório")
	private String cpf;
	
	@Column(length = 14, nullable = false)
	@NotBlank(message="O campo telefone é obrigatório")
	private String telefone;
	
	
	
	
	
	
	
	
}
