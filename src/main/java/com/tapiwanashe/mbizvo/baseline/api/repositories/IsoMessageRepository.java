package com.tapiwanashe.mbizvo.baseline.api.repositories;

import com.tapiwanashe.mbizvo.baseline.api.entity.IsoMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IsoMessageRepository  extends JpaRepository<IsoMessage, Long> {
}
