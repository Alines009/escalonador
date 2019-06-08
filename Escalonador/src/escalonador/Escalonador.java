
package escalonador;

import java.util.ArrayList;

public class Escalonador {
    private static int quantum;
    
    public static void main(String[] args) throws Exception{
        int contador = 0;
        ArrayList<Processo> novos = new ArrayList(); //Cria lista de processos novos
        Leitura leitura = new Leitura();
        novos = leitura.lerArquivos();//Lendo o arquivo processos.txt
        
        FilaPrioridade fp = new FilaPrioridade();
        FilaComum fc = new FilaComum();
        
        fp.ImprimePrioridade();
        fc.ImprimeComum();
        
        try {
            Despachante d = new Despachante();
            while(quantum < 10){
                if(quantum%2==0){
                    d.Despachar(novos, quantum, fp, fc);
                }
            Thread.sleep (1000); 
            
        
            System.out.print("\nTempo: "+quantum);
            quantum +=1;
            }
            
            fp.ImprimePrioridade();
            fc.ImprimeComum();
        } catch (InterruptedException ex) {}
        
    }
    
}
