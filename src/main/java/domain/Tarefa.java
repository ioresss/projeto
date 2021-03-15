package domain;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.validation.constraints.Future;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@Table(name="tarefa")
@NoArgsConstructor 
@AllArgsConstructor
public class Tarefa {
	
	@Id
	@SequenceGenerator(name="tarefa_idtarefa_seq",
	sequenceName="tarefa_idtarefa_seq",
	allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
	generator="tarefa_idtarefa_seq")
	@Column(name="id", columnDefinition = "serial", updatable = false) 
	private Integer codigo;
	
	@ManyToOne
	@JoinColumn(nullable=false)
	@NotNull(message = "O campo responsável é obrigatório!")
	private Funcionario responsavel;
	

	@Column(length = 50, nullable = false, unique = true)
	@NotBlank(message="O campo titulo é obrigatório")
	private String titulo;
	
	
	@Column(length = 144, nullable = false)
	@NotBlank(message="O campo descrição é obrigatório")
	private String descricao;
	
	@Column(length = 5, nullable = false)
	@NotBlank(message="O campo nome é obrigatório")
	private String prioridade;
	
	
	@Column
	@NotNull(message="O campo deadline é obrigatório")
	@Future(message ="O campo deadline deve ser uma data futura!")
	private LocalDate deadline;
	
	
}
