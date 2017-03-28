/**
 * Created by kirill on 07.02.2017.
 */
package eldis.react.mdl.components

import eldis.react._
import eldis.react.mdl._
import eldis.react.util.ElementBuilder
import eldis.react.vdom._

import scalajs.js
import js.annotation.JSImport
import js.JSConverters._

object Checkbox {

  @js.native
  trait Props extends CommonProps {
    val label: js.UndefOr[String] = js.native
    val ripple: js.UndefOr[Boolean] = js.native
    val checked: Option[Boolean] = js.native
    val disabled: Option[Boolean] = js.native
    val onChange: js.UndefOr[js.Function1[js.Any, Unit]] = js.native
    val defaultChecked: js.UndefOr[Boolean] = js.native
  }
  object Props {
    def apply(
      className: Seq[String] = Nil,
      key: Option[String] = None,
      style: Option[js.Object] = None,
      label: Option[String] = None,
      ripple: Option[Boolean] = None,
      checked: Option[Boolean] = None,
      disabled: Option[Boolean] = None,
      onChange: Option[ReactEventI => Unit] = None,
      defaultChecked: Option[Boolean] = None
    ) =
      js.Dynamic.literal(
        className = fillClassAttr("es-checkbox" +: className).orUndefined,
        key = key.orUndefined,
        style = style.orUndefined,
        label = label.orUndefined,
        ripple = ripple.orUndefined,
        checked = checked.orUndefined,
        disabled = disabled.orUndefined,
        onChange = onChange.orUndefined,
        defaultChecked = defaultChecked.orUndefined
      ).asInstanceOf[Props]
  }
  @JSImport("react-mdl", "Checkbox")
  @js.native
  object Component extends JSComponent[Props]

  def apply(p: Props) = ElementBuilder(Component, p)
  def apply(label: String) = ElementBuilder(Component, Props(label = Some(label)))
}