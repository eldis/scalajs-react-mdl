package eldis.mdl.examples.ex2

import scalajs.js
import org.scalajs.dom

import js.annotation._
import scala.concurrent.ExecutionContext.Implicits.global
import eldis.react._
import eldis.react.vdom.prefix_<^.<
import eldis.redux._
import eldis.redux.react.{ eldis => react }

object Main extends js.JSApp {

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

  def main(): Unit = {
    val store = createStore[State, Action](
      Reducers.reducer _,
      State.initialState,
      Reducers.rawReducer,
      applyMiddleware(Seq(createLogger()))
    )

    ReactDOM.render(App(store), dom.document.getElementsByClassName("testApp")(0))
  }
}
