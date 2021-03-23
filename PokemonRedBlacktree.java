import java.util.NoSuchElementException;

public class PokemonRedBlacktree {

    /**
     * This class implements a binary search tree (BST) which stores a set of
     * Pokemons. The left subtree contains the Pokemons who are less powerful than
     * the Pokemon stored at a parent node. The right subtree contains the Pokemons
     * who are more powerful than the Pokemon stored at a parent node.
     *
     */
        public PokemonNode root; // root of this binary search tree
        private int size; // total number of Pokemons stored in this tree.

        /**
         * Checks whether this binary search tree (BST) is empty
         *
         * @return true if this PokemonTree is empty, false otherwise
         */
        public boolean isEmpty() {
            if(root == null&& size ==0){
                return true;
            }
            return false;
        }

        /**
         * Returns the number of Pokemons stored in this BST.
         *
         * @return the size of this PokemonTree
         */
        public int size() {
            return size;
        }

    /**
     * Recursive helper method to find the subtree with a null reference in the
     * position that the newNode should be inserted, and then extend this tree
     * by the newNode in that position.
     * @param newNode is the new node that is being added to this tree
     * @param subtree is the reference to a node within this tree which the
     *      newNode should be inserted as a descenedent beneath
     * @return true is the value was inserted in subtree, false if not
     */
    private boolean insertHelper(PokemonNode newNode, PokemonNode subtree) {
        int compare = newNode.pokemon.compareTo(subtree.pokemon);
        // do not allow duplicate values to be stored within this tree
        if(compare == 0) return false;

            // store newNode within left subtree of subtree
        else if(compare < 0) {
            if(subtree.leftChild == null) { // left subtree empty, add here
                subtree.leftChild = newNode;
                newNode.parent = subtree;
                enforceRBTreePropertiesAfterInsert(newNode);
                return true;
                // otherwise continue recursive search for location to insert
            } else return insertHelper(newNode, subtree.leftChild);
        }

        // store newNode within the right subtree of subtree
        else {
            if(subtree.rightChild == null) { // right subtree empty, add here
                subtree.rightChild = newNode;
                newNode.parent = subtree;
                enforceRBTreePropertiesAfterInsert(newNode);
                return true;
                // otherwise continue recursive search for location to insert
            } else return insertHelper(newNode, subtree.rightChild);
        }
    }
    /**
     * Performs the rotation operation on the provided nodes within this tree.
     * When the provided child is a leftChild of the provided parent, this
     * method will perform a right rotation. When the provided child is a
     * rightChild of the provided parent, this method will perform a left rotation.
     * When the provided nodes are not related in one of these ways, this method
     * will throw an IllegalArgumentException.
     * @param child is the node being rotated from child to parent position
     *      (between these two node arguments)
     * @param parent is the node being rotated from parent to child position
     *      (between these two node arguments)
     * @throws IllegalArgumentException when the provided child and parent
     *      node references are not initially (pre-rotation) related that way
     */
    protected void rotate(PokemonNode child,PokemonNode parent) throws IllegalArgumentException {
        if(parent.leftChild!= null&&parent.leftChild.equals(child)){
            rightRotate(child,parent);
        }else if(parent.rightChild!= null&&parent.rightChild.equals(child)){
            leftRotate(child,parent);
        }else{
            throw new IllegalArgumentException("The child and parent are not related");
        }
    }

    /**
     * enforces the red black tree properties
     * @param newRedNode
     */
    private void enforceRBTreePropertiesAfterInsert(PokemonNode newRedNode){
        PokemonNode parent = newRedNode.parent;//sets parent
        PokemonNode grandparent = parent.parent;//sets grandparent
        PokemonNode uncle;
        //checks if the parent is black
        if(newRedNode.parent.isBlack) {

        }else {
            //sets uncle
            if (grandparent.rightChild != null && grandparent.rightChild.equals(parent)) {
                uncle = grandparent.leftChild;
            } else {
                uncle = grandparent.rightChild;
            }
            //if the unlce is not null
            if (uncle != null) {
                //if the uncle is red
                if (!uncle.isBlack) {// do a color swap
                    parent.isBlack = true;
                    uncle.isBlack = true;
                    grandparent.isBlack = false;
                    if (!grandparent.equals(root)) {
                        enforceRBTreePropertiesAfterInsert(grandparent);
                    } else {
                        grandparent.isBlack = true;
                    }
                } else {//if uncle is is black
                    rotateUncRed(parent, grandparent, uncle, newRedNode);
                }
            } else {//if the uncle is null
                rotateUncRed(parent, grandparent, uncle, newRedNode);
            }
        }
    }

