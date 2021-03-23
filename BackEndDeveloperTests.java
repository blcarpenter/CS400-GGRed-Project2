import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class BackEndDeveloperTests {
    Backend backend;
    Object pokemonList;

    /**
     * sets up the instances of backend
     */
    @Before
    public void setup(){
        //LinkedList<PokemonNode> pokemon = new PokemonDataReader(File f);
        this.backend = new Backend();
    }
    @Test
    /**
     * checks to see if the .get method will work
     */
    public void testGet(){
        Pokemon toAdd = new  Pokemon(1,"pikachu",15,10,12);
        backend.add(toAdd);
        Object PokemonNode = backend.get(1);
        assertEquals(toAdd,PokemonNode);
    }

    /**
     * checks to see if the .add method will work
     */
    @Test
    public void testAdd(){
        Pokemon toAdd = new Pokemon(2,"pikachu",15,10,12);
        boolean added = false;
        backend.add(toAdd);
        if(backend.tree.root.pokemon.equals(toAdd)){
            added =true;
        }
        assertTrue(added);
        Pokemon addAgain = new Pokemon(1, "Electrobuzz",3,10,12);
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
        Pokemon toAdd = new Pokemon(5,"pikachu",15,10,12);
        Pokemon addAgain = new Pokemon(6, "Electrobuzz",3,10,12);
        Pokemon addToRotate = new Pokemon(7, "charmander",3,10,12);
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

        Pokemon toAdd = new Pokemon(5,"pikachu",15,10,12);
        Pokemon addAgain = new Pokemon(7, "Electrobuzz",3,10,12);
        Pokemon addAgain2 = new Pokemon(3, "squirtle",3,10,12);
        Pokemon addToRotate = new Pokemon(6, "charmander",3,10,12);
        backend.add(toAdd);
        backend.add(addAgain );
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
        Pokemon toAdd = new Pokemon(5,"pikachu",15,10,12);
        Pokemon addAgain = new Pokemon(2, "Electrobuzz",3,10,12);
        Pokemon addToRotate = new Pokemon(1, "charmander",3,10,12);
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



