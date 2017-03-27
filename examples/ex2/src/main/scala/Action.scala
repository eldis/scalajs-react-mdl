package eldis.mdl.examples.ex2

import eldis.react.vdom._

sealed trait Action

case class OpenDlg(dlgType: DialogType) extends Action
case object CloseDlg extends Action
