public class Pokemon implements Comparable {
    int pokedexOrder;
    String name;
    int species_id;
    int height;
    int weight;

    public Pokemon(int pokedexOrder, String name, int species_id, int height, int weight) {
        this.pokedexOrder = pokedexOrder;
        this.name = name;
        this.species_id = species_id;
        this.height = height;
        this.weight = weight;
    }

    public int getPokedexOrder() {
        return pokedexOrder;
    }

    public String getName() {
        return name;
    }

    public int getSpecies_id() {
        return species_id;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "pokedexOrder=" + pokedexOrder +
                ", name='" + name  +
                ", species_id=" + species_id +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o.getClass().equals(Pokemon.class)){
            Pokemon comparing = (Pokemon) o;
            if(this.pokedexOrder >comparing.pokedexOrder ){
                return 1;
            }else if(this.pokedexOrder ==comparing.pokedexOrder ){
                return 0;
            }else{
                return -1;
            }
        }else {
            throw new  IllegalArgumentException("not a pokemon");
        }
    }
}
