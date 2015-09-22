import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IrishDwarfTest
{
    @Test
    public void irishDwarfNasceCom110DeVida() {
        IrishDwarf gimli = new IrishDwarf();
        assertEquals(110, gimli.getVida());
    }

    @Test
    public void irishDwarfNasceVivo() {
        IrishDwarf balin = new IrishDwarf();
        assertEquals(Status.VIVO, balin.getStatus());
    }

    @Test
    public void irishDwarfNasceCom0DeExperiencia() {
        IrishDwarf balin = new IrishDwarf();
        assertEquals(0, balin.getExperiencia());
    }

    @Test
    public void irishDwarfNasceComDataNascimentoPadrão() {
        IrishDwarf bofur = new IrishDwarf();
        DataTerceiraEra esperada = new DataTerceiraEra(1,1,1);
        DataTerceiraEra obtida = bofur.getDataNascimento();
        assertEquals(esperada, obtida);
    }

    @Test
    public void irishDwarfNasceComNomeEDataDeNascimento() {
        DataTerceiraEra esperada = new DataTerceiraEra(12,11,1987);
        IrishDwarf bernardin = new IrishDwarf("Bernardin", new DataTerceiraEra(12, 11, 1987));
        assertEquals(esperada, bernardin.getDataNascimento());
        assertEquals("Bernardin", bernardin.getNome());
    }

    @Test
    public void irishDwarfNasceComNome() {
        IrishDwarf oin = new IrishDwarf("Oin II");
        assertEquals("Oin II", oin.getNome());
    }

    @Test
    public void irishDwarfRecebeFlechaEPerde10Vida() {
        // AAA
        // Arrange
        IrishDwarf gimli = new IrishDwarf();
        int vidaEsperada = 100;
        // Act
        gimli.receberFlechada();
        // Assert
        assertEquals(vidaEsperada, gimli.getVida());
    }

    @Test
    public void irishDwarfRecebeFlecha11VezesEVidaÉ0() {
        IrishDwarf gimli = new IrishDwarf();
        int vidaEsperada = 0;
        // Act
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        // Assert
        assertEquals(vidaEsperada, gimli.getVida());
    }

    @Test
    public void irishDwarfRecebeFlecha7VezesEVidaÉ40() {
        IrishDwarf gimli = new IrishDwarf();
        int vidaEsperada = 40;
        // Act
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        // Assert
        assertEquals(vidaEsperada, gimli.getVida());
    }

    @Test
    public void irishDwarfRecebeFlecha5VezesESobrevive() {
        IrishDwarf gimli = new IrishDwarf();
        // Act
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        // Assert
        assertEquals(Status.VIVO, gimli.getStatus());
    }

    @Test
    public void irishDwarfRecebeFlecha12VezesEMorre() {
        IrishDwarf gimli = new IrishDwarf();
        // Act
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        // Assert
        assertEquals(Status.MORTO, gimli.getStatus());
    }

    @Test
    public void irishDwarfRecebeFlecha13VezesEVidaFicaZerada() {
        IrishDwarf gimli = new IrishDwarf();
        // Act
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        // Assert
        assertEquals(0, gimli.getVida());
    }

    @Test
    public void gerarNumeroAnoBissextoVidaEntre80e90() {
        // Arrange
        IrishDwarf uru = new IrishDwarf("Uru", new DataTerceiraEra(01, 01, 2016));
        uru.receberFlechada();
        uru.receberFlechada();
        uru.receberFlechada();
        // Act
        double resultado = uru.gerarNumero();
        // Assert
        assertEquals(-3333.0, resultado, 0.00001);
    }

    @Test
    public void gerarNumeroAnoNaoBissextoNomeSeixas() {
        // Arrange
        IrishDwarf seixas = new IrishDwarf("Seixas", new DataTerceiraEra(01, 01, 2015));
        // Act
        double resultado = seixas.gerarNumero();
        // Assert
        assertEquals(33.0, resultado, 0.00001);
    }

    @Test
    public void gerarNumeroSemEntrarNasCondicoes() {
        // Arrange
        IrishDwarf balin = new IrishDwarf();
        // Act
        double resultado = balin.gerarNumero();
        // Assert
        assertEquals(101.0, resultado, 0.00001);
    }

    @Test
    public void irishDwarfRecebeFlechaComNumeroSorteNegativo() {
        // Arrange
        IrishDwarf IrishDwarf = new IrishDwarf("Gimli", new DataTerceiraEra(1,1,2000));
        IrishDwarf.receberFlechada();
        IrishDwarf.receberFlechada();
        // Act
        IrishDwarf.receberFlechada();
        // Assert
        assertEquals(2, IrishDwarf.getExperiencia());
        assertEquals(90, IrishDwarf.getVida());
    }

    @Test
    public void irishDwarfReceberFlechadaComAnoNormalMeireles() {
        IrishDwarf meireles = new IrishDwarf("Meireles", new DataTerceiraEra(2, 3, 2015));
        meireles.receberFlechada();
        assertEquals(0, meireles.getExperiencia());
        assertEquals(110, meireles.getVida());
    }

    @Test
    public void irishDwarfReceberFlechadaNormal(){
        IrishDwarf IrishDwarf = new IrishDwarf();
        IrishDwarf.receberFlechada();
        assertEquals(100, IrishDwarf.getVida());
        assertEquals(0, IrishDwarf.getExperiencia());
    }
    
    @Test
    public void irishDwarfComSorte() {
        IrishDwarf dwarf = new IrishDwarf("Leprechaun sortudo", new DataTerceiraEra(1, 1, 2000));
        dwarf.receberFlechada();
        dwarf.receberFlechada();
        dwarf.adicionarItem(new Item(5, "Lança"));
        dwarf.adicionarItem(new Item(25, "Poção"));
        
        Inventario esperado = new Inventario();
        esperado.adicionarItem(new Item(15005, "Lança"));
        esperado.adicionarItem(new Item(325025, "Poção"));
        
        dwarf.tentarSorte();
        
        assertEquals(esperado, dwarf.getInventario());
    }
}
