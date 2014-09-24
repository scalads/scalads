package algos.matrixmultiplication

import scala.reflect.ClassTag

class MatrixMultiplication {

  def multiply[A](rowValues: Array[A], colValues: Array[A])(implicit n:Numeric[A]) = {
    var sum:A = null.asInstanceOf[A]
    for(i <- 0 until rowValues.length) {
      sum = n.plus(sum, n.times(rowValues(i), colValues(i)))
    }
    sum
  }

  def bruteForce[A:Numeric](matrix1:Matrix[A], matrix2:Matrix[A])(implicit arg0: ClassTag[A]) = {
    val result = new Matrix[A](matrix1.rows, matrix2.cols)
    for (i <- 0 until matrix1.rows) {
      for (j <- 0 until matrix2.cols) {
        val row1:Array[A] = matrix1.row(i)
        val col2:Array[A] = matrix2.col(j)
        val sum = multiply(row1, col2)
        result.set(i)(j)(sum)
      }
    }
    result
  }

  def recursive[A](matrix1:Matrix[A], matrix2:Matrix[A])(implicit arg0: ClassTag[A], num:Numeric[A]):Matrix[A] = {
    assert(matrix1.rows == matrix2.cols)
    val n = matrix1.rows

    if (n == 1) {
      val matrix = new Matrix(1,1)
      matrix.setRow(0)(Array(num.times(matrix1.get(0)(0), matrix2.get(0)(0))))
      matrix
    } else {
      val(a11, a12, a21, a22) = matrix1.divideIn(2)
      val(b11, b12, b21, b22) = matrix2.divideIn(2)

      Matrix.join(recursive(a11, b11) + recursive(a12, b21),
                  recursive(a11, b12) + recursive(a12, b22),
                  recursive(a21, b11) + recursive(a22, b21),
                  recursive(a21, b12) + recursive(a22, b22))
    }
  }
}

object MatrixMultiplication {
  def apply[A:Numeric] (matrix1: Matrix[A], matrix2: Matrix[A])(implicit arg0: ClassTag[A]): Matrix[A] = {
    new MatrixMultiplication().recursive(matrix1, matrix2)
  }
}
