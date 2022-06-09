package contracts.start

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Hello guest"
    request {
        method GET()
        url("/start")
    }
    response {
        body("Hello guest!")
        status OK()
    }
}
