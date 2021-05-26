package com.readcsv.democsv.service.impl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.bean.CsvToBeanBuilder;
import com.readcsv.democsv.entity.Escola;
import com.readcsv.democsv.entity.dto.EscolaDTO;
import com.readcsv.democsv.repository.EscolaRepository;
import com.readcsv.democsv.service.EscolaService;

@Service
public class EscolaServiceImpl implements EscolaService {

	private EscolaRepository escolaRepository;

	@Autowired
	public EscolaServiceImpl(EscolaRepository escolaRepository) {
		super();
		this.escolaRepository = escolaRepository;
	}

	@Override
	public void saveData(MultipartFile file) {
		try {
			InputStreamReader streamReader = new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8);

			List<EscolaDTO> escolasDTO = new CsvToBeanBuilder<EscolaDTO>(streamReader)
					.withType(EscolaDTO.class)
					.withSeparator(';')
					.withIgnoreLeadingWhiteSpace(true)
					.withSkipLines(1)
					.build()
					.parse();
			for (EscolaDTO escolaDTO : escolasDTO) {
				Escola escola = new Escola();
				BeanUtils.copyProperties(escola, escolaDTO);
				escolaRepository.save(escola);
			}
		} catch (IOException | IllegalAccessException |	InvocationTargetException e) {
			throw new RuntimeException("Operação não realizada");
		}
	}
}
