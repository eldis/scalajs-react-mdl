/**
 * Created by maria on 06.02.2017.
 */
package eldis.react

import scala.scalajs.js
import scala.scalajs.js.Dynamic

package object mdl {
  private[mdl] def fillClassAttr(s: Seq[String]): Option[String] = Option(s).filterNot(_.isEmpty).map(_.mkString(" "))

  // The method is used to copy the values of all properties from propsObject to targetObject. It returns new object
  private[mdl] def copy(targetObject: js.Any, propsObject: js.Any): js.Any =
    Dynamic.global.Object.assign(Dynamic.literal(), targetObject, propsObject)

  @js.native
  trait ReactMDLCommonPropsJS extends js.Any {
    val className: js.UndefOr[String] = js.native
    val key: js.UndefOr[String] = js.native
    val style: js.UndefOr[js.Object] = js.native
  }
}

