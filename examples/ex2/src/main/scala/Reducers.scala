package eldis.mdl.examples.ex2

import scala.scalajs.js
import eldis.redux.rrf.{ Forms, GenLens }
import eldis.redux.rrf.util.chainReducers

object Reducers {
  def rawReducer: js.Function2[State, js.Object, State] = {
    val forms = Forms(GenLens[State](_.rrfData))(
      GenLens[State](_.testForm) -> TestFormState.initialTestForm
    )
    chainReducers(forms)
  }

  def reducer(s: State, a: Action): State =
    a match {
      case OpenDlg(dt) => {
        val newTestFormState = s.testForm.copy(dlgType = Some(dt))
        s.copy(testForm = newTestFormState)
      }
      case CloseDlg => {
        val newTestFormState = s.testForm.copy(dlgType = None)
        s.copy(testForm = newTestFormState)
      }
      case _ => s
    }
}
