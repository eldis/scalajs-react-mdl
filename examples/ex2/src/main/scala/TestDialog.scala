package eldis.mdl.examples.ex2

import eldis.react.{ FunctionalComponent, React, ReactDOMElement }
import eldis.react.mdl.components.{ Dialog, DialogActions, Label, RaisedButton }
import eldis.react.vdom.prefix_<^.<
import eldis.redux.Dispatcher
import eldis.redux.react.eldis.connect

sealed trait DialogType
object DialogType {
  case object SimpleDialog extends DialogType
  case object SecondDialog extends DialogType
  case object DialogWithCancel extends DialogType
}

object TestDialog {
  private case class Props(
    dlgType: Option[DialogType],
    onCloseDialog: () => Unit
  )

  private val component = FunctionalComponent[Props]("UserForm") { props =>
    {
      props.dlgType match {
        case Some(DialogType.SimpleDialog) =>
          Dialog(Some("Simple"), true, className = "width-30-em" :: Nil,
            Seq(
              RaisedButton("Some Button"),
              RaisedButton("CLOSE", onClick = Some(props.onCloseDialog))
            ))(Label("Simple Dialog"))

        case Some(DialogType.SecondDialog) =>
          Dialog(Some("fullWidth Buttons"), true, "width-30-em" :: Nil,
            Seq(
              RaisedButton("Some Button"),
              RaisedButton("CLOSE", onClick = Some(props.onCloseDialog))
            ),
            actionsProps = DialogActions.Props(fullWidth = Some(true)))(Label("Dialog with fullWidth Buttons"))

        case Some(DialogType.DialogWithCancel) =>
          Dialog(Some("With Cancel"), true, "width-30-em" :: Nil,
            Seq(
              RaisedButton("Some Button"),
              RaisedButton("CLOSE", onClick = Some(props.onCloseDialog))
            ),
            Some(props.onCloseDialog))(Label("Dialog with cancel action"))
        case _ => <.div()()
      }
    }
  }

  private val connectedComponent: FunctionalComponent[Unit] = connect(
    (dispatch: Dispatcher[Action]) => {
      val onDlgClose = () => dispatch(CloseDlg)
      (s: State) => Props(s.testForm.dlgType, onDlgClose)
    },
    component
  )

  def apply(): ReactDOMElement = React.createElement(connectedComponent, ())
}
