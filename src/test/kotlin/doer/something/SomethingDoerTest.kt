package doer.something

import org.junit.Test

import org.junit.Before
import kotlin.reflect.KFunction
import kotlin.reflect.jvm.javaMethod

class SomethingDoerTest {

  class TestSomethingDoer(motivationLevel: Int) : SomethingDoer(motivationLevel) {
    fun testDoOneLittleThing() {
      super.doOneLittleThing()
    }
  }
  private lateinit var doer: SomethingDoer
  private lateinit var doerWrapper: TestSomethingDoer

  @Before
  fun setUp() {
    doer = SomethingDoer(99)
    doerWrapper = TestSomethingDoer(99)
  }

  @Test
  fun doSomething() {
    doer.doSomething()
    // assert
  }

  @Test
  fun Test_doOneLittleThing() {
    doerWrapper.testDoOneLittleThing()
    callPrivate(doer, "doOneLittleThing")
    // assert
  }


  @Test
  fun Test_maybeDoSecondLittleThing() {
    callPrivate(doer, "maybeDoSecondLittleThing")
    // assert
  }

  fun callPrivate(objectInstance: Any, methodName: String, vararg args: Any?): Any? {
    val privateMethod: KFunction<*>? =
        objectInstance::class.members.find { t -> return@find t.name == methodName } as KFunction<*>?

    val argList = args.toMutableList()
    (argList as ArrayList).add(0, objectInstance)
    val argArr = argList.toArray()

    if (privateMethod?.javaMethod?.trySetAccessible()!!) {
      privateMethod?.apply {
        return call(*argArr)
      } ?: throw NoSuchMethodException("Method $methodName does not exist in ${objectInstance::class.qualifiedName}")
    } else throw IllegalAccessException("Method $methodName could not be made accessible")

    return null
  }
}
