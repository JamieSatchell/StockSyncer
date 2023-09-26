package com.JamieSatchell.ims.repository

import com.JamieSatchell.ims.domain.Location
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LocationRepository : JpaRepository<Location, Long>
