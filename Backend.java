/**
 * // --== CS400 File Header Information ==--
 * // Name: Alexander Dudin
 * // Email: dudin@wisc.edu
 * // Team: Red
 * // Group: GG
 * // TA: Surabhi
 * // Lecturer: Gary Dahl
 * // Notes to Grader: n/a
 */
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the Backend class, this class acts like the interface for the front end class and the red black tree of our data.
 * this class allows such actions like get, add, display all in range and display all of type and remove
 */
public class Backend {
    private List<Pokemon> pokemon;
    private List<Pokemon> pokemonAdded;
    protected PokemonRedBlacktree tree;

    /**
     * constructor for the class calls pokemon data reader
     */
    public Backend()  {
        this.tree = new PokemonRedBlacktree();
        this.pokemonAdded = new ArrayList<Pokemon>();
        PokemonDataReader reader = new PokemonDataReader();
        Reader read = null;
        try {
           read = new FileReader("src/PokemonData.csv");
        }catch (Exception e){
            System.out.println("foo");
        }
        try {
            this.pokemon = reader.readDataSet(read);
        }catch (Exception e){

        }

    }

    /**
     *
     * @param id adds based on id number
     * @return true if added
     */
    public boolean add(int id){
        if(id>0 && id<808){
            int index = id-1;
            tree.insert(pokemon.get(index));
            pokemonAdded.add(pokemon.get(index));
            return true;
        }
        return false;
    }

    /**
     *
     * @return true if added
     */
    public boolean addAll(){
        this.tree = new PokemonRedBlacktree();
        for(Pokemon p: pokemon){
            tree.insert(p);
        }
        return true;
    }

    /**
     *
     * @param p Instance of pokemon
     * @return true if removed
     */
    public boolean remove(Pokemon p){
        this.tree = new PokemonRedBlacktree();
        pokemonAdded.remove(p);
        for(Pokemon x: pokemonAdded){
            tree.insert(x);
        }
        return true;
    }

    /**
     *
     * @param order pokedex order
     * @return the pokemon that corresponds
     */
    public Pokemon lookUp(int order){
        return tree.lookup(order);
    }

    /**
     *
     * @param start starting index of the pokemon
     * @param end index of the pokemon
     * @return
     */
    public ArrayList<Pokemon> displayAllInRange(int start,int end){
        ArrayList<Pokemon> pokemonsInRange = new ArrayList<>();
        for(int  i = start; i<=end;i++){
            try {
                pokemonsInRange.add(lookUp(i));
            }catch (Exception e){
                continue;
            }
        }
        return pokemonsInRange;
    }

    /**
     *
     * @param pokemon instance of pokemon to be added
     * @return true if sucessfull
     */
    public boolean add(Pokemon pokemon){
        return tree.insert(pokemon);
    }

    /**
     *
     * @param order pokedex order
     * @return an instance of pokemon
     */
    public Pokemon get(int order){
        return tree.get(order,tree.root).pokemon;
    }

    /**
     *
     * @param order pokedex order
     * @return an instance of pokemon node
     */
    public PokemonNode getNode(int order){
        return tree.get(order,tree.root);
    }

    /**
     *
     * @param type type of the pokemon
     * @return arraylist of all the pokemon of that type
     */
    public ArrayList<Pokemon> allOfType(String type){
        ArrayList<Pokemon> listOfMatches = new ArrayList<>();
        for(Pokemon p:pokemon){
            if(p.getType().equals(type)){
                listOfMatches.add(p);
            }
        }
        return listOfMatches;
    }
}
