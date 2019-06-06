/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escalonador;

import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Leitura {
    public Leitura() throws Exception {
        lerArquivos();
    }
    
    private void lerArquivos() throws Exception{
        FileReader arq = new FileReader("processos.txt");
        BufferedReader lerArq = new BufferedReader(arq);
            
        String linha = lerArq.readLine();
        while (linha != null){
            adicionarNovosProcessos(linha);
            System.out.printf("%s\n",linha);
            linha = lerArq.readLine();
        }
    }
    
    private Processo adicionarNovosProcessos(String linha){
        String array[] = new String [6];
        array = linha.split(", ");
        for(int i=0;i<5;i++){
            System.out.println(array[i]+" ");
        }
        System.out.println("\n");
        return null;
    }
}
