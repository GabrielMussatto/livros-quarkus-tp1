package br.unitins.topicos1.service.serviceImpl;

import java.util.List;

import br.unitins.topicos1.dto.CupomDTO;
import br.unitins.topicos1.dto.Response.CupomResponseDTO;
import br.unitins.topicos1.model.cupom.Cupom;
import br.unitins.topicos1.repository.CupomRepository;
import br.unitins.topicos1.service.CupomService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class CupomServiceImpl implements CupomService {

    @Inject
    public CupomRepository cupomRepository;

    @Override
    @Transactional
    public CupomResponseDTO create(@Valid CupomDTO dto) {

        Cupom cupom = new Cupom();
        cupom.setNomeCupom(dto.nomeCupom());
        cupom.setDesconto(dto.desconto());

        cupomRepository.persist(cupom);
        return CupomResponseDTO.valueOf(cupom);

    }

    @Override
    @Transactional
    public void update(Long id, CupomDTO dto) {
        Cupom cupomBanco = cupomRepository.findById(id);

        cupomBanco.setNomeCupom(dto.nomeCupom());
        cupomBanco.setDesconto(dto.desconto());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        cupomRepository.deleteById(id);
    }

    @Override
    public CupomResponseDTO findById(Long id) {
        return CupomResponseDTO.valueOf(cupomRepository.findById(id));
    }

    @Override
    public List<CupomResponseDTO> findAll(int page, int pageSize) {
        List<Cupom> listCupom = cupomRepository
                .findAll()
                .page(page, pageSize)
                .list();
        return listCupom
                .stream()
                .map(cupom -> CupomResponseDTO.valueOf(cupom))
                .toList();
    }

    @Override
    public List<CupomResponseDTO> findByNomeCupom(String nomeCupom) {
        List<Cupom> listCupom = cupomRepository
                .findByNomeCupom(nomeCupom)
                .list();
        return listCupom
                .stream()
                .map(cupom -> CupomResponseDTO.valueOf(cupom))
                .toList();
    }

    @Override
    public List<CupomResponseDTO> findByNomeCupom(int page, int pageSize, String nomeCupom) {
        List<Cupom> listCupom = cupomRepository
                .findByNomeCupom(nomeCupom)
                .page(page, pageSize)
                .list();
        return listCupom
                .stream()
                .map(cupom -> CupomResponseDTO.valueOf(cupom))
                .toList();
    }

    @Override
    public long count() {
        return cupomRepository.count();
    }

    @Override
    public long countByNomeCupom(String nomeCupom) {
        return cupomRepository.findByNomeCupom(nomeCupom).count();
    }

}
