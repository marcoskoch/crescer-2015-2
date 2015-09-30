

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class EstrategiaNoturnosPorUltimoTest
{
  @Test
    public void ataqueCom3ElfosNoturnosE1ElfoVerdeEm2Anoes(){
        Dwarf balin = new Dwarf();
        Dwarf stalin = new Dwarf();
        double vidaEsperada = 70;
        Elfo noturno1 = new ElfoNoturno("NightElf1");
        Elfo noturno2 = new ElfoNoturno("NightElf2");
        Elfo noturno3 = new ElfoNoturno("NightElf3");
        Elfo verde1 = new ElfoVerde("Green1");

        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.mudarEstrategia(new EstrategiaNoturnosPorUltimo());
        exercito.alistar(noturno1);
        exercito.alistar(noturno2);
        exercito.alistar(noturno3);
        exercito.alistar(verde1);

        ArrayList<Elfo> ordemEsperada = new ArrayList<>();
        ordemEsperada.add(verde1);
        ordemEsperada.add(noturno1);
        ordemEsperada.add(noturno2);
        ordemEsperada.add(noturno3);

        exercito.atacar(new ArrayList<>(Arrays.asList(balin,stalin)));

        assertEquals(ordemEsperada,exercito.getOrdemDoUltimoAtaque());
        assertEquals(vidaEsperada, balin.getVida(), .0);
        assertEquals(vidaEsperada, stalin.getVida(), .0);
    }
}
