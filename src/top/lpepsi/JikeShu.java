package top.lpepsi;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 林北
 * @description 二叉树
 * @date 2021-03-31 12:37
 */

public class JikeShu {
    private Node root;

    public JikeShu(Node root) {
        this.root = root;
    }

    /**
     * @Author 林北
     * @Description //TODO 初始化二叉树
     * @Param []
     * @return void
     **/
    private void initShu(){
        Node tempL = root;
        Node tempR = root;
        for (int i = 1; i < 9; i++){
            if (i%2==0){
                Node left = new Node(i);
                tempL.setLeft(left);
                tempL = tempL.getLeft();
            }else{
                Node right = new Node(i);
                tempR.setRight(right);
                tempR = tempR.getRight();
            }
        }
    }

    /**
     * @Author 林北
     * @Description //TODO 前序遍历
     * @Param [root]
     * @return void
     **/

    private void qianXu(Node node){
        if (node == null){
            return;
        }
        System.out.print(node.getData());
        qianXu(node.getLeft());
        qianXu(node.getRight());
    }

    /**
     * @Author 林北
     * @Description //TODO 中序遍历
     * @Param [node]
     * @return void
     **/
    private void zhongXu(Node node){
        if (node == null){
            return;
        }
        zhongXu(node.getLeft());
        System.out.print(node.getData());
        zhongXu(node.getRight());
    }

    /**
     * @Author 林北
     * @Description //TODO 后序遍历
     * @Param [node]
     * @return void
     **/

    private void houXu(Node node){
        if (node == null){
            return;
        }
        houXu(node.getLeft());
        houXu(node.getRight());
        System.out.print(node.getData());
    }

    /**
     * @Author 林北
     * @Description //TODO 层级遍历
     * @Param [node]
     * @return void
     **/

    private void cengXu(Node  node){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (queue.size() > 0){
            Node pop = queue.poll();
            System.out.print(pop.getData());
            if (pop.getRight() != null){
                queue.offer(pop.getRight());
            }
            if (pop.getLeft() != null){
                queue.offer(pop.getLeft());
            }
        }
    }
    public static void main(String[] args) {
        Node root = new Node(0);
        JikeShu shu = new JikeShu(root);
        shu.initShu();
        System.out.println(root.toString());
        System.out.println("前序遍历: ");
        shu.qianXu(root);
        System.out.println("\n中序遍历: ");
        shu.zhongXu(root);
        System.out.println("\n后序遍历");
        shu.houXu(root);
        System.out.println("\n层级遍历");
        shu.cengXu(root);
    }
}

/**
 * @author 林北
 * @description 节点
 * @date 2021-03-31 12:40
 */
class Node{
    private int data;
    /**
     * @Author 林北
     * @Description // 左节点
     **/
    private Node left;
    /**
     * @Author 林北
     * @Description 右节点
     **/
    private Node right;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}