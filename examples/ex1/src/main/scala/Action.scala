package eldis.mdl.examples.ex1

sealed trait Action
case class OpenDlg(dlgType: DialogType) extends Action
case object CloseDlg extends Action
