package eldis.mdl.examples.ex1

import eldis.mdl.examples.ex1.Main.{ State, TestFormState }

import scala.scalajs.js
import eldis.redux.rrf.{ Forms, GenLens }
import eldis.redux.rrf.util.chainReducers

object Reducers {
  def rawReducer: js.Function2[State, js.Object, State] = {
    val forms = Forms(GenLens[State](_.rrfData))(
      GenLens[State](_.testForm) -> Main.initialTestForm
    )
    chainReducers(forms)
  }

  def reducer(s: State, a: Action): State =
    a match {
      case OpenDlg(dt) =>
        new State {
          val testForm = new TestFormState {
            override val user: String = s.testForm.user
            override val dlgType: Option[DialogType] = Some(dt)
          }
        }
      case CloseDlg =>
        new State {
          val testForm = new TestFormState {
            override val user: String = s.testForm.user
            override val dlgType: Option[DialogType] = None
          }
        }
      case _ => s
    }
}
