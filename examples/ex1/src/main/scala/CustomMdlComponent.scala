package eldis.mdl.examples.ex1

import scalajs.js
import js.annotation.ScalaJSDefined
import eldis.react._
import eldis.react.mdl.components.Text
import vdom._

object CustomMdlComponent {

  @ScalaJSDefined
  trait Props extends js.Object {
    val value: js.UndefOr[String]
    val onChange: js.UndefOr[js.Function1[ReactEventI, Unit]] = js.undefined
  }

  val component = NativeFunctionalComponent[Props]("CustomMdlComponent") { props =>
    Text(Text.Props(
      label = "",
      value = props.value.toOption,
      onChange = props.onChange.toOption.map(x => x)
    ))
  }
}
