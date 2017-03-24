package eldis.react.mdl.components

import eldis.react._

import scalajs.js
import js.JSConverters._
import js.annotation.{ JSImport, ScalaJSDefined }
import eldis.react.mdl._

object Reference {

  case class Props[R, ID](
    label: String,
    value: Option[ID] = None,
    ref: Seq[R] = Nil,
    onChange: Option[ID => Unit] = None,
    className: Seq[String] = Nil,
    key: Option[String] = None,
    style: Option[js.Object] = None
  )
  trait PropsImpl[R, ID] {
    val pr: Props[R, ID]
    val rg: RowGetters[R, ID]
  }

  object NativeField {
    @js.native
    trait Props extends CommonProps {
      val label: String = js.native
      val value: js.UndefOr[js.Any] = js.native
      val onChange: js.UndefOr[js.Function1[js.Any, Unit]] = js.native
    }

    object Props {
      def apply(
        label: String,
        value: Option[js.Any],
        onChange: Option[js.Any => Unit] = None,
        className: Seq[String] = Nil,
        key: Option[String] = None,
        style: Option[js.Object] = None
      ) =
        js.Dynamic.literal(
          label = label,
          value = value.orUndefined,
          onChange = onChange.orUndefined,
          className = fillClassAttr(className).orUndefined,
          key = key.orUndefined,
          style = style.orUndefined
        ).asInstanceOf[Props]
    }

    @JSImport("react-mdl-extra", "SelectField")
    @js.native
    object Component extends JSComponent[Props]
    def apply(props: Props)(ch: ReactNode*) = React.createElement(Component, props, ch)
  }

  @ScalaJSDefined
  class NativeFieldWrapper[R, ID] extends Component[PropsImpl[R, ID]]("MultiSelectField.stateful") {

    case class State(value: Option[ID])

    def initialState: State = State(None)

    def onChange(v: ID): Unit = {
      setState(State(Some(v)))
      this.props.pr.onChange.map(h => h(v)).getOrElse(Unit)
    }

    def render = {
      val props = this.props.pr
      val getter = this.props.rg
      val s = this.state
      val children = props.ref.map(row => Option(Option.Props(value = getter.toJsAny(getter.getId(row))))(getter.getDesc(row)))
      val value = s.value.getOrElse(props.value.getOrElse(None)).asInstanceOf[js.Any]

      NativeField(
        NativeField.Props(
          label = props.label,
          value = Some(value),
          className = props.className,
          key = props.key,
          style = props.style,
          onChange = Some(v => onChange(getter.fromJsAny(v)))
        )
      )(children: _*)
    }
  }

  object NativeFieldWrapper {
    def apply[R, ID](prop: Reference.Props[R, ID], children: ReactNode*)(implicit getters: RowGetters[R, ID]): ReactDOMElement = {
      val c = js.constructorOf[NativeFieldWrapper[R, ID]]
      val p = new PropsImpl[R, ID] {
        val pr = prop
        val rg = getters
      }

      val props = implicitly[Wrapper[Wrapped, PropsImpl[R, ID]]].wrap(p)
      JSReact.createElement(c, props, children: _*)
    }
  }

  def apply[R, ID](prop: Reference.Props[R, ID], children: ReactNode*)(implicit getters: RowGetters[R, ID]): ReactDOMElement = {
    NativeFieldWrapper(prop, children: _*)(getters)
  }
}
