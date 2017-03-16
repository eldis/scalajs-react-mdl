package eldis.mdl.examples.ex1

import scalajs.js
import org.scalajs.dom

import js.annotation._
import scala.concurrent.ExecutionContext.Implicits.global
import eldis.react._
import eldis.react.vdom.prefix_<^.<
import eldis.redux._
import eldis.redux.react.{ eldis => react }
import eldis.redux.rrf.{ Forms, GenLens, RRFState }

object Main extends js.JSApp {

  @ScalaJSDefined
  trait TestFormState extends js.Object {
    val dlgType: Option[DialogType]
    val user: String
  }

  @ScalaJSDefined
  trait State extends js.Object {
    val testForm: TestFormState
    val rrfData: RRFState = js.undefined
  }

  def App(store: Store[State, Action]) = {
    val form = TestForm()
    val dlg = TestDialog()
    react.Provider(store)(
      <.div()(
        form,
        dlg
      )
    )
  }

  @JSImport("redux-logger", JSImport.Namespace)
  @js.native
  object createLogger extends js.Object {
    def apply(): Middleware[State, Action] = js.native
  }

  val initialTestForm = new TestFormState {
    override val user: String = "test"
    override val dlgType: Option[DialogType] = None
  }

  val initialState = new State {
    override val testForm: TestFormState = initialTestForm
  }

  def main(): Unit = {
    val store = createStore[State, Action](
      Reducers.reducer _,
      initialState,
      Reducers.rawReducer,
      applyMiddleware(Seq(createLogger()))
    )

    ReactDOM.render(App(store), dom.document.getElementsByClassName("testApp")(0))
  }
}
