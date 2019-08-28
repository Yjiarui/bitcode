package project2;
//层序遍历 用队列实现
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void leavelOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
                TreeNode front = queue.poll();

            System.out.println(front.val);
            if(front.left != null){
                queue.add(front.left);
            }
            if(front.right != null){
                queue.add(front.right);
            }
        }
    }
}