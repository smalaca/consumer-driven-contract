package contracts.products.find

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Find No shop"
    request {
        method GET()
        url("/products") {
            queryParameters {
                parameter("shopId", 7)
            }
        }
    }
    response {
        status NOT_FOUND()
    }
}
