

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

    @Test
    public void elfoNoturnoAtiraMuitasFlechasEMorre() {
        // Arrange
        ElfoNoturno elfo = new ElfoNoturno("Elfo caçador");
        Dwarf balin = new Dwarf();
        int vidaEsperadaElfo = 0;
        // Act
        for(int i = 0; i < 45; i++){
            elfo.atirarFlecha(balin);
        }
        // Assert
        assertEquals(vidaEsperadaElfo, elfo.getVida());
        assertEquals(Status.MORTO, elfo.getStatus());
    }


}
