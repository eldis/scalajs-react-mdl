/**
 * Created by maria on 08.02.2017.
 */
package eldis.react.mdl.components

import scalajs.js
import js.annotation.JSImport
import js.JSConverters._
import js.Dynamic
import eldis.react._
import eldis.react.mdl._
import eldis.react.util.ElementBuilder
import eldis.react.vdom._

object Text {
  @js.native
  trait Props extends CommonProps {
    val disabled: js.UndefOr[Boolean] = js.native
    val error: js.UndefOr[String] = js.native
    val expandable: js.UndefOr[Boolean] = js.native
    val expandableIcon: js.UndefOr[String] = js.native
    val floatingLabel: js.UndefOr[Boolean] = js.native
    val inputClassName: js.UndefOr[String] = js.native
    val label: String = js.native
    val maxRows: js.UndefOr[Int] = js.native
    val onChange: js.UndefOr[js.Function1[ReactEventI, Unit]] = js.native
    val pattern: js.UndefOr[String] = js.native
    val required: js.UndefOr[Boolean] = js.native
    val rows: js.UndefOr[Int] = js.native
    val value: js.UndefOr[String] = js.native
    val `type`: js.UndefOr[String] = js.native
    val defaultValue: js.UndefOr[String] = js.native
  }
  object Props {
    def apply(
      className: Seq[String] = Nil,
      key: Option[String] = None,
      style: Option[js.Object] = None,
      disabled: Option[Boolean] = None,
      error: Option[String] = None,
      expandable: Option[Boolean] = None,
      expandableIcon: Option[String] = None,
      floatingLabel: Option[Boolean] = Some(true),
      inputClassName: Option[String] = None,
      label: String,
      maxRows: Option[Int] = None,
      onChange: Option[ReactEventI => Unit] = None,
      pattern: Option[String] = None,
      required: Option[Boolean] = None,
      rows: Option[Int] = None,
      value: Option[String] = None,
      `type`: Option[String] = None,
      defaultValue: Option[String] = None
    ) =
      js.Dynamic.literal(
        className = fillClassAttr("es-text" +: className).orUndefined,
        key = key.orUndefined,
        style = style.orUndefined,
        disabled = disabled.orUndefined,
        error = error.orUndefined,
        expandable = expandable.orUndefined,
        expandableIcon = expandableIcon.orUndefined,
        floatingLabel = floatingLabel.orUndefined,
        inputClassName = inputClassName.orUndefined,
        label = label,
        maxRows = maxRows.orUndefined,
        onChange = onChange.orUndefined,
        pattern = pattern.orUndefined,
        required = required.orUndefined,
        rows = rows.orUndefined,
        value = value.orUndefined,
        `type` = `type`.orUndefined,
        defaultValue = defaultValue.orUndefined
      ).asInstanceOf[Props]
  }

  @JSImport("react-mdl", "Textfield")
  @js.native
  object Component extends JSComponent[Props]

  def apply(label: String) = ElementBuilder(Component, Props(label = label))
  def apply(label: String, floatingLabel: Boolean) = ElementBuilder(Component, Props(label = label, floatingLabel = Some(floatingLabel)))
  def apply(p: Props) = ElementBuilder(Component, p)

  def password(p: Props) =
    ElementBuilder(Component, copy(p, Dynamic.literal(`type` = "password")).asInstanceOf[Props])
  def textArea(p: Props) =
    ElementBuilder(Component, copy(p, Dynamic.literal(rows = (p.rows.getOrElse(1)).toInt)).asInstanceOf[Props])
  def date(p: Props) = {
    val dateError = "Введите значение в формате ДД.ММ.ГГГГ"
    val datePattern = """^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[1,3-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$"""
    ElementBuilder(Component, copy(p, Dynamic.literal(
      error = dateError, pattern = datePattern
    )).asInstanceOf[Props])
  }
  def time(p: Props) = {
    val timeError = "Введите значение в формате ЧЧ:ММ"
    val timePattern = """^([0-1][0-9]|2[0-3]):([0-5][0-9])$"""
    ElementBuilder(Component, copy(p, Dynamic.literal(
      error = timeError, pattern = timePattern
    )).asInstanceOf[Props])
  }
  def integer(p: Props) = ElementBuilder(Component, copy(p, Dynamic.literal(
    pattern = """^-?\d+$""",
    error = "Введите целое число"
  )).asInstanceOf[Props])

