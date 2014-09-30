package algos.isomorphicwords

import org.specs2.mutable.SpecificationWithJUnit

class TestIsomorphicWords extends SpecificationWithJUnit {
  "The is isomorphic method" should {
    "return true for these strings " in {
      new IsomorphicWords().isIsomorphic("ab", "ca") mustEqual false
    }
  }
}
