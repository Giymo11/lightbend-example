package science.wasabi.testo.entity


import slick.jdbc.H2Profile.api._


case class Customer(id: Option[Int], firstname: String, lastname: String)

class Customers(tag: Tag) extends Table[Customer](tag, "customers") {
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def firstname = column[String]("firstname")
  def lastname = column[String]("lastname")
  def * = (id.?, firstname, lastname) <> (Customer.tupled, Customer.unapply)
}

