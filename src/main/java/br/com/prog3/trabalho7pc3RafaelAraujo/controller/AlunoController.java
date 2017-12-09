package br.com.prog3.trabalho7pc3RafaelAraujo.controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import br.com.prog3.trabalho7pc3RafaelAraujo.model.Aluno;
import br.com.prog3.trabalho7pc3RafaelAraujo.persistence.AlunoDaoImp;

@ManagedBean
public class AlunoController {
	private Integer matricula;
	private String nome;
	private String ra;
	private Aluno aluno;
	private String mensagem;

	public void addAluno() {
		Aluno aluno = new Aluno();
		aluno.setMatricula(matricula);
		aluno.setNome(nome);
		aluno.setRa(ra);
		AlunoDaoImp ad = new AlunoDaoImp();
		setMensagem(ad.save(aluno));
		aluno = new Aluno();
	}

	public void editAluno() {
		Aluno aluno = new Aluno();
		aluno.setMatricula(matricula);
		aluno.setNome(nome);
		aluno.setRa(ra);
		AlunoDaoImp ad = new AlunoDaoImp();
		setMensagem(ad.update(aluno));
	}

	public void deleteAluno() {
		AlunoDaoImp ad = new AlunoDaoImp();
		setMensagem(ad.delete(matricula));
	}

	public List<Aluno> getAlunos() {
		AlunoDaoImp ad = new AlunoDaoImp();
		return ad.list();
	}

	public void findAluno() {
		AlunoDaoImp ad = new AlunoDaoImp();
		aluno =  ad.findByMatricula(matricula);
		if (aluno!=null){
			setMatricula(aluno.getMatricula());
			setNome(aluno.getNome());
			setRa(aluno.getRa());
		}
		else{
			setNome("Matrícula Inexistente");
			setRa("---------------------------");
		}
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
