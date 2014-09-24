package algos.matrixmultiplication

import scala.reflect.ClassTag

class Matrix[A](val rows:Int, val cols:Int)(implicit arg0: ClassTag[A]) {
  private [this] val data = Array.ofDim[A](rows, cols)

  def set(row:Int)(col:Int)(value:A):Unit = {
    data(row)(col) = value
  }

  def setRow(row:Int)(rowData:Array[A]):Unit = {
    data(row) = rowData
  }

  def get(row:Int)(col:Int):A = {
    data(row)(col)
  }

  def row(row:Int):Array[A] = {
    data(row)
  }

  def col(col:Int):Array[A] ={
    val result = Array.ofDim[A](rows)
    for(i <- 0 until rows) {
      result(i) = data(i)(col)
    }
    result
  }

  def divideIn(dimensions: Int):(Matrix[A],Matrix[A],Matrix[A],Matrix[A]) = {
    val numRows = rows/dimensions
    val numCols = cols/dimensions

    val matrix11, matrix12, matrix21, matrix22 = new Matrix[A](numRows, numCols)

    for (i <- 0 until rows) {
      for (j <- 0 until cols) {
        if (i < numRows && j < numCols) {
          matrix11.set(i)(j)(data(i)(j))
        } else if (i < numRows && j >= numCols) {
          matrix12.set(i)(j - numCols)(data(i)(j))
        }else if (i >= numRows && j < numCols) {
          matrix21.set(i - numRows)(j)(data(i)(j))
        }else if (i >= numRows && j >= numCols) {
          matrix22.set(i - numRows)(j - numCols)(data(i)(j))
        }
      }
    }
    (matrix11, matrix12, matrix21, matrix22)
  }

  def +(other:Matrix[A])(implicit n:Numeric[A]) = {
    val result:Matrix[A] = new Matrix[A](rows, cols)
    for (i <-0 until rows) {
      for (j <- 0 until cols) {
        result.set(i)(j)(n.plus(this.get(i)(j), other.get(i)(j)))
      }
    }
    result
  }

  override def toString: String = {
    s"rows = $rows, cols = $cols, data = " + data.deep.mkString(",")
  }
}

object Matrix {
  def join[A](matrix11:Matrix[A], matrix12: Matrix[A], matrix21:Matrix[A], matrix22:Matrix[A])(implicit arg0: ClassTag[A]) = {
    assert(matrix11.rows == matrix12.rows)
    assert(matrix11.cols == matrix21.cols)
    assert(matrix21.rows == matrix22.rows)
    assert(matrix12.cols == matrix22.cols)

    val result = new Matrix[A](matrix11.rows + matrix21.rows, matrix11.cols + matrix12.cols)
    for (i <- 0 until matrix11.rows) {
      for (j <- 0 until matrix11.cols) {
        result.set(i)(j)(matrix11.get(i)(j))
      }
    }

    for (i <- 0 until matrix12.rows) {
      for (j <- 0 until matrix12.cols) {
        result.set(i)(j + matrix11.cols)(matrix12.get(i)(j))
      }
    }

    for (i <- 0 until matrix21.rows) {
      for (j <- 0 until matrix21.cols) {
        result.set(i + matrix11.rows)(j)(matrix21.get(i)(j))
      }
    }

    for (i <- 0 until matrix22.rows) {
      for (j <- 0 until matrix22.cols) {
        result.set(i + matrix11.rows)(j + matrix11.cols)(matrix22.get(i)(j))
      }
    }
    result
  }
}
