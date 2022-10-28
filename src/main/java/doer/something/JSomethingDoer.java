package doer.something;

/**
 * Does something.
 */
public class JSomethingDoer {

  private int motivationLevel;

  /**
   * @param motivationLevel a 0-100 integer, denoting how motivated the #{@link JSomethingDoer} is.
   */
  public JSomethingDoer(int motivationLevel) {
    this.motivationLevel = motivationLevel;
  }

  public void doSomething() {
    doOneLittleThing();
    maybeDoSecondLittleThing();
  }

  void doOneLittleThing() {
    System.out.println("Doing one thing.");
  }

  // package-private for testing
  void maybeDoSecondLittleThing() {
    if (!feelingAmbitious()) {
      System.out.println("We're not feeling that motivated today it seems.");
      return;
    }

    doSecondLittleThing();
  }

  private void doSecondLittleThing() {
    System.out.println("We're overachievers, doing a second thing!!!");
  }

  private boolean feelingAmbitious() {
    return motivationLevel > 90;
  }
}
