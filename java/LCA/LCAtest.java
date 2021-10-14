package LCA;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.lang.NullPointerException;

public class LCAtest {
    @Test
    public void testLCAResult() {
        LCA tree = new LCA();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        //System.out.println("LCA(4, 5): " + tree.findLCA(4,5));
        //System.out.println("LCA(4, 6): " + tree.findLCA(4,6));
        //System.out.println("LCA(3, 4): " + tree.findLCA(3,4));
        //System.out.println("LCA(2, 4): " + tree.findLCA(2,4));

    	assertEquals("LCA(4, 5): ",2,tree.findLCA(4,5));
    	assertEquals("LCA(4, 6): ",1,tree.findLCA(4,6));
    	assertEquals("LCA(3, 4): ",1,tree.findLCA(3,4));
    	assertEquals("LCA(2, 4): ",2,tree.findLCA(2,4));
    }
    @Test
    public void testEmpty(){
        LCA tree = new LCA();
        assertEquals("LCA(0, 0): ",-1,tree.findLCA(0,0));
    }
    
    @Test
    public void testNegative() {
        LCA tree = new LCA();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        
    	assertEquals("LCA(4, 8): ",-1,tree.findLCA(4,8));

    }
}
