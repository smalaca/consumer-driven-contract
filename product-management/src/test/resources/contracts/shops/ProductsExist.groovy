package contracts.producer

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "products exist"
    request {
        method GET()
        url("/shops/summary/13")
    }
    response {
        body("There are 3 products in the shop 13.")
        status OK()
    }
}