    /**
     *
     * @param parent parent node of newRedNode
     * @param grandparent grandparent node of newRedNode
     * @param uncle uncle of newRedNode
     * @param newRedNode the newly added node
     */
    private void rotateUncRed(PokemonNode parent,PokemonNode grandparent,PokemonNode uncle,PokemonNode newRedNode){
        //left left case
        if(parent.leftChild != null && grandparent.leftChild!= null&&parent.leftChild.equals(newRedNode) &&grandparent.leftChild.equals(parent)){
            rotate(parent,grandparent);
            parent.isBlack = !parent.isBlack;
            grandparent.isBlack = !grandparent.isBlack;
            //left right case
        }else if(grandparent.leftChild!= null&&parent.rightChild!= null&& parent.rightChild.equals(newRedNode) &&grandparent.leftChild.equals(parent)){
            rotate(newRedNode,parent);
            rotate(newRedNode,grandparent);
            parent.isBlack = !parent.isBlack;
            grandparent.isBlack = !grandparent.isBlack;
            newRedNode.isBlack = true;
            //right right case
        }else if(grandparent.rightChild!= null&&parent.rightChild!= null&& parent.rightChild.equals(newRedNode) &&grandparent.rightChild.equals(parent)){
            rotate(parent,grandparent);
            parent.isBlack = !parent.isBlack;
            grandparent.isBlack = !grandparent.isBlack;
            //right left case
        }else if(grandparent.rightChild!= null&&parent.leftChild!= null&& parent.leftChild.equals(newRedNode) &&grandparent.rightChild.equals(parent)){
            rotate(newRedNode,parent);
            rotate(newRedNode,grandparent);
            parent.isBlack = !parent.isBlack;
            grandparent.isBlack = !grandparent.isBlack;
            newRedNode.isBlack = true;
        }
    }
        /**
         * Adds a new Pokemon to this PokemonTree
         *
         * @param data a new Pokemon to add to this BST.
         * @return true if the new was successfully added to this BST, and returns false
         *         if there is a match with this Pokemon already already stored in this
         *         BST.
         */
        public boolean insert(Pokemon data) throws NullPointerException, IllegalArgumentException {
            // null references cannot be stored within this tree
            if(data == null) throw new NullPointerException(
                    "This RedBlackTree cannot store null references.");

            PokemonNode newNode = new PokemonNode(data);
            if(root == null) {
                root = newNode;
                size++;
                root.isBlack = true;
                return true;
            } // add first node to an empty tree
            else{
                boolean returnValue = insertHelper(newNode,root); // recursively insert into subtree
                if (returnValue) size++;
                else throw new IllegalArgumentException(
                        "This RedBlackTree already contains that value.");
                return returnValue;
            }
        }
    /**
     * preforms a right rotation
     * @param child child node
     * @param parent parent node
     */
    private void rightRotate(PokemonNode child, PokemonNode parent){
        PokemonNode pTemp = parent;
        //checks if it is the root
        if (parent.parent!= null) {
            //if parent is the right child
            if (parent.parent.rightChild.equals(parent)) {
                parent.leftChild =null;
                parent.parent.rightChild = child;
                parent.parent = child;
                child.rightChild= parent;
            } else {
                parent.leftChild =null;
                parent.parent.leftChild = child;
                parent.parent = child;
                child.rightChild= parent;
            }
        }else{
            parent.leftChild =null;
            parent.parent = child;
            child.rightChild= parent;
            root= child;
            child.parent = null;
        }

    }
    /**
     * preforms a left rotation
     * @param child child node
     * @param parent parent node
     */
    private void leftRotate(PokemonNode child, PokemonNode parent){
        PokemonNode pTemp = parent;
        //checks if it is the root
        if (parent.parent!= null) {
            //if parent is the right child
            if (parent.parent.rightChild.equals(parent)) {
                parent.rightChild =null;
                parent.parent.rightChild = child;
                parent.parent = child;
                child.leftChild = parent;
            } else {
                parent.rightChild =null;
                parent.parent.leftChild = child;
                parent.parent = child;
                child.leftChild= parent;
            }
        }
        else{
            parent.rightChild =null;
            parent.parent = child;
            root= child;
            child.leftChild= parent;
            child.parent = null;
        }
    }
        /**
         * Recursive helper method which returns a String representation of the BST
         * rooted at current. An example of the String representation of the contents of
         * a PokemonTree is provided in the description of the above toString() method.
         *
         * @param current reference to the current PokemonNode within this BST.
         * @return a String representation of all the Pokemons stored in the sub-tree
         *         PokemonTree rooted at current in increasing order with respect to the
         *         CP values. Returns an empty String "" if current is
         *         null.
         */
        public static String toStringHelper(PokemonNode current) {
            String result = "";
            //base case if the left is child is null
            if (current.getLeftChild() ==null) {
                result+="";
                //recursive	case keeps going left
            }if(current.getLeftChild()!= null){
                result += toStringHelper(current.getLeftChild());
            }
            //adds self
            result+= current.getPokemon().toString()+"\n";
            //base case to check if the right child is null
            if(current.getRightChild() == null){
                result+="";
            }
            //recursive case to keep going right
            if(current.getRightChild()!= null){
                result+= toStringHelper(current.getRightChild());
            }
            return result;
        }

