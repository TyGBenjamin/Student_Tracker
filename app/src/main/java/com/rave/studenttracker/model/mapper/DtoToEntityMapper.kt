package com.rave.studenttracker.model.mapper

interface DtoToEntityMapper<in DTO, out ENTITY> {
    operator fun invoke(dto: DTO): ENTITY
}
