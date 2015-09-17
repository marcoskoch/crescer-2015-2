

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ElfoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ElfoTest
{
    @Test
    public void elfoConstrutorFlecha(){
    	Elfo legolas = new Elfo("legolas", 50);
    	assertEquals(50, legolas.getFlechas());
    	assertEquals(0, legolas.getExp());
    }
    
    @Test
    public void elfoFlechasDefault(){
    	Elfo legolas = new Elfo("legolas");
    	assertEquals(42, legolas.getFlechas());
    	assertEquals(0, legolas.getExp());
    }
    
    @Test
    public void elfoAtiraFlecha(){
    	Elfo legolas = new Elfo("legolas");
    	Dwarf gimli = new Dwarf();
    	int nFlechas = legolas.getFlechas();
    	int nExp = legolas.getExp();
    	legolas.atirarFlecha(gimli);
    	int n2Flechas = legolas.getFlechas();
    	int n2Exp = legolas.getExp();
    	assertEquals(nFlechas - 1, n2Flechas);
    	assertEquals(nExp + 1, n2Exp);
    }
}
