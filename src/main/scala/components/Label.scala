/**
 * Created by maria on 09.02.2017.
 */
package eldis.react.mdl.components

import scalajs.js
import js.JSConverters._
import eldis.react._
import eldis.react.mdl._
import eldis.react.vdom._
import vdom.prefix_<^._

object Label {
  @js.native
  trait Props extends CommonProps {
    val label: String = js.native
  }
  object Props {
    def apply(
      label: String,
      className: Seq[String] = Nil,
      key: Option[String] = None,
      style: Option[js.Object] = None

    ) =
      js.Dynamic.literal(
        className = fillClassAttr(Seq("mdl-label", "es-label") ++ className).orUndefined,
        key = key.orUndefined,
        style = style.orUndefined,
        label = label
      ).asInstanceOf[Props]
  }

  def createLabel(p: Props) =
    <.label(
      attr("key") := AttrValue(p.key),
      ^.className := AttrValue(p.className),
      ^.style := AttrValue(p.style)
    )(p.label)

  def apply(p: Props) = createLabel(p)
  def apply(label: String, className: Option[String] = None) = createLabel(Props(label = label, className = Seq(className.getOrElse(""))))
}

