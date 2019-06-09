
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
        
        //Inicializacao da Memoria Principal
        RAM memoria = new RAM();        
        //Inicializacao das CPUs
        CPU cp1 = new CPU(1);
        CPU cp2 = new CPU(2);
        CPU cp3 = new CPU(3);
        CPU cp4 = new CPU(4);
        
        int flag;
        try {
            Despachante d = new Despachante();
            while(!novos.isEmpty()){
                if(quantum%2==0){
                    int i = 0;
                    while(i < novos.size()){
                        flag = d.Despachar(novos.get(i), quantum, fp, fc,memoria);
                        if(flag == 0){
                            novos.remove(i);
                        }else{
                            i += 1;
                        }
                    }
                    
                }
                
            
            Thread.sleep (1000); 
            System.out.print("\nTempo: "+quantum);
            quantum +=1;
            }

            fp.ImprimePrioridade();
            fc.ImprimeComum();
            
            System.out.println("MEMORIA PRINCIPAL");
            int quadros[] = memoria.getQuadroDaMP();
            for(int j=0;j<256;j++){
                System.out.println(quadros[j]);
            }
        } catch (InterruptedException ex) {}
        
    }
    
}
