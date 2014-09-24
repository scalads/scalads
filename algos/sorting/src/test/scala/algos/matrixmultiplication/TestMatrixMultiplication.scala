package algos.matrixmultiplication

import org.specs2.mutable.SpecificationWithJUnit

class TestMatrixMultiplication extends SpecificationWithJUnit {

  "The matrix multiplication algorithm" should {
    "compute correct product of two matrices of two by two size" in {
      val matrix1 = new Matrix[Int](2,2)
      val matrix2 = new Matrix[Int](2,2)

      matrix1.setRow(0)(Array(0, 1))
      matrix1.setRow(1)(Array(0, 0))

      matrix2.setRow(0)(Array(0, 0))
      matrix2.setRow(1)(Array(1, 0))

      val matrix3 = MatrixMultiplication(matrix1, matrix2)

      matrix3.rows mustEqual 2
      matrix3.cols mustEqual 2

      matrix3.row(0) mustEqual Array(1, 0)
      matrix3.row(1) mustEqual Array(0, 0)
    }

    "The matrix multiplication algorithm" should {
      "compute correct product of two matrices of four by four size" in {
        val matrix1 = new Matrix[Int](4,4)
        val matrix2 = new Matrix[Int](4,4)

        matrix1.setRow(0)(Array(0, 1, 0, 1))
        matrix1.setRow(1)(Array(0, 0, 1, 1))
        matrix1.setRow(2)(Array(0, 0, 1, 1))
        matrix1.setRow(3)(Array(0, 0, 1, 1))

        matrix2.setRow(0)(Array(0, 0, 1, 1))
        matrix2.setRow(1)(Array(1, 0, 0, 1))
        matrix2.setRow(2)(Array(1, 0, 0, 1))
        matrix2.setRow(3)(Array(1, 0, 0, 1))

        val matrix3 = MatrixMultiplication(matrix1, matrix2)

        matrix3.rows mustEqual 4
        matrix3.cols mustEqual 4

        matrix3.row(0) mustEqual Array(2, 0, 0, 2)
        matrix3.row(1) mustEqual Array(2, 0, 0, 2)
        matrix3.row(2) mustEqual Array(2, 0, 0, 2)
        matrix3.row(3) mustEqual Array(2, 0, 0, 2)
      }
    }

    "compute correct product of two matrices of different size" in {
      val matrix1 = new Matrix[Int](2,3)
      val matrix2 = new Matrix[Int](3,2)

      matrix1.setRow(0)(Array(1, 2, 3))
      matrix1.setRow(1)(Array(4, 5, 6))

      matrix2.setRow(0)(Array(7, 8))
      matrix2.setRow(1)(Array(9, 10))
      matrix2.setRow(2)(Array(11, 12))

      val matrix3 = new MatrixMultiplication().bruteForce(matrix1, matrix2)

      matrix3.rows mustEqual 2
      matrix3.cols mustEqual 2

      matrix3.row(0) mustEqual Array(58, 64)
      matrix3.row(1) mustEqual Array(139, 154)
    }
  }
}
