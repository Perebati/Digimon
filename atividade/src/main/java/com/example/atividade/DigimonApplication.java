package com.example.atividade;

import com.example.atividade.model.Digimon;
import com.example.atividade.pull.DigimonPuller;
import com.example.atividade.service.DigimonService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DigimonApplication {
	public static void main(String[] args) throws JsonProcessingException {

		// Com "Contexto", eh possivel instaciar servicos no codigo
		ApplicationContext context = SpringApplication.run(DigimonApplication.class, args);

		// "Service" esta referenciando "DigimonService" no momento em que o programa funciona
		DigimonService service = context.getBean(DigimonService.class);

		// "DigimonPuller" eh responsavel por obter a String em formato JSON da API do Digimon
		DigimonPuller pull = new DigimonPuller();
		String line = pull.run(null);

		// "Line" eh a String JSON pura que "DigimonPuller" puxou da API online
		final ObjectMapper objectMapper = new ObjectMapper();

		// ObjectMappar eh um metodo do framework Jackson
		// onde eh possivel ler o JSON de forma rapida e salvar em um objeto
		Digimon[] digimonArray = objectMapper.readValue(line, Digimon[].class);

		// Aqui estou convertendo um Array de Digimons em uma Lista de Digimons
		List<Digimon> list = Arrays.asList(digimonArray);

		// Aqui estou salvando os Digimons no Postgresql utilizando o Spring JPA
		List<Digimon> digimonSalvo = service.saveDigimons(list);
	}
}
