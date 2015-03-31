package hw2;

import java.io.FileNotFoundException;
import java.util.Random;

/**
 * A Words object is used to randomly choose words from a file.
 * The file format is one word per line.
 */
public class Words
{
  /**
   * Constructs a Words object that will use the strings from 
   * the given file.
   * @param filename
   *   name of file containing words
   * @throws FileNotFoundException
   *   if the word file cannot be opened
   */
  public Words(String filename) throws FileNotFoundException
  {
    // TODO
  }
  
  /**
   * Get a randomly chosen word from this word list
   * using the given <code>Random</code> object as the source of randomness.
   * Specifically, the method returns the i-th word from the file, where
   * i is the value returned by <code>rand.nextInt(n)</code>, <code>n</code> is
   * total number of words, and the index i is 0-based.
   * @return
   *   randomly chosen word
   * @throws FileNotFoundException
   *   if the word file cannot be opened
   */
  public String getWord(Random rand) throws FileNotFoundException
  {
    // TODO
    return "AARDVARK";
  }
  

}
