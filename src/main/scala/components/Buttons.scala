/**
 * Created by kirill on 08.02.2017.
 */
package eldis.react.mdl.components

import eldis.react._
import eldis.react.mdl._
import eldis.react.util.ElementBuilder

import scalajs.js
import js.annotation.JSImport
import js.JSConverters._

object Button {
  @js.native
  trait Props extends CommonProps {
    val raised: js.UndefOr[Boolean] = js.native
    val colored: js.UndefOr[Boolean] = js.native
    val accent: js.UndefOr[Boolean] = js.native
    val primary: js.UndefOr[Boolean] = js.native
    val disabled: js.UndefOr[Boolean] = js.native
    val onClick: js.UndefOr[js.Function0[Unit]] = js.native
    val ripple: js.UndefOr[Boolean] = js.native
    val title: js.UndefOr[String] = js.native
  }

  object Props {
    def apply(
      className: Seq[String] = Nil,
      key: Option[String] = None,
      style: Option[js.Object] = None,
      raised: Option[Boolean] = None,
      colored: Option[Boolean] = None,
      accent: Option[Boolean] = None,
      primary: Option[Boolean] = None,
      disabled: Option[Boolean] = None,
      onClick: Option[() => Unit] = None,
      ripple: Option[Boolean] = None,
      title: Option[String] = None
    ) = js.Dynamic.literal(
      className = fillClassAttr(className).orUndefined,
      key = key.orUndefined,
      style = style.orUndefined,
      raised = raised.orUndefined,
      colored = colored.orUndefined,
      accent = accent.orUndefined,
      primary = primary.orUndefined,
      disabled = disabled.orUndefined,
      onClick = onClick.orUndefined,
      ripple = ripple.orUndefined,
      title = title.orUndefined
    ).asInstanceOf[Props]
  }

  @JSImport("react-mdl", "Button")
  @js.native
  object Component extends JSComponent[Props]

  def apply(label: String, p: Props = Props()) = ElementBuilder(Component, p)(label)
}

object FlatButton {
  def apply(label: String, onClick: Option[() => Unit] = None, disabled: Option[Boolean] = None, title: Option[String] = None) =
    Button.apply(label, Button.Props(raised = Some(false), disabled = disabled, onClick = onClick, title = title))
}

object RaisedButton {
  def apply(label: String, onClick: Option[() => Unit] = None, disabled: Option[Boolean] = None, title: Option[String] = None) =
    Button.apply(label, Button.Props(raised = Some(true), disabled = disabled, onClick = onClick, title = title))
}

object ColoredButton {
  def apply(label: String, onClick: Option[() => Unit] = None, disabled: Option[Boolean] = None, title: Option[String] = None) =
    Button.apply(label, Button.Props(colored = Some(true), disabled = disabled, onClick = onClick, title = title))
}

object AccentButton {
  def apply(label: String, onClick: Option[() => Unit] = None, disabled: Option[Boolean] = None, title: Option[String] = None) =
    Button.apply(label, Button.Props(accent = Some(true), disabled = disabled, onClick = onClick, title = title))
}

object FABButton {

  @js.native
  trait Props extends CommonProps {
    val colored: js.UndefOr[Boolean] = js.native
    val ripple: js.UndefOr[Boolean] = js.native
    val disabled: js.UndefOr[Boolean] = js.native
    val mini: js.UndefOr[Boolean] = js.native
    val onClick: js.UndefOr[js.Function0[Unit]] = js.native
    val title: js.UndefOr[String] = js.native
  }

  object Props {
    def apply(
      className: Seq[String] = Nil,
      key: Option[String] = None,
      style: Option[js.Object] = None,
      colored: Option[Boolean] = None,
      ripple: Option[Boolean] = None,
      disabled: Option[Boolean] = None,
      mini: Option[Boolean] = None,
      onClick: Option[() => Unit] = None,
      title: Option[String] = None
    ) =
      js.Dynamic.literal(
        className = fillClassAttr(className).orUndefined,
        key = key.orUndefined,
        style = style.orUndefined,
        colored = colored.orUndefined,
        ripple = ripple.orUndefined,
        disabled = disabled.orUndefined,
        mini = mini.orUndefined,
        onClick = onClick.orUndefined,
        title = title.orUndefined
      ).asInstanceOf[Props]
  }

  @JSImport("react-mdl", "FABButton")
  @js.native
  object Component extends JSComponent[Props]

  def apply(icon: String, p: Props) = ElementBuilder(Component, p)(Icon(Icon.Props(name = icon)))
  def apply(icon: String, onClick: Option[() => Unit] = None, disabled: Option[Boolean] = None, ripple: Option[Boolean] = Some(true), title: Option[String] = None) =
    ElementBuilder(Component, Props(onClick = onClick, disabled = disabled, ripple = ripple, title = title))(Icon(Icon.Props(name = icon)))
}

object IconButton {

  @js.native
  trait Props extends CommonProps {
    val name: js.UndefOr[String] = js.native
    val colored: js.UndefOr[Boolean] = js.native
    val ripple: js.UndefOr[Boolean] = js.native
    val disabled: js.UndefOr[Boolean] = js.native
    val accent: js.UndefOr[Boolean] = js.native
    val primary: js.UndefOr[Boolean] = js.native
    val onClick: js.UndefOr[js.Function0[Unit]] = js.native
    val title: js.UndefOr[String] = js.native
    val id: js.UndefOr[String] = js.native
  }

  object Props {
    def apply(
      className: Seq[String] = Nil,
      key: Option[String] = None,
      style: Option[js.Object] = None,
      icon: Option[String] = None,
      colored: Option[Boolean] = None,
      ripple: Option[Boolean] = None,
      disabled: Option[Boolean] = None,
      accent: Option[Boolean] = None,
      primary: Option[Boolean] = None,
      onClick: Option[() => Unit] = None,
      title: Option[String] = None,
      id: Option[String] = None
    ) =
      js.Dynamic.literal(
        className = fillClassAttr(className).orUndefined,
        key = key.orUndefined,
        style = style.orUndefined,
        name = icon.orUndefined,
        colored = colored.orUndefined,
        ripple = ripple.orUndefined,
        disabled = disabled.orUndefined,
        accent = accent.orUndefined,
        primary = primary.orUndefined,
        onClick = onClick.orUndefined,
        title = title.orUndefined,
        id = id.orUndefined
      ).asInstanceOf[Props]
  }

  @JSImport("react-mdl", "IconButton")
  @js.native
  object Component extends JSComponent[Props]

  def apply(p: Props) = ElementBuilder(Component, p)
  def apply(icon: String, onClick: Option[() => Unit] = None, disabled: Option[Boolean] = None, title: Option[String] = None) = ElementBuilder(Component, Props(icon = Some(icon), disabled = disabled, onClick = onClick, title = title))
}

