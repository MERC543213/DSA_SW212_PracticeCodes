public class BinaryTree {
	private Object data;
	private BinaryTree left,right;
	public BinaryTree(Object data) {
		this.data=data;
	}
	public BinaryTree(Object data,BinaryTree left,BinaryTree right) {
		this.data=data;
		this.left=left;
		this.right=right;
	}
	public void setData(Object data) {
		this.data=data;
	}
	public BinaryTree getLeft() {
		return left;
	}
	public void setLeft(BinaryTree left) {
		this.left = left;
	}
	public BinaryTree getRight() {
		return right;
	}
	public void setRight(BinaryTree right) {
		this.right = right;
	}
	public Object getData() {
		return data;
	}
	public String preOrderTraversal() {
		StringBuffer str=new StringBuffer();
		str.append(this.getData());
		if(getLeft()!=null) {
		str.append(","+getLeft().preOrderTraversal());
		}
		if(getRight()!=null) {
		str.append(","+getRight().preOrderTraversal());
		}
		return str+"";
	}
	public String inOrderTraversal() {
		StringBuffer str=new StringBuffer("");
		if(getLeft()!=null) {
			str.append(getLeft().inOrderTraversal()+",");
		}
		str.append(this.getData());
		if(getRight()!=null) {
			str.append(","+getRight().inOrderTraversal());
		}
		return str+"";
	}
	public String postOrderTraversal() {
		StringBuffer str=new StringBuffer("");
		if(getLeft()!=null) {
			str.append(getLeft().inOrderTraversal()+",");
		}
		if(getRight()!=null) {
			str.append(","+getRight().inOrderTraversal());
		}
		str.append(this.getData());
		return str+"";
	}
    private boolean isLeaf() {
    	if(getLeft()==null && getRight()==null) {
			return true;
		}
		return false;
	}
    public int size() {
    	if(getData()==null) {
    		return 0;
    	}
    	if(getLeft()==null && getRight()==null)
    		return 1;
    	if(getLeft()==null)
        	return 1+getRight().size();
    	if(getRight()==null)
        	return 1+getLeft().size();
    	return 1+getLeft().size()+getRight().size();
    }
    public int height() {
    	if(getData()==null) {
    		return 0;
    	}
    	int leftHeight=0, rightHeight=0;
    	if(getLeft()!=null) {
    		leftHeight=1 + getLeft().height();
    	}
    	if(getRight()!=null) {
    		rightHeight=1 + getRight().height();
    	}
    	return (leftHeight>rightHeight)?leftHeight:rightHeight;
    }
    public boolean contains(Object target) {
    	// Approach 1 (MINE ONE)
//		if(getData()==target) {
//			return true;
//		}
//		boolean present=false;
//		if(getLeft()!=null) {
//			present = getLeft().contains(target);
//			if(present) {
//				return present;
//			}
//		}
//		if(getRight()!=null) {
//			present = getRight().contains(target);
//			if(present) {
//				return present;
//			}
//		}
//		return present;
//    }
    	
		//Approach 2  (BY Teacher)
		if(getData()==target) {
			return true;
		}
		boolean present=false;
		
		if(getLeft()!=null) {
			if(getLeft().preOrderTraversal().contains(target.toString()))  return true;
				present=getLeft().contains(target);
		}
		if(getRight()!=null) {
			if(getRight().preOrderTraversal().contains(target.toString()))  return true;
				present=getRight().contains(target);
			}
		return present;
    }
    public boolean isFull() {
    	if(this.getData()==null)
    		return true;
    	if(this.getLeft()==null && this.getRight()==null) {
    		return true;
    	}
    	if(this.getLeft()!=null && this.getRight()!=null) {
    		return (getLeft().isFull() && getRight().isFull());
    	}
    	return false;
    }
    
    public boolean isComplete() {
//    	// Check if the tree is Empty
//	int nodes=this.size(); // Size is basically the number of nodes
//	int index=0;
//	if(this.getData()==null) {
//		return true;
//	}
//	if(index>=nodes) {
//		return false;
//	}
	return (getLeft().isComplete() && getRight().isComplete());
    }
    
    public int degree() {
    	int deg=0;
    	if(this.getLeft()!=null){
    		deg++;
    	}
    	if(this.getRight()!=null){
    		deg++;
    	}
    	return deg;
    }
    
    public int getNumOfLeafNodes(){
    	if (getData() == null)
            return 0;
        if (getLeft() == null && getRight() == null)
            return 1;
        else
            return getLeft().getNumOfLeafNodes() + getRight().getNumOfLeafNodes();
    }
    
    int getLevelUtil(BinaryTree tree, Object data, int level)
    {
        if (tree == null)
            return 0;
 
        if (tree.getData().equals(data))
            return level;
 
        int downlevel
            = getLevelUtil(tree.getLeft(), data, level + 1);
        if (downlevel != 0)
            return downlevel;
 
        downlevel
            = getLevelUtil(tree.getRight(), data, level + 1);
        return downlevel;
    }
 
    /* Returns level of given data value */
    int getLevel(Object data)
    {
        return getLevelUtil(this, data, 1);
    }
    // Swap the left and right tree;
 	public void swap() {
 		if(getLeft()==null || getRight()==null) {
 			System.out.println("SWAP not possible.");
 			return;
 		}
 		BinaryTree temp=getLeft();
 		setLeft(getRight());
 		setRight(temp);
 	}
 	
 	// Find out the right most node of the left tree
 	public Object Right_Most_Of_Left() {
 		if(getData()==null) {
 			return null;
 		}
 		if(getLeft()!=null) {
 			for(BinaryTree i=getLeft();i!=null;i=i.getRight()) {
 				if(i.getRight()==null)
 				{
 					return i.getData();
 				}
 			}
 		}
 		return null;	
 	}
 		
 	
 	// Find out the left most node of the right tree
 	
 	public Object Left_Most_Of_Right() {
 		if(getData()==null) {
 			return null;
 		}
 		if(getRight()!=null) {
 			for(BinaryTree i=getRight();i!=null;i=i.getLeft()) {
 				if(i.getLeft()==null)
 				{
 					return i.getData();
 				}
 			}
 		}
 		return null;	
 	}
 	
 	 // insert a node in BST 
    void insert(BinaryTree tree,int key)  { 
    	tree = insert_Recursive(tree, key); 
    } 
   
    //recursive insert function
    BinaryTree insert_Recursive(BinaryTree root, int key) { 
          //tree is empty
        if (root == null) { 
            root = new BinaryTree(key);
            return root; 
        } 
        //traverse the tree
        if (key < (int)root.getData())     //insert in the left subtree
            root.setLeft(insert_Recursive(root.getLeft(), key)); 
        else if (key > (int)root.getData())    //insert in the right subtree
            root.setRight(insert_Recursive(root.getRight(), key)); 
          // return pointer
        return root; 
    } 
 	
  //delete a node from BST
    void delete(BinaryTree tree,int key) { 
        tree = delete_Recursive(tree, key); 
    } 
   
    //recursive delete function
    BinaryTree delete_Recursive(BinaryTree tree, int key)  { 
        //tree is empty
        if (tree == null)  return tree; 
   
        //traverse the tree
        if (key < (int)tree.getData())     //traverse left subtree 
            tree.setLeft(delete_Recursive(tree.getLeft(), key)); 
        else if (key > (int)tree.getData())  //traverse right subtree
            tree.setRight(delete_Recursive(tree.getRight(), key)); 
        else  { 
            // node contains only one child
            if (tree.getLeft() == null) 
                return tree.getRight(); 
            else if (tree.getRight() == null) 
                return tree.getLeft(); 
   
            // node has two children; 
            //get inorder successor (min value in the right subtree) 
            tree.setData(minValue(tree.getRight())); 
   
            // Delete the inorder successor 
            tree.setRight(delete_Recursive(tree.getRight(), (int)tree.getData())); 
        } 
        return tree; 
    } 
   
    int minValue(BinaryTree root)  { 
        //initially minval = root
        int minval = (int)root.getData(); 
        //find minval
        while (root.getLeft() != null)  { 
            minval = (int)root.getLeft().getData(); 
            root = root.getLeft(); 
        } 
        return minval; 
    } 
 	
	public static void main(String[] args) {
		BinaryTree treeB =new BinaryTree("B");
		BinaryTree treeD =new BinaryTree("D");
		BinaryTree treeE =new BinaryTree("E");
		BinaryTree treeC =new BinaryTree("C",treeD,treeE);
		BinaryTree tree =new BinaryTree("A",treeB,treeC);
		System.out.println("Inorder traversal of tree is : "+tree.inOrderTraversal());
		System.out.println("Is TreeC have Leaf?  "+treeC.isLeaf());
		System.out.println("Size of tree is : "+tree.size());
		System.out.println("Is treeC contains C?  "+tree.contains("C"));
		System.out.println("Left and Right Trees are swapped. ");
		tree.swap();
		System.out.println("Is treeC contains A?  "+tree.contains("A"));
		System.out.println("Is treeC contains J?  "+tree.contains("J"));
		System.out.println("Right Most node of left subtree is?  "+tree.Right_Most_Of_Left());
		System.out.println("Left Most node of right subtree is?  "+tree.Left_Most_Of_Right());
		System.out.println("Is tree a full binary tree?  "+tree.isFull());
//		System.out.println("Is tree a complete binary tree?  "+tree.isComplete());
		System.out.println("Level of tree where D is?  "+tree.getLevel("D"));
		System.out.println("Number of Leaf Nodes of tree is?  "+tree.getNumOfLeafNodes());
		System.out.println("Degree of tree is : "+tree.degree());
		
		BinaryTree treeB2 =new BinaryTree(14);
		BinaryTree treeD2 =new BinaryTree(18);
		BinaryTree treeE2 =new BinaryTree(19);
		BinaryTree treeC2 =new BinaryTree(27,treeD2,treeE2);
		BinaryTree tree2 =new BinaryTree(15,treeB2,treeC2);
		System.out.println("Before Insertion, tree is : "+tree2.inOrderTraversal());
		tree2.insert(tree2, 13);
		System.out.println("After Insertion, tree is : "+tree2.inOrderTraversal());
		
		System.out.println("Before Deletion, tree is : "+tree2.inOrderTraversal());
		tree2.delete(tree2, 13);
		System.out.println("After Deletion, tree is : "+tree2.inOrderTraversal());

	}
}
