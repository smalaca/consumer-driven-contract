package contracts.products.find

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Find All for shop 13"
    request {
        method GET()
        url("/products") {
            queryParameters {
                parameter("shopId", 13)
            }
        }
    }
    response {
        status OK()
        headers {
            contentType(applicationJson())
        }
        body([
            [
                    id: regex("[0-9]+"),
                    name: "Water",
                    price: 123.45,
                    shopId: fromRequest().query('shopId')
            ],
            [
                    id: regex("[0-9]+"),
                    name: "Tea",
                    price: 13.42,
                    shopId: fromRequest().query('shopId')
            ],
            [
                    id: regex("[0-9]+"),
                    name: "Coffee",
                    price: 321.12,
                    shopId: fromRequest().query('shopId')
            ]
        ])
    }
}
