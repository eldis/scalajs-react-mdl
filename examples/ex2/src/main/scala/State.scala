package eldis.mdl.examples.ex2

import eldis.redux.rrf._

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

@ScalaJSDefined
trait State extends js.Object {
  val testForm: TestFormState
  val rrfData: RRFState = js.undefined
}

object State {
  def apply(initialTestForm: TestFormState, initialRRFState: RRFState) = {
    new State {
      override val testForm = initialTestForm
      override val rrfData = initialRRFState
    }
  }

  implicit class StateOps(self: State) {
    def copy(testForm: TestFormState = self.testForm): State =
      State(
        testForm,
        self.rrfData
      )
  }

  val initialState = new State {
    override val testForm: TestFormState = TestFormState.initialTestForm
  }
}

@ScalaJSDefined
trait TestFormState extends js.Object {
  val dlgType: Option[DialogType]
  val checkBoxFiled: String
  val radio: String
  val textField: String
  val passwordField: String
  val textAreaField: String
  val integerField: String
  val floatField: String
  val fractionField: String
  val dateField: String
  val timeField: String
  val referenceField: String
  val multiSelectField: String
}
object TestFormState {
  def apply(
    initDlgType: Option[DialogType],
    initCheckBoxFiled: String,
    initRadio: String,
    initTextField: String,
    initPasswordField: String,
    initTextAreaField: String,
    initIntegerField: String,
    initFloatField: String,
    initFractionField: String,
    initDateField: String,
    initTimeField: String,
    initReferenceField: String,
    initMultiSelectField: String
  ): TestFormState = new TestFormState {
    override val dlgType = initDlgType
    override val checkBoxFiled = initCheckBoxFiled
    override val radio = initRadio
    override val textField = initTextField
    override val passwordField = initPasswordField
    override val textAreaField = initTextAreaField
    override val integerField = initIntegerField
    override val floatField = initFloatField
    override val fractionField = initFractionField
    override val dateField = initDateField
    override val timeField = initTimeField
    override val referenceField = initReferenceField
    override val multiSelectField = initMultiSelectField
  }

  implicit class StateOps(self: TestFormState) {
    def copy(
      dlgType: Option[DialogType] = self.dlgType,
      checkBoxFiled: String = self.checkBoxFiled,
      radio: String = self.radio,
      textField: String = self.textField,
      passwordField: String = self.passwordField,
      textAreaField: String = self.textAreaField,
      integerField: String = self.integerField,
      floatField: String = self.floatField,
      fractionField: String = self.fractionField,
      dateField: String = self.dateField,
      timeField: String = self.timeField,
      referenceField: String = self.referenceField,
      multiSelectField: String = self.multiSelectField
    ): TestFormState = TestFormState(
      dlgType,
      checkBoxFiled,
      radio,
      textField,
      passwordField,
      textAreaField,
      integerField,
      floatField,
      fractionField,
      dateField,
      timeField,
      referenceField,
      multiSelectField
    )
  }

  val initialTestForm = new TestFormState {
    override val dlgType: Option[DialogType] = None
    override val checkBoxFiled: String = ""
    override val radio: String = ""
    override val textField: String = "123"
    override val passwordField: String = "123"
    override val textAreaField: String = "123"
    override val integerField: String = "123"
    override val floatField: String = "12.3"
    override val fractionField: String = "123"
    override val dateField: String = "123"
    override val timeField: String = "123"
    override val referenceField: String = "123"
    override val multiSelectField: String = "123"
  }

}
