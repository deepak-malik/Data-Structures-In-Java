## Trie Introduction

**Trie**, also known as _Digital Tree_ or _Prefix Tree_ (as they can be searched using a prefix string) is a kind of search tree where keys are usually strings. Unlike a binary search tree, no node in the tree stores the key associated with that node; instead its position in the tree is defined by the key with which it is associated. All the descendants of a node have a common prefix and root is kept as empty. Values are not necessarily associated with all the nodes. Below is a example of a Trie,

<img width="420" alt="trie" src="https://cloud.githubusercontent.com/assets/3439029/22075109/8c5ecc28-dd5f-11e6-8592-f04d13aa73a5.png">

In the above example shown, keys are listed in the nodes and values below them. Each complete English word has an arbitrary integer value associated with it. Though tries are usually keyed by character strings, they need not be. The same algorithms can be adapted to serve similar functions of ordered lists of any construct, e.g. permutations on a list of digits or shapes.

**Advantages v/s Disadvantages of Tries**  

Trie has a number of advantages over binary search trees. A trie can also be used to replace a hash table, over which it has the following advantages:
- Looking up data in a trie is faster in the worst case, O(m) time (where m is the length of a search string), compared to an imperfect hash table. An imperfect hash table can have key collisions. A key collision is the hash function mapping of different keys to the same position in a hash table. The worst-case lookup speed in an imperfect hash table is O(N) time, but far more typically is O(1), with O(m) time spent evaluating the hash.
- There are no collisions of different keys in a trie.
- Buckets in a trie, which are analogous to hash table buckets that store key collisions, are necessary only if a single key is associated with more than one value.
- There is no need to provide a hash function or to change hash functions as more keys are added to a trie.
- A trie can provide an alphabetical ordering of the entries by key.

Tries do have some **drawbacks** as well:

- Tries can be slower in some cases than hash tables for looking up data, especially if the data is directly accessed on a hard disk drive or some other secondary storage device where the random-access time is high compared to main memory.
- Some keys, such as floating point numbers, can lead to long chains and prefixes that are not particularly meaningful. Nevertheless, a bitwise trie can handle standard IEEE single and double format floating point numbers.
- Some tries can require more space than a hash table, as memory may be allocated for each character in the search string, rather than a single chunk of memory for the whole entry, as in most hash tables.

A special kind of trie, called a suffix tree, can be used to index all suffixes in a text in order to carry out fast full text searches.