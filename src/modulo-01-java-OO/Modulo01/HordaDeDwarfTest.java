

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;


public class HordaDeDwarfTest
{
    @Test
    public void adicionarDwarfNaHorda(){
        Dwarf gimli = new Dwarf();
        HordaDeDwarf dwarves = new HordaDeDwarf();

        ArrayList <Dwarf> listaDeDwarvesEsperada = new ArrayList<>();
        ArrayList <Dwarf> listaDeDwarves = new ArrayList<>();
        listaDeDwarvesEsperada.add(gimli);

        dwarves.adicionarDwarf(gimli);
        listaDeDwarves = dwarves.getDwarves();


        assertEquals(listaDeDwarvesEsperada, listaDeDwarves);
    }

    @Test
    public void adicionar3DwarfNaHorda(){
        Dwarf gimli = new Dwarf();
        Dwarf anao = new Dwarf();
        Dwarf terceiro = new Dwarf();
        HordaDeDwarf dwarves = new HordaDeDwarf();

        ArrayList <Dwarf> listaDeDwarvesEsperada = new ArrayList<>();
        ArrayList <Dwarf> listaDeDwarves = new ArrayList<>();
        listaDeDwarvesEsperada.add(gimli);
        listaDeDwarvesEsperada.add(anao);
        listaDeDwarvesEsperada.add(terceiro);

        dwarves.adicionarDwarf(gimli);
        dwarves.adicionarDwarf(anao);
        dwarves.adicionarDwarf(terceiro);

        listaDeDwarves = dwarves.getDwarves();


        assertEquals(listaDeDwarvesEsperada, listaDeDwarves);
    }
}
