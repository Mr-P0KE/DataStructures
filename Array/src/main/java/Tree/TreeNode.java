package Tree;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author: Mr_Poke
 * @Date: 2023/5/8 12:40
 * @Description:
 */
public class TreeNode {
    public int val;
    public  TreeNode left;
    public  TreeNode right;

    public TreeNode(int val){
        this.val = val;
    }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
    /**
    * @Author Mr_Poke
    * @Date 14:09 2023/5/8
    * @Description  前序遍历
    * @Param  * @param
    * @Return void
    */
    public static void preOrder(TreeNode node){
        if(node == null)
            return;
        System.out.print(node.val+"\t");
        preOrder(node.left);
        preOrder(node.right);
    }
    public static void preOrder1(TreeNode node){
        LinkedList<TreeNode> list = new LinkedList<>();
        while(node != null || !list.isEmpty()){
           if(node != null){
               System.out.print(node.val+"\t");
               list.push(node);
               node = node.left;
           }else {
               TreeNode r = list.poll();
               node = r.right;
           }
        }
    }
    /**
    * @Author Mr_Poke
    * @Date 14:10 2023/5/8
    * @Description  中序遍历
    * @Param  * @param
    * @Return void
    */
    public static void inOrder(TreeNode node){
        if(node == null)
            return;
        inOrder(node.left);
        System.out.print(node.val+"\t");
        inOrder(node.right);

    }
    public static void inOrder1(TreeNode node){
        LinkedList<TreeNode> list = new LinkedList<>();
        while( node != null || !list.isEmpty()){
            if(node != null){
                list.push(node);
                node = node.left;
            }else {
                TreeNode temp = list.pop();
                System.out.print(temp.val +"\t");
                node = temp.right;
            }
        }
    }
    /**
    * @Author Mr_Poke
    * @Date 14:10 2023/5/8
    * @Description  后序遍历
    * @Param  * @param
    * @Return void
    */
    public static  void postOrder(TreeNode node){
        if(node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val+"\t");
    }
    //较难
    public static void postOrder1(TreeNode node){
        LinkedList<TreeNode> list = new LinkedList<>();
        //最近一次弹栈的元素
        TreeNode n = null;
        while (node != null || !list.isEmpty()){
            if(node!=null){
                list.push(node);
                node = node.left;
            }else{
                TreeNode temp = list.peek();
                if(temp.right == null || n == temp.right){
                    n = list.poll();
                    System.out.print(n.val+"\t");
                }else {
                    node = temp.right;
                }
            }
        }
    }
    public static void Order(TreeNode node){
        TreeNode n = null;
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<TreeNode> pre = new LinkedList<>();
        LinkedList<TreeNode> mid = new LinkedList<>();
        LinkedList<TreeNode> post = new LinkedList<>();
        while (node != null || !stack.isEmpty()){
            if(node != null){
                stack.push(node);
                pre.add(node);
                //待处理的左子树
                node = node.left;
            }else {
                //待处理的右子树
                TreeNode temp = stack.peek();
                //没有右子树需要处理
                if(temp.right == null){
                    mid.add(temp);
                    n =stack.pop();
                    post.add(n);
                    //处理完成的右子树
                }else if(n == temp.right){
                   n =  stack.pop();
                    post.add(n);
                    //需要处理的右子树
                }else{
                    mid.add(temp);
                    node = temp.right;
                }
            }
        }
        for(TreeNode node1 : pre){
            System.out.print(node1.val +"\t");
        }
        System.out.println();
        for(TreeNode node1 : mid){
            System.out.print(node1.val +"\t");
        }
        System.out.println();
        for(TreeNode node1 : post){
            System.out.print(node1.val +"\t");
        }
    }
    /**
     *  前序遍历和中序遍历确定二叉树
     * @param pre
     * @param in
     * @return
     */
    public TreeNode buildTree(int[] pre,int[] in){
        if(pre.length == 0 || in.length == 0)
        return null;
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if(in[i] == pre[0]){
                //复制左子树
                int[] inleft = Arrays.copyOfRange(in, 0, i);
                //复制右子树
                int[] inright = Arrays.copyOfRange(in, i+1, in.length);
                
                //复制下一个节点左子树
                int[] preleft = Arrays.copyOfRange(pre, 1, i+1);
                //复制下一个节点右子树
                int[] preright = Arrays.copyOfRange(pre, i+1, pre.length);
                
                root.left = buildTree(preleft, inleft);
                root.right = buildTree(preright, inright);  
                break; 
            }
        }
        return root;
    }
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), null), new TreeNode(3, new TreeNode(5, null, null), new TreeNode(6, null, null)));
        LinkedList<TreeNode> pre = new LinkedList<>();
        LinkedList<TreeNode> in = new LinkedList<>();
        LinkedList<TreeNode> post = new LinkedList<>();
        Order(node);


    }
}
