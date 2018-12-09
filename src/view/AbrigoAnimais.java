package view;

import java.util.*;
import model.*;
import exception.*; 
import controller.AbrigoAnimaisController;

public class AbrigoAnimais {

    public static void main (String[] args) {
        
        /*VARIAVEIS*/
        int idade, opcao4, resulmenu1, resulmenu2=0,resulmenu3=0,resulmenuAnimais=0, resulmenuVoluntarios=0, indiceUsuarios=1,
        		id, indiceAnimais=0, tipo, resposta2=0,
        		resulmenuAdotantes=0,
        		menuAtualizarInfoVoluntarios, diasVoluntario [] = new int [6], horarioInicial, horarioFinal, //VOLUNTÁRIO
        		menuDoador=0, dataNascimento [] = new int [3], menuAttDoador, //DOADOR
        		menuDoacao=0,
        		retorno=0;
        String nome, cpf, telefone, login, senha, cep, rua, cidade, bairro, pais,email,
        		descricao, data_chegada, //ANIMAIS
        		endereco, data_doacao; //DOADOR
        	
        boolean result=false, eAdmin=false,
        		run=true, run2=true, run3=true, run4=true, run5=true, run6=true, runsystem=true; //CONTROLE NOS LOOPS DOS MENUS
 
        Scanner input = new java.util.Scanner(System.in);
        
        /*VARIAVEIS AUXILIARES*/
        int resposta;
        ArrayList<Animal> arrAnimais; // REFERENCIA PARA RECEBER
        ArrayList<Doacao> arrDoacoes;
        Doador [] arrDoadores; // REFERENCIA PARA RECEBER
        Adotante [] arrAdotantes;
        
        /*ARRAYS*/
        Usuario [] arrUsuarios;
        Voluntario [] arrVoluntarios;
        
        /*OBJETOS*/
        Animal animal;
        Adotante adotante=null;
        Voluntario voluntario=null;
        Doador doador=null;
        AbrigoAnimaisController controller = new AbrigoAnimaisController();
        Usuario usuarioAdmin=null;
        Usuario usuario;
        Doacao doacao;
        
        try {
        	usuarioAdmin = new Usuario ("admin", "admin", "juvitu", "12345678910", "40028922", true);
        	controller.cadastrarUsuario(usuarioAdmin);
        } catch (CPFInvalidoException e) {
        	System.out.println(e.getMessage());
        } catch (SenhaExcedidaException e) {
        	System.out.println(e.getMessage());
        } catch (LoginExcedidoException e) {
        	System.out.println(e.getMessage());
        } catch (CPFExistenteException e) {
        	System.out.println(e.getMessage());
        }
  
while(runsystem) {
	
	result=false;
	run=true;
	
	while (!result) {	
		   try {
		       System.out.println("------ ÁREA DE LOGIN ------");
		      /*VERIFICA O LOGIN E PEGA O OBJETO DO USUARIO*/
		      System.out.println("DIGITE O SEU LOGIN:");
		      login = input.next();
		      System.out.println("DIGITE A SUA SENHA:");
		      senha = input.next();
		      
		      usuarioAdmin = controller.buscarUsuario(login, senha);
		      if(usuarioAdmin!=null)
		    	  result=true;
		      
		   } catch(UsuarioNaoEncontradoException error){
	       	 System.out.println(error.getMessage());
		   } 
      }
    
      System.out.println("\n");
      
		if (usuarioAdmin.geteAdmin()) { //SE O USUARIO FOR ADMINISTRADOR
		    //MENU DO USUARIO ADMIN
			
			while (run) {
				
			
		    	System.out.println("------ ABRIGO DE ANIMAIS ------");
                System.out.println("DIGITE A OPCAO DESEJADA:");
                System.out.println("[1] - AREA DO USUARIO");
                System.out.println("[2] - AREA DO ANIMAL");
                System.out.println("[3] - AREA DO VOLUNTARIO");
                System.out.println("[4] - AREA DO ADOTANTE");
                System.out.println("[5] - AREA DO DOADOR");
                System.out.println("[6] - AREA DE DOACOES");
                System.out.println("[7] - SAIR");
                resulmenu1 = input.nextInt();
                
                resulmenu2=0;
                
                switch (resulmenu1) {
		                case 1: 
		                	while (resulmenu2!=6) {
			                    System.out.println("------ MENU DO USUARIO ------");
			                    System.out.println("[1] - REALIZAR CADASTRO");
			                    System.out.println("[2] - ATUALIZAR INFORMACOES PESSOAIS");
			                    System.out.println("[3] - ATUALIZAR LOGIN E SENHA");
			                    System.out.println("[4] - DESATIVAR CONTA");
			                    System.out.println("[5] - LISTAR TODOS OS USUÃ�RIOS");
			                    System.out.println("[6] - VOLTAR PRO MENU PRINCIPAL");
			                    resulmenu2=input.nextInt();
			                    
			                    switch (resulmenu2){ //MENU DO USUARIO
			                        case 1: //REALIZAR CADASTRO DO USUARIO
			                            System.out.println("DIGITE O NOME:");
			                            nome = input.next();
			                            System.out.println("DIGITE O CPF:");
			                            cpf = input.next();
			                            System.out.println("DIGITE O TELEFONE:");
			                            telefone = input.next();
			                            System.out.println("DIGITE O LOGIN:");
			                            login = input.next();
			                            System.out.println("DIGITE A SENHA:");
			                            senha = input.next();
			                            
			                            System.out.println("E ADMINISTRADOR?");
			                            System.out.println("[1] - SIM / [2] - NAO");
			                            int eAdminI = input.nextInt();
			                            
			                            if (eAdminI==1) {
			                            	eAdmin=true;
			                            } else if (eAdminI==2){
			                            	eAdmin=false;
			                            } else {
			                            	System.out.println("OPCAO INVALIDA");
			                            }
			                            
			                            
			                            try {
			                            	usuario = new Usuario (login, senha, nome, cpf, telefone, eAdmin);
				                            controller.cadastrarUsuario(usuario); 
			                            }catch (CPFInvalidoException e) {
			                            	System.out.println(e.getMessage());
			                            } catch (SenhaExcedidaException e) {
			                            	System.out.println(e.getMessage());
			                            } catch (LoginExcedidoException e) {
			                            	System.out.println(e.getMessage());
			                            } catch (CPFExistenteException e) {
			                            	System.out.println(e.getMessage());
				                        } 
			                           
			                        break;
			                        
			                        case 2: //ATUALIZAR INFORMACOES DO USUARIO
		                            	
		                                System.out.println("DIGITE QUAL INFORMACAO VOCE DESEJA ATUALIZAR:");
		                                System.out.println("[1] - NOME");
		                                System.out.println("[2] - CPF");
		                                System.out.println("[3] - TELEFONE");
		                                resulmenu3 = input.nextInt(); 
		                                
		                                switch(resulmenu3){
			                                case 1: //ATUALIZAR NOME
			                                	
			                                    System.out.println("DIGITE O SEU NOVO NOME:");
			                                    nome = input.next();
			                                    usuarioAdmin.setNome(nome);
			                                    
			                                    System.out.println("NOME ATUALIZADO COM SUCESSO");
			                                    break;
			                                    
			                                case 2: //ATUALIZAR CPF
			                                    System.out.println("DIGITE O SEU NOVO CPF:");
			                                    cpf = input.next();
			                                    
			                                    
			                                    try {
			                                    	usuarioAdmin.setCpf(cpf);
			                                    	System.out.println("CPF ATUALIZADO COM SUCESSO");
			                                    } catch (CPFInvalidoException error) {
			                                    	System.out.println(error.getMessage());
			                                    }
			                                    
			                                    break;
			                                    
			                                case 3: //ATUALIZAR TELEFONE
			                                    System.out.println("DIGITE O SEU NOVO TELEFONE:");
			                                    telefone = input.next();
			                                    usuarioAdmin.setTelefone(telefone);
			                                   
			                                    break;
			                                default:
			                                    break;
		                                } //FIM MENU ATUALIZAR INFORMACOES DO USUARIO 
		                                break;
		                                
			                       case 3: //ATUALIZAR LOGIN /SENHA
			                        	System.out.println("O QUE DESEJA ATUALIZAR:");
			                        	System.out.println("[1] - LOGIN / [2] - SENHA");
			                        	opcao4 = input.nextInt();
			                        	if (opcao4==1) {
			                        		System.out.println("DIGITE O SEU NOVO LOGIN:");
			                        		login = input.next();
			                        		try {
			                        			usuarioAdmin.atualizarLogin(login);
			                        			System.out.println("LOGIN ATUALIZADO!");
			                        		}catch(LoginExcedidoException e) {
			                        			System.out.println(e.getMessage());
			                        		}
			                        	} else if (opcao4==2) {
			                        		System.out.println("DIGITE A SUA NOVA SENHA:");
			                        		senha = input.next();
			                        		try {
			                        			usuarioAdmin.atualizarSenha(senha);
			                        			System.out.println("SENHA ATUALIZADA!");
			                        		}catch(SenhaExcedidaException e) {
			                        			System.out.println(e.getMessage());
			                        		}
			                        	} else {
			                        		System.out.println("Digite uma opcao valida");
			                        	}
			                        	break;
			                        	
			                     case 4: //DESATIVAR CONTA
			                    	 	
			                    	 	if(controller.desativarUsuario(usuarioAdmin.getCPF())==1) {
			                    	 		System.out.println("Usuário desativado!!");
			                    	 		resulmenu2=6;
			                    	 		run=false;
			                    	 	} else {
			                    	 		System.out.println("Usuário não foi desativado!!");
			                    	 	}
			                    	 	
			                        	break;
			                        	
			                      case 5: //LISTAR TODOS OS USUARIOS
			                    	  
			                    	  arrUsuarios = controller.buscarArrUsuarios();
			                    	  
			                    	  for (int i=0; i<arrUsuarios.length;i++) {
			                    	  		if(arrUsuarios[i]!=null) {
			                    	  			System.out.println("\n");
				                    	  		System.out.println("Nome: " + arrUsuarios[i].getNome());
				                    	  		System.out.println("CPF: " + arrUsuarios[i].getCPF());
				                    	  		System.out.println("Telefone: " + arrUsuarios[i].getTelefone());
				                    	  		System.out.println("\n");
			                    	  		}
			                    	  	}
			                    	  
			                        	break;
			                      case 6:
			                    	  resulmenu2=6;
			                    	  break;
			                      default:
			                    	  break;
			                    
			                   }//FIM DO SWITCH DO USUARIO
		                	} // FIM DO WHILE DO USUÁRIO
		                break;
		                
		                
		                case 2: //*** AREA DO ANIMAL ****
		                	while (resulmenuAnimais!=6) {
			                	System.out.println("----- AREA DO ANIMAL -----");
			                    System.out.println("[1] - REALIZAR NOVO CADASTRO");
			                    System.out.println("[2] - ATUALIZAR CADASTRO");
			                    System.out.println("[3] - LISTAR ANIMAIS DISPONIVEIS PARA ADOCAO");
			                    System.out.println("[4] - REALIZAR ADOCAO");
			                    System.out.println("[5] - BUSCA AVANCADA");
			                    System.out.println("[6] - VOLTAR PARA O MENU PRINCIPAL");
			                    
			                    resulmenuAnimais = input.nextInt();
			                    
			                    
			                    
			                    switch(resulmenuAnimais) {
			                    
				                    case 1: //REALIZAR NOVO CADASTRO
			                    		System.out.println("----- CADASTRANDO NOVO ANIMAL -----");
			                    		System.out.println("QUAL A ESPECIE?");
			                    		System.out.println("[1] - CACHORRO");
			                    		System.out.println("[2] - GATO");
			                    		tipo = input.nextInt();
			                    		
			                    		System.out.println("DIGITE O NOME: ");
			                    		nome = input.next();
			                    		
			                    		input.nextLine();
			                    		
			                    		System.out.println("DIGITE A IDADE: ");
			                    		idade = input.nextInt();
			                    		
			                    		input.nextLine();
			                    	
			                    		input = new Scanner(System.in);
			                    		System.out.println("DIGITE O NOME: ");
			                    		nome = input.nextLine();
			                    		System.out.println("DIGITE A IDADE: ");
			                    		idade = input.nextInt();
			                    		input = new Scanner(System.in);
			                    		System.out.println("ESCREVA UMA DESCRICAO: ");
			                    		descricao = input.nextLine();
			                    		System.out.println("INFORME A DATA DE ENTRADA: ");
			                    		data_chegada = input.nextLine();
			                    		
			                    		animal = new Animal(indiceAnimais, tipo, nome, idade, descricao, data_chegada);
			                    		indiceAnimais++;
			                    		
			                    		//CHAMANDO A FUNCAO QUE ADICIONA NO ARRAY
			                    		controller.cadastrarAnimal(animal);
			                    		
			                    		System.out.println("ANIMAL CADASTRADO COM SUCESSO!");
			                    		System.out.println("ID: "+animal.getidAnimal());
			                    		
			                    		input = new Scanner(System.in);
			                    		
			                    		break;
			                    		
			                    	case 2: //ATUALIZAR CADASTRO
			                    		
			                    		resposta = 0;
			                    		System.out.println("DIGITE O ID DO ANIMAL:");
			                    		id = input.nextInt();
				                    		
			                    		animal = null; //GARANTE QUE O OBJETO EH INICIALIZADO
			                    		
			                    		try {
			                    			animal = controller.buscarAnimalporID(id);
			                    			System.out.println("-----------------------------------");
			                    			System.out.println("Tipo: "+animal.getTipo());
			                    			System.out.println("ID: "+animal.getidAnimal());
			                    			System.out.println("Nome: "+animal.getNome());
			                    			System.out.println("Idade: "+animal.getIdade());
			                    			System.out.println("Data de Chegada: "+animal.getDataChegada());
		                    				System.out.println("Descricao: "+animal.getDescricao());
		                    				System.out.println("Castrado: "+animal.getCastrado());
		                    				System.out.println("Vermifugado: "+animal.getVermifugado());
		                    				System.out.println("Disponivel para adocao: "+animal.getDisponivelAdocao());
		                    				System.out.println("Adotado: "+animal.getAdotado());
		                    				System.out.println("-----------------------------------");
		                    				
		                    				while(resposta!=6) {
					                    		System.out.println("----- ATUALIZANDO INFORMACOES -----");
					                    		System.out.println("[1] - IDADE");
					                    		System.out.println("[2] - DESCRICAO");
					                    		System.out.println("[3] - CASTRADO");
					                    		System.out.println("[4] - VERMIFUGADO");
					                    		System.out.println("[5] - DISPONIBILIZAR PARA ADOCAO");
					                    		System.out.println("[6] - VOLTAR PARA O MENU");
					                    		System.out.println("ESCOLHA UMA OPCAO:");
					                    		resposta = input.nextInt();
					                    		
					                    		switch(resposta) { //MENU DE ATUALIZAR INFORMACOES DE ANIMAIS
					                    		
						                    		case 1: // ATUALIZAR IDADE
						                    			System.out.println("DIGITE A NOVA IDADE");
						                    			idade = input.nextInt();
						                    			animal.setIdade(idade);
						                    			break;
						                    			
						                    		case 2: //ATUALIZAR DESCRICAO
						                    			System.out.println("DIGITE A NOVA DESCRICAO");
						                    			input = new Scanner(System.in);
						                    			descricao = input.nextLine();
						                    			input = new Scanner(System.in);
						                    			animal.setDescricao(descricao);
						                    			break;
						                    			
						                    		case 3: //ATUALIZAR CASTRACAO
						                    			System.out.println("ANIMAL CASTRADO? [1]SIM [2]NAO");
						                    			resposta2 = input.nextInt();
						                    			if(resposta2==1) {
						                    				animal.setCastrado(true);
						                    			}else if (resposta2==2){
						                    				animal.setCastrado(false);
						                    			}else {
						                    				System.out.println("OPCAO INVALIDA!");
						                    			}
						                    			break;
						                    			
						                    		case 4: //ATUALIZAR VERMIFUGACAO
						                    			System.out.println("ANIMAL VERMIFUGADO? [1]SIM [2]NAO");
						                    			resposta2 = input.nextInt();
						                    			if(resposta2==1) {
						                    				animal.setVermifugado(true);
						                    			}else if(resposta2==2) {
						                    				animal.setVermifugado(false);
						                    			}else {
						                    				System.out.println("OPCAO INVALIDA!");
						                    			}
						                    			break;
						                    			
						                    		case 5: // DISPONIBILIZAR PARA ADOCAO
						                    			System.out.println("ANIMAL DISPONIVEL PARA ADOCAO?  [1]SIM [2]NAO");
						                    			resposta2 = input.nextInt();
						                    			if(resposta2==1) {
						                    				animal.setDisponivelParaAdocao(true);
						                    			}else if(resposta2==2) {
						                    				animal.setDisponivelParaAdocao(false);
						                    			}else {
						                    				System.out.println("OPCAO INVALIDA!");
						                    			}
						 
						                    			break;
					                    		
					                    		} // FIM DO SWITCH DE ATUALIZAR INFORMACAOES DE ANIMAIS
					                    		
			                    			}//FIM DO WHILE PARA ATUALIZAR INFORMACOES

			                    		}catch (AnimalNaoEncontradoException error) {
			                    			System.out.println(error.getMessage());
			                    		}
			                    		
			                    		break;
			                    		
			                    	case 3: //LISTAR ANIMAIS DISP. PARA ADOCAO POR FILTRO
			                    		tipo = 0;
			                    		while(tipo!=4) {
				                    		System.out.println("----- ANIMAIS DISPONIVEIS PARA ADOCAO -----");
				                    		System.out.println("FILTRAR POR: ");
				                    		System.out.println("[1] - CACHORRO");
				                    		System.out.println("[2] - GATO");
				                    		System.out.println("[3] - TODOS");
				                    		System.out.println("[4] - VOLTAR PARA O MENU");
				                    		tipo = input.nextInt();
				                    		
				                    		//EXCECAO PARA QUANDO A BUSCA NAO RETORNAR NADA
				                    		try {
				                    			arrAnimais = controller.listarAnimaisDiponiveis(tipo);
				                    			
				                    			//LACO PARA IMPRIMIR NA TELA
					                    		for(int i=0; i<arrAnimais.size(); i++) {
					                    			if(arrAnimais.get(i)!=null) {
					                    				System.out.println("-----------------------------------");
						                    			System.out.println("ID: "+arrAnimais.get(i).getidAnimal());
						                    			System.out.println("Nome: "+arrAnimais.get(i).getNome());
						                    			System.out.println("Idade: "+arrAnimais.get(i).getIdade());
						                    			System.out.println("Data de Chegada: "+arrAnimais.get(i).getDataChegada());
					                    				System.out.println("Descricao: "+arrAnimais.get(i).getDescricao());
					                    				System.out.println("Castrado: "+arrAnimais.get(i).getCastrado());
					                    				System.out.println("Vermifugado: "+arrAnimais.get(i).getVermifugado());
					                    				System.out.println("Disponivel para adocao: "+arrAnimais.get(i).getDisponivelAdocao());
					                    				System.out.println("Adotado: "+arrAnimais.get(i).getAdotado());
					                    				System.out.println("-----------------------------------");
					                    			}
					                    		}
				                    		}catch(AnimalNaoEncontradoException error) {
				                    			System.out.println(error.getMessage());
				                    		}
				                    		
			                    		}
				                    		
			                    		break;
			                    		
			                    	case 4: //REALIZAR ADOCAO
			                    		System.out.println("DIGITE O ID DO ANIMAL:");
			                    		id = input.nextInt();
			                    		
			                    		animal = null; //GARANTE QUE O OBJETO EH INICIALIZADO
			                    		
			                    		try {
			                    			animal = controller.buscarAnimalporID(id);
			                    			
			                    			System.out.println("------ "+animal.getNome()+" -----");
		                    				System.out.println("Idade: "+animal.getIdade());
		                    				System.out.println("Descricao: "+animal.getDescricao());
		                    				System.out.println("Castrado: "+animal.getCastrado());
		                    				System.out.println("Vermifugado: "+animal.getVermifugado());
		                    				System.out.println("---------------------------------------------");
		                    				
				                    		System.out.println("CONFIRMA ANIMAL? [1]SIM [2]NAO");
				                    		resposta = input.nextInt();
				                    		input = new Scanner(System.in);
				                    		
				                    		if(resposta==1) {
				                    		
				                    			System.out.println("INFORME O CPF DO ADOTANTE");
					                    		cpf = input.next();
				                    			
					                    		adotante = controller.buscarAdotante(cpf);
				                    		
					                    		//MARCA O ANIMAL COMO ADOTADO
					                    		animal.realizarAdocao("DATA ATUAL");
					                    		
					                    		//COLOCANDO O ANIMAL NO ARRAY DE ANIMAIS EM ADOTANTE
					                    		adotante.realizarAdocao(animal);
				                    		
				                    		}
				                    		
			                    		}catch (AnimalNaoEncontradoException error) {
			                    			System.out.println(error.getMessage());
			                    		}catch(CPFInvalidoException error) {
			                    			System.out.println(error.getMessage());
			                    		}catch (AdotanteNaoEncontradoException error) {
			                    			System.out.println(error.getMessage());
			                    		}
			                    		
			                    		break;
			                    		
			                    	case 5: //BUSCA AVANCADA
			                    		resposta = 0;
			                    		while(resposta!=8) {
			                    			System.out.println("----- BUSCA AVANCADA -----");
			                    			System.out.println("[1] - TIPO");
			                    			System.out.println("[2] - ANIMAIS CASTRADOS");
			                    			System.out.println("[3] - ANIMAIS NAO CASTRADOS");
			                    			System.out.println("[4] - ANIMAIS VERMIFUGADOS");
			                    			System.out.println("[5] - ANIMAIS NAO VERMIFUGADOS");
			                    			System.out.println("[6] - ANIMAIS ADOTADOS");
			                    			System.out.println("[7] - ANIMAIS NAO ADOTADOS");
			                    			System.out.println("[8] - VOLTAR PARA O MENU");
			                    			resposta = input.nextInt();
			                    			
			                    			switch(resposta) {
				                    			case 1: //BUSCA AVANCADA POR TIPO
					                    			System.out.println("[1] - CACHORRO");
						                    		System.out.println("[2] - GATO");
						                    		System.out.println("[3] - TODOS");
						                    		tipo = input.nextInt();
						                    		
						                    		
						                    		//EXCECAO PARA QUANDO A BUSCA NAO RETORNAR NADA
						                    		try {
						                    			
						                    			arrAnimais = controller.listarAnimaisPorTipo(tipo);
						                    			
						                    			//LACO PARA IMPRIMIR OS ANIMAIS ENCONTRADOS NA BUSCA 
						                    			for (int i=0; i<arrAnimais.size();i++) {
						                    				if(arrAnimais.get(i)!=null) {
						                    					System.out.println("-----------------------------------");
								                    			System.out.println("ID: "+arrAnimais.get(i).getidAnimal());
								                    			System.out.println("Nome: "+arrAnimais.get(i).getNome());
								                    			System.out.println("Idade: "+arrAnimais.get(i).getIdade());
								                    			System.out.println("Data de Chegada: "+arrAnimais.get(i).getDataChegada());
							                    				System.out.println("Descricao: "+arrAnimais.get(i).getDescricao());
							                    				System.out.println("Castrado: "+arrAnimais.get(i).getCastrado());
							                    				System.out.println("Vermifugado: "+arrAnimais.get(i).getVermifugado());
							                    				System.out.println("Disponivel para adocao: "+arrAnimais.get(i).getDisponivelAdocao());
							                    				System.out.println("Adotado: "+arrAnimais.get(i).getAdotado());
							                    				System.out.println("-----------------------------------");
						                    				}
						                    			}
						                    			
						                    		}catch(AnimalNaoEncontradoException error) {
						                    			System.out.println(error.getMessage());
						                    		}
						                    		
						                    		break;
						                    		
				                    			case 2: //BUSCA AVANCADA POR ANIMAIS CASTRADOS
				                    				
				                    				//EXCECAO PARA QUANDO A BUSCA NAO RETORNAR NADA
						                    		try {
						                    			
						                    			arrAnimais = controller.listarAnimaisCastrados();
						                    			
						                    			//LACO PARA IMPRIMIR OS ANIMAIS ENCONTRADOS NA BUSCA 
						                    			for (int i=0; i<arrAnimais.size();i++) {
						                    				if(arrAnimais.get(i)!=null) {
						                    					System.out.println("-----------------------------------");
								                    			System.out.println("ID: "+arrAnimais.get(i).getidAnimal());
								                    			System.out.println("Nome: "+arrAnimais.get(i).getNome());
								                    			System.out.println("Idade: "+arrAnimais.get(i).getIdade());
								                    			System.out.println("Data de Chegada: "+arrAnimais.get(i).getDataChegada());
							                    				System.out.println("Descricao: "+arrAnimais.get(i).getDescricao());
							                    				System.out.println("Castrado: "+arrAnimais.get(i).getCastrado());
							                    				System.out.println("Vermifugado: "+arrAnimais.get(i).getVermifugado());
							                    				System.out.println("Disponivel para adocao: "+arrAnimais.get(i).getDisponivelAdocao());
							                    				System.out.println("Adotado: "+arrAnimais.get(i).getAdotado());
							                    				System.out.println("-----------------------------------");
						                    				}
						                    			}
						                    			
						                    		}catch(AnimalNaoEncontradoException error) {
						                    			System.out.println(error.getMessage());
						                    		}
						                    		
						                    		break;
						                    		
				                    			case 3: //BUSCA AVANCADA POR ANIMAIS NAO CASTRADOS
				                    				
				                    				//EXCECAO PARA QUANDO A BUSCA NAO RETORNAR NADA
						                    		try {
						                    			
						                    			arrAnimais = controller.listarAnimaisNaoCastrados();
						                    			
						                    			//LACO PARA IMPRIMIR OS ANIMAIS ENCONTRADOS NA BUSCA 
						                    			for (int i=0; i<arrAnimais.size();i++) {
						                    				if(arrAnimais.get(i)!=null) {
						                    					System.out.println("-----------------------------------");
								                    			System.out.println("ID: "+arrAnimais.get(i).getidAnimal());
								                    			System.out.println("Nome: "+arrAnimais.get(i).getNome());
								                    			System.out.println("Idade: "+arrAnimais.get(i).getIdade());
								                    			System.out.println("Data de Chegada: "+arrAnimais.get(i).getDataChegada());
							                    				System.out.println("Descricao: "+arrAnimais.get(i).getDescricao());
							                    				System.out.println("Castrado: "+arrAnimais.get(i).getCastrado());
							                    				System.out.println("Vermifugado: "+arrAnimais.get(i).getVermifugado());
							                    				System.out.println("Disponivel para adocao: "+arrAnimais.get(i).getDisponivelAdocao());
							                    				System.out.println("Adotado: "+arrAnimais.get(i).getAdotado());
							                    				System.out.println("-----------------------------------");
						                    				}
						                    			}
						                    			
						                    		}catch(AnimalNaoEncontradoException error) {
						                    			System.out.println(error.getMessage());
						                    		}
				                    				
				                    				break;
				                    				
				                    			case 4: //BUSCA AVANCADA POR ANIMAIS VERMIFUGADOS
				                    				
				                    				//EXCECAO PARA QUANDO A BUSCA NAO RETORNAR NADA
						                    		try {
						                    			
						                    			arrAnimais = controller.listarAnimaisVermifugados();
						                    			
						                    			//LACO PARA IMPRIMIR OS ANIMAIS ENCONTRADOS NA BUSCA 
						                    			for (int i=0; i<arrAnimais.size();i++) {
						                    				if(arrAnimais.get(i)!=null) {
						                    					System.out.println("-----------------------------------");
								                    			System.out.println("ID: "+arrAnimais.get(i).getidAnimal());
								                    			System.out.println("Nome: "+arrAnimais.get(i).getNome());
								                    			System.out.println("Idade: "+arrAnimais.get(i).getIdade());
								                    			System.out.println("Data de Chegada: "+arrAnimais.get(i).getDataChegada());
							                    				System.out.println("Descricao: "+arrAnimais.get(i).getDescricao());
							                    				System.out.println("Castrado: "+arrAnimais.get(i).getCastrado());
							                    				System.out.println("Vermifugado: "+arrAnimais.get(i).getVermifugado());
							                    				System.out.println("Disponivel para adocao: "+arrAnimais.get(i).getDisponivelAdocao());
							                    				System.out.println("Adotado: "+arrAnimais.get(i).getAdotado());
							                    				System.out.println("-----------------------------------");
						                    				}
						                    			}
						                    			
						                    		}catch(AnimalNaoEncontradoException error) {
						                    			System.out.println(error.getMessage());
						                    		}
				                    				break;
				                    				
				                    			case 5: //BUSCA AVANCADA POR ANIMAIS NAO VERMIFUGADOS
				                    				
				                    				//EXCECAO PARA QUANDO A BUSCA NAO RETORNAR NADA
						                    		try {
						                    			
						                    			arrAnimais = controller.listarAnimaisNaoVermifugados();
						                    			
						                    			//LACO PARA IMPRIMIR OS ANIMAIS ENCONTRADOS NA BUSCA 
						                    			for (int i=0; i<arrAnimais.size();i++) {
						                    				if(arrAnimais.get(i)!=null) {
						                    					System.out.println("-----------------------------------");
								                    			System.out.println("ID: "+arrAnimais.get(i).getidAnimal());
								                    			System.out.println("Nome: "+arrAnimais.get(i).getNome());
								                    			System.out.println("Idade: "+arrAnimais.get(i).getIdade());
								                    			System.out.println("Data de Chegada: "+arrAnimais.get(i).getDataChegada());
							                    				System.out.println("Descricao: "+arrAnimais.get(i).getDescricao());
							                    				System.out.println("Castrado: "+arrAnimais.get(i).getCastrado());
							                    				System.out.println("Vermifugado: "+arrAnimais.get(i).getVermifugado());
							                    				System.out.println("Disponivel para adocao: "+arrAnimais.get(i).getDisponivelAdocao());
							                    				System.out.println("Adotado: "+arrAnimais.get(i).getAdotado());
							                    				System.out.println("-----------------------------------");
						                    				}
						                    			}
						                    			
						                    		}catch(AnimalNaoEncontradoException error) {
						                    			System.out.println(error.getMessage());
						                    		}
				                    				break;
				                    				
				                    			case 6: //BUSCA AVANCADA POR ANIMAIS ADOTADOS
				                    				
				                    				//EXCECAO PARA QUANDO A BUSCA NAO RETORNAR NADA
						                    		try {
						                    			
						                    			arrAnimais = controller.listarAnimaisAdotados();
						                    			
						                    			//LACO PARA IMPRIMIR OS ANIMAIS ENCONTRADOS NA BUSCA 
						                    			for (int i=0; i<arrAnimais.size();i++) {
						                    				if(arrAnimais.get(i)!=null) {
						                    					System.out.println("-----------------------------------");
								                    			System.out.println("ID: "+arrAnimais.get(i).getidAnimal());
								                    			System.out.println("Nome: "+arrAnimais.get(i).getNome());
								                    			System.out.println("Idade: "+arrAnimais.get(i).getIdade());
								                    			System.out.println("Data de Chegada: "+arrAnimais.get(i).getDataChegada());
							                    				System.out.println("Descricao: "+arrAnimais.get(i).getDescricao());
							                    				System.out.println("Castrado: "+arrAnimais.get(i).getCastrado());
							                    				System.out.println("Vermifugado: "+arrAnimais.get(i).getVermifugado());
							                    				System.out.println("Disponivel para adocao: "+arrAnimais.get(i).getDisponivelAdocao());
							                    				System.out.println("Adotado: "+arrAnimais.get(i).getAdotado());
							                    				System.out.println("-----------------------------------");
						                    				}
						                    			}
						                    			
						                    		}catch(AnimalNaoEncontradoException error) {
						                    			System.out.println(error.getMessage());
						                    		}
				                    				break;
				                    				
				                    			case 7: //BUSCA AVANCADA POR ANIMAIS NAO ADOTADOS
				                    				
				                    				//EXCECAO PARA QUANDO A BUSCA NAO RETORNAR NADA
						                    		try {
						                    			
						                    			arrAnimais = controller.listarAnimaisNaoAdotados();
						                    			
						                    			//LACO PARA IMPRIMIR OS ANIMAIS ENCONTRADOS NA BUSCA 
						                    			for (int i=0; i<arrAnimais.size();i++) {
						                    				if(arrAnimais.get(i)!=null) {
						                    					System.out.println("-----------------------------------");
								                    			System.out.println("ID: "+arrAnimais.get(i).getidAnimal());
								                    			System.out.println("Nome: "+arrAnimais.get(i).getNome());
								                    			System.out.println("Idade: "+arrAnimais.get(i).getIdade());
								                    			System.out.println("Data de Chegada: "+arrAnimais.get(i).getDataChegada());
							                    				System.out.println("Descricao: "+arrAnimais.get(i).getDescricao());
							                    				System.out.println("Castrado: "+arrAnimais.get(i).getCastrado());
							                    				System.out.println("Vermifugado: "+arrAnimais.get(i).getVermifugado());
							                    				System.out.println("Disponivel para adocao: "+arrAnimais.get(i).getDisponivelAdocao());
							                    				System.out.println("Adotado: "+arrAnimais.get(i).getAdotado());
							                    				System.out.println("-----------------------------------");
						                    				}
						                    			}
						                    			
						                    		}catch(AnimalNaoEncontradoException error) {
						                    			System.out.println(error.getMessage());
						                    		}
				                    				break;
				                    				
						                    		
			                    			} //FIM DO SWITCH DO MENU DE BUSCA AVANCADA DO MENU DE ANIMAL
			                    			
			                    		}// FIM DO WHILE DO MENU DA BUSCA AVANCADA
			                    		
			                    		break;
			                    		
			                    	case 6:
			                    		resulmenuAnimais=6;
			                    		break;
			                    		
			                    	default:
			                    		break;
			                    		
			                    } //FIM DO SWITCH DO MENU DE ANIMAL
			                    
		                	}//FIM DO WHILE DO MENU DE ANIMAL
		                	
		                break;
		                
		                
		                case 3: //MENU DO VOLUNTÁRIO
		                		while (resulmenuVoluntarios!=8) {
			                	    System.out.println("------ MENU DO VOLUNTÁRIO ------");
				                    System.out.println("[1] - CADASTRO");
				                    System.out.println("[2] - ATUALIZAR INFORMACOES PESSOAIS");
				                    System.out.println("[3] - ATUALIZAR DIAS DE VISITA");
				                    System.out.println("[4] - ATUALIZAR HORÁRIO DE VISITA");
				                    System.out.println("[5] - BUSCAR VOLUNTÁRIO");
				                    System.out.println("[6] - LISTAR VOLUNTÁRIOS");
				                    System.out.println("[7] - DESVINCULAR CADASTRO");
				                    System.out.println("[8] - SAIR");
				                    resulmenuVoluntarios = input.nextInt();
				                    
				                    System.out.println("\n");
				                    
				                    switch (resulmenuVoluntarios) {
				                    
				                    	case 1:
				                    		System.out.println("NOME:");
				                    		nome = input.next();
				                    		
				                    		System.out.println("CPF:");
				                    		cpf = input.next();
				                    		System.out.println("DIA DE NASCIMENTO:");
				                			dataNascimento[0]=input.nextInt();
				                			System.out.println("MES DE NASCIMENTO:");
				                			dataNascimento[1]=input.nextInt();
				                			System.out.println("ANO DE NASCIMENTO:");
				                			dataNascimento[2]=input.nextInt();
				                    		System.out.println("TELEFONE:");
				                    		telefone = input.next();
				                    		System.out.println("DIAS DE VISITA:");
				                    		System.out.println("[1] SIM / [2] NÃO");
				                    		
				                    		System.out.println("SEGUNDA");
				                    		diasVoluntario [0] = input.nextInt();
				                    		
				                    		System.out.println("TERÇA");
				                    		diasVoluntario [1] = input.nextInt();
				                    		
				                    		System.out.println("QUARTA");
				                    		diasVoluntario [2] = input.nextInt();
				                    		
				                    		System.out.println("QUINTA");
				                    		diasVoluntario [3] = input.nextInt();
				                    		
				                    		System.out.println("SEXTA");
				                    		diasVoluntario [4] = input.nextInt();
				                    		
				                    		System.out.println("SÁBADO");
				                    		diasVoluntario [5] = input.nextInt();
				                    		
//				                    		System.out.println("**** Lembrando que são funcionamos de 8h as 20h ****");
				                    		System.out.println("HORÁRIO DE ENTRADA:");
				                    		horarioInicial = input.nextInt();
				                    		System.out.println("HORÁRIO DE SAÍDA:");
				                    		horarioFinal = input.nextInt();
				                    		
				                    		
				                    		try{
				                    			controller.verificarCPFVoluntario(cpf);
				                    			voluntario = new Voluntario(nome, cpf, dataNascimento, telefone, diasVoluntario, horarioInicial, horarioFinal);
				                    			controller.cadastrarVoluntario(voluntario);
				                    			System.out.println("USUÁRIO CADASTRADO COM SUCESSO!");
				                    			System.out.println("\n");
				                    		} catch (CPFInvalidoException error) {
				                    			System.out.println(error.getMessage());
				                    		} catch (TelefoneInvalidoException error) {
				                    			System.out.println(error.getMessage());
				                    		} catch (IdadeMaximaAtingidaException error) {
				                    			System.out.println(error.getMessage());
				                    		} catch (HorarioExcedidoException error) {
				                    			System.out.println(error.getMessage());
				                    		} catch (CPFExistenteException error) {
				                    			System.out.println(error.getMessage());
				                    		}catch (MesInvalidoException error) {
				                    			System.out.println(error.getMessage());
				                    		}
				                    		
				                    		break;
				                    		
				                    	case 2:
				                    		System.out.println("DIGITE O CPF DO USUÁRIO:");
				                    		cpf = input.next();
				                    		
				                    		try {
				                    			voluntario = controller.buscarVoluntario(cpf);
				                    		} catch (VoluntarioNaoEncontradoException error) {
				                    			System.out.println(error.getMessage());
				                    			break;
				                    		}
				                    		
				                    		if (voluntario!=null) {
				                    			System.out.println("[1] - NOME");
				                    			System.out.println("[2] - CPF");
				                    			System.out.println("[3] - TELEFONE");
				                    			menuAtualizarInfoVoluntarios = input.nextInt();
				                    			
				                    			switch (menuAtualizarInfoVoluntarios) {
					                    			case 1: 
					                    				
					                    				System.out.println("DIGITE O NOVO NOME:");
					                    				nome = input.next();
					                    				voluntario.setNome(nome);
					                    				break;
					                    				
					                    			case 2:
					                    				System.out.println("DIGITE O NOVO CPF");
					                    				cpf = input.next();
					                    				
					                    				try {
					                    					voluntario.setCpf(cpf);
					                    				} catch (CPFInvalidoException error) {
					                    					System.out.println(error.getMessage());
					                    				}
					                    				
					                    				break;
					                    			case 3:
					                    				
					                    				System.out.println("DIGITE O NOVO TELEFONE:");
					                    				telefone = input.next();
				                    				
					                    				try {
					                    					voluntario.setTelefone(telefone);
					                    				} catch (TelefoneInvalidoException error) {
					                    					System.out.println(error.getMessage());
					                    				}
					                    				
					                    				break;
					                    				
					                    			default:
					                    				break;
				                    				}
				                    		} 
				                    		break;
				                    	case 3:
				                    		diasVoluntario = new int [6];
				                    		
				                    		System.out.println("DIGITE O CPF DO USUÁRIO:");
				                    		cpf = input.next();
				                    		
				                    		try {
				                    			voluntario=controller.buscarVoluntario(cpf);
				                    			System.out.println("DIAS DE VISITA:");
					                    		System.out.println("[1] SIM / [2] NÃO");
					                    		
					                    		System.out.println("SEGUNDA");
					                    		diasVoluntario [0] = input.nextInt();
					                    		
					                    		System.out.println("TERÇA");
					                    		diasVoluntario [1] = input.nextInt();
					                    		
					                    		System.out.println("QUARTA");
					                    		diasVoluntario [2] = input.nextInt();
					                    		
					                    		System.out.println("QUINTA");
					                    		diasVoluntario [3] = input.nextInt();
					                    		
					                    		System.out.println("SEXTA");
					                    		diasVoluntario [4] = input.nextInt();
					                    		
					                    		System.out.println("SÁBADO");
					                    		diasVoluntario [5] = input.nextInt();
					                    		
					                    		voluntario.setDias(diasVoluntario);
				                    		} catch (VoluntarioNaoEncontradoException error) {
				                    			System.out.println(error.getMessage());
				                    		}
				                    		
				                    		break;
				                    		
				                    	case 4:
				                    		
				                    		System.out.println("DIGITE O CPF DO USUÁRIO:");
				                    		cpf = input.next();
				                    		
				                    		try {
				                    			voluntario=controller.buscarVoluntario(cpf);
				                    		} catch (VoluntarioNaoEncontradoException error) {
				                    			System.out.println(error.getMessage());
				                    		}
				                    		
				                    		if (voluntario!=null) {
					                    		System.out.println("HORÁRIO DE ENTRADA:");
					                    		horarioInicial = input.nextInt();
					                    		System.out.println("HORÁRIO DE SAÍDA:");
					                    		horarioFinal = input.nextInt();
				                    		
					                    		try {
					                    			voluntario.setHorarioInicial(horarioInicial);
					                    			voluntario.setHorarioFinal(horarioFinal);
					                    		} catch (HorarioExcedidoException error) {
					                    			System.out.println(error.getMessage());
					                    		}
				                    		} 
				                    		
				                    		break;
				                    		
				                    	case 5:
				                    		System.out.println("DIGITE O CPF DO VOLUNTÁRIO:");
				                			cpf=input.next();
				                			
				                			System.out.println("\n");
				                			
				                			try {
				                				voluntario = controller.buscarVoluntario(cpf);
					                			System.out.println("NOME:" + voluntario.getNome());
					                			dataNascimento=voluntario.getDataNascimento();
					                			System.out.println("DATA DE NASCIMENTO:" + dataNascimento[0] + "/" + dataNascimento[1] + "/" + dataNascimento [2]);
					                			System.out.println("CPF:" + voluntario.getCpf());
					                			System.out.println("TELEFONE:" + voluntario.getTelefone());
					                			diasVoluntario = voluntario.getDiasVoluntario();
					                			System.out.println("DIAS:");
					                			if (diasVoluntario[0]==1) 
					                				System.out.println("SEGUNDA");
					                			if (diasVoluntario[1]==1) 
					                				System.out.println("TERÇA");
					                			if (diasVoluntario[2]==1) 
					                				System.out.println("QUARTA");
					                			if (diasVoluntario[3]==1) 
					                				System.out.println("QUINTA");
					                			if (diasVoluntario[4]==1) 
					                				System.out.println("SEXTA");
					                			if (diasVoluntario[5]==1) 
					                				System.out.println("SABÁDO");
					                			
					                			System.out.println("HORÁRIO: " + voluntario.getHorarioInicial() + " às " + voluntario.getHorarioFinal());
					                		
					                			System.out.println("\n");
				                			} catch (VoluntarioNaoEncontradoException error) {
				                				System.out.println(error.getMessage());
				                			}
				                			
				                			break;
				                    	case 6:
				                    		
				                    		arrVoluntarios=controller.buscarArrVoluntarios();
				                    		for (int i=0; i<arrVoluntarios.length;i++) {
				                    			if (arrVoluntarios[i]!=null) {
					                    			System.out.println("NOME:" + arrVoluntarios[i].getNome());
						                			dataNascimento=arrVoluntarios[i].getDataNascimento();
						                			System.out.println("DATA DE NASCIMENTO:" + dataNascimento[0] + "/" + dataNascimento[1] + "/" + dataNascimento [2]);
						                			System.out.println("CPF:" + arrVoluntarios[i].getCpf());
						                			System.out.println("TELEFONE:" + arrVoluntarios[i].getTelefone());
						                			
						                			diasVoluntario = arrVoluntarios[i].getDiasVoluntario();
						                			System.out.println("DIAS:");
						                			if (diasVoluntario[0]==1) 
						                				System.out.println("SEGUNDA");
						                			if (diasVoluntario[1]==1) 
						                				System.out.println("TERÇA");
						                			if (diasVoluntario[2]==1) 
						                				System.out.println("QUARTA");
						                			if (diasVoluntario[3]==1) 
						                				System.out.println("QUINTA");
						                			if (diasVoluntario[4]==1) 
						                				System.out.println("SEXTA");
						                			if (diasVoluntario[5]==1) 
						                				System.out.println("SABÁDO");
						                			
						                			System.out.println("HORÁRIO: " + arrVoluntarios[i].getHorarioInicial() + " às " + arrVoluntarios[i].getHorarioFinal());
						                			
						                			System.out.println("\n");
				                    			}
				                    		}
				                    		break;
				                    	case 7:
				                    		System.out.println("DIGITE O CPF DO VOLUNTÁRIO A SER DESVINCULADO DO NOSSO ABRIGO:");
				                			cpf=input.next();
				                			if (controller.desvincularVoluntario(cpf)==1) {
				                				System.out.println("VOLUNTÁRIO DESVINCULADO!!");
				                			} else {
				                				System.out.println("VOLUNTÁRIO NÃO FOI DESVINCULADO, POR FAVOR VERIFIQUE O CPF E DIGITE UM EXISTENTE NO SISTEMA!!");
				                			}
				                			
				                			break;
				                    	case 8:
				                    		resulmenuVoluntarios=8;
				                    		break;
				                    	default:
				                    		break;
				                    }
		                		} //FIM DO WHILE DO MENU DE VOLUNTÁRIOS
			                	break;
		                	
		                
		                case 4: //MENU DO ADOTANTE
		                	while(resulmenuAdotantes!=6) {
			                	System.out.println("----- AREA DO ADOTANTE -----");
			                    System.out.println("[1] - REALIZAR NOVO CADASTRO");
			                    System.out.println("[2] - BUSCAR CADASTRO POR CPF");
			                    System.out.println("[3] - REMOVER CADASTRO");
			                    System.out.println("[4] - LISTAR ADOTANTES CADASTRADOS");
			                    System.out.println("[5] - LISTAR ANIMAIS ADOTADOS");
			                    System.out.println("[6] - VOLTAR PARA O MENU PRINCIPAL");
			                    
			                    resulmenuAdotantes = input.nextInt();
			                    
			                    input = new Scanner(System.in);
			                    
			                    switch(resulmenuAdotantes) {
			                    	case 1: //REALIZAR NOVO CADASTRO
			                    		System.out.println("----- INFORMACOES BASICAS -----");
			                    		System.out.println("NOME");
			                    		nome = input.nextLine();
			                    		System.out.println("DIA DE NASCIMENTO:");
			                			dataNascimento[0]=input.nextInt();
			                			input = new Scanner(System.in);
			                			System.out.println("MES DE NASCIMENTO:");
			                			dataNascimento[1]=input.nextInt();
			                			System.out.println("ANO DE NASCIMENTO:");
			                			dataNascimento[2]=input.nextInt();
			                			input = new Scanner(System.in);
			                			System.out.println("CPF:");
			                			cpf = input.nextLine();
			                			input = new Scanner(System.in);
			                			System.out.println("----- ENDERECO -----");
			                			System.out.println("CEP:");
			                			cep = input.nextLine();
			                			System.out.println("RUA:");
			                    		rua = input.nextLine();
			                    		System.out.println("CIDADE:");
			                    		cidade = input.nextLine();
			                    		System.out.println("BAIRRO:");
			                    		bairro = input.nextLine();
			                    		System.out.println("PAIS:");
			                    		pais = input.nextLine();
			                			System.out.println("----- INFORMACOES DE CONTATO -----");
			                    		System.out.println("EMAIL:");
			                    		email = input.nextLine();
			                    		System.out.println("TELEFONE:");
			                    		telefone = input.nextLine();
			                    		
			                    		try {
			                    			adotante = new Adotante(nome, dataNascimento, cpf, email, telefone, rua, cidade, bairro, cep, pais);
			                    			//COLOCAR O ADOTANTE NO ARRAY
				                    		controller.cadastrarAdotante(adotante);
			                    		}catch(CPFInvalidoException error) {
			                    			System.out.println(error.getMessage());
			                    		}
			                    		
			                    		break;
			                    		
			                    	case 2: //BUSCAR CADASTRO POR CPF
			                    		System.out.println("DIGITE O CPF:");
			                    		cpf = input.next();
			                    		input = new Scanner(System.in);
			                    		
			                    		try {
			                    			adotante = controller.buscarAdotante(cpf);
			                    			
			                    			//IMPRIMINDO INFORMACOES SOBRE O ADOTANTE
			                    			System.out.println("---------------------------------------------");
			                    			System.out.println("Nome: "+adotante.getNome());
		                    				System.out.println("CPF: "+adotante.getCpf());
		                    				System.out.println("Data de Nascimento: "+adotante.getDataNascimento());
		                    				System.out.println("Email: "+adotante.getEmail());
		                    				System.out.println("Telefone: "+adotante.getTelefone());
		                    				System.out.println("----- ENDERECO -----");
		                    				System.out.println("CEP: "+adotante.getCEP());
		                    				System.out.println("Rua: "+adotante.getRua());
		                    				System.out.println("Bairro: "+adotante.getBairro());
		                    				System.out.println("Cidade: "+adotante.getCidade());
		                    				System.out.println("---------------------------------------------");

			                    		}catch(CPFInvalidoException error) {
			                    			System.out.println(error.getMessage());
			                    		}catch(AdotanteNaoEncontradoException error) {
			                    			System.out.println(error.getMessage());
			                    		}
			                    		
			                    					                    		
			                    		break;
			                    		
			                    	case 3: //REMOVER CADASTRO
			                    		System.out.println("DIGITE O CPF:");
			                    		cpf = input.next();
			                    		input = new Scanner(System.in);
			                    		
			                    		try {
			                    			adotante = controller.buscarAdotante(cpf);
			                    			controller.removerAdotante(cpf);
			                    		}catch(CPFInvalidoException error) {
			                    			System.out.println(error.getMessage());
			                    		}catch(AdotanteNaoEncontradoException error) {
			                    			System.out.println(error.getMessage());
			                    		}

			                    		break;
			                    		
			                    	case 4: //LISTAR ADOTANTES CADASTRADOS
			                    		arrAdotantes = controller.listarAdotantes();
			                    		
			                    		for(int i=0; i<arrAdotantes.length; i++) {
			                    			if(arrAdotantes[i]!=null) {
				                    			System.out.println("------ "+arrAdotantes[i].getNome()+" -----");
			                    				System.out.println("CPF: "+arrAdotantes[i].getCpf());
			                    				System.out.println("Data de Nascimento: "+arrAdotantes[i].getDataNascimento());
			                    				System.out.println("Email: "+arrAdotantes[i].getEmail());
			                    				System.out.println("Telefone: "+arrAdotantes[i].getTelefone());
			                    				System.out.println("----- ENDERECO -----");
			                    				System.out.println("CEP: "+arrAdotantes[i].getCEP());
			                    				System.out.println("Rua: "+arrAdotantes[i].getRua());
			                    				System.out.println("Bairro: "+arrAdotantes[i].getBairro());
			                    				System.out.println("Cidade: "+arrAdotantes[i].getCidade());
			                    				System.out.println("---------------------------------------------");
			                    			}
			                    		}
			                    		
			                    		break;
			                    		
			                    	case 5: //LISTAR ANIMAIS ADOTADOS
			                    		System.out.println("DIGITE O CPF:");
			                    		cpf = input.next();
			                    		input = new Scanner(System.in);
			                    		
			                    		try {
			                    			adotante = controller.buscarAdotante(cpf);
			                    			arrAnimais = controller.listarAnimaisAdotadosPorAdotante(cpf);
			                    			
			                    			//LACO PARA IMPRIMIR OS ANIMAIS ENCONTRADOS NA BUSCA 
			                    			for (int i=0; i<arrAnimais.size();i++) {
			                    				if(arrAnimais.get(i)!=null) {
			                    					System.out.println("-----------------------------------");
					                    			System.out.println("ID: "+arrAnimais.get(i).getidAnimal());
					                    			System.out.println("Nome: "+arrAnimais.get(i).getNome());
					                    			System.out.println("Idade: "+arrAnimais.get(i).getIdade());
					                    			System.out.println("Data de Chegada: "+arrAnimais.get(i).getDataChegada());
				                    				System.out.println("Descricao: "+arrAnimais.get(i).getDescricao());
				                    				System.out.println("Castrado: "+arrAnimais.get(i).getCastrado());
				                    				System.out.println("Vermifugado: "+arrAnimais.get(i).getVermifugado());
				                    				System.out.println("Disponivel para adocao: "+arrAnimais.get(i).getDisponivelAdocao());
				                    				System.out.println("Adotado: "+arrAnimais.get(i).getAdotado());
				                    				System.out.println("-----------------------------------");
			                    				}
			                    			}
			                    		}catch(CPFInvalidoException error) {
			                    			System.out.println(error.getMessage());
			                    		}catch(AdotanteNaoEncontradoException error) {
			                    			System.out.println(error.getMessage());
			                    		}catch(AnimalNaoEncontradoException error) {
			                    			System.out.println(error.getMessage());
			                    		}
			                    		
			                    		break;
			                    		
			                    } //FIM DO SWITCH DO MENU DE ADOTANTES
			                    
		                	} // FIM DO WHILE DO MENU DE ADOTANTES
		                	break;
		                	
		                	
		                case 5: //MENU DO DOADOR
		                	while (menuDoador!=6) {
			                	System.out.println("------ BEM-VINDO AO MENU DO DOADOR ------");
			                	System.out.println("[1] - CADASTRO");
			                	System.out.println("[2] - ATUALIZAR");
			                	System.out.println("[3] - TIRAR VINCULO");
			                	System.out.println("[4] - BUSCAR DOADOR");
			                	System.out.println("[5] - LISTAR DOADORES");
			                	System.out.println("[6] - SAIR");
			                	menuDoador=input.nextInt();
			                	
			                	switch (menuDoador) {
			                		case 1:
			                			System.out.println("NOME:");
			                			nome=input.next();
			                			
			                			System.out.println("DIA DE NASCIMENTO:");
			                			dataNascimento[0]=input.nextInt();
			                			System.out.println("MES DE NASCIMENTO:");
			                			dataNascimento[1]=input.nextInt();
			                			System.out.println("ANO DE NASCIMENTO:");
			                			dataNascimento[2]=input.nextInt();
			                			System.out.println("CPF:");
			                			cpf=input.next();
			                			System.out.println("TELEFONE:");
			                			telefone = input.next();
			                			
			                			System.out.println("ENDEREÇO:");
			                			endereco=input.next();
			                			
			                			try {
			                				controller.verificarCPFDoador(cpf);
			                				doador = new Doador (nome, dataNascimento, cpf, telefone, endereco);
			                				controller.cadastrarDoador(doador);
			                				System.out.println("DOADOR CADASTRADO!!");
			                			} catch (CPFExistenteException error) {
			                				System.out.println(error.getMessage());
			                			} catch(IdadeMaximaAtingidaException error) {
			                				System.out.println(error.getMessage());
			                			} catch (CPFInvalidoException error) {
			                				System.out.println(error.getMessage());
			                			} catch (TelefoneInvalidoException error) {
			                				System.out.println(error.getMessage());
			                			}
			                			
			                			System.out.println("\n");
			                			
			                			break;
			                		case 2:
			                			
			                			System.out.println("DIGITE O CPF DO DOADOR A SER ATUALIZADO:");
			                			cpf=input.next();
			                			
			                			try { 
		                					doador.setCpf(cpf);
		                					System.out.println("CPF ATUALIZADO!!");
		                				}catch(CPFInvalidoException error) {
		                					System.out.println(error.getMessage());
		                				}
			                			
			                			System.out.println("[1] - NOME");
			                			System.out.println("[2] - CPF");
			                			System.out.println("[3] - TELEFONE");
			                			System.out.println("[4] - ENDEREÇO");
			                			menuAttDoador=input.nextInt();
			                			
			                			switch (menuAttDoador) {
				                			case 1:
				                				System.out.println("DIGITE O NOVO NOME:");
				                				nome=input.next();
				                				doador.setNome(nome);
				                				System.out.println("NOME ATUALIZADO!!");
				                				input = new Scanner(System.in);
				                				break;
				                			case 2:
				                				System.out.println("DIGITE O NOVO CPF:");
				                				cpf=input.next();
				                				
				                				input = new Scanner(System.in);
				                				break;
				                			case 3:
				                				System.out.println("DIGITE O NOVO TELEFONE:");
				                				telefone=input.next();
				                				try { 
				                					doador.setTelefone(telefone);
				                					System.out.println("TELEFONE ATUALIZADO!!");
				                				}catch(TelefoneInvalidoException error) {
				                					System.out.println(error.getMessage());
				                				}
				                				input = new Scanner(System.in);
				                				break;
				                			case 4:
				                				System.out.println("DIGITE O NOVO ENDEREÇO:");
				                				endereco=input.next();
				                				doador.setEndereco(endereco);
				                				System.out.println("TELEFONE ATUALIZADO!!");
				                				
				                				input = new Scanner(System.in);
				                				break;
				                			default:
				                				break;
			                			}
			                			break;
			                		case 3:
			                			System.out.println("DIGITE O CPF DO DOADOR A SER DESVINCULADO DO NOSSO ABRIGO:");
			                			cpf=input.next();
			                			if (controller.desvincularDoador(cpf)==1) {
			                				System.out.println("DOADOR DESVINCULADO!!");
			                			} else {
			                				System.out.println("DOADOR NÃO FOI DESVINCULADO, POR FAVOR VERIFIQUE O CPF E DIGITE UM EXISTENTE NO SISTEMA!!");
			                			}
			                			
			                			break;
			                		case 4:
			                			System.out.println("DIGITE O CPF DO DOADOR:");
			                			cpf=input.next();
			                			
			                			try {
			                				doador = controller.buscarDoador(cpf);
				                			System.out.println("NOME: " + doador.getNome());
				                			dataNascimento=doador.getDataNascimento();
				                			System.out.println("DATA DE NASCIMENTO: " + dataNascimento[0] + "/" + dataNascimento[1] + "/" + dataNascimento [2]);
				                			System.out.println("CPF: " + doador.getCpf());
				                			System.out.println("TELEFONE: " + doador.getTelefone());
				                			System.out.println("ENDEREÇO: "+doador.getEndereco());
				                			System.out.println("\n");
			                			} catch (DoadorNaoEncontradoException error) {
			                				System.out.println(error.getMessage());
			                			}
			                			
			                			break;
			                		case 5:
			                			arrDoadores = controller.buscarArrDoadores();
			                			
			                			for (int i=0; i<arrDoadores.length; i++) {
			                				if (arrDoadores[i]!=null) {
					                			System.out.println("NOME:" + arrDoadores[i].getNome());
					                			dataNascimento=arrDoadores[i].getDataNascimento();
					                			System.out.println("DATA DE NASCIMENTO:" + dataNascimento[0] + "/" + dataNascimento[1] + "/" + dataNascimento [2]);
					                			System.out.println("CPF:" + arrDoadores[i].getCpf());
					                			System.out.println("TELEFONE:" + arrDoadores[i].getTelefone());
					                			System.out.println("ENDEREÇO: "+arrDoadores[i].getEndereco());
					                			System.out.println("+++++++++++++++++++++++++++++++++++++++++");
			                				}
			                			}
			                			break;
			                		case 6:	
			                			menuDoador=6;
			                			break;
			                		default:
			                			break;
			                		
			                	}
			                	
		                	}
		                	
		                	break;
		                	
		                case 6: //AREA DE DOACOES
		                	while(menuDoacao!=4) {
			                	System.out.println("----- AREA DE DOACOES -----");
			                	System.out.println("[1] - REALIZAR NOVA DOACAO");
			                	System.out.println("[2] - LISTAR DOACOES");
			                	System.out.println("[3] - LISTAR DOACOES POR DOADOR");
			                	System.out.println("[4] - VOLTAR AO MENU PRINCIPAL");
			                	menuDoacao = input.nextInt();
			                	input = new Scanner(System.in);
			                	
			                	switch(menuDoacao) {
			                		case 1: //REALIZAR NOVA DOACAO
			                			System.out.println("DIGITE A DESCRICAO:");
			                			descricao = input.nextLine();
			                			System.out.println("DATA DA DOACAO:");
			                			data_doacao = input.nextLine();
			                			System.out.println("DIGITE O ID:");
			                			id = input.nextInt();
			                			input = new Scanner(System.in);
			                			
			                			System.out.println("DOADOR POSSUI CADASTRO? [1]SIM [2]NAO");
			                			resposta = input.nextInt();
			                			input = new Scanner(System.in);
			                			
			                			if(resposta==1) {
			                				System.out.println("DIGITE O CPF DO DOADOR:");
			                				cpf = input.nextLine();
			                			
			                				try {
			                					doador = controller.buscarDoador(cpf);
			                					
			                					doacao = new Doacao(descricao, data_doacao, doador,id);
			                					
			                					//INSERIR NO ARRAY DE DOACOES
					                			controller.cadastrarDoacoes(doacao);
					                			
			                				}catch(DoadorNaoEncontradoException error) {
			                					System.out.println(error.getMessage());
			                				}
			                				
			                			} else {
			                				doacao = new Doacao(descricao, data_doacao, null,id);
			                				
			                				//INSERIR NO ARRAY DE DOACOES
				                			controller.cadastrarDoacoes(doacao);
			                			}

			                			break;
			                			
			                		case 2: //LISTAR DOACAO
			                			try {
			                				arrDoacoes = controller.listarDoacoes();
			                				
			                				for (int i=0; i<arrDoacoes.size(); i++) {
				                				if(arrDoacoes.get(i)!=null) {
				                					System.out.println("----------------------------------------------");
				                					System.out.println("ID: "+arrDoacoes.get(i).getIdDoacao());
				                					System.out.println("Descricao: "+arrDoacoes.get(i).getDescricao());
				                					System.out.println("Data de Doacao: "+arrDoacoes.get(i).getDataDoacao());
				                					if(arrDoacoes.get(i).getDoador()==null) {
				                						System.out.println("Doador: Nao cadastrado");
				                					}else {
				                						System.out.println("Doador: "+arrDoacoes.get(i).getDoador().getNome());
				                					}
				                					System.out.println("----------------------------------------------");
				                				}
				                			}
			                				
			                			}catch(DoacaoNaoEncontradaException error) {
			                				System.out.println(error.getMessage());
			                			}

			                			break;
			                			
			                		case 3: //LISTAR DOACAO POR DOADOR
			                			arrDoacoes=null;
			                			
			                			System.out.println("DIGITE O CPF DO DOADOR");
			                			cpf = input.nextLine();
			                			
			                			try {
			                				doador = controller.buscarDoador(cpf);
			                				
			                				arrDoacoes = controller.listarDoacoesPorDoador(cpf);
			                				
			                				for (int i=0; i<arrDoacoes.size(); i++) {
				                				if(arrDoacoes.get(i)!=null) {
				                					System.out.println("----------------------------------------------");
				                					System.out.println("ID: "+arrDoacoes.get(i).getIdDoacao());
				                					System.out.println("Descricao: "+arrDoacoes.get(i).getDescricao());
				                					System.out.println("Data de Doacao: "+arrDoacoes.get(i).getDataDoacao());
				                					System.out.println("Doador: "+arrDoacoes.get(i).getDoador().getNome());
				                					System.out.println("----------------------------------------------");
				                				}
				                			}
			                				
			                			}catch(DoadorNaoEncontradoException error) {
			                				System.out.println(error.getMessage());
			                			}catch(DoacaoNaoEncontradaException error) {
			                				System.out.println(error.getMessage());
			                			}
			                			
			                			break;
			                	
			                	} //FIM DO SWITCH DO MENU DOACAO
		                	}//FIM DO WHILE DO MENU DOACAO
		                	
		                	break;
		                	
		                case 7:
		                	run=false;
		                	System.out.println("OBRIGADO POR ACESSAR O NOSSO SISTEMA!!");
		                	System.out.println("\n");
		                	break;
		                default:
		                	break;
		                	
                	} //FIM DO SWITCH
                }//FIM DO WHILE
		    
         
                // ****** SE O USUARIO NAO FOR ADMINISTRADOR ****  
       }  else if (usuarioAdmin.geteAdmin()==false) {
            	 
            	      	    	
       } //FIM DO ELSE IF SE O USUARIO NAO FOR ADMINISTRADOR
		
	} //WHILE RUN SYSTEM
		
    } //FIM DO MAIN
}//FIM DA CLASSE

