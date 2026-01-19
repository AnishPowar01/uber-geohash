package com.example.uber.service;

import com.example.uber.service.read.BookingReadService;
import com.example.uber.service.write.BookingWriteService;

public interface BookingService extends BookingReadService, BookingWriteService {
}
