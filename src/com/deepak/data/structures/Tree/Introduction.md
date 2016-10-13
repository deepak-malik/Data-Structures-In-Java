## Introduction to Trees

**AVL Tree**  
This is a self balancing BST. In an AVL tree, height of two subtrees of a given node differ by at most one. If at any time they differ by more then one, re balancing is done to restore this property.  
Lookup, insertion and deletion all of them takes O(log n) time in both average and worst cases, where n is the number of nodes in the tree prior to operation.   

AVL trees are often compared with Red-Black trees because both the them supports same set of operations and takes same amount of time.
Because AVL trees are more rigidly balanced, they are faster than red-black trees for lookup intensive applications. However, red-black trees are faster for insertion and removal.
Term used in AVL trees is balance factor, which is derived as
	BalanceFactor = height(left subtree) - height(right subtree)
At any given node, if this balance factor becomes > 1, then re balancing happens. If for some reason re balancing fails, then this tree is not considered as AVL tree.


Rotations :
To make itself balanced this tree performs 4 different kind of operations, 
	- Left Rotation
	- Right Rotation
	- Left-Right Rotation
	- Right-Left Rotation
	
Left Rotation : If a tree becomes unbalanced when a node is inserted in right sub tree, then left rotation is done.
Right Rotation : AVL tree may become unbalanced when a node is inserted in left sub tree, this will result in right rotation.
Left Right Rotation : Double rotations are slightly complex. This is left rotation followed by right rotation. 
Right Left Rotation : This is right rotation followed by left rotation.

	