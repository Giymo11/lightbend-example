package science.wasabi.testo.gui


import science.wasabi.testo.entity.Customer

import scalafx.application.Platform
import scalafx.geometry.Pos
import scalafx.scene.control.{Button, Label}
import scalafx.scene.layout.GridPane


class CustomerUi() {

  private val label = new Label()

  private val button = new Button {
    text = "Show Customer"
    onAction = (event) => println("trolo")
  }

  val helloworld = new GridPane {
    alignment = Pos.Center
    hgap = 10
    vgap = 10
    add(button, 0, 0)
    add(label, 0, 1)
  }
}