package eldis.react.mdl.components

import scalajs.js
import js.JSConverters._
import js.annotation.JSImport
import eldis.react._
import eldis.react.util.ElementBuilder

private object Option {

  @js.native
  trait Props extends js.Any {
    val key: js.Any = js.native
    val value: js.Any = js.native
    val onClick: js.UndefOr[js.Any] = js.native
    val className: js.UndefOr[String] = js.native
  }

  object Props {
    def apply(
      value: js.Any,
      className: Option[String] = None,
      onClick: js.UndefOr[js.Any] = js.undefined
    ) =
      js.Dynamic.literal(
        key = value, // it's not a typo. Yep, key = value
        value = value,
        onClick = onClick,
        className = className.orUndefined
      ).asInstanceOf[Props]
  }

  @JSImport("react-mdl-extra", "Option")
  @js.native
  object Component extends JSComponent[Props]
  def apply(props: Props)(ch: ReactNode) = ElementBuilder(Component, props)(ch)
}