        /**
         * Returns a String representation of all the Pokemons stored within this BST in
         * the increasing order, separated by a newline "\n". For instance:
         * "[Pikachu CP:123 (A:1 S:2 D:3)]" + "\n" + "[Eevee CP:224 (A:2 S:2 D:4)]" + "\n" +
         * [Lapras CP:735 (A:7 S:3 D:5)] + "\n" + "[Mewtwo CP:999 (A:9 S:9 D:9)]" + "\n"
         *
         * @return a String representation of all the Pokemons stored within this BST
         *         sorted in an increasing order with respect to the CP values.
         *         Returns an empty string "" if this BST is empty.
         */
        public String toString() {
            if(isEmpty()){//if it is empty
                return "";
            }
            //if not it uses a helper method
            return toStringHelper(root);
        }

        /**
         * Search for a Pokemon (Pokemon) given the CP value as lookup key.
         *
         * @param order combat power of a Pokemon
         * @return the Pokemon whose CP value equals our lookup key.
         * @throws NoSuchElementException with a descriptive error message if there is
         *           no Pokemon found in this BST having the provided CP value
         */
        public Pokemon lookup(int order) {
            return lookupHelper(order, root);
        }

        /**
         * Recursive helper method to lookup a Pokemon given a reference Pokemon with
         * the same CP in the subtree rooted at current
         *
         * @param order    a reference to a Pokemon target we are lookup for a match in
         *                the BST rooted at current.
         * @param current "root" of the subtree we are looking for a match to find
         *                within it.
         * @return reference to the Pokemon stored stored in this BST which matches
         *         find.
         * @throws NoSuchElementException with a descriptive error message if there is
         *                                no Pokemon whose CP value matches target value,
         *                                stored in this BST.
         */
        public static Pokemon lookupHelper(int order, PokemonNode current) {
            if(current != null) {// checks if it goes through the entire BST
                Pokemon pokemonRes = null;
                if (current.getPokemon().getPokedexOrder() == order) {//base case if it finds the pokemon
                    pokemonRes =current.getPokemon();
                } else if (current.getPokemon().getPokedexOrder() > order) {//recursive case to go left
                    pokemonRes =lookupHelper(order, current.getLeftChild());
                } else if (current.getPokemon().getPokedexOrder() < order) {//recursive case to go right
                    pokemonRes =lookupHelper(order, current.getRightChild());
                }
                return pokemonRes;
            }
            //throw no such element exception if the pokemon with the cp is not found
            throw new NoSuchElementException("this CP does not exist in this BST");
        }

        /**
         * Computes and returns the height of this BST, counting the number of nodes
         * (PokemonNodes) from root to the deepest leaf.
         *
         * @return the height of this Binary Search Tree
         */
        public int height() {
            return heightHelper(root);
        }

        /**
         * Recursive helper method that computes the height of the subtree rooted at
         * current
         *
         * @param current pointer to the current PokemonNode within a PokemonTree
         * @return height of the subtree rooted at current, counting the number of
         *         PokemonNodes
         */
        public static int heightHelper(PokemonNode current) {
            if (current == null){ // base case whether the current node is null
                return 0;
            }
            else {
                //computes left depth from current node
                int leftDepth= heightHelper(current.getLeftChild());
                //computes right depth from current node
                int rightDepth = heightHelper(current.getRightChild());
                //compares the two
                if (leftDepth > rightDepth)
                    return (leftDepth + 1);
                else {
                    return (rightDepth + 1);
                }
            }
        }
    public PokemonNode get(Pokemon data,PokemonNode current){
        if( current!= null) {// checks if it goes through the entire BST
            PokemonNode node= null;
            if (current.pokemon.equals(data)) {//base case if it finds the pokemon
                node =current;
            } else if (current.pokemon.compareTo(data)==1) {//recursive case to go left
                node =get(data, current.leftChild);
            } else if (current.pokemon.compareTo(data)==-1) {//recursive case to go right
                node =get(data,current.rightChild);
            }
            return node;
        }
        return null;
    }
    public PokemonNode get(int order,PokemonNode current){
        if( current!= null) {// checks if it goes through the entire BST
            PokemonNode node= null;
            if (current.pokemon.getPokedexOrder() == (order)) {//base case if it finds the pokemon
                node =current;
            } else if (current.pokemon.getPokedexOrder()>order) {//recursive case to go left
                node =get(order, current.leftChild);
            } else if (current.pokemon.getPokedexOrder()<order) {//recursive case to go right
                node =get(order,current.rightChild);
            }
            return node;
        }
        return null;
    }


    }
