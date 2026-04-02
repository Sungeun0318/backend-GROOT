package com.green.backend.expertreport.service;

import com.green.backend.expertreport.repository.QrShareRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class QrService {

    private final QrShareRepository qrShareRepository;
}
