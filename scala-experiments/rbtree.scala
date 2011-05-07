package net.mishkovskyi.tree{

  abstract class Tree[T] {
    def insert(value: T): Tree[T]
    def delete(value: T): Tree[T]
    def foreach(callback: T => Any): Unit
    def iterate(): List[T]
  }

  class BinaryTree[T] (root: T,
		       left: BinaryTree[T] = null,
		       right: BinaryTree[T] = null)
  extends Tree[T] {

    def insert(value: T) = {

      this
    }

    def print() = {

    }

    def delete(value: T) = {this}
    def foreach(callback: T => Any) = {}
    def iterate() = {List()}
  }

}
