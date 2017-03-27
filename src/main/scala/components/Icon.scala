/**
 * Created by maria on 06.02.2017.
 */
package eldis.react.mdl.components

import scalajs.js
import js.annotation.JSImport
import js.JSConverters._
import eldis.react._
import eldis.react.mdl._
import eldis.react.util.ElementBuilder

object Icon {
  @js.native
  trait Props extends CommonProps {
    val name: String = js.native
  }
  object Props {
    def apply(
      name: String,
      className: Seq[String] = Nil,
      key: Option[String] = None,
      style: Option[js.Object] = None
    ) =
      js.Dynamic.literal(
        className = fillClassAttr(className).orUndefined,
        key = key.orUndefined,
        style = style.orUndefined,
        name = name
      ).asInstanceOf[Props]
  }

  @JSImport("react-mdl", "Icon")
  @js.native
  object Component extends JSComponent[Props]
  def apply(p: Props) = ElementBuilder(Component, p)
}
