public class PokemonNode {
    protected boolean isBlack;
    protected Pokemon pokemon;
    protected PokemonNode parent;
    protected PokemonNode leftChild;
    protected PokemonNode rightChild;

    public PokemonNode(Pokemon pokemon, boolean color, PokemonNode parent, PokemonNode leftChild, PokemonNode rightChild) {
        this.pokemon = pokemon;
        this.isBlack = color;
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public PokemonNode(Pokemon pokemon) {
        this.pokemon = pokemon;
        this.isBlack =false;
    }
    public PokemonNode(Pokemon pokemon, PokemonNode parent, PokemonNode leftChild, PokemonNode rightChild) {
        this.pokemon = pokemon;
        this.isBlack = false;
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
        return isBlack;
    }

    public void setColor(boolean color) {
        this.isBlack = color;
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
