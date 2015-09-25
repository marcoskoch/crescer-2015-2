

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;

public class EstrategiaNormalTest {
    @Test
    public void ExercitoDeElfosAtacandoDwarves(){
      Elfo elfo = new ElfoNoturno("Night Legolas");
      Elfo elfo2 = new ElfoNoturno("Night Legolas 2");
      Elfo elfo3 = new ElfoVerde("Green Legolas");
      ExercitoDeElfos exercito = new ExercitoDeElfos();
      exercito.alistar(elfo);
      exercito.alistar(elfo2);
      exercito.alistar(elfo3);
      exercito.agruparPorStatus();
      ArrayList<Elfo> vivos = exercito.buscar(Status.VIVO);

      Dwarf gimli = new Dwarf();
      Dwarf anao = new Dwarf();
      Dwarf terceiro = new Dwarf();
      HordaDeDwarf dwarves = new HordaDeDwarf();
      dwarves.adicionarDwarf(gimli);
      dwarves.adicionarDwarf(anao);
      dwarves.adicionarDwarf(terceiro);

      EstrategiaNormal estrategia = new EstrategiaNormal();
      estrategia.atacar(vivos, dwarves.getDwarves());

    }
}
