package contracts.user.find.all

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Find All Avengers"
    request {
        method GET()
        url("/users") {
            queryParameters {
                parameter("group", "Avengers")
            }
        }
    }
    response {
        status OK()
        headers {
            contentType(applicationJson())
        }
        body([[
            id: regex("[0-9]+"),
            login: "Captain America",
            group: fromRequest().query('group')
        ], [
                id: regex("[0-9]+"),
                login: "Odinson",
                group: fromRequest().query('group')
        ], [
                id: regex("[0-9]+"),
                login: "Tony Stark",
                group: fromRequest().query('group')
        ]])
    }
}
