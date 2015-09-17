

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste DwarfTest.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class DwarfTest
{
    @Test
    public void dwarfNasceCom110DeVida(){
        Dwarf gimli = new Dwarf("Tosco");
        assertEquals(110, gimli.getVida());
    }
    
    @Test
    public void dwarfLevaFlechada(){
        Dwarf gimli = new Dwarf("Tosco");
        gimli.levaFlechada();
        assertEquals(100, gimli.getVida());
    }
    
    @Test
    public void dwarfComVida0StatusMorto(){
        Dwarf gimli = new Dwarf("Tosco");
        for (int i = 0; i < 11; i++) {
            gimli.levaFlechada();
        }        
        assertEquals(Status.MORTO, gimli.getStatus());
    }
}
