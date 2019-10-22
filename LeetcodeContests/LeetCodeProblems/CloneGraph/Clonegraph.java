class Clonegraph {
    static HashMap<Node,Node> hm = new HashMap<Node,Node>();

    public Node cloneGraph(Node node) {
        Node copy = new Node(node.val, new ArrayList<Node>());
        hm.put(node, copy);
        for(Node n: node.neighbors){
            if(hm.containsKey(n)){
                copy.neighbors.add(hm.get(n));
            }
            else{
                copy.neighbors.add(cloneGraph(n));
            }
        }

        return copy;
    }
}
