package Aplicativo;

import Classes.Aeronave;
import Classes.Pessoa;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        Scanner leiaString = new Scanner(System.in);

        String nome, cpf,licenca;
        int menu = 1;
        int numPiloto = 0;
        int nav = 0;
        boolean validacao, busca;

        Pessoa[] listaPiloto = new Pessoa[3];
        Aeronave[] listaNave = new Aeronave[80];

        while (menu != 0) {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            abreMenu();
            System.out.print("Selecione a opção: >> ");
            menu = leia.nextInt();

            if (menu == 1) {
                if (numPiloto < 3) {

                    Pessoa piloto = new Pessoa();
                    System.out.println("---------CADASTRO DE PILOTOS--------");
                    System.out.print("\nNOME: ");
                    piloto.setNome(leiaString.nextLine());

                    do {
                        System.out.print("CPF: ");
                        piloto.setCpf(leiaString.nextLine());
                        cpf = piloto.getCpf();

                        validacao = cpf.matches("[0-9]{11}");
                        if (!validacao) {
                            System.out.print("CPF invalido. Digite novamente!!\n");
                        }
                    } while (!validacao);

                    do {
                        System.out.print("Numero CHT(5 digitos): ");
                        piloto.setNumLicenca(leiaString.nextLine());
                        licenca = piloto.getNumLicenca();

                        validacao = licenca.matches("[0-9]{5}");
                        if (!validacao) {
                            System.out.print("Numero de Licença invalido. Digite novamente!!\n");
                        }
                    } while (!validacao);


                    listaPiloto[numPiloto] = piloto;
                    numPiloto++;


                } else {
                    System.out.println("Capacidade Maxima de Pilotos atingida\n");
                }

            } else if (menu == 2) {
                if (numPiloto != 0) {
                    System.out.println("---------CADASTRAR AERONAVE--------");
                    Aeronave nave = new Aeronave();

                    System.out.print("\nMODELO: ");
                    nave.setModelo(leiaString.next());

                    System.out.print("NUMERO DE SERIE: ");
                    nave.setNumeroSerie(leiaString.next());

                    listaNave[nav] = nave;
                    nav++;

                } else {
                    System.out.println("\nNenhum piloto cadastrado\nPara cadastrar naves, cadastre o piloto primeiro\n");
                }

            } else if (menu == 3) {
                System.out.println("----------LISTA DE BREVÊ PILOTOS----------");
                if (listaPiloto[0] != null) {
                    for (Pessoa leiaPiloto : listaPiloto) {
                        if (leiaPiloto != null) {
                            System.out.println(leiaPiloto.breve());
                        }
                    }
                } else {
                    System.out.println("Nenhum Piloto cadastrado!");
                }
            } else if (menu == 4) {
                System.out.println("---------LOCALICAR PILOTO POR CPF---------");
                busca = false;
                System.out.print("\nDigite o CPF: ");
                cpf = leia.next();
                for (Pessoa leiaPiloto : listaPiloto) {
                    if (leiaPiloto != null && cpf.equals(leiaPiloto.getCpf())) {
                        System.out.println("PILOTO: " + leiaPiloto.getNome());
                        busca = true;
                    }
                }
                if (!busca) {
                    System.out.println("CPF nao encontrado");
                }

            } else if (menu == 5) {
                System.out.println("----------LISTA DE AERONAVES----------");
                if (listaNave[0] != null) {
                    for (Aeronave leiaNave : listaNave) {
                        if (leiaNave != null) {
                            System.out.println(leiaNave.naves());
                        }
                    }
                } else {
                    System.out.println("\nNenhuma Aeronave cadastrada!\n");
                }
            }

        }
        System.out.println("\n---------FIM DO PROGRAMA----------");
    }
    private static void abreMenu() {
        System.out.println("=========MENU=======");
        System.out.println("[1] - CADASTRO DE PILOTOS");
        System.out.println("[2] - CADASTRAR AERONAVE");
        System.out.println("[3] - LISTA DE BREVÊ PILOTOS");
        System.out.println("[4] - LOCALICAR PILOTO POR CPF");
        System.out.println("[5] - LISTA DE AERONAVES");
        System.out.println("[0] - SAIR DO PROGRAMA");
    }
}