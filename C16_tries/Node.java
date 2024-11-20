package C16_tries;
import java.util.*;
public class Node {
    char data;
    HashMap<Character, Node> children;
    boolean isTerminal;
    public Node(char data) {
        this.data = data;
        isTerminal = false;
        children= new HashMap<>();
    }
}
