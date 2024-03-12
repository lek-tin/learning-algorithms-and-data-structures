from collections import defaultdict

class Node:
    def __init__(self, _key=None, _val=None, _freq=0):
        self.key = _key
        self.val = _val
        self.freq = _freq
        self.prev = None
        self.next = None
        
    def __str__(self):
        return "(" + str(self.key) + ", " + str(self.val) + ", " + str(self.freq) + ")"
    
class DLL:
    def __init__(self):
        self.head = Node(None)
        self.tail = Node(None)
        self.head.next = self.tail
        self.tail.prev = self.head

    def append(self, node):
        node.prev = self.tail.prev
        node.next = self.tail
        node.prev.next = node
        node.next.prev = node
        
    def front(self):
        if self.isEmpty():
            return None 
        
        return self.head.next
    
    def deleteFront(self,):
        front = self.front()
        self.delete(front)
        del front
    
    def delete(self, node):
        node.prev.next  = node.next
        node.next.prev = node.prev
    
    def isEmpty(self):
        return self.head.next == self.tail
    
    def __str__(self):
        curr = self.head
        temp = ""
        while curr != self.tail:
            temp += "(" + curr.key + ", " + curr.val + ", " + curr.freq + ") -> "
            curr = curr.next
        return temp
    
class LFUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.size = 0
        self.min_freq = 0
        # key : Node
        self.key_to_node = {}
        # freq: DLL<Node>
        self.freq_to_nodes = defaultdict(DLL)

    def get(self, key: int) -> int:
        if key not in self.key_to_node:
            return -1   
        # only update node, no new value
        self.updateFreq(key)
        return self.key_to_node[key].val

    def put(self, key: int, value: int) -> None:
        if self.capacity <= 0:
            return
        
        # key exists
        if key in self.key_to_node:
            self.updateFreq(key, value)
            # self.key_to_node[key].val = value
            return
        
        # key doesn't exist
        if self.size == self.capacity:
            self.evict()
        
        self.addNode(key, value)
        
        return
    
    def updateFreq(self, key, val=None):
        oldNode = self.key_to_node[key]
        self.freq_to_nodes[oldNode.freq].delete(oldNode)
        if self.freq_to_nodes[oldNode.freq].isEmpty():
            del self.freq_to_nodes[oldNode.freq]
            if self.min_freq == oldNode.freq:
                self.min_freq += 1
        
        self.key_to_node[key] = Node(key, oldNode.val if val == None else val, oldNode.freq+1)
        newNode = self.key_to_node[key]
        newFreq = newNode.freq
        self.freq_to_nodes[newFreq].append(newNode)
    
    def evict(self):
        nodes_at_freq = self.freq_to_nodes[self.min_freq]
        node_to_delete = nodes_at_freq.front()
        del self.key_to_node[node_to_delete.key]
        nodes_at_freq.deleteFront()
        if nodes_at_freq.isEmpty():
            del self.freq_to_nodes[self.min_freq]
        self.size -= 1
            
    def addNode(self, key, val):
        self.min_freq = 1
        newNode = Node(key, val, self.min_freq)
        self.key_to_node[key] = newNode
        self.freq_to_nodes[self.min_freq].append(newNode)
        self.size += 1

# Your LFUCache object will be instantiated and called as such:
# obj = LFUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
