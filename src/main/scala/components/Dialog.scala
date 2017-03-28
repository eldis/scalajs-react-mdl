/**
 * Created by kirill on 10.02.2017.
 */

package eldis.react.mdl.components

import eldis.react._
import eldis.react.mdl._
import eldis.react.util.ElementBuilder

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import js.JSConverters._

object Dialog {

  @js.native
  trait Props extends CommonProps {
    val open: js.UndefOr[Boolean] = js.native
    val onCancel: js.UndefOr[js.Function0[Unit]] = js.native
  }

  object Props {
    def apply(
      className: Seq[String] = Nil,
      key: Option[String] = None,
      style: Option[js.Object] = None,
      open: Option[Boolean] = None,
      onCancel: Option[() => Unit] = None
    ) = js.Dynamic.literal(
      className = fillClassAttr("es-dialog" +: className).orUndefined,
      key = key.orUndefined,
      style = style.orUndefined,
      open = open.orUndefined,
      onCancel = onCancel.orUndefined
    ).asInstanceOf[Props]
  }

  @JSImport("react-mdl", "Dialog")
  @js.native
  object Component extends JSComponent[Props]

  def apply(p: Props)(children: ReactNode*) = ElementBuilder(Component, p)(children: _*)

  def apply(
    title: Option[String],
    open: Boolean,
    className: Seq[String],
    actions: Seq[ReactNode] = Nil,
    onCancel: Option[() => Unit] = None,
    titleProps: DialogTitle.Props = DialogTitle.Props(),
    contentProps: DialogContent.Props = DialogContent.Props(),
    actionsProps: DialogActions.Props = DialogActions.Props()
  )(children: ReactNode*) = {

    val dt = DialogTitle(titleProps)(title.getOrElse("").toString)
    val dc = DialogContent(DialogContent.Props())(children: _*)
    val da = DialogActions(actionsProps)(actions: _*)

    val ch = List[ReactNode](dt, dc, da)

    ElementBuilder(Component, Props(className = className, open = Some(open), onCancel = onCancel))(ch: _*)
  }
}

object DialogTitle {

  @js.native
  trait Props extends CommonProps {
    val component: js.UndefOr[String] = js.native
  }

  object Props {
    def apply(
      className: Seq[String] = Nil,
      key: Option[String] = None,
      style: Option[js.Object] = None,
      component: Option[String] = None
    ) = js.Dynamic.literal(
      className = fillClassAttr("es-dialog--title" +: className).orUndefined,
      key = key.orUndefined,
      style = style.orUndefined,
      component = component.orUndefined
    ).asInstanceOf[Props]
  }

  @JSImport("react-mdl", "DialogTitle")
  @js.native
  object Component extends JSComponent[Props]

  def apply(p: Props = Props())(children: ReactNode*) = ElementBuilder(Component, p)(children: _*)
}

object DialogContent {

  @js.native
  trait Props extends CommonProps {}
  object Props {
    def apply(
      className: Seq[String] = Nil,
      key: Option[String] = None,
      style: Option[js.Object] = None
    ) = js.Dynamic.literal(
      className = fillClassAttr("es-dialog--content" +: className).orUndefined,
      key = key.orUndefined,
      style = style.orUndefined
    ).asInstanceOf[Props]
  }

  @JSImport("react-mdl", "DialogContent")
  @js.native
  object Component extends JSComponent[Props]

  def apply(props: Props)(children: ReactNode*) = ElementBuilder(Component, props)(children: _*)
}

object DialogActions {

  @js.native
  trait Props extends CommonProps {
    val fullWidth: js.UndefOr[Boolean] = js.native
  }

  object Props {
    def apply(
      className: Seq[String] = Nil,
      key: Option[String] = None,
      style: Option[js.Object] = None,
      fullWidth: Option[Boolean] = None
    ) = js.Dynamic.literal(
      className = fillClassAttr("es-dialog--action" +: className).orUndefined,
      key = key.orUndefined,
      style = style.orUndefined,
      fullWidth = fullWidth.orUndefined
    ).asInstanceOf[Props]
  }

  @JSImport("react-mdl", "DialogActions")
  @js.native
  object Component extends JSComponent[Props]

  def apply(p: Props = Props())(children: ReactNode*) = ElementBuilder(Component, p)(children: _*)
}

