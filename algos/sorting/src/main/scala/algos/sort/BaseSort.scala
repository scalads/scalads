package algos.sort

abstract class BaseSort {
  def apply[A: Ordering](lst: List[A]):List[A]
}
