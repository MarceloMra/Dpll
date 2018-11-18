/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package launch;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import model.Clausula;
import model.Dpll;
import model.Literal;

/**
 *
 * @author Gigo
 */
public class Main {
    public static void main(String[] args) {
        Scanner dado = new Scanner(System.in);
        int opc = 0;
        do{
            System.out.println("----> Menu");
            System.out.println("1 - Indicar arquivo de entrada e executar o DPLL");
            System.out.println("0 - Sair");
            do{
                System.out.println("Digite a opção desejada: ");
                opc = dado.nextInt();
            }while(opc < 0 || opc> 1);
            
            if(opc == 1){
                dado.nextLine();
                System.out.println("Digite o caminho do arquivo de entrada: ");
                String caminho = dado.nextLine();
                try {        
                    FileReader arq = new FileReader(caminho);
                    BufferedReader br = new BufferedReader(arq);
                    ArrayList<Clausula> clausulas = new ArrayList<>();

                    while(br.ready()){
                        String linha = br.readLine();
                        Clausula c = new Clausula();
                        String elementos[] = linha.split(" ");

                        for(String el : elementos){
                            Literal l = new Literal();
                            l.setLiteral(Integer.parseInt(el));
                            c.addLiteral(l);
                            //System.out.print(el+", ");
                        }
                        //System.out.println("");
                        clausulas.add(c);
                    }
                    System.out.println("Entradas carregadas com sucesso!");
                    System.out.println("Resultado do DPLL:");
                    Dpll instanciaDpll = new Dpll();
                    instanciaDpll.dpll(clausulas);
                } catch (FileNotFoundException ex) {
                    System.out.println(ex.getMessage());
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }while(opc != 0);
    }
}
