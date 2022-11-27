package com.dyplom.service;

import com.dyplom.domain.Request;
import com.dyplom.domain.Status;
import com.dyplom.domain.car.Brand;
import com.dyplom.domain.car.CarNumber;
import com.dyplom.domain.car.CountryRegistration;
import com.dyplom.domain.dto.RequestDTO;
import com.dyplom.repository.RequestRepository;
import com.dyplom.util.UserUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.dyplom.util.UserUtil.getAuthorizedUserName;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class RequestService {
    private final RequestRepository requestRepository;
    private final UserService userService;
    private final CarNumberService carNumberService;
    private final CarService carService;

    @Transactional(readOnly = true)
    public List<Request> findAll() {
        return requestRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Request> findAllByUser() {
        return requestRepository.findAllByUsername(getAuthorizedUserName());
    }

    public void approveRequest(Long requestId) {
        log.info("Start processing request with id: {} for approve", requestId);
        requestRepository.findById(requestId).ifPresent(request -> request.setStatus(Status.APPROVED));
    }

    public void rejectRequest(Long requestId) {
        log.info("Start processing request with id: {} for reject", requestId);
        requestRepository.findById(requestId).ifPresent(request -> request.setStatus(Status.REJECTED));
    }

    public void add(RequestDTO dto) {
        var carNumber = new CarNumber(dto.getCarNumber(), CountryRegistration.valueOf(dto.getCountryRegion()));
        carNumberService.save(carNumber);

        var car = carService.add(
                dto.getCarModel(),
                carNumber,
                Brand.valueOf(dto.getCarBrand()),
                dto.getYearOfProduction(),
                dto.getVinNumber()
        );

        var user = userService.findByUsername(UserUtil.getAuthorizedUserName());

        var request = new Request(car, user);
        request.setStatus(Status.NEW);

        requestRepository.save(request);
    }
}
