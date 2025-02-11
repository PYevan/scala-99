trait Searchable[T] {
  def uri(obj: T): String
}

case class Customer(taxCode: String, name: String, surname: String)
case class Policy(policyId: String, description: String)

implicit val searchableCustomer: Searchable[Customer] = new Searchable[Customer] {
  override def uri(customer: Customer): String = s"/customers/${customer.taxCode}"
}

implicit val searchabePolicy:Searchable[Policy] = new Searchable[Policy] {
  override def uri(policy: Policy): String = s"/policies/${policy.policyId}"
}

val c = Customer("evan_tax", "evan", "lian")
val p = Policy("evan_p_id", "I like scala")

def searchWithImplicit[S] (obj: S) (implicit searchable: Searchable[S]): String = {
  searchable.uri(obj)
}

println(searchWithImplicit(c))
println(searchWithImplicit(p))