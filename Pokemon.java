// --== CS400 File Header Information ==--
// Name: Tate Riordan
//Contributors : Alex Dudin
// Email: triordan2@wisc.edu
// Team: Red
// Group: GG
// TA: Surabhi
// Lecturer: Gary Dahl
// Notes to Grader: n/a
public class Pokemon implements PokemonInterface {

    private Integer id;
    private String name;
    private String type;
    private Integer weight;
    private Integer height;

    /**
     * Constructor for the pokemon class
     * @param id
     * @param name
     * @param type
     * @param height
     * @param weight
     */
    public Pokemon(Integer id, String name, String type, Integer height, Integer weight) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.weight = weight;
        this.height = height;
    }

    /**
     * returns the id of the pokemon
     */
    @Override
    public Integer getID() {
        return this.id;
    }

    /**
     * returns the name of the pokemon
     */
    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return this.name;
    }

    /**
     * returns the type of the pokemon
     */
    @Override
    public String getType() {
        // TODO Auto-generated method stub
        return this.type;
    }

    /**
     * returns the weight of the pokemon
     */
    @Override
    public Integer getWeight() {
        // TODO Auto-generated method stub
        return this.weight;
    }

    /**
     * returns the height of the pokemon
     */
    @Override
    public Integer getHeight() {
        // TODO Auto-generated method stub
        return this.height;
    }

    /**
     * returns the compareTo value of the two pokemons based on id
     */
    @Override
    public int compareTo(PokemonInterface otherPokemon) {
        // TODO Auto-generated method stub
        if (this.name.equals(otherPokemon.getName())) {
            return 0;
        } else if (this.id < otherPokemon.getID()) {
            return -1;
        } else {
            return 1;
        }

    }
    @Override
    public String toString(){
        String s =  "";
        s+= this.id+"| name |"+this.name +"| type |"+this.getType()+"| height |"+this.height+"| weight |"+this.weight;
        return s;
    }
}