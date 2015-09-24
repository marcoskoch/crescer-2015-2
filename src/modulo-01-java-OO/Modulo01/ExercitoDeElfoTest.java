
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import java.util.ArrayList;

public class ExercitoDeElfoTest {

    @Test
    public void exercitoAlistaUmElfoVerde(){
        ExercitoDeElfo exercito = new ExercitoDeElfo();
        ElfoVerde elfo = new ElfoVerde("Lanterna Verde");
        exercito.alistarUmElfo(elfo);
        assertEquals(elfo, exercito.getExercito().get("Lanterna Verde"));
    }

    @Test
    public void exercitoAlistaUmElfoNoturno(){
        ExercitoDeElfo exercito = new ExercitoDeElfo();
        ElfoNoturno elfo = new ElfoNoturno("Blade");
        exercito.alistarUmElfo(elfo);
        assertEquals(elfo, exercito.getExercito().get("Blade"));
    }

    @Test
    public void exercitoAlistaUmElfoNoturnoEUmElfoVerde(){
        ExercitoDeElfo exercito = new ExercitoDeElfo();
        ElfoNoturno elfo = new ElfoNoturno("Blade");
        ElfoVerde elfo2 = new ElfoVerde("Lanterna Verde");
        exercito.alistarUmElfo(elfo);
        exercito.alistarUmElfo(elfo2);

        HashMap <String,Elfo> exercitoEsperado = new HashMap<>();
        exercitoEsperado.put("Blade", elfo);
        exercitoEsperado.put("Lanterna Verde", elfo2);

        assertEquals(exercitoEsperado, exercito.getExercito());
    }

    @Test
    public void buscaElfoNoExercitoPorNome(){
        ExercitoDeElfo exercito = new ExercitoDeElfo();
        ElfoNoturno elfo = new ElfoNoturno("Blade");
        ElfoVerde elfo2 = new ElfoVerde("Lanterna Verde");
        exercito.alistarUmElfo(elfo);
        exercito.alistarUmElfo(elfo2);

        assertEquals(elfo, exercito.getElfoNoExercitoPorNome("Blade"));
    }

}
