package contracts.user.create

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Existing user"
    request {
        method POST()
        url("/users")
        headers {
            contentType(applicationJson())
        }
        body(
            login: "Odinson",
            group: "Avengers",
            password: "xyz"
        )
    }
    response {
        status CONFLICT()
    }
}
