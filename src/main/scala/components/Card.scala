/**
 * Created by kirill on 08.02.2017.
 */

package eldis.react.mdl.components

import eldis.react._
import eldis.react.mdl._
import eldis.react.util.ElementBuilder

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import js.JSConverters._

object Card {

  @js.native
  trait Props extends CommonProps {
    val shadow: js.UndefOr[Int] = js.native
  }

  object Props {
    def apply(
      shadow: Option[Int] = None,
      style: Option[js.Object] = None,
      className: Seq[String] = Nil,
      key: Option[String] = None
    ) = js.Dynamic.literal(
      className = fillClassAttr("es-card" +: className).orUndefined,
      key = key.orUndefined,
      style = style.orUndefined,
      shadow = shadow.getOrElse(0).toInt
    ).asInstanceOf[Props]
  }

  @JSImport("react-mdl", "Card")
  @js.native
  object Component extends JSComponent[Props]

  def apply(props: Props) = ElementBuilder(Component, props)
}

object CardTitle {

  @js.native
  trait Props extends CommonProps {
    val expand: js.UndefOr[Boolean] = js.native
  }

  object Props {
    def apply(
      expand: Option[Boolean] = None,
      className: Seq[String] = Nil,
      key: Option[String] = None,
      style: Option[js.Object] = None
    ) = js.Dynamic.literal(
      expand = expand.orUndefined,
      className = fillClassAttr("es-card--title" +: className).orUndefined,
      key = key.orUndefined,
      style = style.orUndefined
    ).asInstanceOf[Props]
  }

  @JSImport("react-mdl", "CardTitle")
  @js.native
  object Component extends JSComponent[Props]

  def apply()(children: ReactNode*) = ElementBuilder(Component, Props())(children: _*)
  def apply(props: Props)(children: ReactNode*) = ElementBuilder(Component, props)(children: _*)
}
object CardActions {

  @js.native
  trait Props extends CommonProps {
    val border: js.UndefOr[Boolean] = js.native
  }

  object Props {
    def apply(
      border: Option[Boolean] = None,
      className: Seq[String] = Nil,
      key: Option[String] = None,
      style: Option[js.Object] = None
    ) = js.Dynamic.literal(
      border = border.orUndefined,
      className = fillClassAttr("es-card--action" +: className).orUndefined,
      key = key.orUndefined,
      style = style.orUndefined
    ).asInstanceOf[Props]
  }

  @JSImport("react-mdl", "CardActions")
  @js.native
  object Component extends JSComponent[Props]

  def apply()(children: ReactNode*) = ElementBuilder(Component, Props())(children: _*)
  def apply(props: Props)(children: ReactNode*) = ElementBuilder(Component, props)(children: _*)
}

object CardText {
  object Props {
    def apply(
      className: Seq[String] = Nil,
      key: Option[String] = None,
      style: Option[js.Object] = None
    ) = js.Dynamic.literal(
      className = fillClassAttr("es-card--text" +: className).orUndefined,
      key = key.orUndefined,
      style = style.orUndefined
    ).asInstanceOf[CommonProps]
  }
  @JSImport("react-mdl", "CardText")
  @js.native
  object Component extends JSComponent[CommonProps]

  def apply()(children: ReactNode*) = ElementBuilder(Component, Props())(children: _*)
  def apply(props: CommonProps)(children: ReactNode*) = ElementBuilder(Component, props)(children: _*)
}

object CardMenu {
  object Props {
    def apply(
      className: Seq[String] = Nil,
      key: Option[String] = None,
      style: Option[js.Object] = None
    ) = js.Dynamic.literal(
      className = fillClassAttr("es-card--menu" +: className).orUndefined,
      key = key.orUndefined,
      style = style.orUndefined
    ).asInstanceOf[CommonProps]
  }
  @JSImport("react-mdl", "CardMenu")
  @js.native
  object Component extends JSComponent[CommonProps]

  def apply()(children: ReactNode*) = ElementBuilder(Component, Props())(children: _*)
  def apply(props: CommonProps)(children: ReactNode*) = ElementBuilder(Component, props)(children: _*)
}
