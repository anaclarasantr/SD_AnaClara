package br.inatel.labs.labrest.client;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import br.inatel.labs.labrest.client.model.dto.ProdutoDTO;
import reactor.core.publisher.Mono;

public class WebClientGetMonoProdutoPeloId {
	public static void main(String[] args) {

		try {
			Mono<ProdutoDTO> prodUnico = WebClient.create("http://localhost:8080")
					.get().uri("/produto/3")
					.retrieve()
					.bodyToMono(ProdutoDTO.class);

			prodUnico.subscribe();

			ProdutoDTO produto = prodUnico.block();

			System.out.println("Produto encontrado");
			System.out.println(produto);

		} catch (WebClientResponseException e) {
			System.out.println("Status da resposta: " + e.getStatusCode());
			System.out.println("Mensagem response body: " + e.getResponseBodyAsString());
		}
	}
}
