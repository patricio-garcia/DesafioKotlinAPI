package cl.serlitoral.desafiokotlinapi.data

import cl.serlitoral.desafiokotlinapi.data.model.User
import cl.serlitoral.desafiokotlinapi.data.model.UserEntity

fun mapAPI2DB(user: User): UserEntity {
    return UserEntity(user.id, user.name, user.email, user.phone)
}

fun mapDB2API(user: UserEntity): User {
    return User(user.id, user.name, user.email, user.phone)
}