  def float(p: Props) = ElementBuilder(Component, copy(p, Dynamic.literal(
    pattern = """^-?\d*(\.\d+)?$""",
    error = "Введите число"
  )).asInstanceOf[Props])

  def fraction(p: Props) = ElementBuilder(Component, copy(p, Dynamic.literal(
    pattern = """^-?(\d+\/\d+|\d+(\s\d+\/\d+)?|\d*\.\d+)$""",
    error = "Введите дробное значение"
  )).asInstanceOf[Props])
}

object Password {
  def apply(p: Text.Props) = Text.password(p)
  def apply(label: String) = Text.password(Text.Props(label = label))
}

object TextArea {
  def apply(p: Text.Props) = Text.textArea(p)
  def apply(rows: Int) = Text.textArea(Text.Props(label = "", rows = Some(rows)))
}

object Date {
  def apply(p: Text.Props) = Text.date(p)
  def apply() = Text.date(Text.Props(label = "00.00.0000", floatingLabel = Some(false)))
  def apply(label: String) = Text.date(Text.Props(label = label, floatingLabel = Some(false)))
  def apply(label: String, floatingLabel: Boolean) = Text.date(Text.Props(label = label, floatingLabel = Some(floatingLabel)))
  def apply(label: String, defaultValue: String) =
    Text.date(Text.Props(label = label, floatingLabel = Some(false), defaultValue = Some(defaultValue)))
  def apply(label: String, defaultValue: String, floatingLabel: Boolean) =
    Text.date(Text.Props(label = label, floatingLabel = Some(floatingLabel), defaultValue = Some(defaultValue)))
  def apply(label: String, onChange: String => Unit) =
    Text.date(Text.Props(label = label, floatingLabel = Some(false), onChange = Some((e: ReactEventI) => onChange(e.target.value))))
  def apply(label: String, defaultValue: String, onChange: String => Unit) =
    Text.date(Text.Props(label = label, floatingLabel = Some(false), defaultValue = Some(defaultValue), onChange = Some((e: ReactEventI) => onChange(e.target.value))))
}

object Time {
  def apply(props: Text.Props) = Text.time(props)
  def apply() = Text.time(Text.Props(label = "00:00", floatingLabel = Some(false)))
  def apply(label: String) = Text.time(Text.Props(label = "00:00", floatingLabel = Some(false)))
  def apply(label: String, floatingLabel: Boolean) = Text.time(Text.Props(label = "00:00", floatingLabel = Some(floatingLabel)))
  def apply(label: String, defaultValue: String) =
    Text.time(Text.Props(label = label, floatingLabel = Some(false), defaultValue = Some(defaultValue)))
  def apply(label: String, defaultValue: String, floatingLabel: Boolean) =
    Text.time(Text.Props(label = label, floatingLabel = Some(floatingLabel), defaultValue = Some(defaultValue)))
}
object Integer {
  def apply(props: Text.Props) = Text.integer(props)
  def apply() = Text.integer(Text.Props(label = ""))
  def apply(defaultValue: String) = Text.integer(Text.Props(label = "", defaultValue = Some(defaultValue)))
}

object Float {
  def apply(props: Text.Props) = Text.float(props)
  def apply() = Text.float(Text.Props(label = ""))
  def apply(defaultValue: String) = Text.float(Text.Props(label = "", defaultValue = Some(defaultValue)))
}

object Fraction {
  def apply(props: Text.Props) = Text.fraction(props)
  def apply() = Text.fraction(Text.Props(label = ""))
  def apply(defaultValue: String) = Text.fraction(Text.Props(label = "", defaultValue = Some(defaultValue)))
}
