package contracts.producer

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "no shop"
    request {
        method GET()
        url("/shops/summary/7")
    }
    response {
        status NOT_FOUND()
    }
}
