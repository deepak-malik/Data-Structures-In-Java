## Introduction to Graphs

Graph is a Non-Linear type of data structure which contains Vertices and Edges. Wikipedia defines it as _"A graph data structure consists of a finite (and possibly mutable) set of vertices or nodes or points, together with a set of unordered pairs of these vertices for an undirected graph or a set of ordered pairs for a directed graph."_ Even tree is a special kind of graph.  

In Mathematical terms, a Graph can be represented by below definition,  
A graph **G** is an ordered pair of set **V** of vertices and set **E** of edges. i.e **G = (V, E)**
Since it is an ordered pair, so sequence of items matter. 
	
**Ordered Pair v/s UnOrdered Pair**
- **Ordered Pair :** A pair in which order matters and changing the order is not allowed is called an ordered pair. ex. (a, b) != (b, a) if a != b
- **UnOrdered Pair :** A pair in which order doesn't matter is called an unordered pair. ex. {a, b} = {b, a}
	
Now, let's say we have a following graph defined
<img width="644" alt="basic_graph" src="https://cloud.githubusercontent.com/assets/3439029/21968825/ea5fcb4c-db4d-11e6-9eb4-1e40569b230c.png">

We have 6 vertices defined here and 9 edges, which can be represented as below,  
- **V =** _{V0, V1, V2, V3, V4, V5}_
- **E** = _{{V0, V4}, {V0, V5}, {V3, V5} ...}_

Edge is represented like this because it is a pair of 2 vertices i.e start vertex and end vertex. 
Edges can be of two types, i.e either Directed edges or UnDirected Edges.  
Below are the graphs which are created using directed edges and undirected edges. Based on edges, graphs can be categorized in two categories, i.e Directed graphs (or Digraph) and UnDirected graphs.

![directed_vs_undirected](https://cloud.githubusercontent.com/assets/3439029/21968901/a5e4f63a-db4e-11e6-84ba-bac70fed4b69.png)

Directed edge is represented as **(S, D)** where **S** is source and **D** is destination, whereas UnDirected edge is represented as **{S, D}**. Typically in a graph, either all edges are directed or all of them are undirected but it can be both as well.

**Undirected v/s Directed Graphs**
- A social media network like **Facebook** can be a example of **Undirected Graph** where each user is connected to some other user and vice versa. There is a mutual relationship here (i.e if you are a friend of some other person, then he is also your friend).  Now, let's talk about a use case of _"Suggest Friends"_. We can do this by suggesting friends of friends which are not connected to each other i.e find all the nodes where path = 2 (2 because 1 refers to our own friend and second will be the friend of friend).
- **WWW (World Wide Web)** can be a perfect example of **Directed Graph** where each of the web page is connected to some other web page. Here relationship is not mutual. i.e if Page A has a link to Page B, then it's not necessary that Page B will also have a link to Page A. Though there can be self links to the pages. We Crawler does the same thing as well. It traverses through the web pages and create a directed graph.  