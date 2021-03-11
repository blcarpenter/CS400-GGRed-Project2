public class PokemonNode {
    protected Pokemon pokemon;
    protected boolean color; //red is false black is true
    protected PokemonNode parent;
    protected PokemonNode leftChild;
    protected PokemonNode rightChild;

    public PokemonNode(Pokemon pokemon, boolean color, PokemonNode parent, PokemonNode leftChild, PokemonNode rightChild) {
        this.pokemon = pokemon;
        this.color = color;
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public PokemonNode(Pokemon pokemon) {
        this.pokemon = pokemon;
    }
    public PokemonNode(Pokemon pokemon, PokemonNode parent, PokemonNode leftChild, PokemonNode rightChild) {
        this.pokemon = pokemon;
        this.color = false;
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public PokemonNode getParent() {
        return parent;
    }

    public void setParent(PokemonNode parent) {
        this.parent = parent;
    }

    public PokemonNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(PokemonNode leftChild) {
        this.leftChild = leftChild;
    }

    public PokemonNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(PokemonNode rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
       String foo  = "" ;
       foo+= pokemon +"\n";
       foo+= this.getLeftChild().pokemon +"       "+ this.getRightChild().getPokemon();
       return foo;
    }
}
