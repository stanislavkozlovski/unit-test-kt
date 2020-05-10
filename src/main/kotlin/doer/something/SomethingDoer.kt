package doer.something

/**
 * Does something.
 * @param motivationLevel a 0-100 integer, denoting how motivated the #[SomethingDoer] is.
 */
open class SomethingDoer(private val motivationLevel: Int) {
  fun doSomething() {
    doOneLittleThing()
    maybeDoSecondLittleThing()
  }

  protected fun doOneLittleThing() {
    println("Doing one thing.")
  }

  private fun maybeDoSecondLittleThing() {
    if (feelingAmbitious()) {
      doSecondLittleThing()
    }
  }

  private fun doSecondLittleThing() {
    println("We're overachievers, doing a second thing!!!")
  }

  private fun feelingAmbitious(): Boolean {
    return motivationLevel > 90
  }
}
