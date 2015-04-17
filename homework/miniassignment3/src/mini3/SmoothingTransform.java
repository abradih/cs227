package mini3;

/**
 * Transformation implementing a smoothing operation
 * on cells of an array.  The new value is the 
 * average of the values in a neighborhood
 * around a given cell, rounded to the nearest
 * integer. The size of the neighborhood is 
 * 2 * radius + 1, where the radius is a parameter
 * provided to the constructor. Values are not wrapped.
 */
public class SmoothingTransform implements ITransform
{
  
  public SmoothingTransform(int givenRadius)
  {
    // TODO
  }
  
  @Override
  public int apply(int[][] elements)
  {
    // TODO
    return 0;
  }

  @Override
  public int getRadius()
  {
    // TODO
    return 0;
  }

  @Override
  public boolean isWrapped()
  {
    return false;
  }

}
