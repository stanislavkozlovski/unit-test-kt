package doer.something;

import org.junit.Before;
import org.junit.Test;

public class JSomethingDoerTest {

  private JSomethingDoer doer;

  @Before
  public void setUp() {
    doer = new JSomethingDoer(11);
  }

  @Test
  public void Test_doSomething() {
    doer.doSomething();
    // assert
  }

  @Test
  public void Test_doOneLittleThing() {
    doer.doOneLittleThing();
    // assert
  }

  @Test
  public void Test_maybeDoSecondLittleThing() {
    doer.maybeDoSecondLittleThing();
    // assert
  }
}
