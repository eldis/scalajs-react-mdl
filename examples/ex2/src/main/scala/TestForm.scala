package eldis.mdl.examples.ex2

import eldis.react.mdl.components.{ FABButton, IconButton, _ }
import eldis.react.vdom._
import eldis.react.vdom.prefix_<^._
import eldis.react._
import eldis.redux.Dispatcher
import eldis.redux.react.eldis.connect
import eldis.redux.rrf._
import eldis.redux.rrf.syntax._

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
    Form(Form.Props(
      GenLens[State](_.testForm)
    ))(
      <.div(^.className := "form-row")(
        <.div(^.className := "col-7-em")(Label("Checkbox:")),
        <.div(^.className := "margin")(
          Checkbox(Checkbox.Props(label = Some("This is a checkbox"), onChange = Some(e => println(e.target.value))))
            .control(GenLens[TestFormState](_.checkBoxFiled).partial)
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
        <.div(^.className := "colRight")(Text(Text.Props(label = "Enter text", className = Seq("controlWidth")))
          .control(GenLens[TestFormState](_.textField).partial))
      ),
      <.div(^.className := "form-row")(
        <.div(^.className := "col-7-em")(Label("Password:")),
        <.div(^.className := "colRight")(Password(Text.Props(label = "Enter password", className = Seq("controlWidth")))
          .control(GenLens[TestFormState](_.passwordField).partial))
      ),
      <.div(^.className := "form-row")(
        <.div(^.className := "col-7-em")(Label("Textarea:")),
        <.div(^.className := "colRight")(TextArea(Text.Props(label = "", rows = Some(3), className = Seq("controlWidth")))
          .control(GenLens[TestFormState](_.textAreaField).partial))
      ),
      <.div(^.className := "form-row")(
        <.div(^.className := "col-7-em")(Label("Integer:")),
        <.div(^.className := "colRight")(Integer(Text.Props(label = "", className = Seq("controlWidth")))
          .control(GenLens[TestFormState](_.integerField).partial))
      ),
      <.div(^.className := "form-row")(
        <.div(^.className := "col-7-em")(Label("Float:")),
        <.div(^.className := "colRight")(Float(Text.Props(label = "", className = Seq("controlWidth")))
          .control(GenLens[TestFormState](_.floatField).partial))
      ),
      <.div(^.className := "form-row")(
        <.div(^.className := "col-7-em")(Label("Fraction:")),
        <.div(^.className := "colRight")(Fraction(Text.Props(label = "", className = Seq("controlWidth")))
          .control(GenLens[TestFormState](_.fractionField).partial))
      ),
      <.div(^.className := "form-row")(
        <.div(^.className := "col-7-em")(Label("Date:")),
        <.div(^.className := "colRight")(Date(Text.Props(label = "", className = Seq("controlWidth")))
          .control(GenLens[TestFormState](_.dateField).partial))
      ),
      <.div(^.className := "form-row")(
        <.div(^.className := "col-7-em")(Label("Time:")),
        <.div(^.className := "colRight")(Time(Text.Props(label = "", className = Seq("controlWidth")))
          .control(GenLens[TestFormState](_.timeField).partial))
      ),
      <.div(^.className := "form-row")(
        <.div(^.className := "col-7-em")(Label("Reference")),
        <.div(^.className := "colRight")(
          Reference(Reference.Props[RefRow, String]("Select value...", ref))
            .control(GenLens[TestFormState](_.referenceField).partial)
        )
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
          MultiSelectField(MultiSelectField.Props[RefRowInt, Int]("Select values..", refInt, Some(true), Some("Required field")))
            .control(GenLens[TestFormState](_.multiSelectField).partial)
        )
      )
    )
  }

  val connectedComponent: FunctionalComponent[Unit] = connect(
    (dispatch: Dispatcher[Action]) => {
      val onDlgTypeChange = (t: DialogType) => dispatch(OpenDlg(t))
      (s: State) => Props(onDlgTypeChange)
    },
    component
  )

  def apply(): ReactDOMElement = React.createElement(connectedComponent, ())
}

