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
  private object NativeField {
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
        className = fillClassAttr("es-multi--select" +: className).orUndefined,
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
  trait Props[R, ID] extends js.Object {
    val label: String
    val refItems: Seq[R]
    val value: js.UndefOr[Seq[ID]]
    val required: js.UndefOr[Boolean]
    val requiredText: js.UndefOr[String]
    val className: Seq[String]
    val key: js.UndefOr[String]
    val style: js.UndefOr[js.Object]
    val align: js.UndefOr[String]
    val chipsAfter: js.UndefOr[Boolean]
    val chipsOutside: js.UndefOr[Boolean]
    val error: js.UndefOr[String | Boolean]
    val offset: js.UndefOr[String]
    val onFocus: js.UndefOr[js.Function1[ReactEventI, Unit]]
    val onBlur: js.UndefOr[js.Function1[ReactEventI, Unit]]
    val onChange: js.UndefOr[js.Function1[js.Array[ID], Unit]]
    val readOnly: js.UndefOr[Boolean]
    val showChipsBelow: js.UndefOr[Boolean]
    val rg: RowGetters[R, ID]
  }

  object Props {
    def apply[R, ID](
      initLabel: String = "",
      initRefItems: Seq[R] = Nil,
      initRequired: Option[Boolean] = None,
      intiRequiredText: Option[String] = None,
      initOnChange: Option[js.Array[ID] => Unit] = None,
      initValue: Option[Seq[ID]] = None,
      initClassName: Seq[String] = Nil,
      initKey: Option[String] = None,
      initStyle: Option[js.Object] = None,
      initAlign: Option[String] = None,
      initChipsAfter: Option[Boolean] = None,
      initChipsOutside: Option[Boolean] = None,
      initError: Option[String | Boolean] = None,
      initOffset: Option[String] = None,
      initOnFocus: Option[ReactEventI => Unit] = None,
      initOnBlur: Option[ReactEventI => Unit] = None,
      initReadOnly: Option[Boolean] = None,
      initShowChipsBelow: Option[Boolean] = None
    )(implicit initRowGetter: RowGetters[R, ID]) = new Props[R, ID] {
      val label: String = initLabel
      val refItems: Seq[R] = initRefItems
      val value: js.UndefOr[Seq[ID]] = initValue.orUndefined
      val required: js.UndefOr[Boolean] = initRequired.orUndefined
      val requiredText: js.UndefOr[String] = intiRequiredText.orUndefined
      val className: Seq[String] = initClassName
      val key: js.UndefOr[String] = initKey.orUndefined
      val style: js.UndefOr[js.Object] = initStyle.orUndefined
      val align: js.UndefOr[String] = initAlign.orUndefined
      val chipsAfter: js.UndefOr[Boolean] = initChipsAfter.orUndefined
      val chipsOutside: js.UndefOr[Boolean] = initChipsOutside.orUndefined
      val error: js.UndefOr[String | Boolean] = initError.orUndefined
      val offset: js.UndefOr[String] = initOffset.orUndefined
      val onFocus: js.UndefOr[js.Function1[ReactEventI, Unit]] = initOnFocus.orUndefined.map(x => x)
      val onBlur: js.UndefOr[js.Function1[ReactEventI, Unit]] = initOnBlur.orUndefined.map(x => x)
      val onChange: js.UndefOr[js.Function1[js.Array[ID], Unit]] = initOnChange.orUndefined.map(x => x)
      val readOnly: js.UndefOr[Boolean] = initReadOnly.orUndefined
      val showChipsBelow: js.UndefOr[Boolean] = initShowChipsBelow.orUndefined
      val rg: RowGetters[R, ID] = initRowGetter
    }
  }

  @ScalaJSDefined
  private class NativeFieldWrapper[R, ID] extends ComponentBase[Identity, Props[R, ID]]("MultiSelectField.stateful") {

    case class State(value: Option[Seq[ID]])

    def initialState: State = State(None)

    def onChange(v: js.Array[ID]): Unit = {
      setState(State(Some(v)))
      this.props.onChange.foreach(h => h(v))
    }

    def render = {
      val props = this.props
      val getter = this.props.rg
      val s = this.state
      val children = props.refItems.map(row => Option(Option.Props(value = getter.toJsAny(getter.getId(row))))(getter.getDesc(row)): ReactNode)
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
          key = props.key.toOption,
          style = props.style.toOption,
          align = props.align.toOption,
          chipsAfter = props.chipsAfter.toOption,
          chipsOutside = props.chipsOutside.toOption,
          offset = props.offset.toOption,
          onFocus = props.onFocus.toOption.map(x => x),
          onBlur = props.onBlur.toOption.map(x => x),
          onChange = Some(v => onChange(v.filter(x => x != js.undefined).map(x => getter.fromJsAny(x)))),
          readOnly = props.readOnly.toOption,
          showChipsBelow = props.showChipsBelow.toOption
        )
      )(children: _*)
    }
  }

  private object NativeFieldWrapper {
    val component = js.constructorTag[NativeFieldWrapper[String, Int]].constructor.asInstanceOf[NativeComponentType.WithChildren[Props[_, _]]]

    def apply[R, ID](prop: MultiSelectField.Props[R, ID], children: ReactNode*): ElementBuilder[NativeComponentType.WithChildren[Props[_, _]], Props[_, _], Seq[ReactNode]] = {
      ElementBuilder(component, prop: Props[_, _], children)
    }
  }

  def apply[R, ID](prop: MultiSelectField.Props[R, ID], children: ReactNode*) = {
    NativeFieldWrapper(prop, children: _*)
  }
}

