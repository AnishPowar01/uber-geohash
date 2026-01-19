package com.example.uber.service;

import com.example.uber.service.read.PassengerReadService;
import com.example.uber.service.write.PassengerWriteService;

public interface PassengerService extends PassengerReadService, PassengerWriteService {
}
