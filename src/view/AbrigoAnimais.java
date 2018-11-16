package view;

import java.util.Scanner;
import model.*;
import exception.*; 

public class AbrigoAnimais {

    public static void main (String[] args) throws LoginExcedidoException, CPFInvalidoException, SenhaExcedidaException {
        
        /*VARIAVEIS*/
        int opcao4, resulmenu1, resulmenu2,resulmenu3,indiceUsuarios=1;
        String nome, cpf, telefone, login, senha;
        boolean run=true,runtwo=true,result=false, eAdmin=false;
        Scanner input = new java.util.Scanner(System.in);
        
        /*OBJETOS*/
        Usuario usuario = new Usuario ("123456", "123456", "juvitu", "12345678910", true) ;
        
        /*ARRAYS*/
        Usuario [] arrUsuarios = new Usuario [100];
        
       while (!result) {	
		   try {
		        	
		      /*VERIFICA O LOGIN E PEGA O OBJETO DO USUÃƒÆ’Ã¯Â¿Â½RIO*/
		      System.out.println("DIGITE O SEU LOGIN:");
		      login = input.next();
		      System.out.println("DIGITE A SUA SENHA:");
		      senha = input.next();
	        
		      result = usuario.loginAdmin(login,senha);
		   
		   } catch(LoginInvalidoException error){
	       	 System.out.println(error.getMessage());
		   }
       }
       
      
		if (usuario.geteAdmin()) {
		    //MENU DO USUÃƒï¿½RIO ADMIN
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
			                            	usuario = new Usuario (login, senha, nome, cpf, eAdmin);
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
		                                System.out.println("[4] - VOLTAR PRO MENU DO USUÃƒÆ’Ã¯Â¿Â½RIO");
		                                resulmenu3 = input.nextInt(); 
		                                
		                                switch(resulmenu3){
			                                case 1:
			                               
			                                    System.out.println("DIGITE O SEU NOVO NOME:");
			                                    nome = input.next();
			                                    usuario.setNome(nome);
			                                    
			                                    System.out.println("NOME ATUALIZADO COM SUCESSO");
			                                    break;
			                                case 2:
			                                    System.out.println("DIGITE O SEU NOVO CPF:");
			                                    cpf = input.next();
			                                    
			                                    try {
			                                    	usuario.setCpf(cpf);
			                                    	System.out.println("CPF ATUALIZADO COM SUCESSO");
			                                    } catch (CPFInvalidoException error) {
			                                    	System.out.println(error.getMessage());
			                                    }
			                                    
			                                    break;
			                                case 3:
			                                    System.out.println("DIGITE O SEU NOVO TELEFONE:");
			                                    telefone = input.next();
			                                    
			                                    try {
			                                    	usuario.setTelefone(telefone);
			                                    } catch (TelefoneInvalidoException error) {
			                                    }
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
			                        			usuario.atualizarLogin(login);
			                        			System.out.println("LOGIN ATUALIZADO!");
			                        		}catch(LoginExcedidoException e) {
			                        			System.out.println(e.getMessage());
			                        		}
			                        	} else if (opcao4==2) {
			                        		System.out.println("DIGITE A SUA NOVA SENHA:");
			                        		senha = input.next();
			                        		try {
			                        			usuario.atualizarSenha(senha);
			                        			System.out.println("SENHA ATUALIZADA!");
			                        		}catch(SenhaExcedidaException e) {
			                        			System.out.println(e.getMessage());
			                        		}
			                        	} else {
			                        		System.out.println("Digite uma opÃ§Ã£o vÃ¡lida");
			                        	}
			                        	break;
			                        	
			                     case 4:
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
