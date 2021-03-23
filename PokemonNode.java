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
public class PokemonNode {
    protected boolean isBlack;
    protected Pokemon pokemon;
    protected PokemonNode parent;
    protected PokemonNode leftChild;
    protected PokemonNode rightChild;

    /**constructor
     *
     * @param pokemon instance of pokemon
     * @param color red or black false or true
     * @param parent parent node
     * @param leftChild left child node
     * @param rightChild right child node
     */
    public PokemonNode(Pokemon pokemon, boolean color, PokemonNode parent, PokemonNode leftChild, PokemonNode rightChild) {
        this.pokemon = pokemon;
        this.isBlack = color;
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    /**
     *
     * @param pokemon instnace of pokemon
     */
    public PokemonNode(Pokemon pokemon) {
        this.pokemon = pokemon;
        this.isBlack =false;
    }
    /**constructor
     *
     * @param pokemon instance of pokemon
     * @param parent parent node
     * @param leftChild left child node
     * @param rightChild right child node
     */
    public PokemonNode(Pokemon pokemon, PokemonNode parent, PokemonNode leftChild, PokemonNode rightChild) {
        this.pokemon = pokemon;
        this.isBlack = false;
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
    //getter
    public Pokemon getPokemon() {
        return pokemon;
    }
    //setter
    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }
    //setter
    public boolean isColor() {
        return isBlack;
    }
    //setter
    public void setColor(boolean color) {
        this.isBlack = color;
    }
    //getter
    public PokemonNode getParent() {
        return parent;
    }
    //setter
    public void setParent(PokemonNode parent) {
        this.parent = parent;
    }
    //getter
    public PokemonNode getLeftChild() {
        return leftChild;
    }
    //setter
    public void setLeftChild(PokemonNode leftChild) {
        this.leftChild = leftChild;
    }
    //getter
    public PokemonNode getRightChild() {
        return rightChild;
    }
    //setter
    public void setRightChild(PokemonNode rightChild) {
        this.rightChild = rightChild;
    }

    /**
     *
     * @return returns a string interpretation of a pokemon node
     */
    @Override
    public String toString() {
       String foo  = "" ;
       foo+= pokemon +"\n";
       foo+= this.getLeftChild().pokemon +"       "+ this.getRightChild().getPokemon();
       return foo;
    }
}
