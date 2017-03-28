/**
 * Created by kirill on 16.02.2017.
 */

package eldis.react.mdl.components

import eldis.react._
import eldis.react.mdl._
import eldis.react.util.ElementBuilder
import eldis.react.vdom._
import eldis.react.vdom.prefix_<^.<

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import js.JSConverters._

object Menu {

  @js.native
  trait Props extends CommonProps {
    val align: js.UndefOr[String] = js.native
    val ripple: js.UndefOr[Boolean] = js.native
    val target: String = js.native
    val valign: js.UndefOr[String] = js.native
  }

  object Props {
    def apply(
      className: Seq[String] = Nil,
      key: Option[String] = None,
      style: Option[js.Object] = None,
      align: Option[String] = None,
      ripple: Option[Boolean] = None,
      target: String = "",
      valign: Option[String] = None
    ) = js.Dynamic.literal(
      className = fillClassAttr("es-menu" +: className).orUndefined,
      key = key.orUndefined,
      style = style.orUndefined,
      align = align.orUndefined,
      ripple = ripple.orUndefined,
      target = target,
      valign = valign.orUndefined
    ).asInstanceOf[Props]
  }

  @JSImport("react-mdl", "Menu")
  @js.native
  object Component extends JSComponent[Props]

  def apply(target: String)(children: ReactNode*) = ElementBuilder(Component, Props(target = target))(children: _*)
  def apply(props: Props)(children: ReactNode*) = ElementBuilder(Component, props)(children: _*)
  def apply(
    id: String,
    iconName: String,
    align: Option[String] = None,
    ripple: Option[Boolean] = None,
    valign: Option[String] = None
  )(children: ReactNode*) = {
    <.div()(
      IconButton(IconButton.Props(id = Some(id), icon = Some(iconName))),
      ElementBuilder(Component, Props(target = id, align = align, ripple = ripple, valign = valign))(children: _*)
    )
  }
}

object MenuItem {

  @js.native
  trait Props extends CommonProps {
    val disabled: js.UndefOr[Boolean] = js.native
    val onClick: js.UndefOr[js.Function0[Unit]] = js.native
  }

  object Props {
    def apply(
      className: Seq[String] = Nil,
      key: Option[String] = None,
      style: Option[js.Object] = None,
      disabled: Option[Boolean] = None,
      onClick: Option[() => Unit] = None
    ) = js.Dynamic.literal(
      className = fillClassAttr("es-menu--item" +: className).orUndefined,
      key = key.orUndefined,
      style = style.orUndefined,
      disabled = disabled.orUndefined,
      onClick = onClick.orUndefined
    ).asInstanceOf[Props]
  }

  @JSImport("react-mdl", "MenuItem")
  @js.native
  object Component extends JSComponent[Props]

  def apply()(children: ReactNode*) = ElementBuilder(Component, Props())(children: _*)
  def apply(props: Props)(children: ReactNode*) = ElementBuilder(Component, props)(children: _*)
  def apply(
    label: String,
    onClick: Option[() => Unit] = None,
    disabled: Option[Boolean] = None,
    className: Seq[String] = Nil
  ) =
    ElementBuilder(Component, Props(className = className, disabled = disabled, onClick = onClick))(label)
}