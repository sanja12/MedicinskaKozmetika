package medicinska.kozmetika.service;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import medicinska.kozmetika.model.Proizvod;

public interface ProizvodService {

	Proizvod findOne(Long id);

	Page<Proizvod> findAll(int pageNum);

	Proizvod save(Proizvod proizvod);

	Proizvod delete(Long id);

	Page<Proizvod> search(@Param("id") Long id, int pageNum);

}
