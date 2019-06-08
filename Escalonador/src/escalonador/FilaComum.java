/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escalonador;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 *
 * @author Ricardo Monteiro
 */
public class FilaComum {
    private ArrayList<ArrayList<Processo>> filaComum;
    private PrintStream erro;
    
    public FilaComum() throws UnsupportedEncodingException{
        this.erro = new PrintStream(System.err, true, "UTF-8");
        this.filaComum = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            this.filaComum.add(new ArrayList<Processo>());
        }
    }
    
    public int processoFinalizou(Processo p){
        if(p.getArrivalTime() == 0){
            return 20;            
        }else if(p.getArrivalTime() != 0){
            return 10;      
        }  
        this.erro.println("Erro 1 (FilaComum.processoFinalisou): Não existe processo para comparar o tempo.");
        return 1;
    }
    
    public int recebeProcesso(Processo p){

        if(this.processoFinalizou(p) == 10){
            if(p.getQtdExec() == 0){
                ArrayList<Processo> a = this.filaComum.get(0);
                a.add(p);
                this.filaComum.set(0, a);
                return 0;
            }else if(p.getQtdExec() == 1){
                ArrayList<Processo> a = this.filaComum.get(1);
                a.add(p);
                this.filaComum.set(1, a);
                return 0;
            }else if (p.getQtdExec() >= 2){
                ArrayList<Processo> a = this.filaComum.get(2);
                a.add(p);
                this.filaComum.set(2, a);
                return 0;
            }
        }else if(this.processoFinalizou(p) == 1){
            this.erro.println("Erro 1 (FilaComum.recebeProcesso): Não existe processo para ser adicionado.");
            return 1;
        }
        return 20;
    }
    
    public Object enviaProcesso(){
        ArrayList<Processo> a;
        for(int i = 0; i < 3; i++){
            a =  this.filaComum.get(i);
            if(!a.isEmpty()){
                Processo p = a.remove(0);
                this.filaComum.set(i,a);
                return p;
            }
        }
        this.erro.println("Erro 2 (FilaComum.enviaProcesso): Fila Vazia.");
        return 2;
    }
}
