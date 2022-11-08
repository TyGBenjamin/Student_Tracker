package com.rave.studenttracker.model.mapper

/**
 * Converts a [DTO] into a [dataclass].
 *
 * @param DTO represent the JSON from server
 * @param ENTITY represents the data for local use
 * @constructor Create instance [DtoToEntityMapper]
 */
interface DtoToEntityMapper<in DTO, out ENTITY> {
    /**
     * Invoke function used to invoke the class.
     *
     * @param dto
     * @return
     */
    operator fun invoke(dto: DTO): ENTITY
}
