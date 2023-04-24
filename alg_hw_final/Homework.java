public class Homework {

    // 1. Реализовать поиск максимального элемента в дереве. Метод назвать findLast
    // 2. Реализовать подсчет листьев. Листья - это такие узлы дерева, у которых нет дочерних элементов. Метод назвать getChildrenCount
    // 3. *Реализовать проверку, является ли дерево сбалансированным. Метод назвать isBalanced() и он должен возвращать true\false
    // Дерево назвается сбалансированным, если высота левого и правого поддерева отличается не больше, чем на 1
    // Для каждого корня проверить сбалансированность левого и правого подеревьев
    // isBalanced() {
    //   return isBalanced(root.left) && isBalanced(root.right)
    //   && Math.abs(height(root.left) - height(root.right)) <= 1
    // }
    // private int height(Node current) {
    //      // вот это нужно реализовать
    // }

    //             8
    //      6             10
    //  3
    //1

    private Tree ourTree;

    public Homework(Tree ourTree) {
        this.ourTree = ourTree;
    }

    public Tree getOurTree() {
        return ourTree;
    }

    public int findLast(){
        Tree.Node node = ourTree.getRoot();
        if (node == null) {
            return 0;
        }
        while (node.getRight() != null){
            node = node.getRight();
        }
        return node.getValue();
    }

    public int countLeafs(Tree.Node currentNode){
        if (currentNode == null) {
            return 0;
        }
        if (currentNode.getRight() == null && currentNode.getLeft() == null) {
            return 1;
        }
        return countLeafs(currentNode.getRight())+countLeafs(currentNode.getLeft());
    }

}