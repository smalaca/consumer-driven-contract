package contracts.producer

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "no products"
    request {
        method GET()
        url("/shops/summary/42")
    }
    response {
        body("There is no products in the shop 42.")
        status OK()
    }
}
