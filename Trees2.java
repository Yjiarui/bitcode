public class Trees2 {
    //判断是否为完全二叉树(递归)
    public static boolean isComplete(TreeNode root){
        if(root == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (true) {
            TreeNode front = queue.poll();
            if (front == null) {
                break;
            }
            queue.add(front.left);
            queue.add(front.right);
        }
        //判断剩余元素是否为null
        while(!queue.isEmpty()){
            TreeNode node = new TreeNode();
            if(node != null){
                return false;
            }
        }
        return true;
    }
    //用非递归方法写前序
    public static void preorderNoR(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (!stack.empty() || cur != null){
            while (cur != null){
                System.out.println(cur.val);
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode top = stack.pop();
            cur = top.right;
        }
    }
    //用非递归的方法写中序
    public static void inorderNoR(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (!stack.empty() || cur != null){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            //出栈
            TreeNode top = stack.pop();
            System.out.println(cur.val);
            cur = top.right;
        }
    }
    //用非递归方式写后序
public static void postorderNoR(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode last = null; //上一个被三次完整经过的结点

        while(!stack.empty() || cur != null){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.peek();
            if(top.right == null || top.right == last){
                stack.pop();
                System.out.println(top.val);
                last = top;
            }else {
                cur = top.right;
            }
        }
}


        private static class Element{
            int level;
            TreeNode node;
        }
    //层序遍历 用队列实现
        public List<List<Integer>> levelOrder(TreeNode root){
            List<List<Integer>> retlist = new ArrayList<>();
            if(root == null){
                return retlist;
            }
            Queue<Element> queue = new LinkedList<>();
            Element e = new Element();
            e.node = root;
            e.level = 0;
            queue.add(e);

            while (!queue.isEmpty()) {
                Element front = queue.poll();

                if(front.level == retlist.size()){
                    retlist.add(new ArrayList<>());
                }
                retlist.get(front.level).add(front.node.val);

                if (front.node.left != null) {
                    Element l = new Element();
                    l.node = front.node.left;
                    l.level = front.level + 1;
                    queue.add(l);
                }
                if (front.node.right != null) {
                    Element r = new Element();
                    r.node = front.node.right;
                    r.level = front.level + 1;
                    queue.add(r);
                }
            }
            return retlist;
        }
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

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode();
        n1.val = 1;
        n1.left = new TreeNode();
        n1.left.val = 2;
        n1.right = new TreeNode();
        n1.right.val = 3;
        n1.left.left = new TreeNode();
        n1.left.left.val = 4;

        //preorderNoR(n1);
        //inorderNoR(n1);
        postorderNoR(n1);
    }
}