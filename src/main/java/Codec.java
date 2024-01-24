import java.util.Deque;
import java.util.LinkedList;

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val + "," + left + "," + right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> queue = new LinkedList<>();
        for (String s : data.split(",")) {
            queue.addLast(s);
        }
        return buildTree(queue);
    }

    private TreeNode buildTree(Deque<String> queue) {
        String s = queue.removeFirst();
        if (s.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = buildTree(queue);
        root.right = buildTree(queue);
        return root;
    }
}