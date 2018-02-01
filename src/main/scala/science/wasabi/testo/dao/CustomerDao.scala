package science.wasabi.testo.dao


import java.util.concurrent.TimeUnit

import scala.concurrent.Await
import scala.concurrent.duration.Duration

import science.wasabi.testo.entity._


trait CustomerDao {
  def insertCustomers(customers: List[Customer]): List[Customer]
  def findAllCustomers(): List[Customer]
}


class SlickCustomerDao extends CustomerDao {

  import slick.jdbc.H2Profile.api._


  private val db = Database.forConfig("h2mem1")

  private val customers = TableQuery[Customers]

  private val setup = customers.schema.create
  private val setupFuture = db.run(setup)

  val tenSeconds = Duration(10, TimeUnit.SECONDS)
  Await.ready(setupFuture, tenSeconds)


  override def insertCustomers(customers: List[Customer]): List[Customer] = {
    val wot: DBIO[_] = this.customers ++= customers
    Await.ready(db.run(wot), tenSeconds)
    customers
  }

  override def findAllCustomers(): List[Customer] = {
    val wot: DBIO[Seq[Customer]] = customers.result
    val woto = Await.result(db.run(wot), tenSeconds)
    woto.toList
  }
}