package view;

import java.util.Scanner;
import model.*;
import exception.*; 

public class AbrigoAnimais {

    public static void main (String[] args) {
        
        /*VARIAVEIS*/
        int idade, opcao4, resulmenu1, resulmenu2,resulmenu3,resulmenuAnimais, resulmenuVoluntarios, indiceUsuarios=1,
        		id, indiceAnimais=0,
        		indiceAdotantes=0,
        		menuAtualizarInfoVoluntarios, diasVoluntario [] = new int [6], horarioInicial, horarioFinal; //VOLUNTÁRIO 
        String nome, cpf, telefone, login, senha,
        		descricao, data_chegada, data_saida; //ANIMAIS
        	
        boolean run=true,runtwo=true,runthree=true, result=false, eAdmin=false,
        		castrado, vermifugado, disponivelParaAdocao, adotado, //ANIMAIS
        		encontrou; //para buscas
        Scanner input = new java.util.Scanner(System.in);
        
        /*ARRAYS*/
        Usuario [] arrUsuarios = new Usuario [100];
        Animal [] arrAnimais = new Animal[100];
        Adotante [] arrAdotantes = new Adotante[100];
        Voluntario [] arrVoluntarios = new Voluntario[100];
        
        /*OBJETOS*/
        Usuario usuarioAdmin = new Usuario ("admin", "admin", "juvitu", "12345678910", "40028922", true) ;
        Animal animal;
        Voluntario voluntario=null;
        arrUsuarios[indiceUsuarios]=usuarioAdmin;
        indiceUsuarios++;
        
        Usuario usuario=null;
        
       while (!result) {	
		   try {
		        	
		      /*VERIFICA O LOGIN E PEGA O OBJETO DO USUARIO*/
		      System.out.println("DIGITE O SEU LOGIN:");
		      login = input.next();
		      System.out.println("DIGITE A SUA SENHA:");
		      senha = input.next();
	        
		      result = usuarioAdmin.loginAdmin(login,senha);
		   
		   } catch(LoginInvalidoException error){
	       	 System.out.println(error.getMessage());
		   }
       }
       
      
		if (usuarioAdmin.geteAdmin()) { //SE O USUARIO FOR ADMINISTRADOR
		    //MENU DO USUARIO ADMIN
		    while (run) {
		    	
		    	System.out.println("BEM-VINDO AO ABRIGO DE ANIMAIS!!");
                System.out.println("DIGITE A OPCAO DESEJADA:");
                System.out.println("[1] - AREA DO USUARIO");
                System.out.println("[2] - AREA DO ANIMAL");
                System.out.println("[3] - AREA DO VOLUNTARIO");
                System.out.println("[4] - AREA DO ADOTANTE");
                System.out.println("[5] - AREA DO DOADOR");
                System.out.println("[6] - SAIR");
                resulmenu1 = input.nextInt();
                
                runtwo=true;
                
                switch (resulmenu1) {
		                case 1: 
		                	while (runtwo) {
		                		
			                    System.out.println("**** MENU DO USUARIO ****");
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
			                                System.out.println("USUARIO CADASTRADO COM SUCESSO");
			                                arrUsuarios[indiceUsuarios]=usuario;
			                                indiceUsuarios++;
			                            } catch (CPFInvalidoException e) {
			                            	System.out.println(e.getMessage());
			                            } catch (SenhaExcedidaException e) {
			                            	System.out.println(e.getMessage());
			                            } catch (LoginExcedidoException e) {
			                            	System.out.println(e.getMessage());
			                            }
			                            
			                            break;
			                            
			                        case 2: //ATUALIZAR INFORMACOES DO USUARIO
		                            	
		                                System.out.println("DIGITE QUAL INFORMACAO VOCE DESEJA ATUALIZAR:");
		                                System.out.println("[1] - NOME");
		                                System.out.println("[2] - CPF");
		                                System.out.println("[3] - TELEFONE");
		                                System.out.println("[4] - VOLTAR PARA O MENU DO USUARIO");
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
			                                case 4:
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
			                    	 
			                    	 	for(int i=0;i<arrUsuarios.length;i++) {
			                    	 		if (arrUsuarios[i]!=null) {
			                    	 			if (arrUsuarios[i].getCPF().equals(usuarioAdmin.getCPF())) {
			                    	 				arrUsuarios[i]=null;
			                    	 				System.out.println("Usuario desativado");
			                    	 				runtwo=false;
			                    	 			}
			                    	 		}
			                    	 	}
			                        	break;
			                        	
			                      case 5: //LISTAR TODOS OS USUARIOS
			                    	  	for (int i=0; i<arrUsuarios.length;i++) {
			                    	  		if(arrUsuarios[i]!=null) {
				                    	  		System.out.println("Nome: " + arrUsuarios[i].getNome());
				                    	  		System.out.println("CPF:" + arrUsuarios[i].getCPF());
				                    	  		System.out.println("Telefone:" + arrUsuarios[i].getTelefone());
				                    	  		System.out.println("\n");
			                    	  		}
			                    	  	}
			                        	break;
			                      case 6:
			                    	  runtwo=false;
			                    	  break;
			                      default:
			                    	  break;
			                    	  
			                    }//FIM DO SWITCH DO USUARIO
		                	} //FIM DO WHILE 2
		                
		                case 2: //*** AREA DO ANIMAL ****
		                	System.out.println("**** AREA DO ANIMAL ****");
		                    System.out.println("[1] - REALIZAR NOVO CADASTRO");
		                    System.out.println("[2] - ATUALIZAR CADASTRO");
		                    System.out.println("[3] - LISTAR ANIMAIS DISPONIVEIS PARA ADOCAO");
		                    System.out.println("[4] - REALIZAR ADOÃ‡ÃƒO");
		                    System.out.println("[5] - LISTAR TODOS OS ANIMAIS");
		                    System.out.println("[6] - VOLTAR PRO MENU PRINCIPAL");
		                    
		                    resulmenuAnimais = input.nextInt();
		                    
		                    switch(resulmenuAnimais) {
		                    	case 1: //REALIZAR NOVO CADASTRO
		                    		System.out.println("**** CADASTRANDO NOVO ANIMAL ****");
		                    		System.out.println("DIGITE O NOME: ");
		                    		nome = input.next();
		                    		System.out.println("DIGITE A IDADE: ");
		                    		idade = input.nextInt();
		                    		System.out.println("ESCREVA UMA DESCRICAO: ");
		                    		descricao = input.next();
		                    		System.out.println("INFORME A DATA DE ENTRADA: ");
		                    		data_chegada = input.next();
		                    		
		                    		animal = new Animal(indiceAnimais, nome, idade, descricao, data_chegada);
		                    		
		                    		arrAnimais[indiceAnimais] = animal;
		                    		indiceAnimais++;
		                    		
		                    		System.out.println("Animal cadastrado com sucesso!");
		                    		
		                    		break;
		                    		
		                    	case 2: //ATUALIZAR CADASTRO
		                    		
		                    		break;
		                    		
		                    	case 3: //LISTAR ANIMAIS DISP. PARA ADOCAO
		                    		for (int i=0; i<indiceAnimais;i++) {
		                    			if(arrAnimais[i]!=null && arrAnimais[i].getDisponivelAdocao()) {
		                    				System.out.println("------ "+arrAnimais[i].getNome()+" -----");
		                    				System.out.println("ID: "+arrAnimais[i].getidAnimal());
		                    				System.out.println("Idade: "+arrAnimais[i].getIdade());
		                    				System.out.println("Descricao: "+arrAnimais[i].getDescricao());
		                    				System.out.println("Castrado: "+arrAnimais[i].getCastrado());
		                    				System.out.println("Vermifugado: "+arrAnimais[i].getVermifugado());
		                    				System.out.println("---------------------------------------------");
		                    			}
		                    		}
		                    		
		                    		break;
		                    		
		                    	case 4: //REALIZAR ADOCAO
		                    		System.out.println("DIGITE O ID DO ANIMAL:");
		                    		id = input.nextInt();
		                    		
		                    		animal = null;
		                    	
		                    		//BUSCANDO O ANIMAL INFORMANDO
		                    		for (int i=0; i<indiceAnimais;i++) {
		                    			if(arrAnimais[i]!=null && arrAnimais[i].getidAnimal()==id) {
		                    				System.out.println("------ "+arrAnimais[i].getNome()+" -----");
		                    				System.out.println("Idade: "+arrAnimais[i].getIdade());
		                    				System.out.println("Descricao: "+arrAnimais[i].getDescricao());
		                    				System.out.println("Castrado: "+arrAnimais[i].getCastrado());
		                    				System.out.println("Vermifugado: "+arrAnimais[i].getVermifugado());
		                    				System.out.println("---------------------------------------------");
		                    				animal = arrAnimais[i];
		                    				//QUANDO EU FAÃ‡O ISSO EU TÃ” MEXENDO NO INDICE QUE EU QUERO MESMO?
		                    				break;
		                    			}
		                    		}
		                    		System.out.println("INFORME O CPF DO ADOTANTE");
		                    		cpf = input.next();
		                    		
		                    		//FACO A BUSCA AQUI MESMO? ADOTANTENAOENCONTRADO Ã‰ UMA EXCEPTION?
		                    		//BUSCANDO ADOTANTE CADASTRADO
		                    		for (int i=0; i<indiceAdotantes;i++) {
		                    			if(arrAdotantes[i]!=null && arrAdotantes[i].getCpf().equals(cpf)) {
		                    				System.out.println("----- "+arrAdotantes[i].getNome()+" -----");
		                    				System.out.println("CPF: "+arrAdotantes[i].getCpf());
		                    				System.out.println("Email: "+arrAdotantes[i].getEmail());
		                    				System.out.println("Telefone: "+arrAdotantes[i].getTelefoneCelular());
		                    				System.out.println("Cidade: "+arrAdotantes[i].getCidade());
		                    				break;
		                    			}
		                    		}
		                    		
		                    		
		                    		
		                    		break;
		                    		
		                    	case 5: //BUSCAR ANIMAL: GATOS/CACHORROS/NAO VERMIFUGADO/NAO CASTRADOS/
		                    		break;
		                    		
		                    	case 6: //VOLTAR PARA O MENU PRINCIPAL
		                    } //FIM DO SWITCH
		                    
		                	break; //FIM DA AREA DO ANIMAL
		                case 3:
		                	    System.out.println("**** MENU DO VOLUNTÁRIO ****");
			                    System.out.println("[1] - REALIZAR NOVO CADASTRO");
			                    System.out.println("[2] - ATUALIZAR INFORMACOES PESSOAIS");
			                    System.out.println("[3] - ATUALIZAR DIAS DE VISITA");
			                    System.out.println("[4] - ATUALIZAR HORÁRIO DE VISITA");
			                    System.out.println("[5] - DESATIVAR CADASTRO");
			                    System.out.println("[6] - SAIR");
			                    resulmenuVoluntarios = input.nextInt();
			                    
			                    switch (resulmenuVoluntarios) {
			                    
			                    	case 1:
			                    		System.out.println("Digite o seu nome:");
			                    		nome = input.next();
			                    		System.out.println("Digite o seu cpf:");
			                    		cpf = input.next();
			                    		System.out.println("Digite a sua idade:");
			                    		idade = input.nextInt();
			                    		System.out.println("Digite o seu telefone:");
			                    		telefone = input.next();
			                    		System.out.println("Digite os dias da semana que você quer se voluntariar:");
			                    		System.out.println("[1] SIM / [2] NÃO");
			                    		
			                    		System.out.println("Segunda-feira");
			                    		diasVoluntario [0] = input.nextInt();
			                    		
			                    		System.out.println("Terça-feira");
			                    		diasVoluntario [1] = input.nextInt();
			                    		
			                    		System.out.println("Quarta-feira");
			                    		diasVoluntario [2] = input.nextInt();
			                    		
			                    		System.out.println("Quinta-feira");
			                    		diasVoluntario [3] = input.nextInt();
			                    		
			                    		System.out.println("Sexta-feira");
			                    		diasVoluntario [4] = input.nextInt();
			                    		
			                    		System.out.println("Sabado");
			                    		diasVoluntario [5] = input.nextInt();
			                    		
			                    		System.out.println("**** Lembrando que são funcionamos de 8h as 20h ****");
			                    		System.out.println("Digite o horário de entrada que você pode estar como voluntário:");
			                    		horarioInicial = input.nextInt();
			                    		System.out.println("Digite o horário de saída que você pode estar como voluntário:");
			                    		horarioFinal = input.nextInt();
			                    		
			                    		
			                    		try{
			                    			voluntario = new Voluntario(nome, cpf, idade, telefone, diasVoluntario, horarioInicial, horarioFinal);
			                    			System.out.println("USUÁRIO CADASTRADO COM SUCESSO!");
			                    		} catch (CPFInvalidoException error) {
			                    			System.out.println(error.getMessage());
			                    		} catch (TelefoneInvalidoException error) {
			                    			System.out.println(error.getMessage());
			                    		} catch (IdadeMaximaAtingidaException error) {
			                    			System.out.println(error.getMessage());
			                    		} catch (HorarioExcedidoException error) {
			                    			System.out.println(error.getMessage());
			                    		}
			                    		
			                    		break;
			                    		
			                    	case 2:
			                    		
			                    		System.out.println("Digite o cpf do voluntário desejado:");
			                    		cpf = input.next();
			                    		
			                    		//CPF NAO ENCONTRADO E CPF INVALIDO
			                    		
			                    		for (int i=0; i<arrVoluntarios.length;i++) {
			                    			if (arrVoluntarios[i]!=null && arrVoluntarios[i].getCpf().equals(cpf)) {
			                    				voluntario = arrVoluntarios[i];
			                    				break;
			                    			}
			                    		}
			                    		
			                    		System.out.println("O que deseja atualizar?");
			                    		System.out.println("[1] - Nome");
			                    		System.out.println("[2] - CPF");
			                    		System.out.println("[3] - Idade");
			                    		System.out.println("[4] - Telefone");
			                    		
			                    		menuAtualizarInfoVoluntarios = input.nextInt();
			                    		
			                    		switch (menuAtualizarInfoVoluntarios) {
			                    			case 1: 
			                    				
			                    				System.out.println("Digite o seu novo nome:");
			                    				nome = input.next();
			                    				voluntario.setNome(nome);
			                    				break;
			                    				
			                    			case 2:
			                    				System.out.println("Digite o seu novo cpf:");
			                    				cpf = input.next();
			                    				
			                    				try {
			                    					voluntario.setCpf(cpf);
			                    				} catch (CPFInvalidoException error) {
			                    					System.out.println(error.getMessage());
			                    				}
			                    				
			                    				break;
			                    			case 3:
			                    				System.out.println("Digite a sua nova idade:");
			                    				idade = input.nextInt();
			                    				
			                    				try {
			                    					voluntario.setIdade(idade);
			                    				} catch (IdadeMaximaAtingidaException error) {
			                    					System.out.println(error.getMessage());
			                    				}
			                    				
			                    				break;
			                    			case 4:
			                    				System.out.println("Digite o seu novo telefone:");
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
			                    	case 3:
			                    		diasVoluntario=null;
			                    		
			                    		System.out.println("Digite os dias da semana que você quer se voluntariar:");
			                    		System.out.println("[1] SIM / [2] NÃO");
			                    		
			                    		System.out.println("Segunda-feira");
			                    		diasVoluntario [0] = input.nextInt();
			                    		
			                    		System.out.println("Terça-feira");
			                    		diasVoluntario [1] = input.nextInt();
			                    		
			                    		System.out.println("Quarta-feira");
			                    		diasVoluntario [2] = input.nextInt();
			                    		
			                    		System.out.println("Quinta-feira");
			                    		diasVoluntario [3] = input.nextInt();
			                    		
			                    		System.out.println("Sexta-feira");
			                    		diasVoluntario [4] = input.nextInt();
			                    		
			                    		System.out.println("Sabado");
			                    		diasVoluntario [5] = input.nextInt();
			                    		
			                    		voluntario.setDias(diasVoluntario);
			                    		break;
			                    		
			                    	case 4:
			                    		System.out.println("**** Lembrando que são funcionamos de 8h as 20h ****");
			                    		System.out.println("Digite o novo horário de entrada que você pode estar como voluntário:");
			                    		horarioInicial = input.nextInt();
			                    		System.out.println("Digite o novo horário de saída que você pode estar como voluntário:");
			                    		horarioFinal = input.nextInt();
			                    		
			                    		try {
			                    			voluntario.setHorarioInicial(horarioInicial);
			                    			voluntario.setHorarioFinal(horarioFinal);
			                    		} catch (HorarioExcedidoException error) {
			                    			System.out.println(error.getMessage());
			                    		}
			                    		
			                    		break;
			                    	case 5:
			                    		//deixar array null;
			                    		break;
			                    	case 6:
			                    		//finalizar o loop.
			                    		break;
			                    	default:
			                    		break;
			                    }
			                    
		                	break;
		                case 4:
		                	break;
		                case 5:
		                	break;
		                case 6:
		                	run=false;
		                	break;
		                default:
		                	break;
                	
	            } //FIM DO SWITCH PRINCIPAL (MENU PRINCIPAL)  
                
		    	} //FIM DO WHILE      	
		    
		    
		    
		    // ****** SE O USUARIO NAO FOR ADMINISTRADOR ****
		    
             }  else if (usuarioAdmin.geteAdmin()==false) {
            	 
            	 while (run) {
     		    	
     		    	System.out.println("BEM-VINDO AO ABRIGO DE ANIMAIS!!");
                     System.out.println("DIGITE A OPCAO DESEJADA:");
                     System.out.println("[1] - AREA DO USUARIO");
                     System.out.println("[2] - AREA DO ANIMAL");
                     System.out.println("[3] - AREA DO VOLUNTARIO");
                     System.out.println("[4] - AREA DO ADOTANTE");
                     System.out.println("[5] - AREA DO DOADOR");
                     System.out.println("[6] - SAIR");
                     resulmenu1 = input.nextInt();
                     
                     runtwo=true;
                     
                     switch (resulmenu1) {
     		                case 1: 
     		                	while (runtwo) {
     		                		
     			                    System.out.println("**** MENU DO USUARIO ****");
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
     			                                System.out.println("USUARIO CADASTRADO COM SUCESSO");
     			                                arrUsuarios[indiceUsuarios]=usuario;
     			                                indiceUsuarios++;
     			                            } catch (CPFInvalidoException e) {
     			                            	System.out.println(e.getMessage());
     			                            } catch (SenhaExcedidaException e) {
     			                            	System.out.println(e.getMessage());
     			                            } catch (LoginExcedidoException e) {
     			                            	System.out.println(e.getMessage());
     			                            }
     			                            
     			                            break;
     			                            
     			                        case 2: //ATUALIZAR INFORMACOES DO USUARIO
     		                            	
     		                                System.out.println("DIGITE QUAL INFORMACAO VOCE DESEJA ATUALIZAR:");
     		                                System.out.println("[1] - NOME");
     		                                System.out.println("[2] - CPF");
     		                                System.out.println("[3] - TELEFONE");
     		                                System.out.println("[4] - VOLTAR PRO MENU DO USUARIO");
     		                                resulmenu3 = input.nextInt(); 
     		                                
     		                                switch(resulmenu3){
     			                                case 1:
     			                               
     			                                    System.out.println("DIGITE O SEU NOVO NOME:");
     			                                    nome = input.next();
     			                                    usuarioAdmin.setNome(nome);
     			                                    
     			                                    System.out.println("NOME ATUALIZADO COM SUCESSO");
     			                                    break;
     			                                case 2:
     			                                    System.out.println("DIGITE O SEU NOVO CPF:");
     			                                    cpf = input.next();
     			                                    
     			                                    try {
     			                                    	usuarioAdmin.setCpf(cpf);
     			                                    	System.out.println("CPF ATUALIZADO COM SUCESSO");
     			                                    } catch (CPFInvalidoException error) {
     			                                    	System.out.println(error.getMessage());
     			                                    }
     			                                    
     			                                    break;
     			                                case 3:
     			                                    System.out.println("DIGITE O SEU NOVO TELEFONE:");
     			                                    telefone = input.next();
     			                                    
     			                                    usuarioAdmin.setTelefone(telefone);
     			                                   
     			                                    break;
     			                                case 4:
     			                                		break;
     			                                default:
     			                                    break;
     		                                } //FIM MENU ATUALIZAR INFORMAÃƒÆ’Ã¢â‚¬Â¡ÃƒÆ’Ã¢â‚¬Â¢ES DO USUÃƒÆ’Ã¯Â¿Â½RIO 
     		                             break;
     		                                
     			                       case 3:
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
     			                        	
     			                     case 4:
     			                    	 	for(int i=0;i<arrUsuarios.length;i++) {
     			                    	 		if (arrUsuarios[i]!=null) {
     			                    	 			if (arrUsuarios[i].getCPF().equals(usuarioAdmin.getCPF())) {
     			                    	 				arrUsuarios[i]=null;
     			                    	 				System.out.println("Usuario desativado");
     			                    	 				runtwo=false;
     			                    	 			}
     			                    	 		}
     			                    	 	}
     			                        	break;
     			                      case 5:
     			                    	  	for (int i=0; i<arrUsuarios.length;i++) {
     			                    	  		if(arrUsuarios[i]!=null) {
     				                    	  		System.out.println("Nome: " + arrUsuarios[i].getNome());
     				                    	  		System.out.println("CPF:" + arrUsuarios[i].getCPF());
     				                    	  		System.out.println("Telefone:" + arrUsuarios[i].getTelefone());
     				                    	  		System.out.println("\n");
     			                    	  		}
     			                    	  	}
     			                        	break;
     			                      case 6:
     			                    	  runtwo=false;
     			                    	  break;
     			                      default:
     			                    	  break;
     			                    	  
     			                    }//FIM DO SWITCH DO USUÃƒï¿½RIO
     		                	} //FIM DO WHILE 2
     		                case 2:
     		                	break;
     		                case 3:
     		                	break;
     		                case 4:
     		                	break;
     		                case 5:
     		                	break;
     		                case 6:
     		                	run=false;
     		                	break;
     		                default:
     		                	break;
                     	
     	            } //FIM DO SWITCH PRINCIPAL (MENU PRINCIPAL)  
                     
     		    	} //FIM DO WHILE      	    	
             } //FIM DO IF 
    } //FIM DO MAIN
}//FIM DA CLASSE

