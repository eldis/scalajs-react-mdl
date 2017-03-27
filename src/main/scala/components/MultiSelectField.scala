package eldis.react.mdl.components

import eldis.react.mdl.CommonProps

import scalajs.js
import js.JSConverters._
import js.annotation.{ JSImport, ScalaJSDefined }
import eldis.react._
import eldis.react.mdl._
import eldis.react.util.ElementBuilder
import eldis.react.vdom._

import scala.scalajs.js.|

object MultiSelectField {
  case class Props[R, ID](
    label: String,
    ref: Seq[R] = Nil,
    value: Option[Seq[ID]] = None,
    required: Option[Boolean] = None,
    requiredText: Option[String] = None,

    className: Seq[String] = Nil,
    key: Option[String] = None,
    style: Option[js.Object] = None,
    align: Option[String] = None,
    chipsAfter: Option[Boolean] = None,
    chipsOutside: Option[Boolean] = None,
    error: Option[String | Boolean] = None,
    offset: Option[String] = None,
    onFocus: Option[ReactEventI => Unit] = None,
    onBlur: Option[ReactEventI => Unit] = None,
    onChange: Option[js.Array[ID] => Unit] = None,
    readOnly: Option[Boolean] = None,
    showChipsBelow: Option[Boolean] = None
  )

  trait PropsImpl[R, ID] {
    val pr: Props[R, ID]
    val rg: RowGetters[R, ID]
  }

  object NativeField {
    @js.native
    trait Props extends CommonProps {
      val label: String = js.native
      val value: js.Array[js.Any] = js.native
      val children: js.Array[js.Any] = js.native
      val align: js.UndefOr[String] = js.native
      val chipsAfter: js.UndefOr[Boolean] = js.native
      val chipsOutside: js.UndefOr[Boolean] = js.native
      val error: js.UndefOr[String | Boolean] = js.native
      val offset: js.UndefOr[String] = js.native
      val onFocus: js.UndefOr[js.Function1[js.Any, Unit]] = js.native
      val onBlur: js.UndefOr[js.Function1[js.Any, Unit]] = js.native
      val onChange: js.UndefOr[js.Function1[js.Any, Unit]] = js.native
      val readOnly: js.UndefOr[Boolean] = js.native
      val showChipsBelow: js.UndefOr[Boolean] = js.native
    }

    object Props {
      def apply(
        label: String,
        children: Seq[js.Any],
        value: Seq[js.Any] = Nil,
        onChange: Option[js.Array[js.Any] => Unit] = None,
        className: Seq[String] = Nil,
        key: Option[String] = None,
        style: Option[js.Object] = None,
        align: Option[String] = None,
        chipsAfter: Option[Boolean] = None,
        chipsOutside: Option[Boolean] = None,
        error: Option[String | Boolean] = None,
        offset: Option[String] = None,
        onFocus: Option[ReactEventI => Unit] = None,
        onBlur: Option[ReactEventI => Unit] = None,
        readOnly: Option[Boolean] = None,
        showChipsBelow: Option[Boolean] = None
      ) = js.Dynamic.literal(
        label = label,
        children = children.toJSArray,
        value = value.toJSArray,
        onChange = onChange.orUndefined,
        className = fillClassAttr(className).orUndefined,
        key = key.orUndefined,
        style = style.orUndefined,
        align = align.orUndefined,
        chipsAfter = chipsAfter.orUndefined,
        chipsOutside = chipsOutside.orUndefined,
        error = error.orUndefined.asInstanceOf[js.Any],
        offset = offset.orUndefined,
        onFocus = onFocus.orUndefined,
        onBlur = onBlur.orUndefined,
        readOnly = readOnly.orUndefined,
        showChipsBelow = showChipsBelow.orUndefined
      ).asInstanceOf[Props]
    }

    @JSImport("react-mdl-extra", "MultiSelectField")
    @js.native
    object Component extends JSComponent[Props]
    def apply(props: Props)(children: ReactNode*) = ElementBuilder(Component, props)(children: _*)
  }

  @ScalaJSDefined
  class NativeFieldWrapper[R, ID] extends Component[PropsImpl[R, ID]]("MultiSelectField.stateful") {

    case class State(value: Option[Seq[ID]])

    def initialState: State = State(None)

    def onChange(v: js.Array[ID]): Unit = {
      setState(State(Some(v)))
      this.props.pr.onChange.map(h => h(v)).getOrElse(Unit)
    }

    def render = {
      val props = this.props.pr
      val getter = this.props.rg
      val s = this.state
      val children = props.ref.map(row => Option(Option.Props(value = getter.toJsAny(getter.getId(row))))(getter.getDesc(row)): ReactNode)
      val value = s.value.getOrElse(props.value.getOrElse(Seq()))
      val err: String | Boolean =
        if (props.required.getOrElse(false) && value.isEmpty) {
          props.requiredText.getOrElse("Required").toString
        } else {
          false
        }

      NativeField(
        NativeField.Props(
          label = props.label,
          children = children,
          value = value.map(v => getter.toJsAny(v)),
          error = Some(err),
          className = props.className,
          key = props.key,
          style = props.style,
          align = props.align,
          chipsAfter = props.chipsAfter,
          chipsOutside = props.chipsOutside,
          offset = props.offset,
          onFocus = props.onFocus,
          onBlur = props.onBlur,
          onChange = Some(v => onChange(v.filter(x => x != js.undefined).map(x => getter.fromJsAny(x)))),
          readOnly = props.readOnly,
          showChipsBelow = props.showChipsBelow
        )
      )(children: _*)
    }
  }

  object NativeFieldWrapper {
    def apply[R, ID](prop: MultiSelectField.Props[R, ID], children: ReactNode*)(implicit getters: RowGetters[R, ID]): ReactDOMElement = {
      val c = js.constructorOf[NativeFieldWrapper[R, ID]]
      val p = new PropsImpl[R, ID] {
        val pr = prop
        val rg = getters
      }

      val props = implicitly[Wrapper[Wrapped, PropsImpl[R, ID]]].wrap(p)
      JSReact.createElement(c, props, children: _*)
    }
  }

  def apply[R, ID](prop: MultiSelectField.Props[R, ID], children: ReactNode*)(implicit getters: RowGetters[R, ID]): ReactDOMElement = {
    NativeFieldWrapper(prop, children: _*)(getters)
  }
}

