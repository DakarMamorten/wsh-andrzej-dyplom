package com.dyplom.service;

import com.dyplom.domain.Request;
import com.dyplom.domain.Status;
import com.dyplom.domain.car.Brand;
import com.dyplom.domain.car.CarNumber;
import com.dyplom.domain.car.CountryRegistration;
import com.dyplom.domain.car.Model;
import com.dyplom.domain.dto.RequestDTO;
import com.dyplom.repository.RequestRepository;
import com.dyplom.util.StringUtil;
import com.dyplom.util.UserUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Function;

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
    public List<RequestDTO> findAll() {
        List<Request> requests = requestRepository.findAll();
        return mapFromEntity(requests);

    }

    @Transactional(readOnly = true)
    public List<RequestDTO> findAllByUser() {
        List<Request> requestList = requestRepository.findAllByUsername(getAuthorizedUserName());
        return mapFromEntity(requestList);
    }

    private List<RequestDTO> mapFromEntity(List<Request> requestList) {
        return requestList.stream().map(mapEntityToDto()).toList();
    }

    public RequestDTO findById(Long id) {
        return requestRepository.findById(id).map(mapEntityToDto()).orElse(new RequestDTO());
    }

    private static Function<Request, RequestDTO> mapEntityToDto() {
        return r -> {
            RequestDTO dto = new RequestDTO();
            dto.setId(r.getId());
            dto.setIdentifier(StringUtil.getIdentifier(r.getId(), "R"));
            dto.setCarModel(String.valueOf(r.getCar().getModel()));
            dto.setCarBrand(String.valueOf(r.getCar().getBrand()));
            dto.setUsername(String.valueOf(r.getUser().getUsername()));
            dto.setRegistrationNumber(r.getCar().getCarNumber().getRegistrationNumber());
            dto.setCountryRegion(r.getCar().getCarNumber().getCountryRegion().getCountryName());
            dto.setYearOfProduction(r.getCar().getYearOfProduction());
            dto.setVinNumber(r.getCar().getVinNumber());
            dto.setStatus(r.getStatus());
            dto.setDate(r.getDateCreate());
            return dto;
        };
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
        var carNumber = new CarNumber(dto.getRegistrationNumber(), CountryRegistration.valueOf(dto.getCountryRegion()));
        carNumberService.save(carNumber);

        var car = carService.add(Model.valueOf(dto.getCarModel()), carNumber, Brand.valueOf(dto.getCarBrand()), dto.getYearOfProduction(), dto.getVinNumber());


        var user = userService.findByUsername(UserUtil.getAuthorizedUserName());

        var request = new Request(car, user);
        request.setStatus(Status.NEW);

        requestRepository.save(request);
    }
}
