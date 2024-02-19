package com.khit.library.service;

import com.khit.library.dto.RentalReturnDTO;
import com.khit.library.entity.RentalReturn;
import com.khit.library.repository.RentalReturnRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalReturnService {
    private final RentalReturnRepository rentalReturnRepository;

    //대출리스트
    public List<RentalReturnDTO> findAll() {
        List<RentalReturn> rentalReturnList = rentalReturnRepository.findAll();
        List<RentalReturnDTO> rentalReturnDTOList = new ArrayList<>();

        for(RentalReturn rentalReturn : rentalReturnList){
            RentalReturnDTO rentalReturnDTO = RentalReturnDTO.toSaveDTO(rentalReturn);
            rentalReturnDTOList.add(rentalReturnDTO);
        }
        return rentalReturnDTOList;
    }

    //도서 대출
    public void save(RentalReturnDTO rentalReturnDTO) {
        RentalReturn rentalReturn = RentalReturn.toSaveEntity(rentalReturnDTO);
        rentalReturnRepository.save(rentalReturn);
    }

    //도서반납
    public void update(RentalReturnDTO rentalReturnDTO) {
        RentalReturn rentalReturn = RentalReturn.toUpdateEntity(rentalReturnDTO);
        rentalReturnRepository.save(rentalReturn);
    }
    public RentalReturnDTO findByRentalId(Long rentalId) {
        //        Optional<RentalReturn> rentalReturn = rentalReturnRepository.findByRentalId(rentalId);
        RentalReturn rentalReturn = rentalReturnRepository.findByRentalId(rentalId);
        RentalReturnDTO rentalReturnDTO = RentalReturnDTO.toSaveDTO(rentalReturn);
        return rentalReturnDTO;
    }

    public List<RentalReturnDTO> findByMemberMid(String mid) {
        List<RentalReturn> rentalReturnList = rentalReturnRepository.findByMemberMid(mid);
        List<RentalReturnDTO> rentalReturnDTOList = new ArrayList<>();

        for(RentalReturn rentalReturn : rentalReturnList){
            RentalReturnDTO rentalReturnDTO = RentalReturnDTO.toSaveDTO(rentalReturn);
            rentalReturnDTOList.add(rentalReturnDTO);
        }
        return rentalReturnDTOList;
    }

    public int count(Long memberId){
        return rentalReturnRepository.rentalCount(memberId);
    }

    public List<Integer> rentalAble(){
        return rentalReturnRepository.rentalAble();
    }

    //페이징
	public Page<RentalReturnDTO> paging(Pageable pageable) {
		Page<RentalReturn> rentalReturnPage = rentalReturnRepository.findAll(pageable);
		return rentalReturnPage.map(rentalReturn -> RentalReturnDTO.toSaveDTO(rentalReturn));
	}

}
