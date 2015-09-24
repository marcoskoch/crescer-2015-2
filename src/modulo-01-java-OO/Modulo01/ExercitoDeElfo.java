import java.util.HashMap;
import java.util.ArrayList;


public class ExercitoDeElfo {
    private HashMap <String, Elfo> exercito;

    public ExercitoDeElfo (){
        this.exercito = new HashMap<>();
    }

    public void alistarUmElfo(Elfo elfo){
      if((elfo instanceof ElfoNoturno || elfo instanceof ElfoVerde) && elfo.getNome() != null){
          exercito.put(elfo.getNome(), elfo);
      }
    }

    public Elfo getElfoNoExercitoPorNome(String nome) {
        return this.exercito.get(nome);
    }

    public HashMap getExercito(){
        return exercito;
    }

    public boolean equals(Object obj){
        ExercitoDeElfo tropa = (ExercitoDeElfo) obj;
        return this.exercito.equals(tropa.getExercito());
    }
}
