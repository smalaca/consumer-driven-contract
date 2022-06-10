package contracts.user.find.all

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Find No one"
    request {
        method GET()
        url("/users") {
            queryParameters {
                parameter("group", "Defenders")
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
