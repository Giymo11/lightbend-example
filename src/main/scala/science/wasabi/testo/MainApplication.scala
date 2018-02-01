package science.wasabi.testo


import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene

import science.wasabi.testo.dao._
import science.wasabi.testo.entity.Customer
import science.wasabi.testo.gui.CustomerUi


object MainApplication extends JFXApp  {
  val dao: CustomerDao = new SlickCustomerDao()

  private val customers = List(
    Customer(None, "Jack", "Bauer"),
    Customer(None, "Chloe", "O'Brian"),
    Customer(None, "Kim", "Bauer"),
    Customer(None, "David", "Palmer"),
    Customer(None, "Michelle", "Dessler")
  )
  private val res = dao.insertCustomers(customers)

  lazy val ui: CustomerUi = new CustomerUi()

  stage = new PrimaryStage {
    title = "Hello World"
    width = 800
    height = 600
    scene = new Scene {
      root = ui.helloworld
    }
  }
}
