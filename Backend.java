import java.net.PortUnreachableException;
import java.util.ArrayList;

public class Backend {
    private ArrayList<Pokemon> pokemon;
    private PokemonRedBlacktree tree;
    public Backend(ArrayList<Pokemon> pokemons) {
        this.tree = new PokemonRedBlacktree();
        this.pokemon =pokemons;
        for(Pokemon pokemon :pokemon){
            tree.insert(pokemon);
        }
    }
    public void remove(Pokemon p){
        this.pokemon.remove(p);
        for(Pokemon pokemon :pokemon){
            tree.insert(pokemon);
        }
    }
    public Pokemon lookUp(int order){
        return tree.lookup(order);
    }
    public Pokemon get(Pokemon data){
        PokemonNode pokemonNode = tree.get(data,tree.root);
        return pokemonNode.getPokemon();
    }
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
}
