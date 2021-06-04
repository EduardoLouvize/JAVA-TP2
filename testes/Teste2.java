package testes;

import java.util.Scanner;
import auxiliar.Constante;
import dominio.Aluno;
import dominio.Pessoa;
import dominio.Professor;

public class Teste2 {

	private static Pessoa[] pessoas;

	private static String opcao;
	private static Scanner in;

	private static int index;

	public static void main(String[] args) {

		in = new Scanner(System.in);

		pessoas = new Pessoa[Constante.QUANTIDADEALUNOS];

		captarETratarOpcao();

		in.close();
	}

	private static void exibirMenu() {

		System.out.println("---------------------------------");
		System.out.println("--Sistema de Controle Acadêmico--");
		System.out.println("---------------------------------");
		System.out.println("[1] Cadastrar professor.");
		System.out.println("[2] Cadastrar aluno.");
		System.out.println("[3] Consultar situação de um docente/discente.");
		System.out.println("[4] Consultar notas da turma.");
		System.out.println("[5] Sair.");

	}

	private static String captarETratarOpcao() {

		index = 0;

		do {
			exibirMenu();

			System.out.print("Informe a opção desejada: ");
			opcao = in.next();

			switch (opcao) {
			case "1":
				registrarProfessor(index);
				break;

			case "2":
				registrarNota(index);

				break;
			case "3":
				System.out.println("Informe o registro a ser consultado:");
				int registro = in.nextInt();
				if (registro >= 0 && registro < index) {
					System.out.println("..................................");
					System.out.println("----------------------------------");
					pessoas[registro].imprimir();
					System.out.println("----------------------------------");
					System.out.println("..................................");
				} else {
					System.out.println("Registro inexistente.");
				}
				break;
			case "4":
				System.out.println("..................................");
				System.out.println("----------------------------------");
				System.out.println("NOTAS DA TURMA.");
				System.out.println("----------------------------------");
				consultarNotasDaTurma();
				System.out.println("----------------------------------");
				System.out.println("..................................");
				break;
			case "5":
				System.out.println("...................");
				System.out.println("-------------------");
				System.out.println("Sistema finalizado.");
				System.out.println("-------------------");
				System.out.println("...................");
				break;
			default:
				System.out.println("..............");
				System.out.println("--------------");
				System.out.println("Opção inválida");
				System.out.println("--------------");
				System.out.println("..............");
				break;
			}
		} while (!opcao.equals("5"));

		return opcao;
	}
	
	private static void registrarProfessor(int idx) {

		Professor professor = new Professor();

		if (idx < Constante.QUANTIDADEALUNOS) {
			
			professor.setId(idx);

			System.out.println("Informe o nome do professor:");
			professor.setNome(in.next());

			System.out.println("Informe matéria:");
			professor.setMateria(in.next());

			System.out.println("Informe a quantidade de turmas do professor:");
			professor.setQuantTurmas(in.nextInt());
			
			professor.setDisponibilidade();

			pessoas[idx] = professor;

			System.out.println("Dados registrados:");
			pessoas[idx].imprimir();

			index++;

		} else {
			System.out.println("Não há espaço para novos registros.");
		}

	}

	private static void registrarNota(int idx) {

		Aluno aluno = new Aluno();

		if (idx < Constante.QUANTIDADEALUNOS) {
			
			aluno.setId(idx);

			System.out.println("Informe o nome do aluno:");
			aluno.setNome(in.next());

			System.out.println("Nota da avaliação 1:");
			aluno.setNotaAvaliacao1(validarNota());

			System.out.println("Nota da avaliação 2:");
			aluno.setNotaAvaliacao2(validarNota());
			
			aluno.setMediaFinal();
			
			aluno.setSituacao();

			pessoas[idx] = aluno;

			System.out.println("Dados registrados:");
			pessoas[idx].imprimir();

			index++;

		} else {
			System.out.println("Não há espaço para novos registros.");
		}

	}

	private static float validarNota() {

		float nota = in.nextFloat();

		while (nota < 0 || nota > 10) {

			System.out.println("Nota inválida.");
			nota = in.nextFloat();
		}

		return nota;
	}

	private static void consultarNotasDaTurma() {
		for (int i = 0; i < index; i++) {
			pessoas[i].imprimir();
		}
	}

}
