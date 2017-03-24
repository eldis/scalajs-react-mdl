/**
 * Created by kirill on 08.02.2017.
 */

package eldis.react.mdl.components

import eldis.react._
import eldis.react.mdl._
import eldis.react.vdom._

import scalajs.js
import js.annotation.JSImport
import js.JSConverters._

object Radio {

  @js.native
  trait Props extends CommonProps {
    val name: String = js.native
    val value: String = js.native
    val disabled: js.UndefOr[Boolean] = js.native
    val ripple: js.UndefOr[Boolean] = js.native
    val onChange: js.UndefOr[js.Function1[js.Any, Unit]] = js.native
    val defaultChecked: js.UndefOr[Boolean] = js.native
  }

  object Props {
    def apply(groupName: String, value: String, className: Seq[String] = Nil, key: Option[String] = None,
      style: Option[js.Object] = None, disabled: Option[Boolean] = None, ripple: Option[Boolean] = None,
      onChange: Option[ReactEventI => Unit] = None, defaultChecked: Option[Boolean] = None) = js.Dynamic.literal(
      name = groupName,
      value = value,
      className = fillClassAttr(className).orUndefined,
      key = key.orUndefined,
      style = style.orUndefined,
      disabled = disabled.orUndefined,
      ripple = ripple.orUndefined,
      onChange = onChange.orUndefined,
      defaultChecked = defaultChecked.orUndefined
    ).asInstanceOf[Props]
  }

  @JSImport("react-mdl", "Radio")
  @js.native
  object Component extends JSComponent[Props]

  def apply(props: Props, children: ReactNode*) = React.createElement(Component, props, children)

  def apply(label: String, groupName: String, value: String, onChange: Option[ReactEventI => Unit] = None,
    defaultChecked: Option[Boolean] = None, disabled: Option[Boolean] = None) =
    React.createElement(
      Component,
      Props(disabled = disabled, groupName = groupName, value = value, onChange = onChange, ripple = Some(true), defaultChecked = defaultChecked),
      Seq[ReactNode](label)
    )
}
