

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
        legolas.atirarFlecha(new Dwarf());
        assertEquals(41, legolas.getFlechas());
        assertEquals(1, legolas.getExp());
    }
}
