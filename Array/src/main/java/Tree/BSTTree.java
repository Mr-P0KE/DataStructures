package Tree;

import com.sun.source.tree.BinaryTree;

/**
 * @Author: Mr_Poke
 * @Date: 2023/5/10 19:46
 * @Description: 二叉搜索树
 */
public class BSTTree<T extends Comparable<T>,V> {
    private static class TreeNode<T,V>{
        T key;
        V val;
        TreeNode<T,V> left;
        TreeNode<T,V> right;

        public TreeNode(T key, V val) {
            this.key = key;
            this.val = val;
        }

        public TreeNode(T key) {
            this.key= key;
        }

        public TreeNode(T key, V val, TreeNode<T,V> left, TreeNode<T,V> right) {
            this.key = key;
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }
    private TreeNode<T,V> root;

    /**
    * @Author Mr_Poke
    * @Date 19:52 2023/5/10
    * @Description  查找关键字对应的值
    * @Param  * @param key
    * @Return java.lang.Object
    */
   public V get(T key){
       TreeNode<T,V> temp = root;
       return doGet(temp,key);
   }

   private V doGet(TreeNode<T,V> node,T key){
       if(node == null) {
           return null;
       }
       if(key.compareTo(node.key) < 0) {
           return doGet(node.left,key);
       } else if(key.compareTo(node.key) > 0) {
           return doGet(node.right, key);
       } else {
           return node.val;
       }
   }
   /**
   * @Author Mr_Poke
   * @Date 19:52 2023/5/10
    * @Description  查找最小关键字对应的值
   * @Description
   * @Param  * @param
   * @Return java.lang.Object
   */
   public V min(){
       TreeNode<T,V> temp = root;
       return doMin(temp);
   }
   public V doMin(TreeNode<T,V> node){
       if(node == null ) {
           return null;
       }
       if(node.left == null) {
           return node.val;
       }
       return doMin(node.left);
   }
   /**
   * @Author Mr_Poke
   * @Date 19:53 2023/5/10
   * @Description  查找最大关键字对应的值
   * @Param  * @param
   * @Return java.lang.Object
   */
   public V max(){
       TreeNode<T,V> temp = root;
       return doMax(temp);
   }
    public V doMax(TreeNode<T,V> node){
        if(node == null ) {
            return null;
        }
        if(node.right == null) {
            return node.val;
        }
        return doMin(node.right);
    }
   /**
   * @Author Mr_Poke
   * @Date 19:54 2023/5/10
   * @Description  存储对应的值
   * @Param  * @param key
    * @param val
   * @Return void
   */
   public void put(T key,V val){
       TreeNode<T,V> temp = root;
       TreeNode<T,V> parent = null;
       while(temp != null){
           parent = temp;
           if(key.compareTo(temp.key) < 0){
               temp = temp.left;
           }else if(key.compareTo(temp.key) > 0){
               temp = temp.right;
           }else {
               temp.key = key;
               temp.val = val;
               return;
           }
       }
       //不存在key相等的情况
       TreeNode<T,V> newNode = new TreeNode<>(key,val);
       if(parent == null){
           root = newNode;
       }else {
           if ( key.compareTo(parent.key) < 0) {
               parent.left = newNode;
           }else if (key.compareTo(parent.key) > 0) {
               parent.right = newNode;
           }
       }
   }

   /**
   * @Author Mr_Poke
   * @Date 19:54 2023/5/10
   * @Description  查找关键字的前驱值
   * @Param  * @param key
   * @Return java.lang.Object
   */
   public V successor(T key){

       return null;
   }
   /**
   * @Author Mr_Poke
   * @Date 19:55 2023/5/10
   * @Description  查找关键字的后驱值
   * @Param  * @param key
   * @Return java.lang.Object 
   */
   public Object predecessor(int key){
       return null;
   }
   /**
   * @Author Mr_Poke
   * @Date 19:56 2023/5/10
   * @Description  根据关键字删除对应的值
   * @Param  * @param key
   * @Return java.lang.Object
   */
   public Object delete(int key){
       return null;
   }


}
