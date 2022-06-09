package contracts.start

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Hello steve"
    request {
        method GET()
        url("/start/steve")
    }
    response {
        body("Hello steve!")
        status OK()
    }
}
