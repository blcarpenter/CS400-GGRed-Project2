import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class BackEndDeveloperTests {
    Backend backend;

    /**
     * sets up the instances of backend
     */
    @Before
    public void setup(){
        this.backend = new Backend();
    }
    @Test
    /**
     * checks to see if the .get method will work
     */
    public void testGet(){
        Pokemon toAdd = new Pokemon(5,"pikachu","electric",15,10);
        backend.add(toAdd);
        Object PokemonNode = backend.get(5);
        assertEquals(toAdd,PokemonNode);
    }

    /**
     * checks to see if the .add method will work
     */
    @Test
    public void testAdd(){
        Pokemon toAdd = new Pokemon(5,"pikachu","electric",15,10);
        boolean added = false;
        backend.add(toAdd);
        if(backend.tree.root.pokemon.equals(toAdd)){
            added =true;
        }
        assertTrue(added);
        Pokemon addAgain = new Pokemon(2, "Electrobuzz","electric",15,10);
        backend.add(addAgain);
        if(!backend.tree.root.getLeftChild().pokemon.equals(addAgain)){
            added =false;
        }
        assertTrue(added);
    }
    /**
     * checks to see if the .add method will prompt an auto left rotate
     */
    @Test
    public void testAutoLeftRotate(){
        Pokemon toAdd = new Pokemon(5,"pikachu","electric",15,10);
        Pokemon addAgain = new Pokemon(6, "Electrobuzz","electric",15,10);
        Pokemon addToRotate = new Pokemon(7, "charmander","fire",15,10);
        backend.add(toAdd);
        backend.add(addAgain );
        backend.add(addToRotate);
        Pokemon verdict = backend.tree.root.pokemon;
        assertEquals(addAgain,verdict);
    }
    /**
     * checks to see if the .add method will prompt an auto color change
     */
    @Test
    public void testAutoColorSwap(){
        Pokemon toAdd = new Pokemon(5,"pikachu","electric",15,10);
        Pokemon addAgain = new Pokemon(7, "Electrobuzz","electric",15,10);
        Pokemon addAgain2 = new Pokemon(3, "squirtle","water",15,10);
        Pokemon addToRotate = new Pokemon(6, "charmander","fire",15,10);
        backend.add(toAdd);
        backend.add(addAgain);
        backend.add(addAgain2);
        backend.add(addToRotate);
        boolean verdict =backend.tree.root.getLeftChild().isBlack;
        boolean color =  backend.getNode(7).isBlack;
        assertEquals(verdict,color);
    }
    /**
     * checks to see if the .add method will prompt an auto right rotate
     */
    @Test
    public void testAutoRightRotate(){
        Pokemon toAdd = new Pokemon(5,"pikachu","electric",15,10);
        Pokemon addAgain = new Pokemon(2, "Electrobuzz","electric",15,10);
        Pokemon addToRotate = new Pokemon(1, "charmander","fire",15,10);
        backend.add(toAdd);
        backend.add(addAgain );
        backend.add(addToRotate);
        Pokemon verdict = backend.tree.root.pokemon;
        assertEquals(addAgain,verdict);
    }

    @After
    public void cleanup(){
        backend = null;
    }
}



