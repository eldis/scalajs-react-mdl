package eldis.mdl.examples.ex1

import eldis.react.mdl.components.{ FABButton, IconButton, _ }
import eldis.react.vdom._
import eldis.react.vdom.prefix_<^._
import eldis.react._
import eldis.redux.Dispatcher
import eldis.redux.react.eldis.connect
import eldis.redux.rrf._

object TestForm {
  case class RefRow(id: String, value: String)
  implicit val rg: RowGetters[RefRow, String] = new RowGetters[RefRow, String] {
    def getId(r: RefRow) = r.id
    def getDesc(r: RefRow) = r.value
  }
  val ref = List(
    RefRow("1", "Test 1"),
    RefRow("2", "Test 2"),
    RefRow("3", "Test 3")
  )

  case class RefRowInt(id: Int, value: String)
  implicit val rgInt: RowGetters[RefRowInt, Int] = new RowGetters[RefRowInt, Int] {
    def getId(r: RefRowInt) = r.id
    def getDesc(r: RefRowInt) = r.value
  }
  val refInt = List(
    RefRowInt(1, "Test 1"),
    RefRowInt(2, "Test 2"),
    RefRowInt(3, "Test 3")
  )

  case class Props(
    onDlgTypeChange: (DialogType) => Unit
  )

  val component = FunctionalComponent[Props]("UserForm") { props =>
    <.div()(
      <.div(^.className := "form-row")(
        <.div(^.className := "col-7-em")(Label("Checkbox:")),
        <.div(^.className := "margin")(
          Checkbox(
            Checkbox.Props(
              label = Some("This is a checkbox"),
              onChange = Some(e => println(e.target.value)),
              defaultChecked = Some(true)
            )
          )
        )
      ),
      <.div(^.className := "form-row")(
        <.div(^.className := "col-7-em")(Label("Radio:")),
        <.div(^.className := "margin")(
          Radio(
            "Radio 1",
            "radio group 1",
            "value 0",
            Some(
              (e: ReactEventI) => {
                org.scalajs.dom.window.alert("value of radio 1 = \"" + e.target.value + "\"")
              }
            ),
            defaultChecked = Some(true)
          )
        ),
        <.div(^.className := "margin")(
          Radio(
            "Radio 2",
            "radio group 1",
            "value 1",
            Some(
              (e: ReactEventI) => {
                org.scalajs.dom.window.alert("value of radio 2 = \"" + e.target.value + "\"")
              }
            )
          )
        )
      ),
      <.div(^.className := "form-row")(
        <.div(^.className := "col-7-em")(Label("Buttons:")),
        <.div(^.className := "margin")(FlatButton("Flat", onClick = Some(() => props.onDlgTypeChange(DialogType.SimpleDialog)))),
        <.div(^.className := "margin")(RaisedButton("Raised", onClick = Some(() => props.onDlgTypeChange(DialogType.SecondDialog)))),
        <.div(^.className := "margin")(ColoredButton("Colored", onClick = Some(() => props.onDlgTypeChange(DialogType.DialogWithCancel)))),
        <.div(^.className := "margin")(AccentButton("Accent", onClick = Some(() => props.onDlgTypeChange(DialogType.SimpleDialog)))),
        <.div(^.className := "margin")(FABButton("warning", onClick = Some(() => props.onDlgTypeChange(DialogType.SecondDialog)))),
        <.div(^.className := "margin")(FABButton("warning", onClick = Some(() => props.onDlgTypeChange(DialogType.DialogWithCancel)))),
        <.div(^.className := "margin")(IconButton("warning", onClick = Some(() => props.onDlgTypeChange(DialogType.SimpleDialog))))
      ),
      <.div(^.className := "form-row")(
        <.div(^.className := "col-7-em")(Label("Text control:")),
        <.div(^.className := "colRight")(Text(Text.Props(label = "Enter text", defaultValue = Some("123"), className = Seq("controlWidth"))))
      ),
      <.div(^.className := "form-row")(
        <.div(^.className := "col-7-em")(Label("Password:")),
        <.div(^.className := "colRight")(Password(Text.Props(label = "Enter password", defaultValue = Some("123"), className = Seq("controlWidth"))))
      ),
      <.div(^.className := "form-row")(
        <.div(^.className := "col-7-em")(Label("Textarea:")),
        <.div(^.className := "colRight")(TextArea(Text.Props(label = "", rows = Some(3), defaultValue = Some("123"), className = Seq("controlWidth"))))
      ),
      <.div(^.className := "form-row")(
        <.div(^.className := "col-7-em")(Label("Integer:")),
        <.div(^.className := "colRight")(Integer(Text.Props(label = "", defaultValue = Some("12"), className = Seq("controlWidth"))))
      ),
      <.div(^.className := "form-row")(
        <.div(^.className := "col-7-em")(Label("Float:")),
        <.div(^.className := "colRight")(Float(Text.Props(label = "", defaultValue = Some("12.12"), className = Seq("controlWidth"))))
      ),
      <.div(^.className := "form-row")(
        <.div(^.className := "col-7-em")(Label("Fraction:")),
        <.div(^.className := "colRight")(Fraction(Text.Props(label = "", defaultValue = Some("12/13"), className = Seq("controlWidth"))))
      ),
      <.div(^.className := "form-row")(
        <.div(^.className := "col-7-em")(Label("Date:")),
        <.div(^.className := "colRight")(Date(Text.Props(label = "", defaultValue = Some("12.12.2012"), className = Seq("controlWidth"))))
      ),
      <.div(^.className := "form-row")(
        <.div(^.className := "col-7-em")(Label("Time:")),
        <.div(^.className := "colRight")(Time(Text.Props(label = "", defaultValue = Some("12:12"), className = Seq("controlWidth"))))
      ),
      <.div(^.className := "form-row")(
        <.div(^.className := "col-7-em")(Label("Reference")),
        <.div(^.className := "colRight")(Reference(Reference.Props[RefRow, String](label = "Select value...", ref = ref, value = Some("3"))))
      ),
      <.div(^.className := "form-row")(
        <.div(^.className := "col-7-em")(Label("Menu:")),
        <.div(^.className := "margin")(
          Menu(id = "test", iconName = "more_vert", valign = Some("top"), align = Some("left"))(
            MenuItem(label = "Some Action 1", onClick = Some(() => println("click1"))),
            MenuItem(label = "Some Action 2", disabled = Some(true), onClick = Some(() => println("click2")))
          )
        )
      ),
      <.div(^.className := "form-row")(
        <.div(^.className := "col-7-em")(Label("MultiSelectField")),
        <.div(^.className := "colRight")(
          MultiSelectField(MultiSelectField.Props[RefRowInt, Int](
            label = "Select values..",
            ref = refInt,
            onChange = Some((v) => println(v)),
            required = Some(true),
            requiredText = Some("Required field"),
            value = Some(Seq(1, 3))
          ))
        )
      ),
      <.div(^.className := "form-row")(
        <.div(^.className := "col-7-em")(Label("CustomMdlComponent")),
        <.div(^.className := "colRight")(
          Control(
            Control.Props(
              GenLens[Main.State](_.testForm.user),
              component = Some(CustomMdlComponent.component)
            )
          )()
        )
      )
    )
  }

  val connectedComponent = connect(
    (dispatch: Dispatcher[Action]) => {
      val onDlgTypeChange = (t: DialogType) => dispatch(OpenDlg(t))
      (s: Main.State) => Props(onDlgTypeChange)
    },
    component
  )

  def apply(): ReactDOMElement = React.createElement(connectedComponent, ())
}

