package algos.isomorphicwords

import scala.collection.mutable

class IsomorphicWords {
  def isIsomorphic(str1: String, str2: String): Boolean = {
    val wordMappings = new mutable.HashMap[Char, Char]()
    for (i <- 0 until str1.length) {
      val firstChar = str1.charAt(i)
      val secondChar = str2.charAt(i)

      if (wordMappings.contains(firstChar)) {
        if (wordMappings.get(firstChar) != Some(secondChar)) {
          return false
        }
      }
      else if (wordMappings.contains(secondChar)) {
        if (wordMappings.get(secondChar) != Some(firstChar)) {
          return false
        }
      } else {
        wordMappings.put(firstChar, secondChar)
        wordMappings.put(secondChar, firstChar)
      }
    }
    return true
  }
}
