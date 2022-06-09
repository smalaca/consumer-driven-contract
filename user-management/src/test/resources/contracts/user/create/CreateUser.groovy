package contracts.user.create

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Create User"
    request {
        method POST()
        url("/users")
        headers {
            contentType(applicationJson())
        }
        body(
            login: "smalaca",
            group: "Group One",
            password: "xyz"
        )
    }
    response {
        status CREATED()
        headers {
            contentType(applicationJson())
        }
        body(
            id: regex("[0-9]+"),
            login: fromRequest().body('$.login'),
            group: fromRequest().body('$.group')
        )
    }
}
