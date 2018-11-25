package view;

import java.util.Scanner;
import model.*;
import exception.*; 

public class AbrigoAnimais {

    public static void main (String[] args) throws LoginExcedidoException, CPFInvalidoException, SenhaExcedidaException, TelefoneInvalidoException, IdadeMaximaAtingidaException {
        
        /*VARIAVEIS*/
        int idade, opcao4, resulmenu1, resulmenu2,resulmenu3,resulmenuAnimais, resulmenuVoluntarios, indiceUsuarios=1,
        		id, indiceAnimais=0,
        		indiceAdotantes=0,
        		menuAtualizarInfoVoluntarios;
        String nome, cpf, telefone, login, senha,
        		descricao, data_chegada, data_saida, //ANIMAIS
        		diasSemana, horario; //VOLUNTÁRIO
        boolean run=true,runtwo=true,runthree=true, result=false, eAdmin=false,
        		castrado, vermifugado, disponivelParaAdocao, adotado, //ANIMAIS
        		encontrou; //para buscas
        
        Scanner input = new java.util.Scanner(System.in);
        
        /*ARRAYS*/
        Usuario [] arrUsuarios = new Usuario [100];
        Animal [] arrAnimais = new Animal[100];
        Adotante [] arrAdotantes = new Adotante[100];
        
        /*OBJETOS*/
        Usuario usuarioAdmin = new Usuario ("admin", "admin", "juvitu", "12345678910", "40028922", true) ;
        Animal animal;
        Voluntario voluntario;
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
			                    System.out.println("[5] - LISTAR TODOS OS USUÁRIOS");
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
		                    System.out.println("[4] - REALIZAR ADOÇÃO");
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
		                    				//QUANDO EU FAÇO ISSO EU TÔ MEXENDO NO INDICE QUE EU QUERO MESMO?
		                    				break;
		                    			}
		                    		}
		                    		System.out.println("INFORME O CPF DO ADOTANTE");
		                    		cpf = input.next();
		                    		
		                    		//FACO A BUSCA AQUI MESMO? ADOTANTENAOENCONTRADO É UMA EXCEPTION?
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
			                    System.out.println("[3] - ATUALIZAR LOGIN E SENHA");
			                    System.out.println("[4] - DESATIVAR CONTA");
			                    System.out.println("[5] - LISTAR TODOS OS USUÁRIOS");
			                    System.out.println("[6] - VOLTAR PRO MENU PRINCIPAL");
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
			                    		System.out.println("Digite os dias da semana que você poderá se voluntariar:");
			                    		System.out.println("[1] - Segunda");
			                    		System.out.println("[2] - Terça");
			                    		System.out.println("[3] - Quarta");
			                    		System.out.println("[4] - Quinta");
			                    		System.out.println("[5] - Sexta");
			                    		System.out.println("[6] - Sabado");
			                    		System.out.println("Separados por hifen. Ex: 1-2-3-4");
			                    		diasSemana=input.next();
			                    		System.out.println("Digite os horários que você pode estar como voluntário:");
			                    		System.out.println("Lembrando que só funcionamos até as 19h");
			                    		System.out.println("Separados por hifen. Ex: 10h-14h");
			                    		horario = input.next();
			                    		
			                    		try{
			                    			voluntario = new Voluntario(nome, cpf, idade, telefone, diasSemana, horario);
			                    			System.out.println("USUÁRIO CADASTRADO COM SUCESSO!");
			                    		} catch (CPFInvalidoException error) {
			                    			System.out.println(error.getMessage());
			                    		} catch (TelefoneInvalidoException error2) {
			                    			System.out.println(error2.getMessage());
			                    		} catch (IdadeMaximaAtingidaException error3) {
			                    			System.out.println(error3.getMessage());
			                    		}
			                    		
			                    		break;
			                    		
			                    	case 2:
			                    		System.out.println("O que deseja atualizar?");
			                    		System.out.println("[1] - Nome");
			                    		System.out.println("[2] - CPF");
			                    		System.out.println("[3] - Idade");
			                    		System.out.println("[4] - Telefone");
			                    		System.out.println("[5] - Dias de voluntário");
			                    		System.out.println("[6] - Horário de voluntário");
			                    		
			                    		switch () {
			                    			
			                    		}
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
     			                    System.out.println("[5] - LISTAR TODOS OS USUÁRIOS");
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
     		                                } //FIM MENU ATUALIZAR INFORMAÃƒâ€¡Ãƒâ€¢ES DO USUÃƒï¿½RIO 
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
     			                    	  
     			                    }//FIM DO SWITCH DO USUÃ�RIO
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

