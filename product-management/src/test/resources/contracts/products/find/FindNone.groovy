package contracts.products.find

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Find No products"
    request {
        method GET()
        url("/products") {
            queryParameters {
                parameter("shopId", 42)
            }
        }
    }
    response {
        status OK()
        headers {
            contentType(applicationJson())
        }
        body([])
    }
}
