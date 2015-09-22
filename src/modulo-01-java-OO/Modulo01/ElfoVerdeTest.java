

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoVerdeTest{

  @Test
  public void elfoVerdeAtiraFlechaEmDwarf() {
      // Arrange
      ElfoVerde elfoVerde = new ElfoVerde("Elfo caçador");
      Dwarf balin = new Dwarf();
      int qtdFlechasEsperada = 41;
      int experienciaEsperada = 2;
      int vidaEsperada = 100;
      // Act
      elfoVerde.atirarFlecha(balin);
      // Assert
      assertEquals(qtdFlechasEsperada, elfoVerde.getFlechas());
      assertEquals(experienciaEsperada, elfoVerde.getExperiencia());
      assertEquals(vidaEsperada, balin.getVida());
  }

}
