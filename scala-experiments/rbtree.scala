package net.mishkovskyi.rbtree{

  abstract class Tree {
    def insert(value: Node): Unit
    def delete(value: Node): Unit
    def walk(callback: Node => Any): Any
  }

  class Node(value: Any, left: Node = null, right: Node = null) {
    def print() = println(value)
  }

  class BinaryTree(root: Node = null) extends Tree {

    def insert(value: Node) = {}
    def delete(value: Node) = {}
    def walk(callback: Node => Any) = {}
  }

}
