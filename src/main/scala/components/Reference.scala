package eldis.react.mdl.components

import eldis.react._

import scalajs.js
import js.JSConverters._
import js.annotation.{ JSImport, ScalaJSDefined }
import eldis.react.mdl._
import eldis.react.util.ElementBuilder

object Reference {

  private object NativeField {
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
          className = fillClassAttr("es-reference" +: className).orUndefined,
          key = key.orUndefined,
          style = style.orUndefined
        ).asInstanceOf[Props]
    }

    @JSImport("react-mdl-extra", "SelectField")
    @js.native
    object Component extends JSComponent[Props]
    def apply(props: Props)(ch: ReactNode*) = ElementBuilder(Component, props)(ch: _*)
  }

  @ScalaJSDefined
  trait Props[R, ID] extends js.Object {
    val className: Seq[String]
    val key: js.UndefOr[String]
    val style: js.UndefOr[js.Object]
    val label: String
    val value: js.UndefOr[ID]
    val onChange: js.UndefOr[js.Function1[ID, Unit]]
    val refItems: Seq[R]
    val rg: RowGetters[R, ID]
  }

  object Props {
    def apply[R, ID](
      initLabel: String = "",
      initRefItems: Seq[R] = Nil,
      initClassName: Seq[String] = Nil,
      initKey: Option[String] = None,
      initStyle: Option[js.Object] = None,
      initValue: Option[ID] = None,
      initOnChange: Option[js.Function1[ID, Unit]] = None
    )(implicit initRowGetter: RowGetters[R, ID]) = new Props[R, ID] {
      val label: String = initLabel
      val className: Seq[String] = initClassName
      val key: js.UndefOr[String] = initKey.orUndefined
      val style: js.UndefOr[js.Object] = initStyle.orUndefined
      val value: js.UndefOr[ID] = initValue.orUndefined
      val onChange: js.UndefOr[js.Function1[ID, Unit]] = initOnChange.orUndefined
      val refItems: Seq[R] = initRefItems
      val rg: RowGetters[R, ID] = initRowGetter
    }
  }

  @ScalaJSDefined
  private class NativeFieldWrapper[R, ID] extends ComponentBase[Identity, Props[R, ID]]("MultiSelectField.stateful") {

    case class State(value: Option[ID])

    def initialState: State = State(None)

    def onChange(v: ID): Unit = {
      setState(State(Some(v)))
      this.props.onChange.foreach(h => h(v))
    }

    def render = {
      val props = this.props
      val getter = this.props.rg
      val s = this.state
      val children = props.refItems.map(row => Option(Option.Props(value = getter.toJsAny(getter.getId(row))))(getter.getDesc(row)): ReactNode)
      val value = s.value.getOrElse(props.value.getOrElse(None)).asInstanceOf[js.Any]

      NativeField(
        NativeField.Props(
          label = props.label,
          value = Some(value),
          className = props.className,
          key = props.key.toOption,
          style = props.style.toOption,
          onChange = Some(v => onChange(getter.fromJsAny(v)))
        )
      )(children: _*)
    }
  }

  private object NativeFieldWrapper {
    val component = js.constructorTag[NativeFieldWrapper[String, Int]].constructor.asInstanceOf[NativeComponentType.WithChildren[Props[_, _]]]

    def apply[R, ID](prop: Reference.Props[R, ID], children: ReactNode*): ElementBuilder[NativeComponentType.WithChildren[Props[_, _]], Props[_, _], Seq[ReactNode]] = {
      ElementBuilder(component, prop: Props[_, _], children)
    }
  }

  def apply[R, ID](prop: Reference.Props[R, ID], children: ReactNode*) = {
    NativeFieldWrapper(prop, children: _*)
  }
}
