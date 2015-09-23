

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ElfoNoturnoTest {

    @Test
    public void elfoNoturnoAtiraFlechaEmDwarf() {
        // Arrange
        ElfoNoturno elfo = new ElfoNoturno("Elfo caçador");
        Dwarf balin = new Dwarf();
        int qtdFlechasEsperada = 41;
        int experienciaEsperada = 3;
        int vidaEsperadaElfo = 95;
        // Act
        elfo.atirarFlecha(balin);
        // Assert
        assertEquals(qtdFlechasEsperada, elfo.getFlechas());
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(vidaEsperadaElfo, elfo.getVida());
    }
    /*
    @Test
    public void elfoNoturnoAtiraFlechaEmDwarf() {
        // Arrange
        ElfoNoturno elfo = new ElfoNoturno("Elfo caçador");
        Dwarf balin = new Dwarf();
        int qtdFlechasEsperada = 39;
        int experienciaEsperada = 9;
        int vidaEsperadaElfo = 85;
        // Act
        for(int i = 0; i < 45; i++){
            elfo.atirarFlecha(balin);
        }
        int vidaElfo = elfo.getVida();
        // Assert
        assertEquals(qtdFlechasEsperada, elfo.getFlechas());
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(vidaEsperadaElfo, elfo.getVida());
    }
    */

}
